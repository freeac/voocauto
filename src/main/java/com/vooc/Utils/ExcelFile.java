package com.vooc.Utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	private static FileInputStream fistr = null;
	private static XSSFWorkbook wb = null;
	private static XSSFSheet ws = null;

	private static void ReadFileExcel(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\Excels\\" + fileName;
		try {
			fistr = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fistr);
			ws = wb.getSheetAt(0);
			fistr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int NumberOfRows(String fileName, String wsName) {
		ReadFileExcel(fileName);
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1) {
			return 0;
		} else {
			ws = wb.getSheetAt(sheetIndex);
			int countRow = ws.getLastRowNum() + 1;
			return countRow;
		}
	}

	public static int NumberOfColumn(String fileName, String wsName, int row) {
		ReadFileExcel(fileName);
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1) {
			return 0;
		} else {
			ws = wb.getSheetAt(sheetIndex);
			int col = ws.getRow(row).getLastCellNum();
			return col;
		}
	}

	public static String GetValueWithHeaderTable(String fileName, String wsName, String rowName, String colName) {
		int curRow = -1;
		int curCol = -1;
		ReadFileExcel(fileName);
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1) {
			return null;
		} else {
			ws = wb.getSheetAt(sheetIndex);
			int TotalRow = ws.getLastRowNum();
			int TotalCol = 0;
			int row = -1;
			int col = -1;
			// Get index of row header
			for (int k = 0; k < TotalRow; k++) {
				if (ws.getRow(k) != null) {
					TotalCol = ws.getRow(k).getLastCellNum();
					row = k;
					break;
				}
			}
			// Get index of Column Name
			for (int i = 0; i < TotalCol; i++) {
				if (ws.getRow(row) != null) {
					if (ws.getRow(row).getCell(i) != null) {
						if (ws.getRow(row).getCell(i).getStringCellValue().equals(colName)) {
							curCol = i;
						}
					}
				}
			}
			// Get index of column header
			for (int l = 0; l < TotalCol; l++) {
				if (ws.getRow(row) != null) {
					if (ws.getRow(row).getCell(l) != null) {
						col = l;
						break;
					}
				}
			}
			// Get index of Row Name
			for (int j = 0; j < TotalRow; j++) {
				if(ws.getRow(j) != null) {
					if(ws.getRow(j).getCell(col) != null) {
						if(ws.getRow(j).getCell(col).getStringCellValue().equals(rowName)) {
							curRow = j;
						}
					}
				}
			}
			String val = ws.getRow(curRow).getCell(curCol).getStringCellValue();
			return val;
		}
	}

}

