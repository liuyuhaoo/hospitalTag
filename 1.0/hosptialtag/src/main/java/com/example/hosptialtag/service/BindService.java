package com.example.hosptialtag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @Author liuyuhao
 * @Date 2022/2/3
 */
@Service
public class BindService {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private PatientService patientService;
    @Autowired
    private TagService tagService;
    public BindService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String sql;

    public String createBind(int bind_patient_id, int bind_tag_id,  String bind_start_time, String bind_end_time, Model model) {
        String flag = isPatientAndTagExist(bind_patient_id,bind_tag_id);
        if(flag == "0") {
            jdbcTemplate.update("insert into bind(bind_patient_id, bind_tag_id, bind_start_time, bind_end_time)\n" +
                    "values(?,?,?,?);", bind_patient_id, bind_tag_id, bind_start_time, bind_start_time);
            return "index";
        }
        else{
            return flag;
        }

    }

    public String createBindForever(int bind_patient_id, int bind_tag_id, Model model) {
        String flag = isPatientAndTagExist(bind_patient_id,bind_tag_id);
        if(flag == "0") {
        jdbcTemplate.update("insert into bind(bind_patient_id, bind_tag_id)\n" +
                "values(?,?);",bind_patient_id, bind_tag_id);
        return "index";
        }
        else{
            return flag;
        }
    }

    public String isPatientAndTagExist(int patient_id, int tag_id){//添加绑定前确定病人是否存在，确定标签是否存在
        int patientFlag = patientService.getPatientsCountByPatientId(patient_id);
        int tagFlag = tagService.getTagsCountByTagId(tag_id);
        if(patientFlag != 0 && tagFlag != 0)
            return "0";//都存在
        return "该病人或标签都不存在，请检查后重新输入";
    }

    public String updateBind(int bind_id, int bind_patient_id, int bind_tag_id, String bind_start_time, String bind_end_time, Model model) {
        String flag = isPatientAndTagExist(bind_patient_id,bind_tag_id);
        if(flag == "0") {
            jdbcTemplate.update("update bind set bind_patient_id = ?, bind_tag_id = ?, bind_start_time = ?, bind_end_time = ? where bind_id = ?;",
                    bind_patient_id, bind_tag_id, bind_start_time, bind_end_time, bind_id);
            return "index";
        }
        else{
            return flag;
        }
    }

    public String deleteBindById(int bind_id, Model model) {
        jdbcTemplate.update("update bind set bind_delete = 1 where bind_id = ?",bind_id);
        return "index";
    }

    public void deleteBindByPatientId(int bind_patient_id, Model model) {
        jdbcTemplate.update("update bind set bind_delete = 1 where bind_patient_id = ?", bind_patient_id);
    }

    public void deleteBindByTagId(int bind_tag_id, Model model) {
        jdbcTemplate.update("update bind set bind_delete = 1 where bind_tag_id = ?", bind_tag_id);
    }

    public String getBindById(int bind_id, Model model) {
        return jdbcTemplate.queryForMap("select * from bind where bind_id = ? and bind_delete != 1", bind_id).toString();
    }

    public String getBindByPatientId(int bind_patient_id) {
        return jdbcTemplate.queryForList("select * from bind where bind_patient_id = ? and bind_delete != 1 and  " +
                "bind_start_time <= now() and  bind_end_time >= now()", bind_patient_id).toString();
    }

    public String getBindByTagId(int bind_tag_id) {
        return jdbcTemplate.queryForList("select * from bind where bind_tag_id = ? and bind_delete != 1 and " +
                "bind_start_time <= now() and  bind_end_time >= now()", bind_tag_id).toString();
    }



}
