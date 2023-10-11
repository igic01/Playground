import java.util.*;
class Test{

    static long multiple_dig(long number){
        long result = 1;
        while (number != 0) {
            long digit = number % 10;
            result *= digit;
            number /= 10;
        }
        return result;
    }

    static int count_till_single_digit(long number){
        int count = 0;
        while( ("" + number).length() > 1 ){
            number = multiple_dig(number);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count_till_single_digit(999));
    }
}