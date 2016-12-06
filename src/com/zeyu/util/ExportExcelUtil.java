package com.zeyu.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcelUtil {
	private HSSFSheet sheet;
	private HSSFWorkbook wb;
	private CellRangeAddress region1;
	private HSSFCellStyle titleStyle;
	private HSSFCellStyle workbookStyle;
	private HSSFFont titleFont;
	
	public ExportExcelUtil() {
		// TODO Auto-generated constructor stub
		wb = new HSSFWorkbook();
		sheet = wb.createSheet("地区统计表");
		
		titleFont = wb.createFont();
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	
		titleStyle = wb.createCellStyle();
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		
		workbookStyle = wb.createCellStyle();
		workbookStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	}
	
	public ExportExcelUtil(String path) {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(this.getClass().getClassLoader().getResourceAsStream(path));
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void SetTitle( int range ) {	
		
		Row rows = sheet.getRow(0);
		for ( int col = 0; col < range + 4; col++ ) {
			Cell cell = rows.getCell(col);
			if(cell == null)
				cell = rows.createCell(col);
			cell.setCellStyle(titleStyle);
		}
		
		sheet.setColumnWidth(0, 4000);
		for ( int i = 0; i < range; i++ ) {
			sheet.setColumnWidth(i + 4 , 4000);
		}
		region1 = new CellRangeAddress(0, 0, (short) 4, (short) range + 3);
		sheet.addMergedRegion(region1);
		

	}

	public void fill(int row, int col, String value){
		// 在相应的单元格进行赋值
		Row rows = sheet.getRow(row);
		if(rows == null)
			rows = sheet.createRow(row);
		Cell cell = rows.getCell(col);
		if(cell == null)
			cell = rows.createCell(col);
		cell.setCellValue(value);
		
//		if ( 0 == row ) {
//			cell.setCellStyle(titleStyle);
//		} else {
			cell.setCellStyle(workbookStyle);
//		}
	}

	public void export(OutputStream outputStream) {
		try {
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
