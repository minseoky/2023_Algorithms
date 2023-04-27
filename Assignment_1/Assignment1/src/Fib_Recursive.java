public class Fib_Recursive {
    public static int fib_recursive(int n){
        if(n <= 1){
            return n;
        }
        else{
            return fib_recursive(n-1) + fib_recursive(n-2);
        }
    }


}
