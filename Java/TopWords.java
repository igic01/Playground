import java.util.List;

class TopWords {
     public static List<String> top3(String s) {
        // Your code here
        s = s.replace("'", "");
        String[] list = s.split(" ");
        String[] top_words = new String[3];

        top_words[0] = list[0];
        top_words[1] = list[1];
        top_words[2] = list[2];

        for (int i = 2; i < top_words.length; i++) {
            if(top_words[i].length() > )
        }

        return null;
    }
    public static void main(String[] args) {
        
    }
}
