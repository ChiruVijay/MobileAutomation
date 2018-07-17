package com.weeschool.Common_lib;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Calendar;
	import java.util.Hashtable;

	import org.apache.poi.hssf.usermodel.HSSFCellStyle;
	import org.apache.poi.hssf.usermodel.HSSFDateUtil;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.hssf.util.HSSFColor;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFCellStyle;
	import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
	import org.apache.poi.xssf.usermodel.XSSFFont;
	import org.apache.poi.xssf.usermodel.XSSFHyperlink;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class ExcelLib 
	{
		public  String path=null;
		public  FileInputStream fis = null;
		public  FileOutputStream fileOut =null;
		public Workbook workbook = null;
		public Sheet sheet = null;
		private Row row   =null;
		private XSSFCell cell = null;
		Hashtable <String, String> [] data = null;
		int rowIndex = 0, columnIndex = 0;
		

			
			public ExcelLib(String path)
			{
				//System.out.println("inside excel reader");
				this.path=path;  // parameter path is assigned as value of publicly declared path
				try {
					fis = new FileInputStream(path);
					if (path.indexOf("xlsx") < 0) {			
						workbook = new HSSFWorkbook(fis);
			
						sheet = workbook.getSheetAt(0);
						System.out.println("sheet name "+sheet.getSheetName());
						fis.close();
					}
					else
					{
						workbook = new XSSFWorkbook(fis);
//						
						sheet = workbook.getSheetAt(0);
						System.out.println("sheet name "+sheet.getSheetName());
						fis.close();
					}
						
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			
			}
		
			@SuppressWarnings("unchecked")
			public Object[][] getData() throws IOException  {	
				data = new Hashtable[sheet.getPhysicalNumberOfRows()];  
				
				System.out.println("sheet data is >> " +data);
				row = sheet.getRow(0);	
				
				for(rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
					data[rowIndex - 1] = new Hashtable <String, String>();
					
					for (columnIndex = 0; columnIndex < sheet.getRow(rowIndex).getPhysicalNumberOfCells(); columnIndex++) {
						data[rowIndex - 1].put(row.getCell(columnIndex).toString(), sheet.getRow(rowIndex).getCell(columnIndex).toString());
					}		
				}
				
				Object[][] obj = new Object[data.length - 1][1];		 
				for(int i = 0; i < data.length - 1; i++) {
					obj[i][0] = data[i];
				}
				return obj;		
			}
			
			
		
			// returns the row count in a sheet
			public int getRowCount(String sheetName){
				int index = workbook.getSheetIndex(sheetName);
				if(index==-1)
					return 0;
				else{
				sheet = workbook.getSheetAt(index);
				int number=sheet.getLastRowNum()+1;
				return number;
				}
				
			}
			
			// returns the data from a cell
			public String getCellData(String sheetName,String colName,int rowNum)
			{
				try{
					if(rowNum <=0)
						return "";
				
				int index = workbook.getSheetIndex(sheetName);
				int col_Num=-1;
				if(index==-1)
					return "";
				
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					
					if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num=i;
				}
				if(col_Num==-1)
					return "";
				
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum-1);
				if(row==null)
					return "";
				cell = (XSSFCell) row.getCell(col_Num);
				
				if(cell==null)
					return "";
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
					  return cell.getStringCellValue();
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
					  
					  String cellText  = String.valueOf(cell.getNumericCellValue());
					  if (HSSFDateUtil.isCellDateFormatted(cell)) {
				         
						  double d = cell.getNumericCellValue();

						  Calendar cal =Calendar.getInstance();
						  cal.setTime(HSSFDateUtil.getJavaDate(d));
				            cellText =
				             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
				                      cal.get(Calendar.MONTH)+1 + "/" + 
				                      cellText;
				           
				        

				         }

					  
					  
					  return cellText;
				  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				      return ""; 
				  else 
					  return String.valueOf(cell.getBooleanCellValue());
				
				}
				catch(Exception e){
					
					e.printStackTrace();
					return "row "+rowNum+" or column "+colName +" does not exist in xls";
				}
			}
			
			// returns the data from a cell
			
			@SuppressWarnings("deprecation")
			public String getCellData(String sheetName,int colNum,int rowNum){
				try{
					if(rowNum <=0)
						return "";
				
				int index = workbook.getSheetIndex(sheetName);
				

				if(index==-1)
					return "";
				
			
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum-1);
				if(row==null)
				
					
				return "";
				    
				cell = (XSSFCell)row.getCell(colNum);
				if(cell==null)
					return "";
				
				
			  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  
				  return cell.getStringCellValue();
			  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
				
				  String cellText  = String.valueOf(cell.getNumericCellValue());
				  if (HSSFDateUtil.isCellDateFormatted(cell)) {
			         
					  double d = cell.getNumericCellValue();

					  Calendar cal =Calendar.getInstance();
					  cal.setTime(HSSFDateUtil.getJavaDate(d));
			            cellText =
			             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
			           cellText = cal.get(Calendar.MONTH)+1 + "/" +
			                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
			                      cellText;
			

			         }

				  
				  
				  return cellText;
			  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			      return "";
			  else 
				  return String.valueOf(cell.getBooleanCellValue());
				}
				catch(Exception e){
					
					e.printStackTrace();
					return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
				}
			}
			
			// returns true if data is set successfully else false
			public boolean setCellData(String sheetName,String colName,int rowNum, String data){
				try{
				fis = new FileInputStream(path); 
				workbook = new XSSFWorkbook(fis);

				if(rowNum<=0)
					return false;
				
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
				
				
				sheet = workbook.getSheetAt(index);
				

				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;

				sheet.autoSizeColumn(colNum); 
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);
				
				cell = (XSSFCell) row.getCell(colNum);	
				if (cell == null)
			        cell = (XSSFCell) row.createCell(colNum);

			    cell.setCellValue(data);

			    fileOut = new FileOutputStream(path);

				workbook.write(fileOut);

			    fileOut.close();	

				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			
			// returns true if data is set successfully else false
			public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
				
				try{
				fis = new FileInputStream(path); 
				workbook = new XSSFWorkbook(fis);

				if(rowNum<=0)
					return false;
				
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
				
				
				sheet = workbook.getSheetAt(index);
			
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
				
					if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
						colNum=i;
				}
				
				if(colNum==-1)
					return false;
				sheet.autoSizeColumn(colNum); //ashish
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);
				
				cell = (XSSFCell) row.getCell(colNum);	
				if (cell == null)
			        cell = (XSSFCell) row.createCell(colNum);
					
			    cell.setCellValue(data);
			    XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();

			
			    CellStyle hlink_style = workbook.createCellStyle();
			    XSSFFont hlink_font = (XSSFFont) workbook.createFont();
			    hlink_font.setUnderline(XSSFFont.U_SINGLE);
			    hlink_font.setColor(IndexedColors.BLUE.getIndex());
			    hlink_style.setFont(hlink_font);
			

			    XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			    link.setAddress(url);
			    cell.setHyperlink(link);
			    cell.setCellStyle(hlink_style);
			      
			    fileOut = new FileOutputStream(path);
				workbook.write(fileOut);

			    fileOut.close();	

				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			
			
			// returns true if sheet is created successfully else false
			public boolean addSheet(String  sheetname){		
				
				FileOutputStream fileOut;
				try {
					 workbook.createSheet(sheetname);	
					 fileOut = new FileOutputStream(path);
					 workbook.write(fileOut);
				     fileOut.close();		    
				} catch (Exception e) {			
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			// returns true if sheet is removed successfully else false if sheet does not exist
			public boolean removeSheet(String sheetName){		
				int index = workbook.getSheetIndex(sheetName);
				if(index==-1)
					return false;
				
				FileOutputStream fileOut;
				try {
					workbook.removeSheetAt(index);
					fileOut = new FileOutputStream(path);
					workbook.write(fileOut);
				    fileOut.close();		    
				} catch (Exception e) {			
					e.printStackTrace();
					return false;
				}
				return true;
			}
			// returns true if column is created successfully
			public boolean addColumn(String sheetName,String colName){
			
				
				try{				
					fis = new FileInputStream(path); 
					workbook = new XSSFWorkbook(fis);
					int index = workbook.getSheetIndex(sheetName);
					if(index==-1)
						return false;
					
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				
				sheet=workbook.getSheetAt(index);
				
				row = sheet.getRow(0);
				if (row == null)
					row = sheet.createRow(0);
				
		
				if(row.getLastCellNum() == -1)
					cell = (XSSFCell) row.createCell(0);
				else
					cell = (XSSFCell) row.createCell(row.getLastCellNum());
			        
			        cell.setCellValue(colName);
			        cell.setCellStyle(style);
			        
			        fileOut = new FileOutputStream(path);
					workbook.write(fileOut);
				    fileOut.close();		    

				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
				
				return true;
				
				
			}
			// removes a column and all the contents
			public boolean removeColumn(String sheetName, int colNum) {
				try{
				if(!isSheetExist(sheetName))
					return false;
				fis = new FileInputStream(path); 
				workbook = new XSSFWorkbook(fis);
				sheet=workbook.getSheet(sheetName);
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				XSSFCreationHelper createHelper = (XSSFCreationHelper) workbook.getCreationHelper();
				style.setFillPattern(HSSFCellStyle.NO_FILL);
				
			    
			
				for(int i =0;i<getRowCount(sheetName);i++){
					row=sheet.getRow(i);	
					if(row!=null){
						cell=(XSSFCell) row.getCell(colNum);
						if(cell!=null){
							cell.setCellStyle(style);
							row.removeCell(cell);
						}
					}
				}
				fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
			    fileOut.close();
				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
				
			}
		  // find whether sheets exists	
			public boolean isSheetExist(String sheetName){
				int index = workbook.getSheetIndex(sheetName);
				if(index==-1){
					index=workbook.getSheetIndex(sheetName.toUpperCase());
						if(index==-1)
							return false;
						else
							return true;
				}
				else
					return true;
			}
			
			// returns number of columns in a sheet	
			public int getColumnCount(String sheetName){
				// check if sheet exists
				if(!isSheetExist(sheetName))
				 return -1;
				
				sheet = workbook.getSheet(sheetName);
				row = sheet.getRow(0);
				
				if(row==null)
					return -1;
				
				return row.getLastCellNum();
					
			}
			
	}



