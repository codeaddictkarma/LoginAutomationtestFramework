package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadingExcelData {
	
	
	@DataProvider(name = "LoginData")
	public  String[][] readExcelToArray() {
        String[][] data = null;

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\psanj\\eclipse-workspace\\LoginAutomationTest\\src\\test\\java\\Utilities\\practiseLoginDatadriven.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new String[rowCount - 1][colCount]; // Exclude header row

            for (int i = 1; i <rowCount; i++) { // start from 1 to skip headers
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    data[i - 1][j] = cell != null ? cell.toString() : "";
                }
            }

            workbook.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
