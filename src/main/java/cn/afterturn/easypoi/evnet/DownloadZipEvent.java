package cn.afterturn.easypoi.evnet;

import org.springframework.context.ApplicationEvent;

/**
 * @Package: com.weimob.scrm.event
 * @ClassName: DownloadZipEvent
 * @Author: beibei.huang
 * @Description: 下载压缩包事件
 * @Date: 2020/1/17 14:23
 */
public class DownloadZipEvent extends ApplicationEvent {

    /**
     * 需要压缩的文件路径
     */
    private String[] fileUrls;

    public String[] getFileUrls() {
        return fileUrls;
    }

    public String getZipName() {
        return zipName;
    }

    public Long getPid() {
        return pid;
    }

    public Long getCreateUserWid() {
        return createUserWid;
    }

    public String getStage() {
        return stage;
    }

    /**
     * 下载时压缩包的名字
     */
    private String zipName;

    /**
     * 企业ID
     */
    private Long pid;

    /**
     * 创建人
     */
    private Long createUserWid;

    /**
     * 导出操作的类型：@see com.weimob.scrm.enums.datacenter.DataCenterStageEnum
     */
    private String stage;

    public DownloadZipEvent(Object source, String[] fileUrls, String zipName, Long pid, Long createUserWid, String stage) {
        super(source);
        this.fileUrls = fileUrls;
        this.zipName = zipName;
        this.pid = pid;
        this.createUserWid = createUserWid;
        this.stage = stage;
    }
}
