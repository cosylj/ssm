package com.halove.server.service.doctor.test.service.impl;


import com.halove.server.service.doctor.test.mappers.IUserIdcard;
import com.halove.server.service.doctor.test.model.UserIdcard;

import com.halove.server.service.doctor.test.service.UserIdcardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIdcardMapperImpl implements UserIdcardMapper {

    @Autowired
    IUserIdcard iUserIdcard;
    @Override
    public int insertSelective(UserIdcard record) {
        return iUserIdcard.insertSelective(record);
    }

    @Override
    public UserIdcard selectByPrimaryKey(Long idUser) {
        return iUserIdcard.selectByPrimaryKey(idUser);
    }
}
