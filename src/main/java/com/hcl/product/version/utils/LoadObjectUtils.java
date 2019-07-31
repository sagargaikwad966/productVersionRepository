package com.hcl.product.version.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.product.version.entity.Product;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.repository.ProductRepository;

@Component
public class LoadObjectUtils 
{	
	public List<Product> mappingExcelToProduct()
	{
		final String FILE_NAME = "C:/Users/Administrator/Desktop/product.xlsx";
		List<Product> productList = new ArrayList<>();
		
		try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            @SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            Map<String, Integer> headaerMap = new HashMap<>();
            
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                
                Iterator<Cell> cellIterator = currentRow.iterator();
                
                Cell header = null;
                
                if(currentRow.getRowNum() == 0)
                {
                	while(cellIterator.hasNext())
                    {
                		header = cellIterator.next();
                    
                
                	if(header.getStringCellValue().equalsIgnoreCase("productId"))
                		headaerMap.put("productId", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("productNumber"))
                		headaerMap.put("productNumber", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("productName"))
                		headaerMap.put("productName", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("productDescription"))
                		headaerMap.put("productDescription", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("price"))
                		headaerMap.put("price", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("releaseDate"))
                		headaerMap.put("releaseDate", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("version"))
                		headaerMap.put("version", header.getColumnIndex());
                	
                	else if(header.getStringCellValue().equalsIgnoreCase("status"))
                		headaerMap.put("status", header.getColumnIndex());
                	
                	
                    }
                	System.out.println(headaerMap);
                }
                else
                {
                	ProductModel model = new ProductModel();
                	
                	Cell productNameCells = currentRow.getCell(headaerMap.get("productName"));
                	Cell productIdCells = currentRow.getCell(headaerMap.get("productId"));
                	Cell productNumberCells = currentRow.getCell(headaerMap.get("productNumber"));
                	Cell productDescriptionCells = currentRow.getCell(headaerMap.get("productDescription"));
                	Cell priceCells = currentRow.getCell(headaerMap.get("price"));
                	Cell releaseDateCells = currentRow.getCell(headaerMap.get("releaseDate"));
                	Cell versionCells = currentRow.getCell(headaerMap.get("version"));
                	Cell statusCells = currentRow.getCell(headaerMap.get("status"));
                	
                	if(productIdCells != null) 
                            model.setProductId(productIdCells.getStringCellValue());
                	if(productNameCells != null) 
                            model.setProductName(productNameCells.getStringCellValue());
					
					  if(priceCells != null)
					  model.setPrice(priceCells.getNumericCellValue());
					 
                	if(productNumberCells != null) 
                        model.setProductNumber(productNumberCells.getStringCellValue());
                	if(productDescriptionCells != null) 
                        model.setProductDescription(productDescriptionCells.getStringCellValue());
					
					/*
					 * if(releaseDateCells != null)
					 * model.setReleaseDate(releaseDateCells.getDateCellValue());
					 */
					 
                	if(versionCells != null) 
                        model.setVersion(versionCells.getStringCellValue());
                	if(statusCells != null) 
                        model.setStatus(statusCells.getStringCellValue());
                	
                	
                	Product product = new Product();
                	BeanUtils.copyProperties(model, product);
                	productList.add(product);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return productList;
	}

}
