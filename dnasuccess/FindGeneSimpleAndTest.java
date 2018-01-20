import edu.duke.*;

public class FindGeneSimpleAndTest {

       public String findGeneSimple(String dna){
           //start codon ATG stop codon TAA
           String result = "";
           //does the string have a ATG         
           int startIndex = dna.indexOf("ATG");
           if(startIndex==-1){return result;}
           int stopIndex = dna.indexOf("TAA", startIndex+3);
           if ((startIndex ==-1)||(stopIndex==-1))
             {//no ATG or TAA
               return "NOT DNA";
            }
            //System.out.println(startIndex);
            //System.out.println(stopIndex);
            //System.out.println((stopIndex - startIndex)%3 );
             if ((stopIndex - startIndex)%3 != 0){
             return "Not Divisible";
                }
            
           result = dna.substring(startIndex, stopIndex+3);          
           return result;
        }
        
       public void testFindGeneSimple(){
           String dna = "ATGCGGTAA";
           System.out.println("DNA strand is " + dna);
           String gene = findGeneSimple(dna);
           System.out.println("Gene is " + gene);
         
           dna = "ATGCTAGGGRTAA";
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna);
           System.out.println("Gene is " + gene);
           
           dna = "GATGGCCTAA";
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna);
           System.out.println("Gene is " + gene);
           
           dna = "GATGTSTTAT";
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna);
           System.out.println("Gene is " + gene);
         
           dna = "CATGTRTAAC";
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna);
           System.out.println("Gene is " + gene);
           
           
           //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
           
       }
        
}

    
