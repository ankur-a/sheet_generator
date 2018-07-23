package sheet_generator;


import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook; //New imports to read XLSX format
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet; //New imports to read XLSX format
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class Sheet1  {
	BasicData basicData = new BasicData();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void writeHeader(Header head) {
		try {
			FileInputStream file = new FileInputStream(new File("/home/ankur/Documents/sheet/sheet_generator/format/basic_data.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
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
			file.close();
			FileOutputStream outfile  = new FileOutputStream(new File("basic_data.xlsx"));
			wb.write(outfile);
			outfile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createBasicDataSheet(String district , Header head , HashMap <String , BasicData > basicDataMap ) {
		writeHeader(head);
		basicData.scrapRockType(basicDataMap);
		basicData.scrapinfFactor(basicDataMap);
		
		
		
	}
	
	

	public static void main(String[] args) throws IOException {
		CommonSheetDetails commonSheetDetails = new CommonSheetDetails();
		Header head = new Header("Uttar Pradesh" , "2016-2017" , "BLOCK" , "Basic Data" , "Admin","Agra");
		commonSheetDetails.genLocassociation();
		HashMap <String , String> locationNameMap = commonSheetDetails.getNameAssociation("Agra");
		HashMap <String , BasicData > basicDataMap= new HashMap();
		for(String location : locationNameMap.keySet()) {
			BasicData basicData1 = new BasicData();
			basicData1.setDistrict("Agra");
			basicData1.setState("Uttar Pradesh");
			basicData1.setYield(0.16);
			basicDataMap.put(locationNameMap.get(location), basicData1);
		}
		
		
		
		
		
//		FileInputStream fsIP= new FileInputStream(new File("1.xlsx")); //Read the spreadsheet that needs to be updated
//		XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
//		XSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
//        XSSFFont font = wb.createFont();
//        font.setBold(true);
//        XSSFCellStyle style = wb.createCellStyle();
//        style.setFont(font);
//        Cell cell = null; // declare a Cell object
//        
//        cell = worksheet.getRow(0).getCell(1);   // Access the second cell in second row to update the value
//          
//        cell.setCellValue("OverRide Last Name");  // Get current cell value value and overwrite the value
//        cell.setCellStyle(style);
//        fsIP.close(); //Close the InputStream
//         
//        FileOutputStream output_file =new FileOutputStream(new File("1.xlsx"));  //Open FileOutputStream to write updates
//          
//        wb.write(output_file); //write changes
//          
//        output_file.close();  //close the stream  
        
        Sheet1 sh = new Sheet1();
        sh.createBasicDataSheet("Agra", head , basicDataMap);
        
	}
	

}
