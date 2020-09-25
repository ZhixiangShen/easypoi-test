package cn.afterturn.easypoi.controller;

import cn.afterturn.easypoi.evnet.DownloadExcelThroughEntityEvent;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import cn.afterturn.easypoi.hanlder.ExportLoadDataHandler;
import cn.afterturn.easypoi.hanlder.ExportLoadMapHandler;
import cn.afterturn.easypoi.test.entity.MsgClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixiang.shen
 * @date 2020/3/11 14:05
 */
@RestController
public class TestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/publish")
    public void excelDownload(){
        IExcelExportServer server = new ExportLoadDataHandler();
        eventPublisher.publishEvent(new DownloadExcelThroughEntityEvent(new Object(), new ExportParams("Title","sheetName"), new Object(),
                MsgClient.class,server, 1L, 1L,"o_clue","list"));
        System.out.println("发布任务完成");
    }

    @GetMapping("/publish2")
    public void excelMapDataDownload(){
        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        entity.add(new ExcelExportEntity("时间", "date"));
        entity.add(new ExcelExportEntity("姓名", "name"));
        entity.add(new ExcelExportEntity("电话", "phone"));


        IExcelExportServer server = new ExportLoadDataHandler();
        eventPublisher.publishEvent(new DownloadExcelThroughEntityEvent(new Object(), new ExportParams("Title","sheetName"), new Object(),
                MsgClient.class,server, 1L, 1L,"o_clue","list"));
        System.out.println("List下载任务发布完成");
        IExcelExportServer serverMap = new ExportLoadMapHandler();
        eventPublisher.publishEvent(new DownloadExcelThroughEntityEvent(new Object(), new ExportParams("Map","sheetName"), new Object(),
                entity,serverMap, 1L, 1L,"o_clue","map"));
        System.out.println("Map任务发布完成");
    }

}
