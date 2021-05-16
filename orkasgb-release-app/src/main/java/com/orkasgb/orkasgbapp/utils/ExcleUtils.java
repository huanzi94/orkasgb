package com.orkasgb.orkasgbapp.utils;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExcleUtils {

    private static HSSFSheet sheet;

    private static HSSFCellStyle cellStyle;

    public static void exportExcle(HttpServletResponse response, List<?> dataList, String fileName) throws IOException {
        createExcleTemple(response, dataList, fileName);
    }

    public static void createExcleTemple(HttpServletResponse response, List<?> dataList, String fileName) throws IOException {
        //创建Excel对象
        HSSFWorkbook workBook = new HSSFWorkbook();

        // 文档中添加一个sheet页
        sheet = workBook.createSheet("sheet0");

        // 在sheet页中增加表头
        HSSFRow row = sheet.createRow(Integer.valueOf(String.valueOf(BigInteger.ZERO)));

        /**
         * 设置表头样式
         */
        // 获取文档样式对象
        cellStyle = workBook.createCellStyle();

        // 设置字体
        Font font = workBook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 13);

        cellStyle.setFont(font);

        // 设置字体居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        row.setRowStyle(cellStyle);

        setDataToExcle(row, workBook, response, dataList, fileName);
    }

    public static void setDataToExcle(HSSFRow rowTitle, Workbook workBook, HttpServletResponse response, List<?> dataList, String fileName) throws IOException {
        List<Map> dataMap = dataList.stream().map(entity -> JSON.parseObject(JSON.toJSONString(entity), Map.class)).collect(Collectors.toList());
        AtomicBoolean setHeader = new AtomicBoolean(true);
        AtomicInteger k = new AtomicInteger(Integer.valueOf(String.valueOf(BigInteger.ONE)));
        dataMap.forEach(map -> {
            if (setHeader.get()) {
                AtomicInteger i = new AtomicInteger(Integer.valueOf(String.valueOf(BigInteger.ZERO)));
                map.keySet().forEach(key -> {
                    sheet.autoSizeColumn(i.get());
                    rowTitle.createCell(i.get()).setCellValue(String.valueOf(key));
                    i.getAndIncrement();
                });
                setHeader.set(false);
            }

            HSSFRow rows = sheet.createRow(k.get());
            AtomicInteger y = new AtomicInteger(Integer.valueOf(String.valueOf(BigInteger.ONE)));
            map.values().forEach(value -> {
                HSSFCell cell = rows.createCell(y.get() - Integer.valueOf(String.valueOf(BigInteger.ONE)));
                cell.setCellValue(String.valueOf(value));
                cell.setCellType(CellType.STRING);
                y.getAndIncrement();
            });
            k.getAndIncrement();
        });

        // 输出文件
        OutputStream outputStream = response.getOutputStream();
        String file = new String(fileName.getBytes("GB2312"), StandardCharsets.ISO_8859_1) + "_" + System.currentTimeMillis() + ".xlsx";
        try {
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //下面这三行必须设置前端才可以读取到文件名
            response.setHeader("Content-Disposition", "attachment; filename=" + file);
            response.setHeader("filename", file);
            response.setHeader("Access-Control-Expose-Headers", "filename");
            response.flushBuffer();
            workBook.write(outputStream);
        } finally {
            outputStream.close();
            workBook.close();
        }
    }
}
