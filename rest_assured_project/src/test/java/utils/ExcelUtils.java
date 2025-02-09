package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static List<String> getTranslations(String filePath, String sheetName) {
        List<String> translations = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // First column
                translations.add(cell.getStringCellValue());
                System.out.println(cell.getStringCellValue());
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translations;
    }
}
