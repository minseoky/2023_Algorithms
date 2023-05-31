import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int digit = 3; //최대 자릿수
        int[] numbers = {1,63,104,125,52,11};

        System.out.println(Arrays.toString(numbers));

        radixSort(numbers, digit);

        System.out.println(Arrays.toString(numbers));

    }
    public static void radixSort(int[] numbers, int digit){


        for(int i = digit ; i > 0 ; i--){

            List<List<Integer>> bucket = new ArrayList<>();
            for(int k = 0 ; k < 10 ; k++){
                bucket.add(new ArrayList<>());
            }

            for(int j = 0 ; j < numbers.length ; j++){
                int currentDigit = extractN(numbers[j], i);
                bucket.get(currentDigit).add(numbers[j]);
            }
            int index = 0;
            for(int k = 0 ; k < 10 ; k++){
                for(int j = 0 ; j < bucket.get(k).size() ; j++){
                    numbers[index++] = bucket.get(k).get(j);
                }
            }

        }
    }

    public static int extractN(int number, int n){ // 수의 n번째 자릿수를 반환하는 메서드
        if(n < 1) return 0;
        return number % (int)Math.pow(10,n) / (int)Math.pow(10,n-1);
    }
}
