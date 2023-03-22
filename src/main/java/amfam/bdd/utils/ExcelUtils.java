package amfam.bdd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import amfam.bdd.reporting.Logs;

public class ExcelUtils {

	FileInputStream fileInputStream;
	public Workbook book;
	public Sheet sheet;

	public ExcelUtils(String filePath, String sheetName) {
		try {
			fileInputStream = new FileInputStream(filePath);
			if (filePath.endsWith(".xlsx")) { // Newer excel version
				book = new XSSFWorkbook(fileInputStream);
			} else if (filePath.endsWith(".xls")) { // Older Excel Version
				book = new HSSFWorkbook(fileInputStream);
			}
			sheet = book.getSheet(sheetName);
			book.close();
			fileInputStream.close();
		} catch (IOException e) {
			Logs.log("File not found : " + new File(filePath).getAbsolutePath());
		}
	}
	
	public List<Map<String, String>> getMapDataList(){
		List<Map<String, String>> listOfMaps = new ArrayList<>();

		int totalRows = sheet.getLastRowNum();
		int totalCols = sheet.getRow(0).getLastCellNum();

		for (int row = 1; row <= totalRows; row++) {
			Map<String, String> map = new HashMap<>();
			for (int cell = 0; cell <= totalCols; cell++) {
				String key = "";
				String value = "";
				try {
					key = sheet.getRow(0).getCell(cell).getStringCellValue()+row;
					value = sheet.getRow(row).getCell(cell).getStringCellValue();
				} catch (NullPointerException e) {

				}
				map.put(key, value);
			}
			listOfMaps.add(map);
		}
		return listOfMaps;
	}
	
}
