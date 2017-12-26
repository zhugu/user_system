package com.system.utils;

import com.system.model.Wages;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 * Created by leovo on 2017/12/22.
 */
public class ExportWagesExcel {
    public static void exportWagesData(List<Wages> list) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();//创建一个工作簿对象
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("工资报表");//创建一个工作表对象
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);
		/* 列名 */
        String[] titles = { "工号","基本工资","全勤奖","工龄补助工资","处罚扣除工资","五险一金","个人所得税","应发工资","实发工资","发放时间" };
		/* for循环生成列名 */
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
        }
		/* 填充数据 */
        int rowIndex = 1;
        for (Wages wages : list) {
            hssfRow = hssfSheet.createRow(rowIndex);
            hssfCell = hssfRow.createCell(0);
            hssfCell.setCellValue(wages.getUserid());
            hssfCell = hssfRow.createCell(1);
            hssfCell.setCellValue(wages.getBasicwages());
            hssfCell = hssfRow.createCell(2);
            hssfCell.setCellValue(wages.getAttendancereward());
            hssfCell = hssfRow.createCell(3);
            hssfCell.setCellValue(wages.getYearwages());
            hssfCell = hssfRow.createCell(4);
            hssfCell.setCellValue(wages.getPublish());
            hssfCell = hssfRow.createCell(5);
            hssfCell.setCellValue(wages.getInsurance());
            hssfCell = hssfRow.createCell(6);
            hssfCell.setCellValue(wages.getTax());
            hssfCell = hssfRow.createCell(7);
            hssfCell.setCellValue(wages.getWages());
            hssfCell = hssfRow.createCell(8);
            hssfCell.setCellValue(wages.getTruewages());
            hssfCell = hssfRow.createCell(9);
            hssfCell.setCellValue(wages.getDate().toString());
            rowIndex++;
        }
        File file = new File("E:\\工资报表.xls");
        OutputStream output = null;
        try {
            output = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            hssfWorkbook.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
