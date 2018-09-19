package com.halove.server.service.doctor.test.common;

/**
 * @author : yining@halove.com @ 17-12-15
 */
public enum FreePackage {
    VIP_90_STANDARD("家庭健康VIP卡·季卡", "季卡", 299, 500, 90, "10", ""),
    //手机设备默认赠卡
    VIP_180_STANDARD("家庭健康VIP卡·半年卡", "半年卡", 599, 1000, 180, "30", "halove_mobile"),
    //F1设备默认赠卡
    VIP_180_STANDARD_PAD("家庭健康VIP卡·年卡", "年卡", 599, 1000, 180, "30", "smart_f1"),
    VIP_365_STANDARD("家庭健康VIP卡·年卡", "年卡", 999, 2000, 365, "99", ""),
    VIP_365_UNLIMITED("家庭健康VIP卡·超级年卡", "超级年卡", 1999, 4000, 365, "无限", "halove_svip"),
    VIP_180_SICHUAN_TELECOM("个人健康VIP卡·年卡", "年卡", 899, 1500, 365, "30","sichuan_telecom"),
    VIP_30_HALOVE_PROMOTION("一键通体验卡","一键通体验卡",299,500,30,"无限","halove_promotion"),
    VIP_90_HALOVE_DEMO("健康咨询体验卡","健康咨询体验卡",599,1000,90,"无限","halove_demo"),
    VIP_30_TERMINAL_PROMOTION("一键通体验卡","一键通体验卡",299,500,30,"无限","f1_promotion"),
    VIP_90_TERMINAL_DEMO("健康咨询体验卡","健康咨询体验卡",599,1000,90,"无限","f1_demo"),
    VIP_365_UNLIMITED_PAD("家庭健康VIP卡·超级年卡", "超级年卡", 1999, 4000, 365, "无限", "f1_svip");
    public final String fullTitle;
    public final String title;
    public final int currentPrice;
    public final int originalPrice;
    public final int days;
    public final String consultTimes;
    public final String[] descriptions;
    //赠卡渠道(微医侧定义的字符串)用于访问微医api时作为参数标识卡类型
    public final String channel;

    FreePackage(String fullTitle, String title, int currentPrice, int originalPrice, int days, String consultTimes, String channel) {
        this.fullTitle = fullTitle;
        this.title = title;
        this.currentPrice = currentPrice;
        this.originalPrice = originalPrice;
        this.days = days;
        this.consultTimes = consultTimes;
        this.channel = channel;
        //恭喜获得价值599元", "家庭医生服务", "半年卡/180天 视频问诊/10次
        descriptions = new String[]{String.format("恭喜获得价值%d元", originalPrice), "家庭医生服务", String.format("%s/%d天 在线咨询/%s次", title, days, consultTimes)};
    }
}
