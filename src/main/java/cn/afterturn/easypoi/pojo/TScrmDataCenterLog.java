package cn.afterturn.easypoi.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mybatis Generator on 2020/01/17
 */
public class TScrmDataCenterLog implements Serializable {
    private Integer id;

    private Long pid;

    @Override
    public String toString() {
        return "TScrmDataCenterLog{" +
                "id=" + id +
                ", pid=" + pid +
                ", type=" + type +
                ", optionType=" + optionType +
                ", stage='" + stage + '\'' +
                ", successRows=" + successRows +
                ", failedRows=" + failedRows +
                ", schedule=" + schedule +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createTime=" + createTime +
                ", createUserWid=" + createUserWid +
                ", updateTime=" + updateTime +
                ", updateUserWid=" + updateUserWid +
                ", isDelete=" + isDelete +
                ", version=" + version +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getOptionType() {
        return optionType;
    }

    public void setOptionType(Byte optionType) {
        this.optionType = optionType;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getSuccessRows() {
        return successRows;
    }

    public void setSuccessRows(Integer successRows) {
        this.successRows = successRows;
    }

    public Integer getFailedRows() {
        return failedRows;
    }

    public void setFailedRows(Integer failedRows) {
        this.failedRows = failedRows;
    }

    public Byte getSchedule() {
        return schedule;
    }

    public void setSchedule(Byte schedule) {
        this.schedule = schedule;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserWid() {
        return createUserWid;
    }

    public void setCreateUserWid(Long createUserWid) {
        this.createUserWid = createUserWid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserWid() {
        return updateUserWid;
    }

    public void setUpdateUserWid(Long updateUserWid) {
        this.updateUserWid = updateUserWid;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Integer type;

    private Byte optionType;

    private String stage;

    private Integer successRows;

    private Integer failedRows;

    private Byte schedule;

    private String fileUrl;

    private String fileName;

    private Date createTime;

    private Long createUserWid;

    private Date updateTime;

    private Long updateUserWid;

    private Byte isDelete;

    private Integer version;

    private static final long serialVersionUID = 1L;
}