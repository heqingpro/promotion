package cn.ipanel.apps.interactive.window.util;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yezm
 * createTime 2016-4-17 下午08:53:40
 */
public class ExcelUtil {
	
	private Workbook wb;
	
	public ExcelUtil(MultipartFile file) throws Exception {
	    InputStream stream = null;
	    try {
	        String suffix = file.getOriginalFilename().substring(Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf(".") + 1);
	        stream = file.getInputStream();
	        if ("xls".equals(suffix)) {
	            this.wb = new HSSFWorkbook(stream);
	        } else if ("xlsx".equals(suffix)) {
	            this.wb = new XSSFWorkbook(stream);
	        } else {
	            throw new Exception("上传的excel格式不正确");
	        }
        } finally {
            if (null != stream) {
                stream.close();
            }
        }
	}
	
	/**
	 * 获取所有行
	 * @author yezm
	 * createTIme 2016-4-17 下午09:06:42
	 * @param sheetIndex sheetIndex
	 * @return row
	 */
	public List<Row> getRows(int sheetIndex){
		Sheet sheet = wb.getSheetAt(sheetIndex);
		List<Row> rows = new ArrayList<Row>();
		for(Row row : sheet){
			rows.add(row);
		}
		return rows;
	}
	
	/**
	 * 获取所有列
	 * @author yezm
	 * createTIme 2016-4-17 下午09:06:51
	 * @param sheetIndex sheetIndex
	 * @return cell
	 */
	public List<List<Cell>> getCells(int sheetIndex){
		Sheet sheet = wb.getSheetAt(sheetIndex);
		List<List<Cell>> rows = new ArrayList<List<Cell>>();
		int cellLength = sheet.getRow(0).getLastCellNum();
		for(Row row : sheet){
			List<Cell> cellLs = new ArrayList<Cell>();
			for(int cellIndex = 0;cellIndex<cellLength;cellIndex ++){
				Cell cell = row.getCell(cellIndex);
				if(cell != null){
					cellLs.add(cell);
				}else{
					cellLs.add(null);
				}
			}
			rows.add(cellLs);
		}
		return rows;
	}
	
	/**
	 * 获取所有数据
	 * @author yezm
	 * createTIme 2016-4-17 下午09:08:52
	 * @param sheetIndex sheetIndex
	 * @return string
	 */
    public List<List<String>> getData(int sheetIndex){
		Sheet sheet = wb.getSheetAt(sheetIndex);
		List<List<String>> rows = new ArrayList<List<String>>();
		int cellLength = sheet.getRow(0).getLastCellNum();
		for(Row row : sheet){
			List<String> cellLs = new ArrayList<String>();
			for(int cellIndex = 0;cellIndex<cellLength;cellIndex ++){
				Cell cell = row.getCell(cellIndex);
				if(cell != null){
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_STRING:
						cellLs.add(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
					    DecimalFormat df = new DecimalFormat("0");  
						cellLs.add(df.format(cell.getNumericCellValue()));
						break;
					default :
						cellLs.add(null);
						break;
					}
				}else{
					cellLs.add(null);
				}
			}
			rows.add(cellLs);
		}
		return rows;
	}
}
