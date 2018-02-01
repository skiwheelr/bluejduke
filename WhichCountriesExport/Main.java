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
        System.out.println(countryInfo(parser, "Germany"));

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
   public String countryInfo(CSVParser parser, String country){
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
}


