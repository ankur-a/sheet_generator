package sheet_generator;


import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook; //New imports to read XLSX format
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet; //New imports to read XLSX format
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class Sheet1  {
	BasicData basicData = new BasicData();
	
	public void writeHeader(Header head , XSSFWorkbook wb) {
		for(int i=0 ; i< wb.getNumberOfSheets();i++) {
				XSSFSheet sheet = wb.getSheetAt(i);
				
				Iterator <Row> row = sheet.rowIterator();
				row.next().createCell(1,CellType.STRING).setCellValue(head.state);
				row.next().createCell(1,CellType.STRING).setCellValue(head.assessmentYear);
				row.next().createCell(1, CellType.STRING).setCellValue(head.assessmentUnitType);
				row.next().createCell(1,CellType.STRING).setCellValue(head.view);
				row.next().createCell(1,CellType.STRING).setCellValue(head.parentLocName);
				row.next().createCell(1,CellType.STRING).setCellValue(head.fileType);
				
			}
	}
	
	public void createBasicDataSheet(String district , Header head , HashMap <String , BasicData > basicDataMap ) {
		basicData.scrapRockType(basicDataMap);
		basicData.scrapinfFactor(basicDataMap);
		basicData.scrapG(basicDataMap);
		basicData.scrapTotalRNRArea(basicDataMap);
		try {
			FileInputStream file = new FileInputStream(new File("/home/ankur/Documents/sheet/sheet_generator/format/basic_data.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			writeHeader(head, wb);
		
		
		
			for(int i=0 ; i< wb.getNumberOfSheets();i++) {
				XSSFSheet sheet = wb.getSheetAt(i);
				String name = sheet.getSheetName();
				System.out.println(name + "------------\n");
				
				if (name.contains("Basic")) {
					int rowindex = 11,count=1;
					
					for (String blockName : basicDataMap.keySet()) {
						System.out.println(blockName+ "---------");
						BasicData basicData = basicDataMap.get(blockName);
						XSSFRow row = sheet.createRow(rowindex);
						row.createCell(0).setCellValue(count);
						row.createCell(1).setCellValue(basicData.state);
						row.createCell(5).setCellValue(basicData.District);
						row.createCell(6).setCellValue(blockName);
						row.createCell(7).setCellValue(blockName);
						row.createCell(8).setCellValue(basicData.getRockType());
						row.createCell(9).setCellValue(basicData.getYield());
						row.createCell(10).setCellValue(basicData.getInfFactor());
						row.createCell(11).setCellValue(basicData.getTotalGArea());
						row.createCell(12).setCellValue(basicData.getTotalGComArea());
						row.createCell(13).setCellValue(basicData.getTotalGNComArea());
						row.createCell(14).setCellValue(basicData.getPoorQualityG());
						row.createCell(15).setCellValue(basicData.getTotalNComArea());
						row.createCell(16).setCellValue(basicData.getTotalNNComArea());
						row.createCell(17).setCellValue(basicData.getPoorQualityN());
						row.createCell(18).setCellValue(basicData.getTotalNArea());
						row.createCell(19).setCellValue(basicData.getTotalRComArea());
						row.createCell(20).setCellValue(basicData.getTotalRNComArea());
						row.createCell(21).setCellValue(basicData.getPoorQualityR());
						row.createCell(22).setCellValue(basicData.getTotalRArea());
						
						rowindex++;
						count++;
					}
				}
				
			}
			file.close();
			FileOutputStream outfile  = new FileOutputStream(new File("basic_data.xlsx"));
			wb.write(outfile);
			outfile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

	public static void main(String[] args) throws IOException {
		CommonSheetDetails commonSheetDetails = new CommonSheetDetails();
		Header head = new Header("Uttar Pradesh" , "2016-2017" , "BLOCK" , "Basic Data" , "Admin","Agra");
		HashMap <String , String> locationNameMap = commonSheetDetails.getNameAssociation("Agra");
		HashMap <String , BasicData > basicDataMap= new HashMap();
		for(String location : locationNameMap.keySet()) {
			BasicData basicData1 = new BasicData();
			basicData1.setDistrict("Agra");
			basicData1.setState("Uttar Pradesh");
			basicData1.setYield(0.16);
			basicDataMap.put(locationNameMap.get(location), basicData1);
		}
		

        Sheet1 sh = new Sheet1();
        sh.createBasicDataSheet("Agra", head , basicDataMap);
        
	}
	

}
