package com.chenlb.mmseg4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {
	
	
	private List<List<String>> readXls(String path) throws Exception{
		InputStream is = new FileInputStream(path);
		XSSFWorkbook hssfworkbook  = new XSSFWorkbook(is);
		List<List<String>> result = new ArrayList<List<String>>();
		for(int numSheet =0; numSheet < hssfworkbook.getNumberOfSheets();numSheet++){
			XSSFSheet hssfSheet = hssfworkbook.getSheetAt(numSheet);
			
			if(hssfSheet ==null){
				continue;
			}
			for(int rowNum = 1; rowNum<= hssfSheet.getLastRowNum();rowNum++){
				XSSFRow hssfRow = hssfSheet.getRow(rowNum);
				int minColIx = hssfRow.getFirstCellNum();
				int maxColIx = hssfRow.getLastCellNum();
				List<String> rowList = new ArrayList<String>();
				for(int colIx =minColIx; colIx< maxColIx; colIx++){
					XSSFCell cell = hssfRow.getCell(colIx);
					if(cell==null){
						continue;
					}
					rowList.add(cell.toString());
				}
				result.add(rowList);

			}
		}
		return result;
 		
	}
//	public String toString1(XSSFCell cell){
//		switch (cell.getCellType()) {
//		case Cell.CELL_TYPE_BOOLEAN:
//			return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
//		case Cell.CELL_TYPE_FORMULA:
//			return cell.getCellFormula();
//		case Cell.CELL_TYPE_NUMERIC:
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			return cell.getStringCellValue();
//		default:
//			return "GG";
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		test a =new test();
		List<List<String>> list= a.readXls("/Users/dongmenyingnan/Documents/workspace/ssm/src/main/webapp/resources/documents/1.xlsx");
		for(int b = 0; b<list.size();b++){
			for(int c =0;c<list.get(b).size();c++){
				System.out.println(list.get(b).get(c));
			}
		}
		
	}

}
