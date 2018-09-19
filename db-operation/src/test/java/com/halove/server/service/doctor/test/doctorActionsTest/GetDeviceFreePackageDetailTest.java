package com.halove.server.service.doctor.test.doctorActionsTest;




import com.halove.server.service.doctor.test.common.TestDate;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class GetDeviceFreePackageDetailTest {
    @Autowired
    TestDate testDate;

    @BeforeClass
    public static void prepare() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //1.deviceInfo为null
    //2.deviceInfo为空
    //3.不存在的deviceInfo
    //4.无激活服务包
    //5.F1S设备服务卡已经开通
    //6.F1S设备服务卡未开通
    //7.V1S设备服务卡未开通
    //8.V1S设备服务卡已开通

}
