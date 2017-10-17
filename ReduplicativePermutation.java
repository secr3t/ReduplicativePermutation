import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
 
public class ReduplicativePermutation {
 
    private int n; // nPr의 n
    private int r; // nPr의 r
//    public HashSet<String> result = new HashSet<>();
    public ArrayList<String>result = new ArrayList<>();
    private String[] res;
    
    // 초기화
    public ReduplicativePermutation(int n, int r){
        this.n = n;
        this.r = r;
        res = new String[r];
    }
    
    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void save(String[] arr) {
    	String str = "";
    	for(String a : arr)
    		str+=a;
    	result.add(str);
    }
 
    public void perm(String[] arr, int depth) {
        
        // depth가 0부터 시작했을 경우 depth == r에서 리턴
        if (depth == r) {
        	save(res);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            swap(arr, depth, i);     // 스왑
            res[depth] = arr[depth]; // 선택된 원소 저장
            perm(arr, depth +1);     // 재귀호출
            swap(arr, depth, i);     // 복원
        }
    }
    
    public static void main(String[] args) {
 
        int r = 3;
        String[] 일이 = {"일", "이"};
        String[] 세개얌 = {"하나", "A", "3"};
        
        ReduplicativePermutation rp = new ReduplicativePermutation(세개얌.length, r);
        rp.perm(세개얌, 0);
        for(String str : rp.result)
        	System.out.println(str);
    }
}
 
