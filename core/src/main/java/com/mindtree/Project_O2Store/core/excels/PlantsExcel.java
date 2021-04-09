package com.mindtree.Project_O2Store.core.excels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlantsExcel {
	
	public List<PlantPojo> returnDataToService(String path) throws FileNotFoundException 
	{
		XSSFWorkbook wb = null;
		String paths=""+path;
		FileInputStream readFile = new FileInputStream(paths);
		List<PlantPojo> ls=new ArrayList<PlantPojo>();
		try {
			wb = new XSSFWorkbook(readFile);
			XSSFSheet sh = wb.getSheetAt(0);
			int firstRow = sh.getFirstRowNum();
			int lastRow = sh.getLastRowNum();
			for (int i = firstRow + 1; i <= lastRow; i++) {
				XSSFRow r = sh.getRow(i);
				String pageName=r.getCell(0).getStringCellValue();
				String pagePath=r.getCell(1).getStringCellValue();
				String templatePath=r.getCell(2).getStringCellValue();
				String pageTitle=r.getCell(3).getStringCellValue();
				String category=r.getCell(4).getStringCellValue();
				String title=r.getCell(5).getStringCellValue();
				String description=r.getCell(6).getStringCellValue();
				String abt1=r.getCell(7).getStringCellValue();
				String abt2=r.getCell(8).getStringCellValue();
				String abt3=r.getCell(9).getStringCellValue();
				int price=(int) r.getCell(10).getNumericCellValue();
				String image=r.getCell(11).getStringCellValue();
				String offer1=r.getCell(12).getStringCellValue();
				String offer2=r.getCell(13).getStringCellValue();
				int originalPrice=(int)r.getCell(14).getNumericCellValue();
				int plantId=(int)r.getCell(15).getNumericCellValue();
				PlantPojo data=new PlantPojo(pageName,pagePath,templatePath,pageTitle,category,title,description,abt1,abt2,abt3,price,image,offer1,offer2,originalPrice,plantId);
				ls.add(data);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}
}
