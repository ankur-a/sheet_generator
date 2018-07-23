package sheet_generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.bind.ParseConversionEvent;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BasicData {
	

	static DataFormatter dataFormatter = new DataFormatter();
	static String getStringValue(Cell cell) {
	    return dataFormatter.formatCellValue(cell);
	}
	CommonSheetDetails commonSheetDetails = new CommonSheetDetails();
	HashMap <String , String> locationNameMap = commonSheetDetails.getNameAssociation("Agra");
	public String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getRockType() {
		return rockType;
	}
	public void setRockType(String rockType) {
		this.rockType = rockType;
	}
	public double getYield() {
		return yield;
	}
	public void setYield(double yield) {
		this.yield = yield;
	}
	public double getInfFactor() {
		return infFactor;
	}
	public void setInfFactor(double infFactor) {
		this.infFactor = infFactor;
	}
	public double getTotalGArea() {
		return totalGArea;
	}
	public void setTotalGArea(double totalGArea) {
		this.totalGArea = totalGArea;
	}
	public double getTotalGComArea() {
		return totalGComArea;
	}
	public void setTotalGComArea(double totalGComArea) {
		this.totalGComArea = totalGComArea;
	}
	public double getTotalGNComArea() {
		return totalGNComArea;
	}
	public void setTotalGNComArea(double totalGNComArea) {
		this.totalGNComArea = totalGNComArea;
	}
	public double getPoorQualityG() {
		return poorQualityG;
	}
	public void setPoorQualityG(double poorQualityG) {
		this.poorQualityG = poorQualityG;
	}
	public double getTotalNArea() {
		return totalNArea;
	}
	public void setTotalNArea(double totalNArea) {
		this.totalNArea = totalNArea;
	}
	public double getTotalNComArea() {
		return totalNComArea;
	}
	public void setTotalNComArea(double totalNComArea) {
		this.totalNComArea = totalNComArea;
	}
	public double getTotalNNComArea() {
		return totalNNComArea;
	}
	public void setTotalNNComArea(double totalNNComArea) {
		this.totalNNComArea = totalNNComArea;
	}
	public double getPoorQualityN() {
		return poorQualityN;
	}
	public void setPoorQualityN(double poorQualityN) {
		this.poorQualityN = poorQualityN;
	}
	public double getTotalRArea() {
		return totalRArea;
	}
	public void setTotalRArea(double totalRArea) {
		this.totalRArea = totalRArea;
	}
	public double getTotalRComArea() {
		return totalRComArea;
	}
	public void setTotalRComArea(double totalRComArea) {
		this.totalRComArea = totalRComArea;
	}
	public double getTotalRNComArea() {
		return totalRNComArea;
	}
	public void setTotalRNComArea(double totalRNComArea) {
		this.totalRNComArea = totalRNComArea;
	}
	public double getPoorQualityR() {
		return poorQualityR;
	}
	public void setPoorQualityR(double poorQualityR) {
		this.poorQualityR = poorQualityR;
	}
	public String District;
	public String rockType;
	public double yield;
	public double infFactor;
	public double totalGArea;
	public double totalGComArea;
	public double totalGNComArea;
	public double poorQualityG;
	public double totalNArea;
	public double totalNComArea;
	public double totalNNComArea;
	public double poorQualityN;
	public double totalRArea;
	public double totalRComArea;
	public double totalRNComArea;
	public double poorQualityR;
	
	
	public void scrapRockType(HashMap <String , BasicData > basicDataMap) {
		try {
			FileInputStream fsIP= new FileInputStream(new File("GWSR 31-03-2013 Agra-R.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fsIP);
			for(int i=0 ; i< wb.getNumberOfSheets();i++) {
				HSSFSheet sheet = wb.getSheetAt(i);
				String name = sheet.getSheetName();
				System.out.println(name + "\n");
				
				if(name.equals("Basic-SY,RFI")){
					
					int count =0;
					for(Row mrow : sheet) {
						if(count<8) {
							count++;
							continue;
						}
						System.out.println(mrow.toString());
						Cell blockName = mrow.getCell(1);
						Cell rockName = mrow.getCell(3);
						if(getStringValue(blockName).contains("TOTAL")) return;
						BasicData basicData = basicDataMap.get(locationNameMap.get(blockName.getStringCellValue()));
						basicData.setRockType(getStringValue(rockName));
//						else
//						basicData.setRockType("Alluvial Sandy Area");
						System.out.println(basicDataMap.get(locationNameMap.get(blockName.getStringCellValue())).getRockType() + locationNameMap.get(blockName.getStringCellValue())+ "\n");
					}
				}
			}
			
			fsIP.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void scrapinfFactor(HashMap <String , BasicData > basicDataMap) {
			try {
				FileInputStream fsIP= new FileInputStream(new File("GWSR 31-03-2013 Agra-R.xls"));
				HSSFWorkbook wb = new HSSFWorkbook(fsIP);
				for(int i=0 ; i< wb.getNumberOfSheets();i++) {
					HSSFSheet sheet = wb.getSheetAt(i);
					String name = sheet.getSheetName();
					System.out.println(name + "\n");
					
					if(name.equals("IIIC")){
						
						int count =0;
						for(Row mrow : sheet) {
							if(count<9) {
								count++;
								continue;
							}
							System.out.println(mrow.toString());
							Cell blockName = mrow.getCell(1);
							Cell infFactor = mrow.getCell(6);
							if(getStringValue(blockName).contains("TOTAL")) return;
							BasicData basicData = basicDataMap.get(locationNameMap.get(blockName.getStringCellValue()));
							basicData.setInfFactor(Double.parseDouble(getStringValue(infFactor)));
//							else
//							basicData.setRockType("Alluvial Sandy Area");
							System.out.println(basicDataMap.get(locationNameMap.get(blockName.getStringCellValue())).getRockType() + locationNameMap.get(blockName.getStringCellValue())+ "\n");
						}
					}
				}
				
				fsIP.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	

}
