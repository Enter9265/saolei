package com.chen.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    /**
     * 读取
     */
    @Test
    public void getExcel() {
        XSSFWorkbook workbook = null; //获取工作表，既可以根据工作表的顺序获取，也可以根据工作表的名称获取
        try {
            workbook = new XSSFWorkbook("F:\\hello.xlsx");
            XSSFSheet sheet = workbook.getSheetAt(0); //遍历工作表获得行对象
            /*for (Row row : sheet) {//遍历行对象获取单元格对象  
                for (Cell cell : row) {//获得单元格中的值    
                    String value = cell.getStringCellValue();
                    System.out.println(value);
                }
            }*/
            int lastRowNum = sheet.getLastRowNum();

            for (int i = 0; i <= lastRowNum; i++) { //根据行号获取行对象  
                XSSFRow row = sheet.getRow(i);
                short lastCellNum = row.getLastCellNum();
                for (short j = 0; j < lastCellNum; j++) {//获取列
                    if (j == 0) {//读取纯数字
                        XSSFCell cell = row.getCell(j);
                        DecimalFormat df = new DecimalFormat("0");
                        String whatYourWant = df.format(cell.getNumericCellValue());
                        System.out.print(whatYourWant);
                    }
                    if (j == 1) {//读取字符串
                        String value = row.getCell(j).getStringCellValue();
                        System.out.println(value);
                    }
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入
     */
    @Test
    public void setExcel() {
        try {

            //在内存中创建一个Excel文件
            XSSFWorkbook workbook = new XSSFWorkbook(); //创建工作表，指定工作表名称
            XSSFSheet sheet = workbook.createSheet("名字");

            //创建行，0表示第一行
            XSSFRow row = sheet.createRow(0); //创建单元格，0表示第一个单元格
            row.createCell(0).setCellValue("编号");
            row.createCell(1).setCellValue("名称");
            row.createCell(2).setCellValue("年龄");
            XSSFRow row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("1");
            row1.createCell(1).setCellValue("小明");
            row1.createCell(2).setCellValue("10");
            XSSFRow row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("2");
            row2.createCell(1).setCellValue("小王");
            row2.createCell(2).setCellValue("20");
            //通过输出流将workbook对象下载到磁盘
            FileOutputStream out = null;
            out = new FileOutputStream("F:\\itcast.xlsx");
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        Map<String,String> map = new HashMap<>();
        map.put("12","21");
        map.put("13","22");
        map.put("14","23");
        map.put("15","24");
        map.put("16","652");
        map.put("17","26");
        map.put("18","28");
        map.put("10","29");
        map.put("11","233");
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            String s1 = map.get(s);

            System.out.println(s+"::::::"+s1);
        }
    }
}
