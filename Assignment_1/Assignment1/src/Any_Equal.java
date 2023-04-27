import java.util.ArrayList;
import java.util.List;

public class Any_Equal {
    public static boolean any_equal(int n, int A[][]){
        int i,j;
        List<Integer> numList = new ArrayList<>();

        for(i = 0 ; i < n ; i++){
            for(j = 0 ; j < n ; j++){
                if(!numList.contains(A[i][j])){
                    numList.add(A[i][j]);
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean any_equal_bad(int n, int A[][]){
        int i,j,k,m;

        for(i = 0 ; i < n ; i++){
            for(j = 0 ; j < n ; j++){
                for(k = 0 ; k < n ; k++){
                    for(m = 0 ; m < n ; m++){
                        if(A[i][j]==A[k][m] && !(i==k && j==m)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}
