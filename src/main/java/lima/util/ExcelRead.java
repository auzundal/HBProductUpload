package lima.util;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    public int excelRowCount(String excelPath) throws Exception
    {
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = workbook.getSheetAt(4);
        int rowCount = sheet1.getLastRowNum()-2;
        return rowCount;
    }

    public int waitSecondCalculator(int rowCount){
        int kaySayi=2,second,waitSecond;
        if(rowCount<=54){
            kaySayi=2;
        }
        else if(rowCount>=55){
            kaySayi=1;
        }
        else{
            System.out.println("Error: excelRowCount!");
        }
         second = rowCount*kaySayi;
         waitSecond = second*1000;

        return waitSecond;
    }
}
