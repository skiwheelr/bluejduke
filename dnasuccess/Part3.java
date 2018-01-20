
public class Part3 {

    public boolean twoOccurances(String stringa, String stringb){
    return (stringa.substring(stringa.indexOf(stringb)+(stringb.length()-1)).indexOf(stringb))!=-1;
    }
    
    public String lastPart(String stringa,String stringb){
        if(stringa.indexOf(stringb)==-1)
        return stringa;
        else{
            
            return stringa.substring(stringa.indexOf(stringb)+stringb.length()-1);
           
        }
    
    }

    
    public void testing(){ 
    String stringa = "One Two Three Three Two  ";
    String stringb = "Three";
    if(twoOccurances(stringa, stringb)){
    System.out.println("There are multiple!");}else{System.out.println("no");}
    
    stringa = "Once Upon A Time";
    stringb = "Three";
    if(twoOccurances(stringa, stringb)){
    System.out.println("There are multiple!");}else{System.out.println("no");}
    
    stringa = "Hello World Three Three Three";
    stringb = "Three";
    if(twoOccurances(stringa, stringb)){
    System.out.println("There are multiple!");}else{System.out.println("no");}
    
    stringa = "What If I Told You A Story About A Duck That Was A Stupid Duck?";
    stringb = "o";
    if(twoOccurances(stringa, stringb)){
    System.out.println("There are multiple!");}else{System.out.println("no");}
    
    stringa = "banana";
    stringb = "ana";
    System.out.println(lastPart(stringa,stringb));
    }
}
