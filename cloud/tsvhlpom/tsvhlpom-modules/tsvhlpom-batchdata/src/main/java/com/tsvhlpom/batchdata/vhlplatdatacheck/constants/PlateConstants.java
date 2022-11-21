package com.tsvhlpom.batchdata.vhlplatdatacheck.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 车险平台对账公共类
 */
public class PlateConstants {

    public final static String[] AREACODE = {"HB", "QD", "JS", "SD", "NMG","NB", "BJ", "ZJ","HN","SX","SX_11","SC","TJ"};
    public final static String[] PRODARR = {"JQ", "SY"};
    public static Map<String, String> districtCdeMap = new HashMap<String, String>();
    public static Map<String, String> dptCdeMap = new HashMap<String, String>();

    static {
        dptCdeMap.put("QD", "02");
        dptCdeMap.put("HB", "03");
        dptCdeMap.put("NMG", "05");
        dptCdeMap.put("JS", "04");
        dptCdeMap.put("ZJ", "06");
        dptCdeMap.put("NB", "07");
        dptCdeMap.put("SD", "01");
        dptCdeMap.put("BJ", "08");
        dptCdeMap.put("HN", "09");
        dptCdeMap.put("SX", "10");
        dptCdeMap.put("SX_11", "11");
        dptCdeMap.put("SC", "12");
        dptCdeMap.put("TJ", "13");

        //初始化区域代码，交强商业相同
        districtCdeMap.put("QD", "370200");
        districtCdeMap.put("HB", "130000");
        districtCdeMap.put("NMG", "150000");
        districtCdeMap.put("JS", "320000");
        districtCdeMap.put("ZJ", "330000");
        districtCdeMap.put("NB", "330200");
        districtCdeMap.put("SD", "370000");
        districtCdeMap.put("BJ", "110000");
        districtCdeMap.put("HN", "410000");
        districtCdeMap.put("SX", "610000");
        districtCdeMap.put("SX_11", "140000");
        districtCdeMap.put("SC", "510000");
        districtCdeMap.put("TJ", "120000");
    }
}
