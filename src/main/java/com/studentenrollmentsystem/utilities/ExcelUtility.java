
package com.studentenrollmentsystem.utilities;

//import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook excelWBook; // Excel WorkBook 
	private static XSSFSheet excelWSheet; // Excel Sheet // This method has two parameters:
	public static ArrayList<Object> getRowData(String sheetName) {

		try

		{

			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources" + "/TestData.xlsx"); // creating a new file
																								// instance obtaining
																								// bytes from the file

			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook excelWBook = new XSSFWorkbook(fis);
			XSSFSheet excelWSheet = excelWBook.getSheet(sheetName); // creating a Sheet object to retrieve object

			ArrayList<Object> list = new ArrayList<Object>();
			Iterator<Row> itr = excelWSheet.iterator(); // iterating over excel file
			itr.next();// To avoid First row;
			while (itr.hasNext())
			// if(itr.hasNext())

			{
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case STRING: // field that represents string cell type

						String value = cell.getStringCellValue();
						list.add(value);
						// System.out.print(cell.getStringCellValue() + "\t\t\t");

						break;
					case NUMERIC: // field that represents number cell type
						// System.out.print(cell.getNumericCellValue() + "\t\t\t");
						double d = cell.getNumericCellValue();
						double data = cell.getNumericCellValue();
						int value1 = (int) data;
						list.add(value1);
						break;
					default:

					}

				}
				// System.out.println(ar);
				// break;
				return list;
				// break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
	public static ArrayList<Object> getExcelData(String sheetName, int colNo) throws IOException {

		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources" + "/TestData.xlsx");
		
		excelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet excelWSheet= excelWBook.getSheet(sheetName); 
		
	    Iterator <Row> rowIterator = excelWSheet.iterator();
	    
	    rowIterator.next();//To avoid First row;
	    
	    ArrayList <Object> list= new ArrayList<Object>();
	    
	    while(rowIterator.hasNext())
	    {
	    	
	    	Cell cell = rowIterator.next().getCell(colNo);
//	    	if(!cell.equals(null)) {
		    	switch (cell.getCellType())               
		    	{  
		    	
		    	case STRING:    //field that represents string cell type  
		    	  
		    	list.add(cell.getStringCellValue());
		    	break;  
		    	
		    	case NUMERIC:    //field that represents number cell type  
	
		        double data = cell.getNumericCellValue();
		    	int value = (int)data;
		    	list.add(value);
		        
		    	break;  
		    	default:  
		    		
		    	}  
//	    	}
	    }
	    
	    return list;
	}




}
