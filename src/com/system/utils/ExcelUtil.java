package com.system.utils;

/**
 * @author xu
 * 操作Excel表格的功能类
 */
public class ExcelUtil {
    //excel文件对象
//    private POIFSFileSystem fs;
//    // 工作簿对象
//    private HSSFWorkbook wb;
//    // 工作表对象
//    private HSSFSheet sheet;
//    // 行对象
//    private HSSFRow row;
//
//
//    /**
//     * 读取Excel数据内容
//     * @param is
//     * @return 一组学生数据list集合
//     */
//    public List<Student> readExcelContent(InputStream is) {
//        List<Student> studentList = new ArrayList<>();
//        try {
//            fs = new POIFSFileSystem(is);
//            wb = new HSSFWorkbook(fs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //得到第一张工作表
//        sheet = wb.getSheetAt(0);
//        // 正文内容应该从第二行开始,第一行为表头的标题
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //所有要导入的学生对象使用这个默认头像
//        File file = new File("D:\\default.png");
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        byte[] b = new byte[(int) file.length()];
//        try {
//            inputStream.read(b);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //循环读取表格每一行，封装成一个Student对象，然后放入list中
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            row = sheet.getRow(i);
//            String account = row.getCell(0).getRichStringCellValue().getString().trim();
//            String name = row.getCell(1).getRichStringCellValue().getString().trim();
//            String sex = row.getCell(2).getRichStringCellValue().getString().trim();
//            String departmentid = row.getCell(3).getRichStringCellValue().getString().trim();
//            String birthland = row.getCell(4).getRichStringCellValue().getString().trim();
//            String phonenumber = row.getCell(5).getRichStringCellValue().getString().trim();
//            String schoolindate = row.getCell(6).getRichStringCellValue().getString().trim();
//            java.util.Date date = null;
//            try {
//                date = sdf.parse(schoolindate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Student student = new Student();
//            student.setAccount(account);
//            student.setPassword(account);
//            student.setName(name);
//            student.setBirthland(birthland);
//            student.setDepartmentid(Integer.parseInt(departmentid));
//            student.setSex(sex);
//            student.setPhonenumber(phonenumber);
//            student.setPicture(b);
//            student.setSchoolindate(new Date(date.getTime()));
//            studentList.add(student);
//        }
//        return studentList;
//    }
//
//    public static void main(String[] args) throws Exception {
//        File file = new File("e:\\student.xls");
//        InputStream is = new FileInputStream(file);
//        ExcelUtil excelUtil = new ExcelUtil();
//        List<Student> studentList = excelUtil.readExcelContent(is);
//        studentList.forEach(student -> System.out.println(student));
//    }
}

