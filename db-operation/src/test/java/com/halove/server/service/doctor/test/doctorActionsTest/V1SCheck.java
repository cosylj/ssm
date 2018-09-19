package com.halove.server.service.doctor.test.doctorActionsTest;
import com.alibaba.dubbo.config.annotation.Reference;
import com.halove.server.commons.exception.DomainException;
import com.halove.server.service.doctor.DeviceInfo;
import com.halove.server.service.doctor.DoctorService;
import com.halove.server.service.doctor.test.common.TestDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class V1SCheck {
    @Reference(version = "1.1.0")
    DoctorService doctorService;

    @Autowired
    TestDate testDate;

    public static void prepare() {
        System.setProperty("env", "beta");
        System.setProperty("name", "doctor-api");
    }

    //1.DeviceInfo中的imei2与vCode中的imei2一致
    @Test
    public void sameImei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","1234567891111199","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);

            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2与vCode中的imei2不一致
    @Test
    public void noSameImei2(){
        try {
            String vCode="ggA/1qzgmHz/d1RyRmA2gzFVvEEpHBQv4ldMqScT6hHze7iXkGuAKCqFqmijUXYfMh5A/pEzhynq\n" +
                    "zR7hSMM7WFIYKjFh32ddgpFMn/Epb/3aLTfa9Prj1TAjx3LCvfMweCsKs27MyEpkzSjVZGRn7SB/\n" +
                    "3VJX5TIz7uULl9EXI0AOT/3ezWy9a+KkRdMUJlFarUb3RkFRU9BJJemKqH7cGZZXdtTe6D23mu4s\n" +
                    "KIGzdpX4hXsciHM6AwxjU90HPWgjrH17I+SQ4VfeFT6oKYoYvPm8zQ1wYFQR3nGEBmWf11bbWfiE\n" +
                    "5uJXthopT+zYf/hyteXdE9gMtDC6s8n7c2PSnw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","1234567891111199","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (DomainException doma){
            Assert.assertEquals("没有可激活的服务包",doma.getMsg());
        }
    }

    //1.DeviceInfo中的imei2为null与vCode中的imei2不为null
    @Test
    public void nullImei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111",null,"1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2为“”与vCode中的imei2不为空
    @Test
    public void emptyImei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2为“  ”与vCode中的imei2不为空
    @Test
    public void spaceimei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","   ","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
           // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2长度为16为数字,
    @Test
    public void longImei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","012345678911111","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            // doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals("null",doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2长度为14为数字
    @Test
    public void shortImei2(){
        try {
            String vCode="i/QV6In41QZlP9M7B69qPuC2F+VisEJRsW+UTQY0VpPgBgq6nm9ab7+CGynSebuTHvtdBWKQ20Yw\n" +
                    "18G5MdRahlcVfkMFW5w9obe7S6iGI0RXL0jDT4Vdy2WcSOcYZVoHQOF8pJrPfutCH22rRpJHkpX6\n" +
                    "wGXX+ZahG8JWtf28LUuSGhsFANO3UGG8hSO3U2DQA1D1LUXodUUnzqbbWqHQnI/VdbcK/riM53XA\n" +
                    "47s0NoJEhN5SDTxPX+yZA57WK4lAhXIK4YttV+k7CEu1f2X19hvVpua0NlCBKbUf+XW72C6SidM/\n" +
                    "BfPCVjNiHK4/soFZfUhNoJDtlSS+PvGuP+JLiw==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","12345678911111","345678911111","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals("null",doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei2长度为15为数字+字母，符号
    @Test
    public void numberAndLetter(){
        try {
            String vCode="GPhbG+c1KiwKUwYf1i11Cgi1rghTVAcI1ne35wcKdrPf4LVEiCOOyE9RsC8g31S/Jb7ik+0E36Yd\n" +
                    "Oz05E1w9Ga8ICI++mToj58tFqJcjToVMj1q5Mm43uPzTkmHUMJuQaG7iQHABbzzJYr+iWZtsjGmD\n" +
                    "19pXdVEvlBqVxM/Lzl2mPyMQRLeEE+BShb0DdRMT8S7wdBYbnMNMk7ITuvUXHWrY32OwEHgp029K\n" +
                    "iSisfKsUGYg2nrAlfNlkEYLNfuGOHgaDOXlbJHlaDgrhYvhNtNRU0kzAyVSlupbydkxcPRVzConk\n" +
                    "XVJVI0icuyw/HDfMRo50PhgoInzZhyOrN36/1Q==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","111uiijhdjf","111uiijhdjf","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }

    //1.DeviceInfo中的imei1：111，imei2:222与vCode中的imei1:222，imei：111
    @Test
    public void changeImei1(){
        try {
            String vCode="K5Fqdkpd03886ESKNf940znc4F4ymn6QOJm/fkQkpEMOh/LFYV8C1DMAHT64XIc3pao7Iy70TEUD\n" +
                    "oZfa6pgD3B5sLquU4i6nqvU/DUJxtTo6LlEOb4XWmkQFrxl6TzsvQoHUm2yG4yNNIfaNRvWJbZSk\n" +
                    "fV87bq41TQTg9Y1nsV3DJUP1PyvpvmSiZ352pyN/PpNvEq7KCd3ysxPqIICniDIPaU92WO4biVze\n" +
                    "oLsJZG0cdXkuOGeFCNYS9Mc8VCvABf+7dwPEKxx2r7cPi+aewsDmZxGAN1+pPqZcRh3nscZTB8uJ\n" +
                    "T5797odAMc3k428cU++HyR3XmJXLGI7TD+aIrA==";
            DeviceInfo deviceInfo=testDate.createDeviceInFo("HL2001","","590013664","111uiijhdjf444","111uiijhdjf","1234567891111199","18:3b:d2:ff:3b:b0","18:3B:D2:FF:40:60","10.16.40.160",vCode);
            doctorService.activateDevicePackage(10000358L,deviceInfo);
            //doctorActions.activateDoctorUser(10000358L,deviceInfo);
        }catch (NullPointerException doma){
            Assert.assertEquals(null,doma.getMessage());
        }
    }
}
