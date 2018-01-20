 import edu.duke.*;
 import java.lang.*;
 
public class Main {
//FileResource fr = new FileResource("brca1line.fa");  
    public void Main(){
     
     
        String dna = "ATGCTGCTGATGTAA";
        Main one = new Main();
        
        //System.out.println(cgRatio(dna));
        //System.out.println(countCTG(dna));
        //System.out.println(HOW RIGHT HERE?);
        //testProcessGenes() takes the fileresource and converts it into a 
        //storageresource.
        //processgenes takes a SR and processes it. 
        //How would i call the two in main?
                 
        
        
    }
    
     public int cgRatio(String dna){
   //   int cCounter = 0;
   //   int gCounter = 0;  
    //  while (true){
     //   String currentGene = findGene(dna, cCounter);
      //  if (currentGe
      //  }
       //dna = "AAATTTGGGCCC";
    //int cg = ((StringUtils.countMatches(dna, "c") + StringUtils.countMatches(dna, "g"))/dna.length());
   
   String dnamc =  dna.replace("c", "");
   String dnamg = dna.replace("g", "");
   int countC = dna.length() - dnamc.length();
   int countG = dna.length() - dnamg.length();
   
   float cgRatio1 = countC + countG; 
   float length = dna.length();
   float cgRatio2 = cgRatio1 / length;
   
   System.out.println("Ratio is " + cgRatio2);
   return 0;

}

public float countCTG(String dna){
 dna = "ATGGTTTCTGATGCTGRTT";
    String dnamcod = dna.replace("CTG","");
 float remain = dna.length() - dnamcod.length();
 float number = (remain/3);
 System.out.println(number);
 return number;
 
}

FileResource fr = new FileResource("brca1line.fa");

public StorageResource testProcessGenes(FileResource fr){   
    StorageResource sr = new StorageResource();
    for (String temp : fr.lines()){
    //System.out.println(temp);
    sr.add(temp);
    }
    return sr;
}

public void processGenes(StorageResource sr){
int overnine = 0;
int over35 = 0;
int maxLength = 0;
String longestLine = null;
//String sft = fr.asString();
for (String line : sr.data()) {
    if(line.length() > 60){
        overnine++;        
        System.out.println(line);}        
    if(cgRatio(line) > .35){
        System.out.println(line);
        over35++;
        }
    if (line.length() > maxLength) {
              maxLength = line.length();
              longestLine = line;
            }
            System.out.println(longestLine);    
            System.out.println(overnine);
            System.out.println(over35);
        }
  // return overnine;
    
}

    
    
    
}

