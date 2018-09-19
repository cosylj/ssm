package com.halove.server.service.doctor.test.service;

import com.halove.server.service.doctor.test.model.DoctorDeviceActivation;

public interface DoctorDeviceActivationMapper {


    int insert(DoctorDeviceActivation record);


    int insertSelective(DoctorDeviceActivation record);


    DoctorDeviceActivation selectByPrimaryKey(Long id);
}
