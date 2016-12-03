 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Answer_3 {   
//passes 1,2,3,4,5
   public static void main(String[] args){
       int[] test = new int[]{3,1,4,1,5,9};
       long now = System.currentTimeMillis();
       System.out.println(Answer_3.answer(test));
       System.out.println(System.currentTimeMillis()-now);
  }
    public static int answer(int[] l) { 
        ArrayList<Integer> combos = new ArrayList<>(1);
        combos.add(new Integer(0));
        ArrayList<Integer> trays = new ArrayList<>();
        for(int num:l){
            trays.add(num);
        }
        Collections.sort(trays,Collections.reverseOrder());
        return getCombos(trays,combos,l.length,0);
    } 

    private static int getCombos(ArrayList<Integer> digits,ArrayList<Integer> combos, int len,int solution){
       permutations(digits,0,combos);
       solution = combos.get(0);
       if(solution > 0){
           return solution;
       }
       else{
           //Collections.sort(digits,Collections.reverseOrder());
           for(int i = len-1; i > -1; i--){
               ArrayList<Integer> placeholder = new ArrayList<>(digits);
               placeholder.remove(i);
               permutations(placeholder,1,combos);
               solution = combos.get(0);
           }
           if(solution>0){
               return solution;
           }
           else{
               for(int j = len-1; j > -1; j--){
                   ArrayList<Integer> alt = new ArrayList<>(digits);
                   alt.remove(j);
                   solution = getCombos(alt,combos,len-1,0);
               }
           }
       }
       return solution;
    }
    private static void permutations(ArrayList<Integer> arr,
    int k, ArrayList<Integer> combos){
        if(combos.get(0)!=0){
            return;
        }
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permutations(arr, k+1,combos);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            StringBuilder num = new StringBuilder();
            for(Integer e:arr){
               num.append(e.toString());
            }
            Integer possible = Integer.parseInt(num.toString());
            if(possible%3==0&&possible>combos.get(0)){
                    combos.set(0,possible);
            }
        }
    }
}