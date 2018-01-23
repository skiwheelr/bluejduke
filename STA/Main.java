 import edu.duke.*;
 import java.lang.*;
 
public class Main {
//FileResource fr = new FileResource("brca1line.fa");  
    public void Main(){
     
     
        String dna = "ATGCTGCTGATGTAA";
        Main one = new Main();
        processGenes(testProcessGenes(fr));
        
        //System.out.println(processGenes(testProcessGenes(fr)));
        
        
        //System.out.println(processGenes());
        //System.out.println(cgRatio(dna));
        //System.out.println(countCTG(dna));
        //System.out.println(HOW RIGHT HERE?);
        //testProcessGenes() takes the fileresource and converts it into a 
        //storageresource.
        //processgenes takes a SR and processes it. 
        //How would i call the two in main?
                 
        
        
    }
 FileResource fr = new FileResource("brca1line.fa");   
     public int cgRatio(String dna){
   //   int cCounter = 0;
   //   int gCounter = 0;  
    //  while (true){
     //   String currentGene = findGene(dna, cCounter);
      //  if (currentGe
      //  }
       //dna = "AAATTTGGGCCC";
    //int cg = ((StringUtils.countMatches(dna, "c") + StringUtils.countMatches(dna, "g"))/dna.length());
   
   String dnamc =  dna.replace("C", "");
   String dnamg = dna.replace("G", "");
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



public StorageResource testProcessGenes(FileResource fr){   
    StorageResource sr = new StorageResource();
    for (String temp : fr.lines()){
    System.out.println(temp);
    String tempUp = temp.toUpperCase();
    if(findGene(tempUp,0) != ""){
    String temper = findGene(tempUp,0);  
    sr.add(temper + " ");
        }
}
    return sr;
}

public int processGenes(StorageResource sr){
int overnine = 0;
int over35 = 0;
int maxLength = 0;
String longestLine = null;
//String sft = fr.asString();
for (String line : sr.data()) {
    if(line.length() > 60){
        overnine++;        
        //System.out.println("This many over 9 in length " + line);}        
    if(cgRatio(line) > .35){
        //System.out.println("This many over 35%" + line);
        over35++;
        }
    if (line.length() > maxLength) {
              maxLength = line.length();
              longestLine = line;
            }
            System.out.println("Longest Gene is " + longestLine);    
            System.out.println("No. Genes over nine " + overnine);
            System.out.println("Percent over 35 " + over35);
        }
   return 0;
    
}


//Everything below from class: allGenesStored:


    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
            int currIndex = dna.indexOf(stopCodon,startIndex +3);
                while (currIndex != -1) { 
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            }else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
                //recursive method
            }
        
    //if((stopCodon.indexOf() - startIndex)%3==0){
    //    return stopCodon.indexOf("TAA");}
    //else{
    //    return dna.length();      
        //returns index of first occurance of stopcodon that appears past 
    //startIndex and is a multiple of three.
    //If there is no such stopcodon, it returns the length of the dna strand.
}
        return dna.length();
    }

    public void testFindStopCodon(){
        String dna = "ATGCCTCGCTAA";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex != 9) System.out.println("error on 9");
        System.out.println("Testing Finished");
        
        //System.out.println("The codon is "+  findStopCodon.stopCodon);     
        //  if((findStopCodon(stopCodon)-findStopCodon(startIndex))%3 == 0){
        //  return dna.substring(startIndex, stopCodon-3);
       // } currIndex = dna.indexOf("TAA", stopCodon+1);
       // System.out.println("no");}
        //return "";
        
    }
    
    public String findGene(String dna, int where){
       int startCodon = dna.indexOf("ATG",where);
       if (startCodon == -1) {
           return "";
        }
        int stopCodonTAA = findStopCodon(dna,startCodon,"TAA");
        int stopCodonTAG = findStopCodon(dna,startCodon,"TAG");
        int stopCodonTGA = findStopCodon(dna,startCodon,"TGA");
        int minIndex = Math.min(stopCodonTAA,stopCodonTAG);
            minIndex = Math.min(minIndex,stopCodonTGA);
            
         //   System.out.println(stopCodonTAA+" "+stopCodonTAG+" "+stopCodonTGA);
        if(minIndex == dna.length()){
           return "";}
           
           return dna.substring(startCodon,minIndex+3);
           
       // int startCodon = dna.indexOf("ATG");      
       // if (stopCodon > stopCodonTAG){stopCodon = stopCodonTAG;}
       // if (stopCodon > stopCodonTGA){stopCodon = stopCodonTGA;}
       // System.out.println("Your Gene is" + dna.substring(startCodon,stopCodon));
       // return dna.substring(startCodon,stopCodon);
       //if(dna.indexOf("ATG") != -1 && dna.indexOf("TAA") != -1 && dna.indexOf("TAG") != -1 && dna.indexOf("TGA") != -1) {
       //} else
       //return "";}
    }
    
        
   public void testFindGene(){
        
    
        
    String Dino1 = "xxxyyyzzzTAA";
    System.out.println("Sequence is " + Dino1);
    System.out.println(findGene(Dino1,0));
        
    String Dino2 = "ATGxxxyyyzzzTAA";
    System.out.println("Sequence is " + Dino2);
    System.out.println(findGene(Dino2,0));
    
    String Dino3 = "xxxATGyyyzzzTAG";
    System.out.println("Sequence is " + Dino3);
    System.out.println(findGene(Dino3,0));
    
    String Dino4 = "xxxATGyyyzzz";
    System.out.println("Sequence is " + Dino4);
    System.out.println(findGene(Dino4,0));
    
    String Dino5 = "ATGxxxTAAyyyTGA";
    System.out.println("Sequence is " + Dino5);
    System.out.println(findGene(Dino5,0));
    
    
    }
    
    public StorageResource printAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        
    //String given = "llATGxxxxxxTAAyyyyyyATGzzzzzzTAGbb";
    int startIndex = 0;
    int counter = 0;
    //System.out.println(given.findGene());
    //find next gene after startIndex and print, if no gene found, leave loop.
    //then set startindex to just pass the end of the gene.
    //given = 
    while (true){
        String currentGene = findGene(dna, startIndex);
        
        if (currentGene.isEmpty()){
        break;
        }
        geneList.add(currentGene);
        
        //ADD A WAY TO COUNT THE NUMBER OF REPEATS FOR PART 3!!
        System.out.println(currentGene);
        counter++;
        startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    } 
    System.out.println(counter);
    return geneList;
  }  
 
  public void testOn(String dna){
      System.out.println("Testing printAllGenes on " + dna);
      //printAllGenes(dna);
      StorageResource genes = printAllGenes(dna);
      for (String g: genes.data()){
          System.out.println(g);
        }
        
        
      
    }
    
  public void test() {
    testOn("ATGATCTAATTTATGCTGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    
    }
    
    
    
    
}

