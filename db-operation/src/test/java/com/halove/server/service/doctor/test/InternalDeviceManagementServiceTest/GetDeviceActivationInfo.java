package com.halove.server.service.doctor.test.InternalDeviceManagementServiceTest;


import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;
import com.halove.server.service.doctor.InternalDeviceManagementService;
import com.halove.server.service.doctor.test.common.FreePackage;
import com.halove.server.service.doctor.test.model.UserMember;
import com.halove.server.service.doctor.test.common.TestDate;
import com.halove.server.service.doctor.test.model.DoctorDeviceInfo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@Transactional
//@Rollback
public class GetDeviceActivationInfo {
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
            internalDeviceManagementService.getDeviceActivationInfo(null,"1111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //空的token
    @Test
    public void emptyToken(){
        try {
            internalDeviceManagementService.getDeviceActivationInfo("","1111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
            System.out.println("=============="+doma.getMsg());
        }
    }

    //错误的token
    @Test
    public void errorToken(){
        try {
            internalDeviceManagementService.getDeviceActivationInfo("edad51e6-4f28-4122-a6a5-5f02ca3868c1","1111");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //正确的token不存在的imei
    @Test
    public void noExitImei(){
        Map<String, Object> result=internalDeviceManagementService.getDeviceActivationInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T","1111");
        Assert.assertEquals("没有查询到设备",result.get("查询结果"));
    }

    //正确的token,存在的imei，未激活,model为HL3001
    @Test
    public void exitImeiAndActice(){
        UserMember userMember= testDate.createUserMember(null,"13300000000",null,(short)1,null,null,null,null);
        DoctorDeviceInfo doctorDeviceInfo=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",null,FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        testDate.createDoctorDeviceActivation(userMember.getId(),"HL3001","1111","1111","dddd",null);

        Map<String, Object> result=internalDeviceManagementService.getDeviceActivationInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",doctorDeviceInfo.getImei1());

       Assert.assertEquals(userMember.getMobile(),result.get("激活手机号"));
       Assert.assertEquals("test",result.get("经销商"));
       Assert.assertEquals("4444",result.get("批次"));
       Assert.assertEquals(doctorDeviceInfo.getReleased().toString(),result.get("生产日期").toString());
       Assert.assertEquals("V1",result.get("设备类型"));
       Assert.assertEquals("未激活",result.get("激活时间"));
       Assert.assertEquals("一键通体验卡",result.get("赠卡类型"));
    }

    //已激活且有激活记录
    @Test
    public void exitAndActiveDriver(){
        UserMember userMember= testDate.createUserMember(null,"13300000000",null,(short)1,null,null,null,null);
        DoctorDeviceInfo doctorDeviceInfo=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",new Date(),FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        testDate.createDoctorDeviceActivation(userMember.getId(),"HL3001","1111","1111","dddd",doctorDeviceInfo.getActivated());

        Map<String, Object> result=internalDeviceManagementService.getDeviceActivationInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",doctorDeviceInfo.getImei1());

        Assert.assertEquals(doctorDeviceInfo.getActivated(),result.get("激活手机号"));
        Assert.assertEquals("test",result.get("经销商"));
        Assert.assertEquals("4444",result.get("批次"));
        Assert.assertEquals(doctorDeviceInfo.getReleased().toString(),result.get("生产日期").toString());
        Assert.assertEquals("F1S",result.get("设备类型"));
        Assert.assertEquals(doctorDeviceInfo.getActivated(),result.get("激活时间"));
        Assert.assertEquals("一键通体验卡",result.get("赠卡类型"));
    }

    //设备已经激活，但没有激活记录
    @Test
    public void noActiveRecord(){
        try{
            testDate.createUserMember(null,"13300000000",null,(short)1,null,null,null,null);
            DoctorDeviceInfo doctorDeviceInfo=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",new Date(),FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());

            internalDeviceManagementService.getDeviceActivationInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",doctorDeviceInfo.getImei1());
        }catch (Exception E){
            Assert.assertNull(E.getMessage());
        }
    }


    //设备是F1S,已激活且有激活记录

    @Test
    public void actived(){
        UserMember userMember= testDate.createUserMember(null,"13300000000",null,(short)1,null,null,null,null);
        DoctorDeviceInfo doctorDeviceInfo=testDate.createDoctorDeviceInfoPO(444l,"1111","2222","4444","HL3001","7777",new Date(),FreePackage.VIP_30_HALOVE_PROMOTION,"test","4444",new Date());
        testDate.createDoctorDeviceActivation(userMember.getId(),"HL3001","1111","1111","dddd",doctorDeviceInfo.getActivated());

        Map<String, Object> result=internalDeviceManagementService.getDeviceActivationInfo("0pLmHn311UhIdUyk5evm7rs7CbcuGF2JcA4T",doctorDeviceInfo.getImei1());

        Assert.assertEquals("18658891868",result.get("激活手机号"));
        Assert.assertEquals("test",result.get("经销商"));
        Assert.assertEquals("4444",result.get("批次"));
        Assert.assertEquals(doctorDeviceInfo.getReleased().toString(),result.get("生产日期").toString());
        Assert.assertEquals("F1S",result.get("设备类型"));
        Assert.assertEquals(doctorDeviceInfo.getActivated(),result.get("激活时间"));
        Assert.assertEquals("一键通体验卡",result.get("赠卡类型"));
    }

}
