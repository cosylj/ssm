package com.halove.server.service.doctor.test.common;


import com.halove.server.service.doctor.DeviceInfo;
import com.halove.server.service.doctor.test.model.DoctorDeviceInfo;
import com.halove.server.service.doctor.test.model.UserMember;



import com.halove.server.service.doctor.test.model.DoctorDeviceActivation;
import com.halove.server.service.doctor.test.service.DoctorDeviceActivationMapper;
import com.halove.server.service.doctor.test.service.DoctorDeviceInfoMapper;
import com.halove.server.service.doctor.test.service.UserMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class TestDate {

    @Autowired
    UserMemberMapper userMemberMapper;

    @Autowired
    DoctorDeviceInfoMapper doctorDeviceInfoMapper;

    @Autowired
    DoctorDeviceActivationMapper doctorDeviceActivationMapper;



    /**---------------------------------------------一下是实体-------------------------------------------------------------------*/

    public DeviceInfo createDeviceInFo(String Model, String RomVer, String Serial, String Imei1, String Imei2, String Meid, String WifiMac, String BtMac , String Ip, String vCode) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setModel(Model);
        deviceInfo.setRomVer(RomVer);
        deviceInfo.setSerial(Serial);
        deviceInfo.setImei1(Imei1);
        deviceInfo.setImei2(Imei2);
        deviceInfo.setMeid(Meid);
        deviceInfo.setWifiMac(WifiMac);
        deviceInfo.setBtMac(BtMac);
        deviceInfo.setIp(Ip);
        deviceInfo.setvCode(vCode);
        return deviceInfo;
    }


    public UserMember createUserMember(String imUserName, String mobile, String password, Short onlineStatus, String realname, String nickname, Date createTime, Date updateTime){
        UserMember userMember=new UserMember();
        userMember.setImUserName(imUserName);
        userMember.setMobile(mobile);
        userMember.setPassword(password);
        userMember.setOnlineStatus(onlineStatus);
        userMember.setRealname(realname);
        userMember.setNickname(nickname);
        userMember.setCreateTime(createTime);
        userMember.setUpdateTime(updateTime);
        userMemberMapper.insertSelective(userMember);
        return userMember;
    }


    /**
     *创建一个DoctorDeviceInfoPO
     */
    public DoctorDeviceInfo createDoctorDeviceInfoPO(Long id, String imei1, String imei2, String meid, String model, String serial, Date activated, FreePackage freePackage, String distributor, String batch, Date released){
        DoctorDeviceInfo doctorDeviceInfoPO=new DoctorDeviceInfo();
        doctorDeviceInfoPO.setId(id);
        doctorDeviceInfoPO.setImei1(imei1);
        doctorDeviceInfoPO.setImei2(imei2);
        doctorDeviceInfoPO.setMeid(meid);
        doctorDeviceInfoPO.setModel(model);
        doctorDeviceInfoPO.setSerial(serial);
        doctorDeviceInfoPO.setActivated(activated);
        doctorDeviceInfoPO.setFreePackage(freePackage.toString());
        doctorDeviceInfoPO.setDistributor(distributor);
        doctorDeviceInfoPO.setBatch(batch);
        doctorDeviceInfoPO.setReleased(released);
        doctorDeviceInfoMapper.insertSelective(doctorDeviceInfoPO);
        return doctorDeviceInfoPO;
    }

    /**
     * mock DoctorDeviceActivationPO数据
     */

    public DoctorDeviceActivation createDoctorDeviceActivation(Long userId,String model,String imei,String uuid,String result,Date activated){
        DoctorDeviceActivation doctorDeviceActivationPO=new DoctorDeviceActivation();
        doctorDeviceActivationPO.setUserId(userId);
        doctorDeviceActivationPO.setModel(model);
        doctorDeviceActivationPO.setImei(imei);
        doctorDeviceActivationPO.setUuid(uuid);
        doctorDeviceActivationPO.setResult(result);
        doctorDeviceActivationPO.setActivated(activated);
        doctorDeviceActivationMapper.insertSelective(doctorDeviceActivationPO);
        return doctorDeviceActivationPO;
    }
}
