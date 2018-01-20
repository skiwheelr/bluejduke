import edu.duke.*;



public class Part1{
   
    
    
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
    
    public void printAllGenes(String dna){
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
        //ADD A WAY TO COUNT THE NUMBER OF REPEATS FOR PART 3!!
        System.out.println(currentGene);
        counter++;
        startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        
    } 
    System.out.println(counter);
    
  }  
  
  public void testOn(String dna){
      System.out.println("Testing printAllGenes on " + dna);
      printAllGenes(dna);
    }
    
  public void test() {
    testOn("ATGATCTAATTTATGCTGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    
    }
    
  
}

