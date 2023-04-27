public class Hanoi {
    public static void hanoi(int n, char A, char B, char C){//n개의 디스크를 A에서 B를 통해 C로 옮기기
        if(n==1){
            move(n,A,C);
        }
        else{
            hanoi(n-1,A,C,B);
            move(n,A,C);
            hanoi(n-1,B,A,C);
        }

    }

    public static void move(int n, char start, char end){ //n번 원반을 A에서 B로 이동
        String string = String.format("disk#%s : %c to %c", n, start, end);
        System.out.println(string);
    }
}
