/* import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import edu.duke.*;
import org.apache.commons.csv.*;


public class CSVreader {

    public static void main(String[] args) {

        String csvFile = "./exportdata.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                //CSVParser.

                System.out.println([1] + Export + Value(dollars));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
*/
