package com.halove.server.service.doctor.test.doctorActionsTest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;
import com.halove.server.service.doctor.DeviceInfo;
import com.halove.server.service.doctor.DoctorService;

import com.halove.server.service.doctor.test.common.TestDate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")


public class F1Check {
    @Reference(version = "1.1.0")
    DoctorService doctorService;

    @Autowired
    TestDate testDate;

    @BeforeClass
    public static void prepare() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //1.DeviceInfo中的imei1与vCode中的imei1一致
    @Test
    public void sameIMEI1(){
        String vCode="KZwKMr7L5xpyuJqlXINidI0VYyOjdSwMWSDx8lIKwhgXP3HSmyD6mEvFfGKa817qOycg+ChgmWEQ\n" +
                "ANQn5ClAuvzn2jbiCwaoR50YHsHQtsBKLoNCZLsaDxTjQJsIGfqxbTs+GB20cMOYQkuy0EuYGQnd\n" +
                "0NrUTciiNPx+FY3vVxhEXpaiWQOz12dGeyMejaqrjqQC+PztBYMoWzscOUlFfP5e4Jom/2CkAqce\n" +
                "xprf+zquxtyuu9a2PVADS1+4jZHVgeslg2dg9FXpXmziXV/0zloge8YcuHePr6t9PEkMCQkfSLTS\n" +
                "X2AVenrslvwnZLIHfAVoyJd2inTYHWOC8ha8JQ==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","1111","","1111","","","",vCode);

        try {
              doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1与vCode中的imei1不一致
    @Test
    public void noSameIMEI1(){
        String vCode="KZwKMr7L5xpyuJqlXINidI0VYyOjdSwMWSDx8lIKwhgXP3HSmyD6mEvFfGKa817qOycg+ChgmWEQ\n" +
                "ANQn5ClAuvzn2jbiCwaoR50YHsHQtsBKLoNCZLsaDxTjQJsIGfqxbTs+GB20cMOYQkuy0EuYGQnd\n" +
                "0NrUTciiNPx+FY3vVxhEXpaiWQOz12dGeyMejaqrjqQC+PztBYMoWzscOUlFfP5e4Jom/2CkAqce\n" +
                "xprf+zquxtyuu9a2PVADS1+4jZHVgeslg2dg9FXpXmziXV/0zloge8YcuHePr6t9PEkMCQkfSLTS\n" +
                "X2AVenrslvwnZLIHfAVoyJd2inTYHWOC8ha8JQ==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","11111","","1111","","","",vCode);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
          //  doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1为null与vCode中的imei1不为null
    @Test
    public void nullVcode(){
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","11111","","1111","","","",null);
        try {
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1为“”与vCode中的imei1不为空
    @Test
    public void emptyIMEI(){
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","","","1111","","","",null);
        try {
             doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1为“  ”与vCode中的imei1不为空
    @Test
    public void spantIMEI(){
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","  ","","1111","","","",null);
        try {
             doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1长度为16为数字
    @Test
    public void longImei(){
        String vCODE="dO3s26OQj2mPaD6wOq9r7ay35fISNE4dAzfibmmrUqe8LbffH9dRqr4xwy6YeJbeNkrIb581rPjX\n" +
                "1bhUKZ4tEQs+WrxfTQmI6/2RtafCDEdhUW7RcUFdUk1x7fLqjBbMbtkJDxuLi5ebAJ+2gOpJioAO\n" +
                "wa3tgwtKL1KX3azqbTR2gXOctwfWFrcLsCAo/6RbQ3V3o+gb4BRT76IINFg8MtBLKtMjTs8jP45U\n" +
                "eAhOlDEYOzgr43hwtuy6aCXDlCQEbIEF0FdSLKmZFt5sADwzRvujPakb8m7qqTk4wnKcHFCXoFz+\n" +
                "PuuxLo4KCNflTTLE5pZZ2TCzZLBgWhVvLXPJaw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","123456789111111111","","123456789111111111","","","",vCODE);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包1",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei1长度为14为数字
    @Test
    public void shortImei(){
        String vCODE="hEMJHzTHc3C5/FJtO2eVxW731wVkvqIuz7RU1Zh6HG1XCvIA0wnAKLxCnvxOun7r4wH2g9sK1KUl\n" +
                "Jh1/kN7wTpvb9xZ+1+xPL4t7LsEN8JdD9zpwFR9DJEpxYvsC27eG+zBG3WCy/a62Vw0tEXBoI2Aq\n" +
                "I56FDlIFmORqXUdPEhdCvOxbYmGxk3VxR5GxDzaScaYFBYNZwiXzHLwyX6FqCmrewXPVr8/NmHhK\n" +
                "mbBZ9xDcjumijyOWmT0L+VJ29Q1VcQqTkfqxJKfOTueBO+zbJLRmBT8Ccmrg7putm4BeHBd8//rs\n" +
                "5uweevla9LHEDoh17gozv2W1+BwOwOZcldIU9A==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("Q8311WD","","590013664","12345678911111","","12345678911111","","","",vCODE);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包1",doma.getMsg());
        }
    }
}
