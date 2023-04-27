public class Pascal {
    /* O(n^2)공간복잡도 알고리즘 */
    public static void pascalArr(int line){
        int[][] pascalArr = new int[line][line];
        for(int i = 0 ; i < line ; i++){
            if(i == 0){
                pascalArr[0][0] = 1;
            }
            else{
                for(int j = 0 ; j <= i ; j++){
                    if(j == 0){
                        pascalArr[i][j] = pascalArr[i-1][j];
                    }
                    else if(j == i){
                        pascalArr[i][j] = pascalArr[i-1][j-1];
                    }
                    else{
                        pascalArr[i][j] = pascalArr[i-1][j-1]+pascalArr[i-1][j];
                    }
                }
            }
        }
        // 파스칼 삼격형 출력
        for(int k = 0 ; k < line ; k++){
            for(int l = 0 ; l <= k ; l++){
                System.out.print(pascalArr[k][l] + " ");
            }
            System.out.println();
        }
    }

    /* O(n)공간복잡도 알고리즘 */
    public static void pascalArrBetter(int line){
        int[] prevArr = {1};
        for(int i = 1 ; i < line ; i++){
            int[] tempArr = new int[i+1];
            for(int j = 0 ; j < i ; j++){
                if(j == 0){
                    tempArr[j] = prevArr[j];
                }
                else if(j == i){
                    tempArr[j] = prevArr[j-1];
                }
                else{
                    tempArr[j] = prevArr[j-1]+prevArr[j];
                }
            }
            prevArr = tempArr;
            //전 배열이 필요 없게 되므로 출력 후 초기화
            for(int k = 0 ; k < i ; k++){
                System.out.print(prevArr[k] + " ");
            }
            System.out.println();
        }
    }
}
