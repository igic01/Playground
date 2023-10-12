import java.util.Arrays;
import java.util.List;

public class RegX {
    static int countSmileys(List<String> arr) {
      int counter = 0;
      for(String smile : arr){
        if(smile.matches("[:;](?:[-~])?[D\\)]")){
          counter++;
        }
      }
      return counter;
  }
    public static void main(String[] args) {
        String[] arr = {":)", ";(", ";}", ":-D"};
        List<String> list = Arrays.asList(arr);
        System.out.println(countSmileys(list)); 
    }
}
