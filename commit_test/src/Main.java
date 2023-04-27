import java.util.Arrays;

public class Main {
    static long[] dp = new long[100];
    public static long newfibo(int n){//DP?
        if(n <= 1){
            return n;
        }
        else{
            if(dp[n] > 0){
                return dp[n];
            }
            dp[n] = newfibo(n-1) + newfibo(n-2);
            return dp[n];
        }
    }
    public static long oldfibo(int n){
        if(n <= 1){
            return n;
        }
        else{
            return oldfibo(n-1) + oldfibo(n-2);
        }
    }
    public static void main(String[] args) {
        /*
        long start = System.nanoTime();

        for(int i = 1 ; i < 66 ; i++){
            System.out.println(i + "번째 피보나치 수 : " + newfibo(i));
        }
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start)/1000 + " ms");
        start = System.nanoTime();
        for(int i = 1 ; i < 35 ; i++){
            System.out.println(i + "번째 피보나치 수 : " + oldfibo(i));
        }
        end = System.nanoTime();
        System.out.println("수행시간: " + (end - start)/1000 + " ms");
        */
        int[] arr = {7,3,2,5};
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



}