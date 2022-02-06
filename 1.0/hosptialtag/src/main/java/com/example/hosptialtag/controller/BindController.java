package com.example.hosptialtag.controller;

import com.example.hosptialtag.service.BindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liuyuhao
 * @Date 2022/2/3
 */
@RestController
public class BindController {

    @Autowired
    private BindService bindService;

    @RequestMapping("/createBind")//新建绑定（病人id——标签id）有限时间
    public String createBind(int bind_patient_id, int bind_tag_id, String bind_start_time, String bind_end_time, Model model) {
        return bindService.createBind(bind_patient_id, bind_tag_id, bind_start_time, bind_end_time, model);
    }

    @RequestMapping("/createBindForever")//新建绑定，1900到9999年默认为无限时间
    public String createBindForever(int bind_patient_id, int bind_tag_id, Model model) {
        return bindService.createBindForever(bind_patient_id, bind_tag_id, model);
    }

    @RequestMapping("/updateBind")
    public String updateBind(int bind_id, int bind_patient_id, int bind_tag_id, String bind_start_time, String bind_end_time, Model model){
        return bindService.updateBind(bind_id, bind_patient_id, bind_tag_id, bind_start_time, bind_end_time, model);
    }

    @RequestMapping("/deleteBindById")//根据bind_id删除
    public String deleteBindId(int bind_id, Model model) {
        return bindService.deleteBindById(bind_id, model);
    }

    @RequestMapping("/getBindById")//根据bind_id获取
    public String getBindById(int bind_id, Model model) {
        return bindService.getBindById(bind_id, model);
    }

    @RequestMapping("/getBindByPatientId")//根据bind_patient_id获取 并保证在期限内
    public String getBindByPatientId(int bind_patient_id, Model model){
        return bindService.getBindByPatientId(bind_patient_id);
    }

    @RequestMapping("/getBindByTagId")//根据bind_tag_id获取  并保证在期限内
    public String getBindByTagId(int bind_tag_id, Model model){
        return bindService.getBindByTagId(bind_tag_id);
    }

//    @RequestMapping("/getBind")

}
