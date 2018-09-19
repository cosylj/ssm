package com.halove.server.service.doctor.test.service.impl;



import com.halove.server.service.doctor.test.mappers.IDeviceInfo;

import com.halove.server.service.doctor.test.model.DeviceInfo;
import com.halove.server.service.doctor.test.service.DeviceInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceInfoMapperImpl implements DeviceInfoMapper {
    @Autowired
    IDeviceInfo iDeviceInfo;

    @Override
    public int insertSelective(DeviceInfo record) {
        return iDeviceInfo.insertSelective(record);
    }

    @Override
    public DeviceInfo selectByPrimaryKey(Long id) {
        return iDeviceInfo.selectByPrimaryKey(id);
    }
}
