package com.halove.server.service.doctor.test.InternalDeviceManagementServiceTest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;

import com.halove.server.service.doctor.InternalDeviceManagementService;
import com.halove.server.service.doctor.test.common.FreePackage;
import com.halove.server.service.doctor.test.common.TestDate;
import com.halove.server.service.doctor.test.model.DoctorDeviceActivation;
import com.halove.server.service.doctor.test.model.DoctorDeviceInfo;
import com.halove.server.service.doctor.test.service.DoctorDeviceActivationMapper;
import com.halove.server.service.doctor.test.service.DoctorDeviceInfoMapper;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
@Transactional
//@Rollback
public class clearDeviceActivation {
    @Autowired
    TestDate testDate;

    @Reference()
    InternalDeviceManagementService internalDeviceManagementService;

    @Autowired
    DoctorDeviceInfoMapper doctorDeviceInfoMapper;

    @Autowired
    DoctorDeviceActivationMapper doctorDeviceActivationMapper;


    @BeforeClass
    public static void befor() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //nullToken
    @Test
    public void nullToken(){
        try {
            internalDeviceManagementService.clearDeviceActivation(null,"11111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //空的token
    @Test
    public void emptyToken(){
        try {
            internalDeviceManagementService.clearDeviceActivation("","11111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //错误的token
    @Test
    public void errorToken(){
        try {
            internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c1","11111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //nullImei
    @Test
    public void nullImei(){
         String string=internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0",null);
         Assert.assertEquals("设备信息不存在(未录入的设备或F1设备) 没有激活记录",string);
    }

    //空的Imei ??
    @Test
    public void emptyImei(){
        try {
            internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0","");
        }catch (InvalidDataAccessApiUsageException e){
           System.out.println("===================="+e.getLocalizedMessage());
        }
    }

    //设备激活信息Imei：863002030114047
    //未激活，且没有记录
    @Test
    public void noActivedAndNoRecord(){
         DoctorDeviceInfo doctorDeviceInfoPO=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",null,FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
         String string=internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0","1111");
         Assert.assertEquals("查询到设备[未激活] 没有激活记录",string);
         DoctorDeviceInfo doctorDeviceInfoPO1=doctorDeviceInfoMapper.selectByPrimaryKey(doctorDeviceInfoPO.getId());
        Assert.assertEquals(null,doctorDeviceInfoPO1.getActivated());

    }

    //1.设备服务包信息Imei：863002030114047，已激活，
    //但没有激活记录
    @Test
    public void activedAndNoRecord(){
        DoctorDeviceInfo doctorDeviceInfoPO=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",new Date(),FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        String string=internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0","1111");
        Assert.assertEquals("查询到设备[已激活] 没有激活记录",string);
        DoctorDeviceInfo doctorDeviceInfoPO1=doctorDeviceInfoMapper.selectByPrimaryKey(doctorDeviceInfoPO.getId());
        Assert.assertEquals(null,doctorDeviceInfoPO1.getActivated());

    }

    //1.设备服务包信息Imei：863002030114047，未激活，
    //有激活记录
    @Test
    public void noActivedAndRecord(){
        testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",null,FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        testDate.createDoctorDeviceActivation(1l,"HL3001","1111","1111","dddd",null);
        String string=internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0","1111");
        Assert.assertEquals("查询到设备[未激活] 清除了激活记录",string);
       DoctorDeviceActivation doctorDeviceActivationPO=doctorDeviceActivationMapper.selectByPrimaryKey(1L);
       Assert.assertNull(doctorDeviceActivationPO);
    }

    //1.设备服务包信息Imei：863002030114047，未激活，
    //有激活记录
    @Test
    public void ActivedAndRecord(){
        DoctorDeviceInfo doctorDeviceInfoPO=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",new Date(),FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        testDate.createDoctorDeviceActivation(1l,"HL3001","1111","1111","dddd",doctorDeviceInfoPO.getActivated());
        String string=internalDeviceManagementService.clearDeviceActivation("edad51e6-4f28-4122-a6a5-5f02ca3868c0","1111");
        Assert.assertEquals("查询到设备[已激活] 清除了激活记录",string);
        DoctorDeviceInfo doctorDeviceInfoPO1=doctorDeviceInfoMapper.selectByPrimaryKey(doctorDeviceInfoPO.getId());
        Assert.assertNull(null,doctorDeviceInfoPO1.getActivated());
        DoctorDeviceActivation doctorDeviceActivationPO=doctorDeviceActivationMapper.selectByPrimaryKey(1L);
        Assert.assertNull(doctorDeviceActivationPO);
    }

}
