import java.util.*;
public class MajorElement2 {
    // Optimal
    public static List<Integer> majorityElement(int[] arr) {
        List <Integer> ans=new ArrayList<>();
        int c1=0;
        int c2=0;
        int cand1=-1;
        int cand2=0;
        for(int i=0;i<arr.length;i++){
            if(c1==0 && arr[i]!=cand2){
                c1=1;
                cand1=arr[i];
            }else if(c2==0 && arr[i]!=cand1){
                c2=1;
                cand2=arr[i];
            }else if(arr[i]==cand1){
                c1++;
            }else if(arr[i]==cand2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==cand1){
                c1++;
               
            }
            if(arr[i]==cand2){
                c2++;
                
            }
        }
        if(c1>arr.length/3){
            ans.add(cand1);
        }
        if(c2>arr.length/3){
            ans.add(cand2);
        }
        return ans;
    }

    public static ArrayList<Integer> majors(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : array) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        ArrayList<Integer> majorElements = new ArrayList<>();
        int requiredFreq = array.length / 3;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > requiredFreq) {
                majorElements.add(entry.getKey());
            }
        }
        return majorElements;
    }

    public static void main(String[] args) {
        int[] array = {11, 33, 33, 11, 33, 11};

        for (int i : majors(array)) {
            System.out.print(i + " ");
        }
        System.out.println("------------------------");
        for (int i : majorityElement(array)) {
            System.out.print(i + " ");
        }
    }
}
