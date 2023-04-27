public class Fib_Iterative {
    public static int fib_iterative(int n){
        int index = 0;
        int fibDP[] = new int[100];
        fibDP[0] = 0;
        if(n > 0){
            fibDP[1] = 1;
            for(index = 2 ; index <= n ; index++){
                fibDP[index] = fibDP[index-1] + fibDP[index-2];
            }
        }
        return fibDP[n];
    }
}
