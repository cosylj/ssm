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
public class PublicCheckDriverTest {

    @Reference(version = "1.1.0")
    DoctorService doctorService;

    @Autowired
    TestDate testDate;
    @BeforeClass
    public static void prepare() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }


    /**
     * 设备校验的公共的测试用例
     */
    //1.userid为空，DeviceInfo不为空
    @Test
    public void nullUserid(){
        Long userId=null;
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","SYT30022B86H004691",null,null,null,"68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(userId,deviceInfo);
            //doctorActions.activateDoctorUser(userId,deviceInfo);
        }catch (NullPointerException d){
            Assert.assertEquals(null,d.getMessage());
        }
    }

    //2.userid不为空，DeviceInfo为空

    @Test
    public void nullDeviceInfo(){
        try {
            doctorService.activateDevicePackage(1L,null);
            //doctorActions.activateDoctorUser(1L,null);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //3.userid不存在用户，DeviceInfo不为空
    @Test
    public void noExitUserId(){
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","SYT30022B86H00469",null,null,null,"68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);
        try {
            doctorService.activateDevicePackage(7777777L,deviceInfo);
           // doctorActions.activateDoctorUser(7777777L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("100:未查询到用户",doma.getMsg());
        }
    }
    //4.userid存在用户但已注册，DeviceInfo数据正确
    @Test
    public void exidUserId(){
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","SYT30022B86H00469",null,null,null,"68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("100:查询用户服务包状态失败",doma.getMsg());
        }
    }


    //6.userid存在用户，DeviceInfo中的vCode为空
    @Test
    public void nullVcode(){
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","SYT30022B86H00469",null,null,null,"68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",null);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

}
