package com.example.hosptialtag.service;

/**
 * @Author  liuyuhao
 * @Date  2022-2-2
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class TagService {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    private String sql;

    public TagService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTag(String tag_name, Integer tag_group, String tag_start_time, String tag_end_time,Model model){
        jdbcTemplate.update("insert into tag(tag_name, tag_group, tag_start_time, tag_end_time) value (?,?,?,?)",
                tag_name, tag_group, tag_start_time, tag_end_time);
        model.addAttribute("message","成功");
        return "index";
    }
    public String createTag_Forever(String tag_name, Integer tag_group, Model model) {
        jdbcTemplate.update("insert into tag(tag_name, tag_group) value (?,?)",
                tag_name, tag_group);
        model.addAttribute("message","添加成功");
        return "index";
    }

    public String deleteTagById(int tag_id, Model model) {
        jdbcTemplate.update("update tag set tag_delete = 1 where tag_id=?", tag_id);
        model.addAttribute("message","删除成功");
        return "index";
    }

    public String getTagById(int tag_id, Model model) {
        List<Map<String, Object>> tag = jdbcTemplate.queryForList("select * from tag where tag_id = ? and tag_delete!=1", tag_id);
        model.addAttribute("tag",tag);
        return "index";

    }

    public String getTagsByPatientIdAndGroupId(int patient_id, int tag_group, Model model) {
        sql = "select * from tag \n" +
                "where tag_group = ? and tag_id = (\n" +
                "select bind_tag_id from bind\n" +
                "where bind_tag_id = tag_id and bind_patient_id = ? \n" +
                ");";
        List<Map<String, Object>> tag = jdbcTemplate.queryForList(sql, patient_id, tag_group);
        System.out.println(tag.toString());
        model.addAttribute("tag",tag);
        return "index";
    }

    public String getTagByName(String tag_name, Model model) {
        sql = "select * from tag where tag_name = ?";
        return jdbcTemplate.queryForList(sql,tag_name).toString();
    }

    public String getTagsCount(Model model) {
        model.addAttribute("count",Integer.toString(jdbcTemplate.queryForObject("select count(1) from tag where tag_delete != 1", Integer.class)));
        return "index";
    }
    public int getTagsCountByTagId(int tag_id) {
        return jdbcTemplate.queryForObject("select count(1) from tag where tag_delete != 1 and tag_id = "+ Integer.toString(tag_id), Integer.class);
    }



}
