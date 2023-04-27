public class QuickSort {
    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;

        int pivot = array[startIndex];
        int leftIndex = startIndex+1;
        int rightIndex = endIndex;

        while(leftIndex <= rightIndex){
            while(leftIndex <= endIndex && array[leftIndex] < pivot){ //선행 조건문은 index out of bounds 방지
                leftIndex++;
            }
            while(rightIndex >= startIndex && array[rightIndex] > pivot){//선행 조건문은 index out of bounds 방지
                rightIndex--;
            }
            //현재 상황 : pivot보다 큰 값이 leftIndex에 있고 pivot보다 작은 값이 rightIndex에 있음.
            if(leftIndex <= rightIndex){  //각 인덱스가 아직도 교차하지 않았으면 swap
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        //인덱스가 교차했을경우 while문 빠져나옴.
        swap(array, startIndex, rightIndex);
        quickSort(array, startIndex, rightIndex-1);
        quickSort(array, rightIndex+1, endIndex);
    }
}
