package com.halove.server.service.doctor.test.service.impl;




import com.halove.server.service.doctor.test.mappers.IUserMember;
import com.halove.server.service.doctor.test.model.UserMember;
import com.halove.server.service.doctor.test.service.UserMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMemberMapperImpl implements UserMemberMapper {
    @Autowired
    IUserMember iUserMember;

    @Override
    public int insertSelective(UserMember record) {
        return iUserMember.insertSelective(record);
    }

    @Override
    public UserMember selectByPrimaryKey(Long id) {
        return iUserMember.selectByPrimaryKey(id);
    }
}
