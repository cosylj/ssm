package com.halove.server.service.doctor.test.mappers;



import com.halove.server.service.doctor.test.model.UserIdcard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserIdcard {


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_idcard
     *
     * @mbg.generated Wed Aug 15 09:58:35 CST 2018
     */
    int insertSelective(UserIdcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_idcard
     *
     * @mbg.generated Wed Aug 15 09:58:35 CST 2018
     */
    UserIdcard selectByPrimaryKey(Long idUser);
}