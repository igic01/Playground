import java.util.Arrays;
import java.util.LinkedList;

class Josephus{

    static int find(LinkedList<Integer> arr, int k){
        int counter = 1;
        int i = 0;

        while(true){
            if(arr.size() == 1) return arr.get(0);
            if(i == arr.size()){
                i = 0;
            }
            if(counter == 3){
                arr.remove(i);
                counter = 1;
            }else{
                counter++;
                i++;
            }
        }   

    }

    static int findd(LinkedList<Integer> arr, int k) {
        int i = 0;
        while (arr.size() > 1) {
            i = (i + k - 1) % arr.size();
            arr.remove(i);
        }
    
        return arr.get(0);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        list.addAll(Arrays.asList(numbers));
        System.out.println(find(list, 3));   
        System.out.println(findd(list, 3));   
    }
}