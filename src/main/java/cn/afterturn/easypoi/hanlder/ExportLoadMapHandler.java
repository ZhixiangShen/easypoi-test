package cn.afterturn.easypoi.hanlder;

import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import cn.afterturn.easypoi.test.entity.MsgClient;
import cn.afterturn.easypoi.test.entity.MsgClientGroup;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ExportLoadMapHandler implements IExcelExportServer {

    @Override
    public List<Object> selectListForExcelExport(Object obj, int page) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 100; i++) {
            Map<String,Object> client = new HashMap<>();
            client.put("date",new Date());
            client.put("name","小明" + i);
            client.put("phone","18797" + i);
            list.add(client);
        }
        if(page>10){
            return null;
        }
        return list;
    }

}
