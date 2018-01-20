import edu.duke.*;

public class Part2 {
public String findGeneSimple(String dna, int startCodon, int stopCodon){
           //start codon ATG stop codon TAA
           String result = "";
           //does the string have a ATG 
           dna = dna.toUpperCase();
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
           int startCodon = dna.indexOf("ATG");
           int stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           System.out.println(startCodon);
           System.out.println(stopCodon+3);
           String gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
         
           dna = "ATGCTAGGGRTAA";
           startCodon = dna.indexOf("ATG");
           stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
           
           dna = "GATGGCCTAA";
           startCodon = dna.indexOf("ATG");
           stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
           
           dna = "GATGTSTTAT";
           startCodon = dna.indexOf("ATG");
           stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
         
           dna = "CATGTRTAAC";
           startCodon = dna.indexOf("ATG");
           stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
           
           dna = "atgbfftaa";
           startCodon = dna.indexOf("ATG");
           stopCodon = dna.indexOf("TAA");
           System.out.println("DNA strand is " + dna);
           gene = findGeneSimple(dna,startCodon,stopCodon);
           System.out.println("Gene is " + gene);
           
           //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
           
       }
   
      }
