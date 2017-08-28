package com.midland.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jim on 2017/6/14.
 */
public class PayChannelReader {
    private Logger logger = LoggerFactory.getLogger(PayChannelReader.class);
    private static String PAY_CHANNEL = "jsonMap/midland.json";
    private ObjectMapper mapper = new ObjectMapper();
    private static Map<String, ParamObject> map = null;

    public  List<ParamObject> getPayChannelInfo(String pro) {
        List<ParamObject> list = new ArrayList<>();
        ClassPathResource cpr = new ClassPathResource(pro);
        if (cpr != null && cpr.exists()) {
            try {
                String packDeliveries = JsonUtil.getNodeValue(cpr.getInputStream(), "quotation_type");
                List<ParamObject> objects = JsonUtil.getListValues(packDeliveries, ParamObject.class);
                return objects;
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return null;
    }

    public static Map<String, ParamObject> getMap() {
        if (map == null) {
            PayChannelReader payChannelReader = new PayChannelReader();
            payChannelReader.getPayChannelInfo(PAY_CHANNEL);
        }
        return map;
    }

    public void setMap(Map<String, ParamObject> map) {
        this.map = map;
    }


    public static void main(String[] args) {
        PayChannelReader properties = new PayChannelReader();
        Map<String, ParamObject> result = properties.getMap();
        System.out.println(result);
    }
}
