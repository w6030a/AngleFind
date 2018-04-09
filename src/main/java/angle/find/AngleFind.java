package angle.find;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.Timer;

// TODO: many names are not symbol in planet table
// TODO: some planet has time in cell?
/* example
skipped:FT
skipped:V
skipped:K2
skipped:K3
skipped:LE 2017/8/7 MOON
skipped:LE SUN
skipped:SE 2017/8/21 MOON
skipped:SE SUN
 */
public class AngleFind {

	private static ArrayList<Unit> unitTable = new ArrayList<Unit>();
	private static final String fileName = "C:\\Users\\Peter\\Desktop\\fractal superfractal.xlsx";
	//private static final String fileName = "C:\\Users\\Peter\\Desktop\\活頁簿1.xlsx";

	public static void main(String[] args) {
		// create table
		Timer timer = new Timer();
		timer.start();
		
		try {
			File myFile = new File(fileName);
			FileInputStream fis = new FileInputStream(myFile);
			
			// Finds the workbook instance for XLSX file
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			// Return first sheet from the XLSX workbook
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = mySheet.iterator();

			// Skip title row
			Row titleRow = rowIterator.next();
			String planetName = "";
			// Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				try {
					Row row = rowIterator.next();
					
					// For each row, iterate through each columns
					Cell planet = row.getCell(0);
					planetName = planet.toString().trim();
					
					// originalAngle
					Cell originalAngle = row.getCell(1);
					String[] parts = SignHelper.splitParts(originalAngle.getRichStringCellValue().toString().trim());
					Sign sign = SignHelper.getSign(parts[1].toUpperCase());
					double cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2]);
					
					Unit leadingUnit = new Unit();
					Planet temp = PlanetTable.getPlanet(planetName);
					leadingUnit.setPlanet(PlanetTable.getPlanet(planetName));
					
					if(temp == null) {
						continue;
					}
					
					leadingUnit.setPostFix("");
					leadingUnit.setAngle(cellAngle);
					
					// F`
					Cell firstPrime = row.getCell(1);
					parts = SignHelper.splitParts(firstPrime.getRichStringCellValue().toString().trim());
					sign = SignHelper.getSign(parts[1].toUpperCase());
					cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2]);
					
					Unit firstUnit = new Unit();
					firstUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
					firstUnit.setPostFix("`");
					firstUnit.setAngle(cellAngle);
					
					// F``
					Cell secondPrime = row.getCell(2);
					parts = SignHelper.splitParts(secondPrime.getRichStringCellValue().toString().trim());
					sign = SignHelper.getSign(parts[1].toUpperCase());
					cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2]);
					
					Unit secondUnit = new Unit();
					secondUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
					secondUnit.setPostFix("``");
					secondUnit.setAngle(cellAngle);
					
					// F```
					Cell thirdPrime = row.getCell(3);
					parts = SignHelper.splitParts(thirdPrime.getRichStringCellValue().toString().trim());
					sign = SignHelper.getSign(parts[1].toUpperCase());
					cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2]);
					
					Unit thirdUnit = new Unit();
					thirdUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
					thirdUnit.setPostFix("```");
					thirdUnit.setAngle(cellAngle);
					
					// paralle angle
					// TODO:
					
					// connect units
					leadingUnit.setNext(firstUnit);
					firstUnit.setNext(secondUnit);
					secondUnit.setNext(thirdUnit);
					
					// construct table
					unitTable.add(leadingUnit);
					
					Unit currentUnit = leadingUnit;
					while(currentUnit != null) {
						System.out.print(String.format("%s:%2f  ", currentUnit.getSymbol(), currentUnit.getAngle()));
						currentUnit = currentUnit.getNext();
					}
					System.out.println("");
					
				} catch (Exception e) {
					System.out.println("skipped:" + planetName);
//					e.printStackTrace();					
					continue;
				}
			}
			
			timer.stop();
			System.out.println(String.format("Tabke Creation Took %d ms" , timer.getElapsedTime()/1000000L));
			
			// calculate diff against whole table
			timer.reset();
			timer.start();
			
			for(Unit unit : unitTable) {
				Unit currentUnit = unit;
				while(currentUnit != null) {
					//System.out.print(String.format("%s:%2f  ", currentUnit.getSymbol(), currentUnit.getAngle()));
					
					// TODO: compare to all other symbols
					for(Unit innerUnit : unitTable) {
						if(currentUnit.getPlanet().equals(innerUnit.getPlanet())) {
							continue;
						}
						
						Unit innerCurrentUnit = innerUnit;
						while(innerCurrentUnit != null) {
							double diff = Math.abs(currentUnit.getAngle() - innerCurrentUnit.getAngle());
							
							if(diff <= 1) {
								System.out.println(String.format("The two angles have a diff less than 1: %s & %s", currentUnit.getSymbol(), innerUnit.getSymbol()));
								System.out.println(String.format("Which are: %f & %f", currentUnit.getAngle(), innerUnit.getAngle()));
							}
							
							innerCurrentUnit = innerCurrentUnit.getNext();
						}
					}

					// TODO: calculate time elapsed
					currentUnit = currentUnit.getNext();
				}
			}

			timer.stop();
			System.out.println(String.format("Calculattion Took %d ms", timer.getElapsedTime()/1000000L));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

}
