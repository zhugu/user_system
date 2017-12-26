package com.system.utils;


import com.system.model.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 * @author xu
 * 数据导出工具类
 */
public class ExportUserExcel {
    public static void exportData(List<User> list) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();//创建一个工作簿对象
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("学生信息表");//创建一个工作表对象
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);
		/* 列名 */
        String[] titles = { "工号","名字","性别","住址","籍贯","民族","部门","职位","电话","身份证号" };
		/* for循环生成列名 */
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
        }
		/* 填充数据 */
		int rowIndex = 1;
        for (User user : list) {
            hssfRow = hssfSheet.createRow(rowIndex);
            hssfCell = hssfRow.createCell(0);
            hssfCell.setCellValue(user.getUserid());
            hssfCell = hssfRow.createCell(1);
            hssfCell.setCellValue(user.getName());
            hssfCell = hssfRow.createCell(2);
            hssfCell.setCellValue(user.getSex());
            hssfCell = hssfRow.createCell(3);
            hssfCell.setCellValue(user.getAddress());
            hssfCell = hssfRow.createCell(4);
            hssfCell.setCellValue(user.getPlace());
            hssfCell = hssfRow.createCell(5);
            hssfCell.setCellValue(user.getNation());
            hssfCell = hssfRow.createCell(6);
            hssfCell.setCellValue(user.getDepartmentid());
            hssfCell = hssfRow.createCell(7);
            hssfCell.setCellValue(user.getJob());
            hssfCell = hssfRow.createCell(8);
            hssfCell.setCellValue(user.getTel());
            hssfCell = hssfRow.createCell(9);
            hssfCell.setCellValue(user.getEntrytime().toString());
            hssfCell = hssfRow.createCell(10);
            hssfCell.setCellValue(user.getIdentityID());
            rowIndex++;
        }
        File file = new File("E:\\员工信息表.xls");
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
