package com.epc.operator.service.service.impl.test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POI解析Excel
 */
public class ExcelReaderUtil {

    /**
     * 根据fileType不同读取excel文件
     * @param path
     * @param path
     * @throws IOException
     */
    public static List<List<String>> readExcel(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        // return a list contains many list
        List<List<String>> lists = new ArrayList<>();
        InputStream is = null;

        try {
            is = new FileInputStream(path);
            Workbook wb;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }

            System.out.println("sheet:-------" + wb.getNumberOfSheets());

            for(int i=0;i<wb.getNumberOfSheets();i++) {
                Sheet sheet = wb.getSheetAt(i);
                String sheetname  =  sheet.getSheetName().trim();
                for (Row row : sheet) {
                    ArrayList<String> list = new ArrayList<>();
                    int a=0;
                    for (Cell cell : row) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String str = cell.getStringCellValue();
                        ++a ;
                        if ( a==1 && "".equals(str)) {
                            list.add(sheetname);
                        }
                        if (str.indexOf("\n") != -1) {
                            String s = str.replace("\n", ";");
                            list.add(s);
                        } else {
                            list.add(str);
                        }

                    }
                    lists.add(list);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return lists;
    }

    public static void main(String[] args) {
        int i =0;

        String path = "/Users/lijun/epc1688/data/室内景观 2.xlsx";
        List<List<String>> lists = readExcel(path);
        for (List<String> list : lists) {
            for (String strs : list) {
                System.out.print(strs);
                System.out.print(",");
               i++;
            }
            System.out.println();
            System.out.println("===============================================================================================================================================================================");
            System.out.println();
        }

        System.out.println(i);
    }


}