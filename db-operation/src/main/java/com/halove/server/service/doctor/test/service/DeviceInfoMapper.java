package com.halove.server.service.doctor.test.service;


import com.halove.server.service.doctor.test.model.DeviceInfo;

public interface DeviceInfoMapper {


    int insertSelective(DeviceInfo record);

    DeviceInfo selectByPrimaryKey(Long id);
}
