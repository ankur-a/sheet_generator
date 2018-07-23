package sheet_generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonSheetDetails {
	
	HashMap< String ,  String> locassociation;
	
	
	public void genLocassociation() {
		try {
			locassociation = new HashMap<>();
			FileInputStream file = new FileInputStream(new File("Master mapping data UP.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet worksheet = wb.getSheetAt(0);
			
			for(Row mrow : worksheet) {
				Cell district = mrow.getCell(0);
				Cell blockName = mrow.getCell(1);
				Cell nblockName = mrow.getCell(2);
				HashMap <String , String> nameMap = new HashMap();
				nameMap.put(blockName.getStringCellValue(), nblockName.getStringCellValue());
				locassociation.put(district.getStringCellValue()+"#" + blockName.getStringCellValue(), nblockName.getStringCellValue());
				
				
			}
			
//			System.out.println(locassociation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap <String , String> getNameAssociation(String district){
		genLocassociation();
		HashMap< String, String> blockShapeMap = new HashMap<>();
//		List <String> districtBlockName = (List<String>) locassociation.keySet();
		
		for (String districtBlockName : locassociation.keySet()) {
			String [] speName = districtBlockName.split("#");
			
			if(speName[0].contains(district)) {
				blockShapeMap.put(speName[1], locassociation.get(districtBlockName));
			}
			
		}
		return blockShapeMap;
	}

}
