import javax.swing.text.html.parser.Entity;
import java.util.*;

//노드 구현
class HuffmanNode implements Comparable<HuffmanNode>{
    char key; // 문자
    int value; // 빈도수
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }
}

public class Huffman {
    public static HashMap<Character,String> TransHuffman(String p){
        HashMap<Character,Integer> count = new HashMap<>(); // 'a' : 5

        // 문자 빈도수 계산
        for(char i : p.toCharArray()){
            if(!count.containsKey(i)){
                count.put(i,1);
            }
            else{
                count.replace(i, count.get(i) + 1);
            }
        }

        // 힙 노드 추가
        PriorityQueue<HuffmanNode> huffmanNodes = new PriorityQueue<>();
        for(Character key : count.keySet()){
            huffmanNodes.offer(new HuffmanNode(key, count.get(key)));
        }
        // 허프만 트리 생성
        while(huffmanNodes.size() > 1){ //전체 노드 수가 2개 이상이면 반복 (하나의 tree로 만들것이기 때문)
            HuffmanNode left = huffmanNodes.poll();
            HuffmanNode right = huffmanNodes.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.value+right.value);
            parent.left = left;
            parent.right = right;
            huffmanNodes.offer(parent);
        }

        // 허프만 코드 result에 삽입
        HashMap<Character,String> result = new HashMap<>(); // 'a' : '001'
        if(huffmanNodes.peek().key == '\0'){
            GenerateCode(huffmanNodes.peek(), "", result);
        }
        else{
            result.put(huffmanNodes.peek().key, "0");
        }


        System.out.println(result);
        return result;
    }

    private static void GenerateCode(HuffmanNode node, String code, HashMap<Character,String> codes){ //재귀 호출
        if(node == null){
            return;
        }
        if(node.key != '\0'){
            codes.put(node.key, code);
        }

        GenerateCode(node.right, code + "1", codes);
        GenerateCode(node.left, code + "0", codes);
    }
}
