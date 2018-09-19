package com.halove.server.service.doctor.test.service.impl;


import com.halove.server.service.doctor.test.mappers.IDoctorDeviceInfo;
import com.halove.server.service.doctor.test.model.DoctorDeviceInfo;
import com.halove.server.service.doctor.test.service.DoctorDeviceInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDeviceInfoMapperImpl implements DoctorDeviceInfoMapper {
    @Autowired
    IDoctorDeviceInfo iDoctorDeviceInfo;
    @Override
    public int insertSelective(DoctorDeviceInfo record) {
        return iDoctorDeviceInfo.insertSelective(record);
    }

    @Override
    public DoctorDeviceInfo selectByPrimaryKey(Long id) {
        return iDoctorDeviceInfo.selectByPrimaryKey(id);
    }
}
