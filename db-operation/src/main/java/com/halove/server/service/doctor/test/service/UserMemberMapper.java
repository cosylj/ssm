package com.halove.server.service.doctor.test.service;

import com.halove.server.service.doctor.test.model.UserMember;
public interface UserMemberMapper {



    int insertSelective(UserMember record);


    UserMember selectByPrimaryKey(Long id);
}