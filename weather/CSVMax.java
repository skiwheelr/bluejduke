import edu.duke.*;
import java.lang.*;
import org.apache.commons.csv.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class CSVMax {
 
      public CSVRecord hottestHourInFile(CSVParser parser) {
    //start with largestSoFar = null
    CSVRecord largestSoFar = null;
    
    for (CSVRecord currentRow : parser) {
        largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        
    } 
    return largestSoFar;
  }
  
  public void testHottestDay() {
      FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
      CSVRecord largest = hottestHourInFile(fr.getCSVParser());
      System.out.println("hottest temperature was " + largest.get("TemperatureF") +
      " at " + largest.get("TimeEST"));
      
    }
    
   public CSVRecord hottestInManyDays() {
   CSVRecord largestSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
           largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
          /* if (largestSoFar == null) {
               largestSoFar = currentRow;  
        } 
        else
        {
       double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
       double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
         
            if (currentTemp > largestTemp) {
            largestSoFar = currentRow;
            
        }
       }
    }*/
    }

    
       return largestSoFar;
  
 }

  public CSVRecord getLargestOfTwo(CSVRecord currentRow,CSVRecord largestSoFar){
 if (largestSoFar == null) {
               largestSoFar = currentRow;  
        } 
        else
        {
       double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
       double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
         
            if (currentTemp > largestTemp) {
            largestSoFar = currentRow;
            
        }
       }
       return largestSoFar;
  }

 public void testHottestInManyDays(){
    CSVRecord largest = hottestInManyDays();
    System.out.println("hottest temp was " + largest.get("TemperatureF") + "at" +
    largest.get("DateUTC"));
 }

}


