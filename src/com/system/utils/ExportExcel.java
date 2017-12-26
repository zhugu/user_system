package com.system.utils;

import com.system.model.Wages;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 王宁
 * 数据导出工具类
 */
public class ExportExcel {
	private static List<Wages>wages;

	public static void exportData(List<Wages> list) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();//创建一个工作簿对象
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
		HSSFSheet hssfSheet = hssfWorkbook.createSheet("SUN公司"+dfs.format(new Date())+"员工工资表");//创建一个工作表对象
		HSSFRow hssfRow = hssfSheet.createRow(0);
		HSSFCell hssfCell = hssfRow.createCell(0);
		/* 列名 */
		String[] titles = {"工号","基本工资","全勤奖","工龄工资","惩罚项","保险","个税","应得工资","实得工资","发放日期"};
		/* for循环生成列名 */
		for (int i = 0; i < titles.length; i++) {
			hssfCell = hssfRow.createCell(i);
			hssfCell.setCellValue(titles[i]);
		}
		/* 填充数据 */
		int rowIndex = 1;
		for (Wages wage : list) {
			hssfRow = hssfSheet.createRow(rowIndex);
			hssfCell = hssfRow.createCell(0);
			hssfCell.setCellValue(wage.getUserid());
			hssfCell = hssfRow.createCell(1);
			hssfCell.setCellValue(wage.getBasicwages());
			hssfCell = hssfRow.createCell(2);
			hssfCell.setCellValue(wage.getAttendancereward());
			hssfCell = hssfRow.createCell(3);
			hssfCell.setCellValue(wage.getYearwages());
			hssfCell = hssfRow.createCell(4);
			hssfCell.setCellValue(wage.getPublish());
			hssfCell = hssfRow.createCell(5);
			hssfCell.setCellValue(wage.getInsurance());
			hssfCell = hssfRow.createCell(6);
			hssfCell.setCellValue(wage.getTax());
			hssfCell = hssfRow.createCell(7);
			hssfCell.setCellValue(wage.getWages());
			hssfCell = hssfRow.createCell(8);
			hssfCell.setCellValue(wage.getTruewages());
			hssfCell = hssfRow.createCell(9);
			hssfCell.setCellValue(wage.getDate());
			rowIndex++;
		}
		File file = new File("d:\\wages.xls");
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

	public static void main(String[] args) {
		exportData(wages);
	}
}
