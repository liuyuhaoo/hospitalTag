package com.example.hosptialtag.service;

import com.example.hosptialtag.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Author liuyuhao
 * @Date 2022/2/3
 */
@Service
public class PatientService {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    private String sql;

    public PatientService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createPatient(String patient_name, int patient_age , String patient_idcard, String patient_phone, Model model){
        jdbcTemplate.update("insert into patient(patient_name, patient_age, patient_idcard, patient_phone) values(?,?,?,?)",
                patient_name, patient_age, patient_idcard, patient_phone);
        return "index";
    }

    public String deletePatientById(int patient_id, Model model) {
        jdbcTemplate.update("update patient set patient_delete = 1 where patient_id = ?", patient_id);
        return "index";
    }

    public String getPatientById(int patient_id, Model model) {
        return jdbcTemplate.queryForMap("select * from patient where patient_id = ? and patient_delete != 1", patient_id).toString();
    }

    public String getPatientsCount(Model model){
        return (jdbcTemplate.queryForObject("select count(1) from patient where patient_delete != 1", Integer.class)).toString();
    }
    public int getPatientsCountByPatientId(int patient_id){
        return jdbcTemplate.queryForObject("select count(1) from patient where patient_delete != 1 and patient_id = " + Integer.toString(patient_id), Integer.class);
    }

    public String getPatientListByCondition(List<Tag> tagList, Model model) {
        sql = "select * from patient\n" +
                "where exists(\n" +
                "select bind_patient_id\n" +
                "from bind\n" +
                "where 1 = 1 ";

        for(Tag t: tagList){
             sql+="and exists(\n" +
                     "select * from bind\n" +
                     "where bind_patient_id = patient_id and bind_tag_id ="+Integer.toString(t.getTag_id());
        }
        for (int i=0;i<tagList.size();i++){
            sql+=")";
        }
        sql+=") ;";
        return jdbcTemplate.queryForList(sql).toString();
    }
}
