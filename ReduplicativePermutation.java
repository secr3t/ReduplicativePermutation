import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
 
public class ReduplicativePermutation {
 
    private int n; // nPr�� n
    private int r; // nPr�� r
//    public HashSet<String> result = new HashSet<>();
    public ArrayList<String>result = new ArrayList<>();
    private String[] res;
    
    // �ʱ�ȭ
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
        
        // depth�� 0���� �������� ��� depth == r���� ����
        if (depth == r) {
        	save(res);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            swap(arr, depth, i);     // ����
            res[depth] = arr[depth]; // ���õ� ���� ����
            perm(arr, depth +1);     // ���ȣ��
            swap(arr, depth, i);     // ����
        }
    }
    
    public static void main(String[] args) {
 
        int r = 3;
        String[] ���� = {"��", "��"};
        String[] ������ = {"�ϳ�", "A", "3"};
        
        ReduplicativePermutation rp = new ReduplicativePermutation(������.length, r);
        rp.perm(������, 0);
        for(String str : rp.result)
        	System.out.println(str);
    }
}
 
