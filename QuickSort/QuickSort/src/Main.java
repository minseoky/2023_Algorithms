import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int array[] = {5,1,7,2,3,0,9,8};
        System.out.println(Arrays.toString(array));
        QuickSort.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}