package ReadData.RD;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


public class App {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String args[]) {

		String action = "";
		String value = "";
		String attribute = "";
		String attrval = "";

		try {
			// Open the Excel file for reading
			FileInputStream fis = new FileInputStream(new File("/home/admin-pc/Downloads/TestData (1).xlsx"));
			// Open it for writing too
//			FileOutputStream fos = new FileOutputStream("/home/admin-pc/Downloads/TestData (1).xls");
			// Access the required test data sheet
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheet("Sheet1");
			// Loop through all rows in the sheet
			// Start at row 1 as row 0 is our header row
			for (int count = 1; count <= sheet.getLastRowNum(); count++) {
				HSSFRow row = sheet.getRow(count);
				System.out.println("Running test step " + row.getCell(0).toString());

				// Run the test step for the current test data row
				if (!(row.getCell(1) == null || row.getCell(1).equals(CellType.BLANK))) {
					action = row.getCell(1).toString();
				} else {
					action = "";
				}

				if (!(row.getCell(2) == null || row.getCell(2).equals(CellType.BLANK))) {
					value = row.getCell(2).toString();
				} else {
					value = "";
				}

				if (!(row.getCell(3) == null || row.getCell(3).equals(CellType.BLANK))) {
					attribute = row.getCell(3).toString();
				} else {
					attribute = "";
				}

				if (!(row.getCell(4) == null || row.getCell(4).equals(CellType.BLANK))) {
					attrval = row.getCell(4).toString();
				} else {
					attrval = "";
				}

				System.out.println("Test action: " + action);
				System.out.println("Parameter value: " + value);
				System.out.println("Attribute: " + attribute);
				System.out.println("Attribute value: " + attrval);

				String result = runTestStep(action, value, attribute, attrval);

				// Write the result back to the Excel sheet
				row.createCell(5).setCellValue(result);

			}

			// Save the Excel sheet and close the file streams
//			wb.write(fos);
			fis.close();
//			fos.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static String runTestStep(String action, String value, String attribute, String attrval) {
		// TODO Auto-generated method stub
		return null;
	}
}