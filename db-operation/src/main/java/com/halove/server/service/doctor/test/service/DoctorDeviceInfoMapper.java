package com.halove.server.service.doctor.test.service;


import com.halove.server.service.doctor.test.model.DoctorDeviceInfo;

public interface DoctorDeviceInfoMapper {
    int insertSelective(DoctorDeviceInfo record);

    DoctorDeviceInfo selectByPrimaryKey(Long id);


}
