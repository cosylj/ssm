package com.halove.server.service.doctor.test.InternalDeviceManagementServiceTest;



import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;

import com.halove.server.service.doctor.InternalDeviceManagementService;
import com.halove.server.service.doctor.test.common.FreePackage;
import com.halove.server.service.doctor.test.common.TestDate;
import com.halove.server.service.doctor.test.model.UserMember;
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
public class activateFreePackageTest {
    @Autowired
    TestDate testDate;

    @Reference()
    InternalDeviceManagementService internalDeviceManagementService;



    @BeforeClass
    public static void befor() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //1.输入手机号null
    @Test
    public void nullMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0",null,"VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }
    //1.输入手号码“  ”
    @Test
    public void spaceMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","  ","VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }
    //1.输入手号码“”
    @Test
    public void emptyMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","","VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }

    //1.输入10位手机号"1330000000"
    @Test
    public void shortMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","1330000000","VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }

    //1.输入12位手机号"133000000000"
    @Test
    public void longMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","133000000000","VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }

    //1.输入11位非运营商的手机号"11300000000"
    @Test
    public void notMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","11300000000","VIP_180_STANDARD");
        }catch (Exception E){
            Assert.assertEquals(null,E.getMessage());
        }
    }

    //1.查找不存在的用户
    @Test
    public void notExitUserByMobile(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","13600000000","VIP_180_STANDARD");
        }catch (DomainException dome){
            Assert.assertEquals("用户不存在",dome.getMsg());
        }
    }

    //1.Token为“”，进行 校验
    @Test
    public void emptyToken(){
        try {
            internalDeviceManagementService.activateFreePackage("","13600541783","VIP_180_STANDARD");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //1.Token为null，进行 校验
    @Test
    public void nullToken(){
        try {
            internalDeviceManagementService.activateFreePackage(null,"13600541783","VIP_180_STANDARD");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

   // 1.输入错误的的TestToken“edad51e6-4f28-4122-a6a5-5f02ca3868c7”，进行校验
    @Test
    public void errorTestoken(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c7","13600541783","VIP_180_STANDARD");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //1.输入错误的的ApiToken“3333dafdaf”，进行校验
    @Test
    public void errorApioken(){
        try {
            internalDeviceManagementService.activateFreePackage("Jo9dqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C","13600541783","VIP_180_STANDARD");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //服务包为null
    @Test
    public void nullFreePackage(){
        try {
            internalDeviceManagementService.activateFreePackage("Jo9dqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C","13600541783",null);
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //空的服务包
    @Test
    public void emptyFreePackage(){
        try {
            internalDeviceManagementService.activateFreePackage("Jo9dqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C","13600541783","");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //不存在的服务包
    @Test
    public void noExitFreePackage(){
        try {
            internalDeviceManagementService.activateFreePackage("Jo9dqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C","13600541783","VIP_90_STANDARD1");
        }catch (DomainException doma){
            Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }

    //激活服务包失败
    @Test
    public void fildActivateFreePackage(){
        try {
            internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","13067880116","VIP_90_STANDARD");
        }catch (DomainException doma){
            Assert.assertEquals("4:渠道不支持",doma.getMsg());
        }

    }


    //token为测试环境激活所有服务包
    @Test
    public void activateAllFreePackageInTestEvn(){
        int i=0;
        try {
            for (FreePackage freePack:FreePackage.values()){
                i++;
                for(int j=i;j<=i;j++){
                    testDate.createUserMember("test","1330000000"+j,"1111",(short)1,"cosy","cosytest",new Date(),new Date());
                    internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0","13067880116",freePack.toString());
                }
            }
        }catch (DomainException doma){
           // Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }


    //1.测试环境，13300000011手机号，VIP_365_UNLIMITED_PAD服务包，激活，
    //验证一个手机号能否激活多个服务包

    @Test
    public void activateFreePackageBySameMobile(){
        UserMember userMember=testDate.createUserMember("test","13300000000","1111",(short)1,"cosy","cosytest",new Date(),new Date());

        //第一次激活服务包
        internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0",userMember.getMobile(),"VIP_90_STANDARD");
        //再次激活
        internalDeviceManagementService.activateFreePackage("edad51e6-4f28-4122-a6a5-5f02ca3868c0",userMember.getMobile(),"VIP_90_STANDARD");
    }

    //  token为非测试环境激活所有服务包Jo9CqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C
    @Test
    public void activateAllFreePackageNotInTestEvn(){
        int i=0;
        try {
            for (FreePackage freePack:FreePackage.values()){
                i++;
                for(int j=i;j<=i;j++){
                    testDate.createUserMember("test","1330000000"+j,"1111",(short)1,"cosy","cosytest",new Date(),new Date());

                    internalDeviceManagementService.activateFreePackage("Jo9CqILq0Saa1bcuGpz6cbN0pLmHn31F2J9acA4TUhIdUy65k5evm7Dsrs7u5C","13067880116",freePack.toString());
                }
            }
        }catch (DomainException doma){
            // Assert.assertEquals("parameter is invalid",doma.getMsg());
        }
    }






}
