package com.midland.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by jim on 2017/6/14.
 */
public class JsonMapReader
{
    private Logger logger = LoggerFactory.getLogger(JsonMapReader.class);
    private static String mapName = "jsonMap/midland.json";
    private static List<ParamObject> map = null;

    public  void getPayChannelInfo(String pro) {
        ClassPathResource cpr = new ClassPathResource(pro);
        if (cpr != null && cpr.exists()) {
            try {
                String packDeliveries = JsonUtil.getNodeValue(cpr.getInputStream(), "quotation_type");
                map = JsonUtil.getListValues(packDeliveries, ParamObject.class);
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }

    public static List<ParamObject> getMap() {
        if (map == null) {
            JsonMapReader jsonMapReader = new JsonMapReader();
            jsonMapReader.getPayChannelInfo(mapName);
        }
        return map;
    }

    public void setMap(List<ParamObject> map) {
        this.map = map;
    }


    public static void main(String[] args) {
        JsonMapReader properties = new JsonMapReader();
        List<ParamObject> result = properties.getMap();
        System.out.println(result);
    }
}
