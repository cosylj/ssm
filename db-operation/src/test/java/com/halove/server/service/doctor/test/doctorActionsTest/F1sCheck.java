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
public class F1sCheck {
    @Reference(version = "1.1.0")
    DoctorService doctorService;

   @Autowired
    TestDate testDate;

    @BeforeClass
    public static void prepare() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //1.userid存在用户，DeviceInfo中的serial为空
    @Test
    public void emptySerial(){
        //SYT30022B86H00469
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","",null,null,"","68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);
        try {
             doctorService.activateDevicePackage(10000358L,deviceInfo);
           //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

   // 1.DeviceInfo中的serial为“  ”与vCode中的serial不为空
    @Test
    public void spaceSerial(){
        //SYT30022B86H00469
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","   ",null,null,"","68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.userid存在用户，DeviceInfo中的serial为null
    @Test
    public void nullSerial(){
        //SYT30022B86H00469
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01",null,null,null,"","68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

   // 1.DeviceInfo中的serial与vCode中的serial一致
    @Test
    public void serialNotSameVcode(){
        //SYT30022B86H00469
        String vCode="RQnaVTR59B7r1pAp75SIoDPCFgQmbwIIUI9a95q6szdGa4D4y+/6pmQnl92ahQAEe/5SpIuNkp89\n" +
                "i9kTGciBkzOUmxQkPHgsEnFKha9usdtXiJinEBXgrZ2I3WXOTeGnqGpZwfcHt0JyWDjsVXRwgbMT\n" +
                "Csf9Ij9QDFVPxTQ4A/kCH+zy+tx4ZJBamT7jRyXfvYF2csBKXtIDch/AJs9GBpOFtajcER4qgTGp\n" +
                "7+pXeRs3Dd6aZ16dNihwWIqtQD8vevi3QygfPBuZd+wJbbzw8L+hHbcguOQVRe5pIn+5VCbGiZ87\n" +
                "7zUJXGP9Ni4j6tShJI8gSy04nCYj6jPlFSd6Dw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","F1S_180408_2X8_v0.01","SYT30022B86H004691",null,null,"","68:b3:5e:59:3c:66","68:B3:5E:59:3A:72","10.16.40.87",vCode);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }


    //1.userid存在用户，DeviceInfo中的wifiMac为空
    @Test
    public void emptyWifiMac(){
        //68:b3:5e:59:3c:66
        String vCode="eddfLHjV9Iyd63FT1/agPvsX11hu7LUshqDTrjA/6aL/GN4a+Y85Meu6M44snSPsqBTYG0JH0Zzb\n" +
                "ebk06cZeofsOZIsxndVm737zJBW8efS722osE8LJRfFaAcoEYkKCmw7pDW3aa7h44smVf52yLjS9\n" +
                "WDpCQYBP59Qaar9E5g0do6VGIT1ArzAl/7ZOoJaHuO6JvJAGf1kKV4BTafR/BGQGHPnLWzLF110w\n" +
                "my1dHuwevtj7YtE+wzJY4Ao9+ZRF5HcImzsBlU+R8D3majtj4UdctL9o3I55aUsS3XDnV0jZZy+r\n" +
                "7rFdgIYdU2C2QeHYWWXKHaBmuiSmzXp74RdqaA==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","","111111","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.userid存在用户，DeviceInfo中的wifiMac为null
    @Test
    public void nullWifiMac(){
        //68:b3:5e:59:3c:66
        String vCode="a1pPy5QWwm8SUwNGh7hDQW6vkjlLVUY5rZxGZPC1r1P/1p1m7TNb6xmuo4RGx2OOPgH1PxhMBAG2\n" +
                "v7I3gQIG8oSWSDBDeq/t1jwc8SpLZ7yNUO94AC4OI3FtH/qeuRqx1SxBG19Rfd6Jlwz4gViAb7wg\n" +
                "nF0M5af18acTwdvQUJsBI7XwJEEOcw6zVCEZO/K3clkDs8yS9Rv8W9/I3f5zdszOYHiPXQZXFQdY\n" +
                "ncznWVDRBtcxeQYzfCkly1aVW48CNul7DrTKj+AoquP+lMCsXVFt0zD3cnsV0/EScZsTVtt/0sej\n" +
                "ITjF0MZc2EVP2+mg5gQDmG4mi7YNE1xDCuuS8A==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","",null,"111111","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    @Test
    public void spanceWifiMac(){
        //68:b3:5e:59:3c:66
        String vCode="EUV3J1WOFanNfcQiq/zhJpdzFMlMhe45BqU0nSH654cnJNrzm9YCRn825QMqd6dbanKk7uAfXRQk\n" +
                "j8lH5kaf2bS2lG77W5sf1mf5Mj4a3zkzV0E4R/45k5vRa3h2PHh4VDaX87xeudxCLXhLshvkhxPA\n" +
                "XW0AdLAZffDOoieEUprHWUp7Mbvc/mEo2edOVgTKWUFogfSrfKGJD8B87NEAQLqg0ojOhalFhZtY\n" +
                "3A8159KdymMPUw1aUjG5IiNda+URJxRiClYZS1JwOFPqbTd7ENoOGNDh7pPSJzHA2qcPfzcZO9CL\n" +
                "iVdcT9JTcThgfKDyYKjXx2GS7xyD7XRffEJabQ==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","",null,"    ","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

   //1.DeviceInfo中的wifiMac长度为7组数字  ??
    @Test
    public void wrongWiFimac(){
        String vCode="Ghk6yZGMJ86v1X49STv8yc3FuzT5tRRvVRPcWLhgBvvnIHQ+7wmnvpeyuvK6DDmGiHhxu2Z5Lj0N\n" +
                "yHn64aXLQw6QZYzlB60WvK569biiJLIW6zx9vuHWrrFpvyx0gjWwV043BE9B1Xun+SwHHXKoTcDX\n" +
                "UdWjmzXcRwggSVQ/Z+/J/kfBxZ/80/WLNoMXRZaZGFvvOLI5ID4ZjABcwJjKEIGCxGCoZe4b6bfR\n" +
                "G8dsN9pjKkvf5DiwfyBo4YMqAObhooY7Vu3yzN//zR6VwiCMDJFSVfa0U6zURHx+XhuLFfQQkQT3\n" +
                "u1navIiUNTBoQIwuZTPq7qofoYyPUp2CxDWMVw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","68:b3:5e:59:3c:66:88," ,"77777","",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包1",doma.getMsg());
        }
    }

    //1.DeviceInfo中的wifiMac长度为5组数字
    @Test
    public void wWiFimac(){
        String vCode="VlUeFkNamWiEGmHUqvUFGk1JzSFwWU3uDSdiiSkLoy2iY1ROOgI9oHFntWpfCEp1gyS7ByiqtaQh\n" +
                "hEehrFi8kp4FSSzorGUOtbx4tjPc1ik5CYBQpShy0CqzkM4LB+8lj88rOwFECiuboISZt8TSkvDU\n" +
                "bACmBg69GH8DTlmgmj62UMi9WBxmxCsN37grO9pz18VEoUNqA9AY+FPdO9kyZKvuKMZ3zhEmdycp\n" +
                "4IN0ikDtO6gFcvSEmxWITotyNuVba7Yv5nQrzaFP9dWHu8OufAMOgG+tNQwPic3ebBqShUs90zZJ\n" +
                "qRx0WRTBAErw5567dTNpq+EVV0awEhJgiu4Iww==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","68:b3:5e:59:3c," ,"77777","",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包1",doma.getMsg());
        }
    }

    //1.DeviceInfo中的serial与vCode中的serial不一致
    @Test
    public void wifiMacNotSameVcode(){
        //68:b3:5e:59:3c:66
        String vCode="WWS0G53bU85FzVpz9HKWmLHE5Sl8DxRAHs0A2or4vXYMgsFypYUoo9uBDfEa77ECOiTyZ95TjDgh\n" +
                "LAKvRa3msLb0SFc9JW5FnFdjCo4W3BtFbCxLOJOPXO2HQS/steOZ+rJzLXPzZjsKs6xEYBb7UHz/\n" +
                "7D0k0G4EduET/S/8DSHza7dPJm/nadJIELrfLyJRJaq4Sw4Np948R9VxqrnnGk5IefHgbnPEjDD2\n" +
                "vEyn9JZ1pPbrgmFEpaXrBoDmDRkk2in3Tq6rAbLblW43Djh/Q0PcnSzNT30i06bvMCCQuJVzVEmn\n" +
                "P+XJNeFuZqRDrGbwIUuC+YqDNOlf6WQUuyzJKg==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","","222222","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.userid存在用户，DeviceInfo中的btMac为空
    @Test
    public void emptyBtMac(){
        //68:b3:5e:59:3c:66
        String vCode="JhGIpFuxuEPAq97bNvtSuMZKsKSI2hw/TJ7Xz8sfzIGqMz6uYmL6lC7kWbE8nwFyfZFEg7GUaJ6k\n" +
                "2RT/DYE+4aYFxWNu5mti/qKUsPflDuIxljuP4NftXNJmMj8DH+PcoyXqrS77brcX1fKbw7qNL4FQ\n" +
                "07JnI5hzIzJauV3Q+INiifmjHQ3BrxAIbQj4Fh6MaNp3NAZVKDEKy70Xqfbyh2/ejJCn3A37ZNOw\n" +
                "YXH+WeJWInwyz7Zml+BwLjyYml87OTiF1foGZBiAxQ0Mb/1tvyqCvkN2vi0/UiTtcwAyT8b4fJz2\n" +
                "Kd1HWIijOxeuNnnGILxUz3N5OfdJ9/3zOz7oxA==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","11111","","10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.userid存在用户，DeviceInfo中的btMac为null
    @Test
    public void nullBtMac(){
        //68:b3:5e:59:3c:66
        String vCode="eTjAPyUiWaZeOis4jWarysFkiRFPzIsCbs6HoWCptH9P37Bir6b9IauVqGptrd81wadMoaNFD4xX\n" +
                "pVXJcmGhUm+n+SVvDdyNuthqIBb2lqx68fi6ikCpKYrv0fH6PA0BKNMWM9jckaDqbNdI8RaAzBAO\n" +
                "vAix7LfhP3EqDoPdg/T/UgJNsgi7d7TNcbZOep8V9esSoZ+pQLwgXFqhgUHKUYQLX0tVl1wqzL8e\n" +
                "zUwKCh2uB+4cVfNXAjm94WWKxdyX1c+Zt/kCyAD85lXjyjbhLvhSs40QJkK27UZeCpxubR/cKP5b\n" +
                "D/xrnV7Tp9XQ3MSx6mo3ltbAqBpuMLzh6XbDPw==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","11111",null,"10.16.40.87",vCode);

        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }


  //  1.DeviceInfo中的BTmac为“  ”与vCode中的BTmac不为空
    @Test
    public void spaceBtMac(){
        //68:b3:5e:59:3c:66
        String vCode="ZyqD3Gccx2or6DCB9ZP+HeLzaF9jY06LhFAHvc2G69nxBa41gZe9aJgL27jfZhZxAmP+5bS3MZGh\n" +
                "ZFGDfxiAqa3KNXfb60DEMP1b0on9VcZ5rCH3MqrI8zPyCuRozehqendv2j3HQX4wqnWsowp2oLHS\n" +
                "9lGGi/tp2xaXBM7GqVtSnssRyEahSCln+bh3KAeDiUUPYxk3EtdzMVM2AL/GBt2Chc3grXSc3G86\n" +
                "9f/cuNOwn88FxOJlOGeSyxaaMUtNob6e2qOlli/lxdyOPrMcWrWl/OM8GFkZnrOEX/xPXTwGlNN6\n" +
                "yFhz3GavxLFMviJjv2l2MMKphCfw9BY5HL+voA==";
        DeviceInfo deviceInfo=testDate.createDeviceInFo("YT3002","","590013664","","","","11111","   ","10.16.40.87",vCode);
        try {
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }


}
