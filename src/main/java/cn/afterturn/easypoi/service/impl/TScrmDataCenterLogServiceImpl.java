package cn.afterturn.easypoi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import cn.afterturn.easypoi.pojo.TScrmDataCenterLog;
import cn.afterturn.easypoi.service.TScrmDataCenterLogService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Package: com.weimob.scrm.service.impl
 * @ClassName: TScrmDataCenterLogImpl
 * @Author: beibei.huang
 * @Description: 数据中心业务处理实现类
 * @Date: 2020/1/15 14:32
 */
@Service
public class TScrmDataCenterLogServiceImpl implements TScrmDataCenterLogService {


    @Override
    public void createSchedule(Long pid, Long createUserWid, String stage, ExportParams exportParams, Object queryParams, Class<?> pojoClass, IExcelExportServer server) {
        //Integer id = insertSelective(pid, createUserWid, stage, DataCenterOptionTypeEnum.EXPORT.getCode());
        exportExcel(exportParams, queryParams, pojoClass, server, 1);
    }

    @Override
    public void createSchedule(Long pid, Long createUserWid, String stage, String[] fileUrls, String zipName) {
        //Integer id = insertSelective(pid, createUserWid, stage, );
        exportZip(fileUrls, zipName, 1);
    }

    @Override
    public Integer insertSelective(Long pid, Long createUserWid, String stage, Byte optionType) {
        TScrmDataCenterLog tScrmDataCenterLog = new TScrmDataCenterLog();
        tScrmDataCenterLog.setCreateUserWid(createUserWid);
        tScrmDataCenterLog.setIsDelete((byte)1);
        tScrmDataCenterLog.setOptionType(optionType);
        tScrmDataCenterLog.setPid(pid);
        tScrmDataCenterLog.setSchedule((byte)1);
        tScrmDataCenterLog.setStage(stage);
        return 100;
    }

    @Override
    public void exportExcel(ExportParams exportParams, Object queryParams, Class<?> pojoClass, IExcelExportServer server, Integer id) {
        Workbook workbook = ExcelExportUtil.exportBigExcel(exportParams, pojoClass, server, queryParams);
        try {

            File savefile = new File("D:/home/excel/list/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(savefile+File.separator+exportParams.getSheetName() + System.currentTimeMillis() + ".xlsx");
            workbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exportZip(String[] fileUrls, String zipName, Integer id) {

        File destZipFile = new File(zipName + System.currentTimeMillis() + ".zip");
        if (!destZipFile.exists()) {
            destZipFile.mkdirs();
        }

        //String fileUrl = mediaCenterService.packEntries(fileUrls, destZipFile);

        //completeSchedule(id, fileUrl, zipName);
    }

    @Override
    public void completeSchedule(Integer id, String fileUrl, String fileName) {
        TScrmDataCenterLog tScrmDataCenterLog = new TScrmDataCenterLog();
        tScrmDataCenterLog.setId(id);
        //tScrmDataCenterLog.setSchedule(DataCenterScheduleEnum.COMPLETED.getCode());
        tScrmDataCenterLog.setFileUrl(fileUrl);
        tScrmDataCenterLog.setFileName(fileName);
        //dataCenterLogMapper.updateByPrimaryKeySelective(tScrmDataCenterLog);
    }

    /**
     * @param pid
     * @param createUserWid
     * @param stage
     * @param exportParams
     * @param queryParams
     * @param dataView
     * @param server
     * @MethodName: createSchedule
     * @Description: 创建导出/下载计划
     * @Param: [exportParams Excel文件的相关描述,
     * queryParams 查询导出数据的阐述,
     * dataView 表格展示样式,
     * server 执行查询的实现类，继承com.weimob.scrm.service.impl.AbstractExcelExportServer抽象类,
     * pid 企业ID
     * createUserWid 任务创建人,
     * stage 任务所属类型]
     * @Return: void
     * @Author: beibei.huang
     * @Date: 2020/1/16
     */
    @Override
    public void createSchedule(Long pid, Long createUserWid, String stage, ExportParams exportParams, Object queryParams, List<ExcelExportEntity> dataView, IExcelExportServer server) {
        //Integer id = insertSelective(pid, createUserWid, stage, DataCenterOptionTypeEnum.EXPORT.getCode());
        exportExcel(exportParams, queryParams, dataView, server, 1);
    }



    public void exportExcel(ExportParams exportParams, Object queryParams,  List<ExcelExportEntity> dataView, IExcelExportServer server, Integer id) {
        Workbook workbook = ExcelExportUtil.exportBigExcel(exportParams, dataView, server, queryParams);
        try {

            File savefile = new File("D:/home/excel/map/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(savefile+File.separator+exportParams.getSheetName() + System.currentTimeMillis() + ".xlsx");
            workbook.write(fos);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
