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

import aspect.AspectHelper;
import aspect.AspectWarehouse;
import planet.Planet;
import planet.PlanetTable;
import sign.Sign;
import sign.SignHelper;
import utils.Timer;

public class AngleFind {

	//private static final String fileName = "C:\\Users\\pc\\Desktop\\solarExcel\\test.xlsx";

	private static final String ECLIPTIC_START_KEY = "EclipticStart".toUpperCase();
	private static final String ECLIPTIC_END_KEY = "EclipticEnd".toUpperCase();
	private static final String RIGHT_ASCENSION_START_KEY = "RAStart".toUpperCase();
	private static final String RIGHT_ASCENSION_END_KEY = "RAEnd".toUpperCase();
	
	private static ArrayList<Unit> eclipticTable = new ArrayList<Unit>();
	private static ArrayList<Unit> rightAscensionTable = new ArrayList<Unit>();

	private static Timer timer = new Timer();

	private static final Double PARTIAL_ANGLE_UNIT = 60.0;
	private static final Long NANO_TO_MICRO_UNIT = 1000000L;
	
	public static void main(String[] args) {
		
		String fileName = args[0];
		File myFile = new File(fileName);
		
		try(FileInputStream fis = new FileInputStream(myFile);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);){
			
			// TODO: for each sheet
			// Return first sheet from the XLSX workbook
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = mySheet.iterator();

			/* create ecliptic table */
			skipToRow(rowIterator, ECLIPTIC_START_KEY);
			createTable(rowIterator, eclipticTable, ECLIPTIC_END_KEY);
			
			/* create right ascension table */
			skipToRow(rowIterator, RIGHT_ASCENSION_START_KEY);
			createTable(rowIterator, rightAscensionTable, RIGHT_ASCENSION_END_KEY);
			
			// calculate diff for ecliptic table
			calculateInnerDiff(eclipticTable);
			// calculate diff for right ascension table
			calculateInnerDiff(rightAscensionTable);

			printAspectWarehouse();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void skipToRow(Iterator<Row> rowIterator, String key) {
		String firstCellContent = "";
		Row row = null;
		while(rowIterator.hasNext() && !firstCellContent.equals(key)) {
			row = rowIterator.next();
			try {
				firstCellContent = row.getCell(0).getRichStringCellValue().toString().trim().toUpperCase();
			} catch (NullPointerException e) {
				throw new RuntimeException("Error row = " + row.getCell(0));
			}
		}
	}
	
	static void createTable(Iterator<Row> rowIterator, ArrayList<Unit> table, String terminationKey) {
		timer.start();
		
		String planetName = "";
		while (rowIterator.hasNext()) {
			try {
				Row row = rowIterator.next();
				
				String firstCellContent = row.getCell(0).getRichStringCellValue().toString().trim().toUpperCase();
				if(firstCellContent.equals(terminationKey)) {
					break;
				}
				
				Cell planet = row.getCell(0);
				planetName = planet.getRichStringCellValue().toString().trim();
				
				// originalAngle - N
				Cell originalAngle = row.getCell(1);
				String[] parts = SignHelper.splitParts(originalAngle.toString().trim());
				Sign sign = SignHelper.getSign(parts[1].toUpperCase());
				double cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2])/PARTIAL_ANGLE_UNIT;
				
				Unit firstUnit = new Unit();
				Planet temp = PlanetTable.getPlanet(planetName);
				
				if(temp == null) {
					PlanetTable.getPlanets().put(planetName, new Planet(planetName));
				}
				
				firstUnit.setPlanet(PlanetTable.getPlanet(planetName));
				firstUnit.setPostFix("");
				firstUnit.setAngle(cellAngle);
				
				// F`
				Cell firstPrime = row.getCell(2);
				parts = SignHelper.splitParts(firstPrime.getRichStringCellValue().toString().trim());
				sign = SignHelper.getSign(parts[1].toUpperCase());
				cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2])/PARTIAL_ANGLE_UNIT;
				
				Unit secondUnit = new Unit();
				secondUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
				secondUnit.setPostFix("`");
				secondUnit.setAngle(cellAngle);
				
				// F``
				Cell secondPrime = row.getCell(3);
				parts = SignHelper.splitParts(secondPrime.getRichStringCellValue().toString().trim());
				sign = SignHelper.getSign(parts[1].toUpperCase());
				cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2])/PARTIAL_ANGLE_UNIT;
				
				Unit thirdUnit = new Unit();
				thirdUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
				thirdUnit.setPostFix("``");
				thirdUnit.setAngle(cellAngle);
				
				// F```
				Cell thirdPrime = row.getCell(4);
				parts = SignHelper.splitParts(thirdPrime.getRichStringCellValue().toString().trim());
				sign = SignHelper.getSign(parts[1].toUpperCase());
				cellAngle = sign.getAngle() + Double.parseDouble(parts[0]) + Double.parseDouble(parts[2])/PARTIAL_ANGLE_UNIT;
				
				Unit fourthUnit = new Unit();
				fourthUnit.setPlanet(PlanetTable.getPlanet(planetName)); 
				fourthUnit.setPostFix("```");
				fourthUnit.setAngle(cellAngle);
				
				// paralle angle
				// TODO:
				
				// connect units
				firstUnit.setNext(secondUnit);
				secondUnit.setNext(thirdUnit);
				thirdUnit.setNext(fourthUnit);
				
				// construct table
				table.add(firstUnit);
				
				Unit currentUnit = firstUnit;
				while(currentUnit != null) {
					System.out.print(String.format("%s:%.3f  ", currentUnit.getSymbol(), currentUnit.getAngle()));
					currentUnit = currentUnit.getNext();
				}
				System.out.println("");
				
			} catch (Exception e) {
				System.out.println("skipped:" + planetName + "due to error");
				e.printStackTrace();
				continue;
			}
		}
		
		timer.stop();
		System.out.println(String.format("Ecliptic Table Creation Took %d ms" , timer.getElapsedTime()/NANO_TO_MICRO_UNIT));
	}

	static void calculateInnerDiff(ArrayList<Unit> table) {
		timer.start();
		
		for(Unit unit : table) {
			Unit firstUnit = unit;
			while(firstUnit != null) {
				for(Unit secondUnit : table) {
					if(firstUnit.getPlanet().equals(secondUnit.getPlanet())) {
						continue;
					}
					
					Unit current = secondUnit;
					while(current != null) {
						double diffToAngle = Math.abs(firstUnit.getAngle() - current.getAngle());
						
						for(AspectHelper.AspectType aspectType : AspectHelper.AspectType.values()) {
							double diffToAspect = diffToAngle - aspectType.getAngle();
							
							if(Math.abs(diffToAspect) <= 1) {
								String planet = firstUnit.getPlanet().getName();
								String aspect = aspectType.name();
								Angle angle = new Angle(Math.abs(diffToAspect), firstUnit.getSymbol(), current.getSymbol());
								AspectWarehouse.add(planet, aspect, angle);
							}
						}
						
						current = current.getNext();
					}
				}

				firstUnit = firstUnit.getNext();
			}
		}
		
		timer.stop();
		System.out.println(String.format("Calculation Took %d ms", timer.getElapsedTime()/NANO_TO_MICRO_UNIT));
	}

	private static void printAspectWarehouse() {
		timer.start();
		
		for(String planet : AspectWarehouse.getPlanetTypes()) {
			System.out.println(String.format("Planet: [%s]", planet));
			for(String aspect : AspectWarehouse.getAspectTypes(planet)) {
				System.out.println(String.format("\tAspect: [%s]", aspect));
				for(Angle angle : AspectWarehouse.getSortedAspectsByPlanetAndAspectName(planet, aspect)) {
					System.out.println(String.format("\t\tThe two planets : [%s & %s] have a angle: [%.3f]", angle.getFirstSymbol(), angle.getSecondSymbol(), angle.getDegree()));
				}
			}
		}
		
		timer.stop();
		System.out.println(String.format("Print Aspects Took %d ms", timer.getElapsedTime()/NANO_TO_MICRO_UNIT));
	}
}
