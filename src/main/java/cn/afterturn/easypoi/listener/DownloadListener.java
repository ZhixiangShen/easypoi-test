package cn.afterturn.easypoi.listener;

import cn.afterturn.easypoi.evnet.DownloadExcelThroughEntityEvent;
import cn.afterturn.easypoi.service.TScrmDataCenterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Package: com.weimob.scrm.listener
 * @ClassName: DownloadListener
 * @Author: beibei.huang
 * @Description: 下载处理监听器
 * @Date: 2020/1/15 17:06
 */
@Component
public class DownloadListener {

    @Autowired
    TScrmDataCenterLogService dataCenterLogService;

    @EventListener
    @Async
    public void downloadExcel(DownloadExcelThroughEntityEvent downloadExcelEvent) {
        if (downloadExcelEvent.getInnerDataType().equals("list")) {
            dataCenterLogService.createSchedule(downloadExcelEvent.getPid(), downloadExcelEvent.getCreateUserWid(), downloadExcelEvent.getStage(),
                    downloadExcelEvent.getExportParams(), downloadExcelEvent.getQueryParams(),
                    downloadExcelEvent.getPojoClass(), downloadExcelEvent.getServer());
        }else {
            dataCenterLogService.createSchedule(downloadExcelEvent.getPid(), downloadExcelEvent.getCreateUserWid(), downloadExcelEvent.getStage(),
                    downloadExcelEvent.getExportParams(), downloadExcelEvent.getQueryParams(),
                    downloadExcelEvent.getEntity(), downloadExcelEvent.getServer());
        }
    }


}
