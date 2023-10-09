import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {

    public static Map<String, String> morse_code = new HashMap<>();
    
    public static String decode(String morseCode) {
      
        String[] words = morseCode.split("   ");
        String sol = "";
      
        for(String word : words){
          String[] letters = word.split(" ");
          for(String letter : letters){
            String temp = morse_code.get(letter);
            if(temp != null) sol += morse_code.get(letter);
          }
          sol += " ";
        }
      
        return sol.trim();
    }


    public static void main(String[] args) {

        morse_code.put(".", "E");
        System.out.println(decode("A ."));
        
    }
}
