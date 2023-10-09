import java.util.HashMap;
import java.util.Map;

public class Str_Sorter {

    static String str = "is2 Thi1s T4est 3a";
    public static String order(String words) {

        if(words.isEmpty()) return "";
        String[] arr_words = words.split(" ");
        Map<Integer, String> sentance = new HashMap<Integer, String>();

        for (String word : arr_words) {
            sentance.put(Integer.parseInt(word.replaceAll("[^0-9]", "")), word);
        }

        return String.join(" ", sentance.values());
    }
    public static void main(String[] args) {
        System.out.println(order(""));
    }
}
