

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args){
    Main lister = new Main();
    //lister.whoExportsCoffee();
    System.out.println("Mainrunning");
    //System.out.println(countryInfo());
    
    
    
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Germany"));
        //listExportersTwoProducts(parser,"gold","diamonds");
        //System.out.println(numberOfExporters(parser,"gold"));
        bigExporters(parser,"150000");
        
    }
    
    /* public String countryInfo(CSVParser parser, String dataLine){
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        for (CSVRecord ghost : parser) {
            dataLine = ghost.get("Country") + ":" + ghost.get("Exports") + ":" + ghost.get("Value(dollars)");
            System.out.println(dataLine);
        }
    return dataLine;
    } 
    */
   private String countryInfo(CSVParser parser, String country){
        try{
            for(CSVRecord record: parser.getRecords()){
                if(record.get("Country").equals(country)){
                    String info = "";
                    info += record.get(0) + ": " + record.get(1) + ": " + record.get(2);
                    return info;
                }
            }
        } catch (IOException e){}
        
        return "NOT FOUND";
    }

   private void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
       try{
           for(CSVRecord record : parser.getRecords()){
               String Exports = record.get("Exports");
               if(Exports.indexOf(exportItem1) != -1 && Exports.indexOf(exportItem2) != -1){
                   System.out.println(record.get("Country"));
                }
            
            }   
       } catch (IOException e) {}
       
        }
   private int numberOfExporters(CSVParser parser, String exportItem){
    int noCo = 0;
    try{
           for(CSVRecord record : parser.getRecords()){
               String items = record.get("Exports");
               if(items.indexOf(exportItem) != -1){
                   noCo += 1;
               
                }
            
            }

       } catch (IOException e) {}
        return noCo;  
        }
       
   public void bigExporters(CSVParser parser, String amount){
      try{
        for(CSVRecord record : parser.getRecords()){
            String strumber = (record.get("Value (dollars)")).replace(",","");
            String strumbero = strumber.replace("$","");
            int numerical = Integer.parseInt(strumbero);
                if(Integer.parseInt(amount) < numerical) {
                    System.out.println(record.get("Country") + ":" + record.get("Value (dollars)"));
                    
                }
            
        }
    
      } catch (IOException e) {}
   }
}

    
    

   
   
   
   
   
   
   
        

