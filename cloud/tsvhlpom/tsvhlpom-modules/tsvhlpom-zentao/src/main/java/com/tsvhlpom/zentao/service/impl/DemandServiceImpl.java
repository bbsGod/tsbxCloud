package com.tsvhlpom.zentao.service.impl;

import com.tsvhlpom.system.api.MysqlClientService;
import com.tsvhlpom.system.api.model.DemandDTO;
import com.tsvhlpom.zentao.DO.DemandDO;
import com.tsvhlpom.zentao.DTO.ZenTaoDTO;
import com.tsvhlpom.zentao.mapper.DemandMapper;
import com.tsvhlpom.zentao.service.IDemandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DemandServiceImpl implements IDemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Autowired
    private MysqlClientService mysqlToolClient;

    @Override
    public List<DemandDO> findList(ZenTaoDTO zenTaoDTO) {
        List<DemandDO> demandList = demandMapper.findList(zenTaoDTO);
        List<Integer> zidList = demandList.stream().map(DemandDO::getZid).collect(Collectors.toList());
        List<DemandDTO> demandDTOList = null;
        if(zidList.size()>0){
            demandDTOList =  mysqlToolClient.findDemandByZidIn(zidList);
        }

        changeList(demandList, demandDTOList, zenTaoDTO);
        //用预计结束时间回填 任务结束时间
        demandList.forEach(demandDO -> {
            if(demandDO.getTaskrealed() == null) {
                demandDO.setTaskrealed(demandDO.getDeadline());
            }
        });
        List<DemandDO> demandSortList = demandList.stream().sorted(Comparator.comparing(DemandDO::getSorted)).collect(Collectors.toList());
        log.info("查询完毕");
        return demandSortList;
    }

    @Override
    public void exportDemand(HttpServletResponse res, ZenTaoDTO zenTaoDTO, String type) throws Exception {
        log.info("开始导出需求跟进表");
        List<DemandDO> demandDOList = eportData(zenTaoDTO);
        Workbook wb = null;
        if("old".equals(type)) {
            wb = demandExcelOld(demandDOList, zenTaoDTO);
        } else {
            wb = demandExcelNew(demandDOList, zenTaoDTO);
        }
        String flag = "1";
        if(zenTaoDTO.getProductId().equals(1)) {
            flag = "0";
        }
        downExcel(res, wb, flag);
        log.info("需求跟进表导出结束");
    }

    @Override
    public void exportWeekly(HttpServletResponse res, ZenTaoDTO zenTaoDTO) throws Exception  {
        log.info("开始导出周报");
        List<DemandDO> demandDOList = eportWeeklyData(zenTaoDTO);
        Workbook wb = weeklyExcel(demandDOList, zenTaoDTO);
        downExcel(res, wb, "2");
        log.info("周报导出结束");
    }

    @Override
    public Map<String, Object> findDemandById(Integer zid) {
        DemandDO demandDO = demandMapper.findDemandById(zid);
        DemandDTO demandDTO = mysqlToolClient.getDemandByZid(zid);
        Map<String, Object> reMap = new HashMap();
        reMap.put("demandDO", demandDO);
        reMap.put("demandDTO", demandDTO);
        return reMap;
    }

    private List<DemandDO> eportWeeklyData( ZenTaoDTO zenTaoDTO) {
        List<DemandDO> demandDOList = findList(zenTaoDTO);
        demandDOList.forEach(demandDO -> {
            if(demandDO.getTaskrealed() == null) {
                demandDO.setTaskrealed(demandDO.getDeadline());
            }
            if(demandDO.getProonlinedate() == null) {
                demandDO.setProonlinedate(zenTaoDTO.getOnlineDate());
            }
            if(demandDO.getCheckdate() == null) {
                demandDO.setCheckdate(zenTaoDTO.getOnlineDate());
            }
            if(demandDO.getOnlinedate() == null) {
                demandDO.setOnlinedate(zenTaoDTO.getOnlineDate());
            }
        });
        return demandDOList;
    }

    private List<DemandDO> eportData( ZenTaoDTO zenTaoDTO) {
        List<DemandDO> demandDOList = findList(zenTaoDTO);
        demandDOList.forEach(demandDO -> {
            if(demandDO.getProonlinedate() == null) {
                demandDO.setProonlinedate(zenTaoDTO.getOnlineDate());
            }
        });
        return demandDOList;
    }
    /**
     * DTO中数据不为空时，直接替换对应的DO中的值，最终使用DO的list
     * @param demandDOList
     * @param demandDTOList
     */
    private void changeList(List<DemandDO> demandDOList, List<DemandDTO> demandDTOList, ZenTaoDTO zenTaoDTO) {
        for(int i =0; i < demandDOList.size(); i++) {
            DemandDO demandDO = demandDOList.get(i);
            for(DemandDTO demandDTO : demandDTOList) {
                if(demandDO.getZid().equals(demandDTO.getZid())) {
                    if(demandDTO.getZtitle() != null && !"".equals(demandDTO.getZtitle())) {
                        demandDO.setZtitle(demandDTO.getZtitle());
                    }
                    if(demandDTO.getMname() != null && !"".equals(demandDTO.getMname())) {
                        demandDO.setMname(demandDTO.getMname());
                    }
                    if(demandDTO.getZsource() != null && !"".equals(demandDTO.getZsource())) {
                        demandDO.setZsource(demandDTO.getZsource());
                    }
                    if(demandDTO.getRemarks() != null && !"".equals(demandDTO.getRemarks())) {
                        demandDO.setRemarks(demandDTO.getRemarks());
                    }
                    if(demandDTO.getCheckdate() != null) {
                        demandDO.setCheckdate(demandDTO.getCheckdate());
                    }
                    if(demandDTO.getOnlinedate() != null) {
                        demandDO.setOnlinedate(demandDTO.getOnlinedate());
                    }
                    if(demandDTO.getTaskrealst() != null) {
                        demandDO.setTaskrealst(demandDTO.getTaskrealst());
                    }
                    if(demandDTO.getTaskrealed() != null) {
                        demandDO.setTaskrealed(demandDTO.getTaskrealed());
                    }
                    if(demandDTO.getProonlinedate() != null) {
                        demandDO.setProonlinedate(demandDTO.getProonlinedate());
                    }
                    break;
                }
            }
            if(demandDO.getOnlinedate() !=null && zenTaoDTO.getStartDate().after(demandDO.getOnlinedate())) {
                demandDOList.remove(i);
                i--;
            }
        }
    }

    /**
     * 处理需求Excelold
     * @param demandDOList
     * @param zenTaoDTO
     * @return
     */
    private Workbook demandExcelOld(List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        HSSFWorkbook wb = new HSSFWorkbook();
        demandExcelSheet1(wb,demandDOList, zenTaoDTO);
        demandExcelSheet2(wb,demandDOList, zenTaoDTO);
        return  wb;
    }

    /**
     * 处理需求Excelnew
     * @param demandDOList
     * @param zenTaoDTO
     * @return
     */
    private Workbook demandExcelNew(List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        HSSFWorkbook wb = new HSSFWorkbook();
        demandExcelSheet1(wb, demandDOList, zenTaoDTO);
        demandExcelOtherSheet(wb,  demandDOList, zenTaoDTO);
        return  wb;

    }

    /**
     * 处理周报EXcel
     * @param demandDOList  数据
     * @param zenTaoDTO  数据条件
     * @return
     */
    private Workbook weeklyExcel(List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        String productName = "";
        if(zenTaoDTO.getProductId() == 1) {
            productName = "车险部";
        }
        Map<Integer, List<DemandDO>> dataMap = weeklyDataMap(demandDOList);

        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle cellStyle = textCellStyle(wb);
        CellStyle limeCellStyle = textLimeCell(wb);
        //周报一共有4个 sheet 页面 每次循环的sheet页面
        for(int i =0; i < 4; i++) {
            //处理Excel表头
            HSSFSheet sheet = wb.createSheet(sheetNameMap.get(i));
            HSSFRow headerRow =  sheet.createRow(0);
            for(int j=0; j < weeklyHeaderList.size(); j++) {
                HSSFCell cell = headerRow.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(weeklyHeaderList.get(j));
            }
            //处理数据
            List<DemandDO> datalist = dataMap.get(i);
            if(datalist != null && datalist.size() > 0) {
                for (int j = 0; j < datalist.size(); j++) {
                    DemandDO demand = datalist.get(j);
                    Boolean miteFlag = demand.getZopeneddate().before(zenTaoDTO.getStartDate())? false : true;
                    List<String> cellList = weeklyDemandDOToList(demand);
                    int rowNum = j + 1;
                    HSSFRow row = sheet.createRow(rowNum);
                    for (int k =0; k < cellList.size(); k++) {
                        HSSFCell cell = row.createCell(k);
                        CellStyle cellStyle1;
                        if(miteFlag && j ==3) {
                            cellStyle1 = limeCellStyle;
                        }else {
                            cellStyle1 = cellStyle;
                        }
                        cell.setCellStyle(cellStyle1);
                        cell.setCellValue(cellList.get(k));

                    }
                }
                CellRangeAddress cellrange = new CellRangeAddress(1, datalist.size() , 0, 0);
                sheet.addMergedRegion(cellrange);
                HSSFCell cell = sheet.getRow(1).getCell(0);
                cell.setCellValue(productName);
            }
        }
        return wb;
    }

    /**
     * 统计页sheet
     * @param wb
     * @param demandDOList
     */
    private void demandExcelSheet1(HSSFWorkbook wb, List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        long newCount = demandDOList.stream().filter(demandDO -> demandDO.getZopeneddate().after(zenTaoDTO.getStartDate())).count();
        long waitCount = demandDOList.stream().filter(demandDO -> demandDO.getZstage().equals("待开发")).count();
        long devCount = demandDOList.stream().filter(demandDO -> demandDO.getZstage().equals("开发中")).count();
        long testCount = demandDOList.stream().filter(demandDO -> demandDO.getZstage().equals("待用户验收")).count();
        long relCount = demandDOList.stream().filter(demandDO -> demandDO.getZstage().equals("已上线")).count();

        //统计sheet
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 16);
        font.setFontName("微软雅黑");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setFont(font);
        //下边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        cellStyle.setWrapText(true);

        HSSFSheet sheet1 = wb.createSheet("统计");
        sheet1.setColumnWidth(0,40*256);
        HSSFRow row = sheet1.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        row.setHeight((short) 2500);
        String con = "1.新增%s项需求。\r\n2. 待开发%s项需求。\r\n3. 开发中%s项需求。\r\n4. 用户正在测试%s项需求。\r\n5. 成功上线%s项需求。";
        con = String.format(con, newCount, waitCount, devCount, testCount, relCount);
        cell.setCellValue(new HSSFRichTextString(con));
    }

    /**
     * 需求页sheet
     * @param wb
     * @param demandDOList
     */
    private void demandExcelSheet2(HSSFWorkbook wb, List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        demandExcelSheet(wb, demandDOList, "需求", zenTaoDTO);
    }


    /**
     * 需求页sheet
     * @param wb
     * @param demandDOList
     */
    private void demandExcelOtherSheet(HSSFWorkbook wb, List<DemandDO> demandDOList, ZenTaoDTO zenTaoDTO) {
        try{
            /*List<DemandDO> list0 = new ArrayList<>();
            for(DemandDO demandDO: demandDOList){
                if(demandDO.getMname() !=null && !"".equals(demandDO.getMname())
                        &&(demandDO.getMname().equals("功能新增") || demandDO.getMname().equals("功能改造"))){
                    list0.add(demandDO);
                }
            }*/
            List<DemandDO> list0 = demandDOList.stream().filter(demandDO ->
             demandDO.getMname() !=null &&(demandDO.getMname().equals("功能新增") || demandDO.getMname().equals("功能改造"))
                    ).collect(Collectors.toList());
            List<DemandDO> list1 = demandDOList.stream().filter(demandDO -> demandDO.getMname() !=null && demandDO.getMname().equals("数据提取") ).collect(Collectors.toList());
            List<DemandDO> list2 = demandDOList.stream().filter(demandDO -> demandDO.getMname() !=null && demandDO.getMname().equals("数据更新") ).collect(Collectors.toList());
            demandExcelSheet(wb, list0, demandsheetNameMap.get(0), zenTaoDTO);
            demandExcelSheet(wb, list1, demandsheetNameMap.get(1), zenTaoDTO);
            demandExcelSheet(wb, list2, demandsheetNameMap.get(2), zenTaoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void demandExcelSheet(HSSFWorkbook wb, List<DemandDO> demandDOList, String sheetName, ZenTaoDTO zenTaoDTO) {
        CellStyle cellStyle = textCellStyle(wb);
        CellStyle limeCellStyle = textLimeCell(wb);
        HSSFSheet sheet2 = wb.createSheet(sheetName);
        //创建表头
        HSSFRow headerRow = sheet2.createRow(0);
        for(int i = 0; i<demandHeaderList.size(); i++) {
            String headerStr = demandHeaderList.get(i);
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headerStr);
        }
        //内容填充
        for(int i = 0; i< demandDOList.size(); i++) {
            DemandDO demand = demandDOList.get(i);
            Boolean miteFlag = demand.getZopeneddate().before(zenTaoDTO.getStartDate())? false : true;
            int RowNum = i + 1;
            HSSFRow row = sheet2.createRow(RowNum);
            List<String> cellList = demandDOToList(demand);
            for(int j = 0; j < cellList.size(); j++) {
                HSSFCell cell = row.createCell(j);
                CellStyle cellStyle1;
                if(miteFlag && j ==3) {
                    cellStyle1 = limeCellStyle;
                }else {
                    cellStyle1 = cellStyle;
                }
                cell.setCellStyle(cellStyle1);
                cell.setCellValue(cellList.get(j));
            }
        }
    }




    /**
     * 返回前端Excel流
     * @param res
     * @param wb
     * @throws Exception
     */
    private void downExcel(HttpServletResponse res, Workbook wb, String type) throws Exception {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "%s" +  sdf.format(date) + ".xls";
        //车险需求跟进表单独处理 标志0
        if("0".equals(type)) {
            fileName = String.format(fileName, "车险需求跟进表");
        } else if("1".equals(type)) {
            fileName = String.format(fileName, "需求跟进表");
        } else if("2".equals(type)) {
            fileName = String.format(fileName, "周报统计材料");
        }
        //设置前端返回 包括进度条
        res.setHeader("content-type", "application/vnd.ms-excel;charset=utf-8");
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Content-Disposition", "attachment;filename=" +  URLEncoder.encode(fileName,"UTF-8") );
        res.flushBuffer();
        //设置文件大小，如果做下载进度条可以直接用
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wb.write(byteArrayOutputStream);
        res.setHeader("Content-Length",""+ byteArrayOutputStream.size());
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            wb.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw  e;
        } finally {
            if(os != null) {
                os.close();
            }
        }

    }

    private CellStyle textCellStyle(HSSFWorkbook wb) {
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("微软雅黑");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        //下边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        return cellStyle;
    }


    private CellStyle textLimeCell(HSSFWorkbook wb) {
        CellStyle cellStyle =  textCellStyle(wb);
        cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        return cellStyle;
    }


    private CellStyle textCellStyleFontMiC(HSSFWorkbook wb) {
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("微软雅黑");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        //下边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        return cellStyle;
    }


    /**
     * 为了以后数据变动调整方便增加此方法，此方法仅仅是为了方便维护使用不做性能考虑
     * @param demand
     * @return
     */
    private List<String> demandDOToList(DemandDO demand) {
        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(demand.getZid()));
        list.add(demand.getZpname());
        list.add(String.valueOf(demand.getZpri()));
        list.add(demand.getZtitle());
        list.add(demand.getMname());
        list.add(demand.getZsource());
        list.add(demand.getUrealname());
        list.add(demand.getU2realname());
        list.add(demand.getZstage());
        list.add(DateToString(demand.getZopeneddate()));
        list.add(DateToString(demand.getProonlinedate()));
        list.add(DateToString(demand.getTaskrealst()));
        list.add(DateToString(demand.getTaskrealed()));
        list.add(DateToString(demand.getCheckdate()));
        list.add(DateToString(demand.getOnlinedate()));
        list.add(demand.getRemarks());
        return list;
    }

    private Map<Integer, List<DemandDO>> weeklyDataMap(List<DemandDO> demandDOList) {
        Map<Integer, List<DemandDO>> map = new HashMap<Integer, List<DemandDO>>();
        List<DemandDO> list0 = demandDOList.stream().filter(demandDO -> demandDO.getMname().equals("功能新增") || demandDO.getMname().equals("功能改造")).collect(Collectors.toList());
        List<DemandDO> list1 = demandDOList.stream().filter(demandDO -> demandDO.getMname().equals("数据提取") ).collect(Collectors.toList());
        List<DemandDO> list2 = demandDOList.stream().filter(demandDO -> demandDO.getMname().equals("数据更新") ).collect(Collectors.toList());
        map.put(0, list0);
        map.put(1, list1);
        map.put(2, list2);
        map.put(3, null);
        return map;
    }

    /**
     * 为了以后数据变动调整方便增加此方法，此方法仅仅是为了方便维护使用不做性能考虑
     * @param demand
     * @return
     */
    private List<String> weeklyDemandDOToList(DemandDO demand) {
        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("");
        list.add(String.valueOf(demand.getZid()));
        list.add(demand.getZtitle());
        list.add(DateToString(demand.getZopeneddate()));
        list.add(DateToString(demand.getTaskrealed()));
        if(demand.getCheckdate() != null) {
            list.add(DateToString(demand.getCheckdate()));
        } else if(demand.getOnlinedate() != null) {
            list.add(DateToString(demand.getOnlinedate()));
        } else {
            list.add(DateToString(demand.getProonlinedate()));
        }
        if(demand.getOnlinedate() != null) {
            list.add(DateToString(demand.getOnlinedate()));
        } else {
            list.add(DateToString(demand.getProonlinedate()));
        }
        list.add(demand.getZstage());
        list.add(demand.getRemarks());

        return list;
    }

    private static String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null) {
            return "";
        } else {
            return sdf.format(date);
        }
    }



    private static List<String> demandHeaderList = new ArrayList<String>();
    private static List<String> weeklyHeaderList = new ArrayList<String>();
    private static Map<Integer, String> sheetNameMap = new HashMap<Integer, String>();
    private static Map<Integer, String> demandsheetNameMap = new HashMap<Integer, String>();

    static {
        demandHeaderList.add("需求");
        demandHeaderList.add("产品名称");
        demandHeaderList.add("需求优先级");
        demandHeaderList.add("需求名称");
        demandHeaderList.add("所属模块");
        demandHeaderList.add("需求来源");
        demandHeaderList.add("需求创建");
        demandHeaderList.add("需求指派");
        demandHeaderList.add("需求阶段");
        demandHeaderList.add("创建时间");
        demandHeaderList.add("预计上线时间");
        demandHeaderList.add("开发开始时间");
        demandHeaderList.add("开发完成时间");
        demandHeaderList.add("需求验收时间");
        demandHeaderList.add("需求上线时间");
        demandHeaderList.add("备注");

        weeklyHeaderList.add("提出部门");
        weeklyHeaderList.add("序号");
        weeklyHeaderList.add("需求号");
        weeklyHeaderList.add("需求名称");
        weeklyHeaderList.add("提交时间");
        weeklyHeaderList.add("完成时间");
        weeklyHeaderList.add("验收测试时间");
        weeklyHeaderList.add("预计上线时间");
        weeklyHeaderList.add("需求状态");
        weeklyHeaderList.add("备注");

        sheetNameMap.put(0, "需求");
        sheetNameMap.put(1,"数据提取");
        sheetNameMap.put(2, "数据更正");
        sheetNameMap.put(3, "日常运行");

        demandsheetNameMap.put(0, "需求");
        demandsheetNameMap.put(1,"数据提取");
        demandsheetNameMap.put(2, "数据更正");
    }

}
