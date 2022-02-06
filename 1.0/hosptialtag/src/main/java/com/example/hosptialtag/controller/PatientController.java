package com.example.hosptialtag.controller;

import com.example.hosptialtag.pojo.Tag;
import com.example.hosptialtag.service.BindService;
import com.example.hosptialtag.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author liuyuhao
 * @Date 2022/2/3
 */
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private BindService bindService;

    @RequestMapping("/createPatient")//新建病人信息档案
    public String createPatient(String patient_name, int patient_age , String patient_idcard, String patient_phone, Model model){
        return patientService.createPatient(patient_name, patient_age, patient_idcard, patient_phone, model);
    }

    @RequestMapping("/deletePatientById")//根据病人id删除病人信息
    public String deletePatientById(int patient_id,Model model){
        bindService.deleteBindByPatientId(patient_id, model);  //同时删除病人相关的绑定关系
        return patientService.deletePatientById(patient_id,model);
    }

    @RequestMapping("/getPatientById")//根据病人id查询病人信息
    public String getPatientById(int patient_id,Model model){
        return patientService.getPatientById(patient_id,model);
    }

    @RequestMapping("/getPatientsCount")//查询病人总数量
    public String getPatientsCount(Model model){
        return patientService.getPatientsCount(model);
    }

    @RequestMapping("/getPatientListByCondition")//根据多个tag筛选病人
    public String getPatientListByCondition(List<Tag> tagList, Model model){
        return patientService.getPatientListByCondition(tagList, model);
    }

}
