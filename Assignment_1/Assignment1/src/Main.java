public class Main {
    public static void main(String[] args) {
        long start;
        long end;

        int[][] A = new int[100][100];
        int value = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                A[i][j] = value++;
            }
        }


        start = System.currentTimeMillis(); //측정 시작
        System.out.println("배열 A에 같은 항목이 있는가? : " + Any_Equal.any_equal(100,A));
        end = System.currentTimeMillis(); //측정 종료

        System.out.println("Worst Case 수행시간: " + (end - start) + " ms");

    }
}