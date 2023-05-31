import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //인덱스
        int[] nodes = {1,9,8,2,3,7,6,4,5,0};

        printTree(nodes);

        System.out.println("siftdown 메서드 호출하여 배열을 힙으로 만들기");
        siftdown(nodes, 0);

        printTree(nodes);

        System.out.println("removeKeys 메서드 호출하여 배열의 루트 제거 및 siftdown");
        nodes = removeKeys(nodes);

        printTree(nodes);


    }

    public static void printTree(int[] nodes) {
        int depth = (int) (Math.log(nodes.length) / Math.log(2)); // 계산된 깊이
        int currentIndex = 0; // 현재 노드의 인덱스
        int elementsInLevel = 1; // 현재 레벨에 있는 요소 수

        // 각 레벨을 순회하며 요소를 출력
        for (int level = 0; level <= depth; level++) {
            int elementsInNextLevel = Math.min(nodes.length - currentIndex, 2 * elementsInLevel);
            printSpaces((int) Math.pow(2, depth - level) - 1); // 각 레벨 시작에 들여쓰기

            // 현재 레벨의 요소를 출력
            for (int i = 0; i < elementsInLevel; i++) {
                if(currentIndex < nodes.length){
                    System.out.print(nodes[currentIndex++]);
                    printSpaces((int) Math.pow(2, depth - level + 1) - 1); // 요소 사이의 간격
                }
            }

            System.out.println(); // 다음 레벨로 넘어갈 때 줄바꿈
            elementsInLevel = elementsInNextLevel;
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    public static void siftdown(int[] nodes, int index){
        int parentIndex, largerChildIndex;
        boolean stop = false;
        parentIndex = index;
        while(!stop){
            if(nodes.length > parentIndex*2+2){
                largerChildIndex = nodes[parentIndex*2+1] > nodes[parentIndex*2+2] ? parentIndex*2+1 : parentIndex*2+2;
                System.out.printf("node[%d] = %d와 node[%d] = %d 스왑\n", parentIndex, nodes[parentIndex], largerChildIndex, nodes[largerChildIndex]);
                if(nodes[parentIndex] < nodes[largerChildIndex]){
                    swap(nodes, parentIndex, largerChildIndex);
                    parentIndex = largerChildIndex;
                }
                else{
                    stop = true;
                }
            }
            else if(nodes.length == parentIndex*2+2){
                largerChildIndex = parentIndex*2+1;
                System.out.printf("node[%d] = %d와 node[%d] = %d 스왑\n", parentIndex, nodes[parentIndex], largerChildIndex, nodes[largerChildIndex]);
                if(nodes[parentIndex] < nodes[largerChildIndex]){
                    swap(nodes, parentIndex, largerChildIndex);
                    parentIndex = largerChildIndex;
                }
                else{
                    stop = true;
                }
            }
            else{
                stop = true;
            }
        }
    }

    public static void swap(int[] nodes, int index1, int index2){
        int temp = nodes[index1] ;
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }

    public static int[] removeKeys(int[] nodes){
        int[] newNodes = new int[nodes.length-1];
        swap(nodes, 0, nodes.length-1);
        for(int i = 0 ; i < newNodes.length ; i++){
            newNodes[i] = nodes[i];
        }
        siftdown(newNodes, 0);
        return newNodes;
    }
}
