import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,5,2,6,3,7,5,4,1,5,3,1};


        System.out.println("정렬 전");
        System.out.println(Arrays.toString(numbers));

        numbers = countingSort(numbers);

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] countingSort(int[] numbers){
        int maxNumber = numbers[0];

        //배열 내 최대값 찾기
        for(int i = 0 ; i < numbers.length ; i++){
            maxNumber = maxNumber < numbers[i] ? numbers[i] : maxNumber;
        }

        int[] tempArr = new int[maxNumber];
        //인덱스 0 에 1들어감
        for(int i = 0 ; i < numbers.length ; i++){
            tempArr[numbers[i]-1]++;
        }


        int[] newNumbers = new int[numbers.length];
        int index = 0;
        for(int i = 0 ; i < tempArr.length ; i++){
            for(int j = 0 ; j < tempArr[i] ; j++){
                newNumbers[index++] = i+1; // 1이 인덱스 0이므로 +1
            }

        }

        return newNumbers;
    }
}
