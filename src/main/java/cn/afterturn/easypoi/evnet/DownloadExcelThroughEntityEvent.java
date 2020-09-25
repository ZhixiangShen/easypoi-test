package cn.afterturn.easypoi.evnet;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @Package: com.weimob.scrm.event
 * @ClassName: DownloadExcelThroughEntityEvent
 * @Author: beibei.huang
 * @Description: 下载Excel文件事件
 * @Date: 2020/1/15 17:10
 */
public class DownloadExcelThroughEntityEvent extends ApplicationEvent {

    /**
     * 导出文件的基本描述：包括文件名、sheet名称
     */
    private ExportParams exportParams;

    /**
     * 导出文件中的数据需要查询数据时：查询语句的入参
     */
    private Object queryParams;

    /**
     * 查询结果集的对象类型
     */
    private Class<?> pojoClass;

    /**
     * 执行查询的实现类
     */
    private IExcelExportServer server;

    /**
     * 返回数据类型 list map
     */
    private String innerDataType;

    /**
     * 查询结果Map数据类格式封装
     */
    public List<ExcelExportEntity> entity;

    public ExportParams getExportParams() {
        return exportParams;
    }

    public Object getQueryParams() {
        return queryParams;
    }

    public Class<?> getPojoClass() {
        return pojoClass;
    }

    public IExcelExportServer getServer() {
        return server;
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

    public List<ExcelExportEntity> getEntity() {
        return entity;
    }

    public String getInnerDataType() {
        return innerDataType;
    }



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

    public DownloadExcelThroughEntityEvent(Object source, ExportParams exportParams, Object queryParams, Class<?> pojoClass, IExcelExportServer server, Long pid, Long createUserWid, String stage,String innerDataType) {
        super(source);
        this.exportParams = exportParams;
        this.queryParams = queryParams;
        this.pojoClass = pojoClass;
        this.server = server;
        this.pid = pid;
        this.createUserWid = createUserWid;
        this.stage = stage;
        this.innerDataType = innerDataType;
    }

    public DownloadExcelThroughEntityEvent(Object source, ExportParams exportParams, Object queryParams, List<ExcelExportEntity> entity, IExcelExportServer server, long pid, long createUserWid, String o_clue,String innerDataType) {
        super(source);
        this.exportParams = exportParams;
        this.queryParams = queryParams;
        this.entity = entity;
        this.server = server;
        this.pid = pid;
        this.createUserWid = createUserWid;
        this.stage = stage;
        this.innerDataType = innerDataType;
    }
}
