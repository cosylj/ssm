package com.halove.server.service.doctor.test.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


public class DoctorDeviceInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.ID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.MODEL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.DISTRIBUTOR
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String distributor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.BATCH
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String batch;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.RELEASED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private Date released;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.IMEI1
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String imei1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.IMEI2
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String imei2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.MEID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String meid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.SERIAL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String serial;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.FREE_PACKAGE
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private String freePackage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.ACTIVATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private Date activated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.CREATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doctor_device_info.UPDATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.ID
     *
     * @return the value of doctor_device_info.ID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.ID
     *
     * @param id the value for doctor_device_info.ID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.MODEL
     *
     * @return the value of doctor_device_info.MODEL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.MODEL
     *
     * @param model the value for doctor_device_info.MODEL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.DISTRIBUTOR
     *
     * @return the value of doctor_device_info.DISTRIBUTOR
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getDistributor() {
        return distributor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.DISTRIBUTOR
     *
     * @param distributor the value for doctor_device_info.DISTRIBUTOR
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setDistributor(String distributor) {
        this.distributor = distributor == null ? null : distributor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.BATCH
     *
     * @return the value of doctor_device_info.BATCH
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getBatch() {
        return batch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.BATCH
     *
     * @param batch the value for doctor_device_info.BATCH
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.RELEASED
     *
     * @return the value of doctor_device_info.RELEASED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public Date getReleased() {
        return released;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.RELEASED
     *
     * @param released the value for doctor_device_info.RELEASED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setReleased(Date released) {
        this.released = released;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.IMEI1
     *
     * @return the value of doctor_device_info.IMEI1
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getImei1() {
        return imei1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.IMEI1
     *
     * @param imei1 the value for doctor_device_info.IMEI1
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setImei1(String imei1) {
        this.imei1 = imei1 == null ? null : imei1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.IMEI2
     *
     * @return the value of doctor_device_info.IMEI2
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getImei2() {
        return imei2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.IMEI2
     *
     * @param imei2 the value for doctor_device_info.IMEI2
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setImei2(String imei2) {
        this.imei2 = imei2 == null ? null : imei2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.MEID
     *
     * @return the value of doctor_device_info.MEID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getMeid() {
        return meid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.MEID
     *
     * @param meid the value for doctor_device_info.MEID
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setMeid(String meid) {
        this.meid = meid == null ? null : meid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.SERIAL
     *
     * @return the value of doctor_device_info.SERIAL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getSerial() {
        return serial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.SERIAL
     *
     * @param serial the value for doctor_device_info.SERIAL
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.FREE_PACKAGE
     *
     * @return the value of doctor_device_info.FREE_PACKAGE
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public String getFreePackage() {
        return freePackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.FREE_PACKAGE
     *
     * @param freePackage the value for doctor_device_info.FREE_PACKAGE
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setFreePackage(String freePackage) {
        this.freePackage = freePackage == null ? null : freePackage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.ACTIVATED
     *
     * @return the value of doctor_device_info.ACTIVATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public Date getActivated() {
        return activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.ACTIVATED
     *
     * @param activated the value for doctor_device_info.ACTIVATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setActivated(Date activated) {
        this.activated = activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.CREATED
     *
     * @return the value of doctor_device_info.CREATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.CREATED
     *
     * @param created the value for doctor_device_info.CREATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doctor_device_info.UPDATED
     *
     * @return the value of doctor_device_info.UPDATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doctor_device_info.UPDATED
     *
     * @param updated the value for doctor_device_info.UPDATED
     *
     * @mbg.generated Wed Aug 22 15:19:49 CST 2018
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}