package com.example.hosptialtag.controller;

import com.example.hosptialtag.service.BindService;
import com.example.hosptialtag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author  liuyuhao
 * @Date  2022-2-2
 */

@RestController
public class TagController {
@Autowired
private TagService tagService;
@Autowired
private BindService bindService;
@RequestMapping("/createTag")//创建有时间限制的标签
    public String createTag(String tag_name, Integer tag_group, String tag_start_time, String tag_end_time,Model model){
    return tagService.createTag(tag_name, tag_group, tag_start_time, tag_end_time, model);
}
@RequestMapping("/createTag_Forever")//创建期限为创建时间到9999年的标签（datetime极限，看作无期限）
    public String createTag_Forever(String tag_name, Integer tag_group, Model model){
        return tagService.createTag_Forever(tag_name, tag_group, model);
    }

@RequestMapping("/deleteTagById")//根据tag_id删除tag
    public String deleteTagById(int tag_id,Model model){
    bindService.deleteBindByTagId(tag_id,model);//同时删除tag相关的绑定
    return tagService.deleteTagById(tag_id,model);
}

@RequestMapping("/getTagById")//根据tag_id获得tag
    public String getTagById(int tag_id,Model model){
    return tagService.getTagById(tag_id,model);
    }

@RequestMapping("/getTagsByPatientIdAndGroupId")//查看一个人在某分组中的tag
    public String getTagsByPatientIdAndGroupId(int patient_id, int tag_group, Model model){
        return tagService.getTagsByPatientIdAndGroupId(patient_id, tag_group, model);
    }

@RequestMapping("/getTagByName")
    public String getTagByName(String tag_name, Model model){
    return tagService.getTagByName(tag_name,model);
}

@RequestMapping("/getTagsCount")//所有标签个数(除删除的外)
    public String getTagsCount(Model model){
    String num = tagService.getTagsCount(model);
    return num;
}


@RequestMapping("/t")

    public void test(){

    System.out.println("test");
}
}
