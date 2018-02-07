import edu.duke.*;
import java.lang.*;
import org.apache.commons.csv.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class CSVMin {
    public static void main(String [] args) {
   //CSVMax tryhard = new CSVMax();

   CSVMin alpha = new CSVMin();
   
}

  CSVMin(){
      DirectoryResource xyz = new DirectoryResource();
      
  }
  
      public CSVRecord coldestHourInFile(CSVParser parser) {
    //start with largestSoFar = null
    CSVRecord smallestSoFar = null;
    
    for (CSVRecord currentRow : parser) {
        smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        
    } 
    return smallestSoFar;
  }
  //nc_weather/2014/weather-2014-01-08.csv
  public void testColdestDay(String fileName) {
      FileResource fr = new FileResource(fileName);
      CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
      System.out.println("Coldest temperature was " + smallest.get("TemperatureF") +
      " at " + smallest.get("TimeEST"));
      
    }
    
   public CSVRecord coldestInManyDays() {
   CSVRecord smallestSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
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

    
       return smallestSoFar;
  
 }

  public CSVRecord getSmallestOfTwo(CSVRecord currentRow,CSVRecord smallestSoFar){
 if (smallestSoFar == null) {
               smallestSoFar = currentRow;  
        } 
        else
        {
       double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
       double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
         
            if (currentTemp < smallestTemp) {
            smallestSoFar = currentRow;
            
        }
       }
       return smallestSoFar;
  }


 public void testcoldestInManyDays(){
    CSVRecord smallest = coldestInManyDays();
    System.out.println("Coldest temp was " + smallest.get("TemperatureF") + "at" +
    smallest.get("DateUTC"));
 }
   /*
 public double avgTemp(CSVParser parser){
  CSVRecord avgSoFar = null;
  for (CSVRecord currentRow : parser) {
      
        if (avgSoFar == null) {
               avgSoFar = currentRow;  
        } 
        else
        {
       double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
       double avgNow = Double.parseDouble(avgSoFar.get("TemperatureF"));
       double newAvg = ((currentTemp + avgNow) / 1);
       }   
    }     
  //return newAvg; 
  return 0;
  
    }
    
 public void testAvgTemp(){
     //CSVRecord avg = avgTemp();
     FileResource fa = new FileResource("nc_weather/2014/weather-2014-01-08.csv");
     double avg = avgTemp(fa.getCSVParser());
     
     System.out.println("Avg was " + avg);
    }
  */
    public double averageTemperatureInFile(CSVParser parser){
        int count = 0;
        double sumtemp = 0;
       for (CSVRecord temper : parser){
        sumtemp += Double.parseDouble(temper.get("TemperatureF"));
        count ++;
        }
       return sumtemp / count;
    }
    
    public void testAverageTemperatureInFile(){
    //CSVRecord vgr = averageTemperatureInFile();
    FileResource fg = new FileResource("nc_weather/2014/weather-2014-01-08.csv");
    double avorg = averageTemperatureInFile(fg.getCSVParser());
    
    System.out.println("Avg Temp = " + avorg );
    }
    
}



