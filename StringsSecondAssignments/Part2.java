
public class Part2 extends Main{

    String stringa = "ab";
    String stringb = "abcamabmeab";
    
    
    public int howMany(String stringa, String stringb){
        
        
        if(stringa.indexOf(stringb)==-1)
        return 0;       
        
        return howMany(stringa.substring(stringa.indexOf(stringb)+stringb.length()),stringb)+1;
    }
}
