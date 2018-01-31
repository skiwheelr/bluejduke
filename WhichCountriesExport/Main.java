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

    }
    
    /* public String countryInfo(CSVParser parser, String Country){
        String info = null;
        FileResource fr = new FileResource();
        parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String countryInfo = record.get("Country")+":"+ record.get("Exports")+":"+ record.get("Value (dollars)");
            System.out.println(countryInfo);
            

            
		}
	return info;
    
    } */
    
    
    
    
}


