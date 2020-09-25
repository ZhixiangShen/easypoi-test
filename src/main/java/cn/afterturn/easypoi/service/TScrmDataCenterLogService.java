package cn.afterturn.easypoi.service;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.weimob.scrm.service
 * @ClassName: TScrmDataCenterLog
 * @Author: beibei.huang
 * @Description: 数据中心业务处理接口
 * @Date: 2020/1/15 14:27
 */
public interface TScrmDataCenterLogService {

    /**
     * @MethodName: createSchedule
     * @Description: 创建导出/下载计划
     * @Param: [exportParams Excel文件的相关描述,
     *          queryParams 查询导出数据的阐述,
     *          pojoClass 查询结果集的class,
     *          server 执行查询的实现类，继承com.weimob.scrm.service.impl.AbstractExcelExportServer抽象类,
     *          pid 企业ID
     *          createUserWid 任务创建人,
     *          stage 任务所属类型]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/16
     **/
    void createSchedule(Long pid, Long createUserWid, String stage, ExportParams exportParams, Object queryParams, Class<?> pojoClass, IExcelExportServer server);

    /**
     * @MethodName: createSchedule
     * @Description: 创建导出/下载计划
     * @Param: [exportParams Excel文件的相关描述,
     *          queryParams 查询导出数据的阐述,
     *          dataView 表格展示样式,
     *          server 执行查询的实现类，继承com.weimob.scrm.service.impl.AbstractExcelExportServer抽象类,
     *          pid 企业ID
     *          createUserWid 任务创建人,
     *          stage 任务所属类型]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/16
     **/
    void createSchedule(Long pid, Long createUserWid, String stage, ExportParams exportParams, Object queryParams, List<ExcelExportEntity> dataView, IExcelExportServer server);
    /**
     * @MethodName: createSchedule
     * @Description: 创建多文件下载计划
     * @Param: [pid, createUserWid, stage,
     *          fileUrls 文件所在的url
     *          zipName  下载时文件名称]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/17
     **/
    void createSchedule(Long pid, Long createUserWid, String stage, String[] fileUrls, String zipName);

    /**
     * @MethodName: insertSelective
     * @Description: 创建上传/下载任务
     * @Param: [pid, createUserWid, stage, optionType]
     * @Return: Integer 记录主键
     * @Author: beibei.huang
     * @Date: 2020/1/16
     **/
    Integer insertSelective(Long pid, Long createUserWid, String stage, Byte optionType);

    /*  *
     * @MethodName: exportExcel
     * @Description: 导出EXCEL并上传媒体中心
     * @Param: [exportParams, queryParams, pojoClass, server, id]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/16
     **/
    @Async
    void exportExcel(ExportParams exportParams, Object queryParams, Class<?> pojoClass, IExcelExportServer server, Integer id);

    /**
     * @MethodName: exportZip
     * @Description: 将文件列表进行压缩上传
     * @Param: [fileUrls  文件URL列表,
     *          zipName  下载时文件名称
     *          id  任务ID]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/17
     **/
    @Async
    void exportZip(String[] fileUrls, String zipName, Integer id);

    /**
     * @MethodName: completeSchedule
     * @Description: 任务更新为完成并更新文件路径
     * @Param: [id 任务ID,
     *          fileUrl  文件URL,
     *          fileName  文件名称]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/17
     **/
    void completeSchedule(Integer id, String fileUrl, String fileName);
}
