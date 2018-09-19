package com.halove.server.service.doctor.test.service;


import com.halove.server.service.doctor.test.model.UserIdcard;

public interface UserIdcardMapper {


    int insertSelective(UserIdcard record);


    UserIdcard selectByPrimaryKey(Long idUser);
}