package com.halove.server.service.doctor.test.InternalDeviceManagementServiceTest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;
import com.halove.server.service.doctor.DoctorServiceStatus;
import com.halove.server.service.doctor.InternalDeviceManagementService;
import com.halove.server.service.doctor.test.model.UserMember;
import com.halove.server.service.doctor.test.common.TestDate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@Transactional
//@Rollback
public class GetServicePackageInfoTest {
    @Autowired
    TestDate testDate;

    @Reference()
    InternalDeviceManagementService internalDeviceManagementService;

    @BeforeClass
    public static void befor() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //nullToken
    @Test
    public void nullToken(){
        try {
            internalDeviceManagementService.getServicePackageInfo(null,"13600541783");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

   //空的Token
    @Test
    public void emptyToken(){
        try {
            internalDeviceManagementService.getServicePackageInfo("","13600541783");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //错误的Token
    @Test
    public void errorToken(){
        try {
            internalDeviceManagementService.getServicePackageInfo("edad51e6-4f28-4122-a6a5-5f02ca3868c1","13600541783");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //nullmobile
    @Test
    public void nullMobile(){
        try {
            internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",null);
        }catch (DomainException doma){
            Assert.assertEquals("用户不存在",doma.getMsg());
        }
    }

    //空的mobile
    @Test
    public void emptyMobile(){
        try {
            internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T","");
        }catch (DomainException doma){
            Assert.assertEquals("用户不存在",doma.getMsg());
        }
    }


    //不存在的mobile
    @Test
    public void noExitMobile(){
        try {
            internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T","13300000000");
        }catch (DomainException doma){
            Assert.assertEquals("用户不存在",doma.getMsg());
        }
    }

    //不存在的用户
    @Test
    public void exitMobile(){
        try {
            internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T","13300000000");
        }catch (DomainException doma){
            Assert.assertEquals("用户不存在",doma.getMsg());
        }
    }

    //存在的用户但没有服务包
    @Test
    public void exitUserNoPackageInFo(){
        UserMember userMember=testDate.createUserMember("test","13600541783","123456",(short)1,"tese","cosy",new Date(),null);
        DoctorServiceStatus doctorServiceStatus=internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",userMember.getMobile());
        Assert.assertEquals(null,doctorServiceStatus.getServicePackageInfo());
        Assert.assertEquals(null,doctorServiceStatus.getExpireDate());
    }

    //存在的用户且有服务卡
    @Test
    public void exitUserPackageInFo(){
        DoctorServiceStatus doctorServiceStatus=internalDeviceManagementService.getServicePackageInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T","18803836226");
        Assert.assertEquals("个人健康VIP・半年卡",doctorServiceStatus.getServicePackageInfo().getPackageName());
        Assert.assertEquals("Sat Mar 09 23:59:59 CST 2019",doctorServiceStatus.getExpireDate().toString());
    }
}
