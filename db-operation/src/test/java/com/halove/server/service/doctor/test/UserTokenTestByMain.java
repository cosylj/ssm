package com.halove.server.service.doctor.test;
import com.halove.server.service.doctor.test.service.DeviceInfoMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTokenTestByMain {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeviceInfoMapper deviceInfoMapper=(DeviceInfoMapper) application.getBean("deviceInfoMapperImpl");
        System.out.println("============"+deviceInfoMapper);
       // DeviceInfo deviceInfo=deviceInfoMapper.selectByPrimaryKey(1L);
        System.out.println("==================="+deviceInfoMapper.selectByPrimaryKey(1L));
    }
}
