package com.halove.server.service.doctor.test.service.impl;

import com.halove.server.service.doctor.test.mappers.IDoctorDeviceActivation;
import com.halove.server.service.doctor.test.model.DoctorDeviceActivation;
import com.halove.server.service.doctor.test.service.DoctorDeviceActivationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDeviceActivationMapperImpl implements DoctorDeviceActivationMapper {

    @Autowired
    IDoctorDeviceActivation iDoctorDeviceActivation;
    @Override
    public int insert(DoctorDeviceActivation record) {
       return iDoctorDeviceActivation.insert(record);
    }

    @Override
    public int insertSelective(DoctorDeviceActivation record) {
        return iDoctorDeviceActivation.insertSelective(record);
    }

    @Override
    public DoctorDeviceActivation selectByPrimaryKey(Long id) {
        return iDoctorDeviceActivation.selectByPrimaryKey(id);
    }
}
