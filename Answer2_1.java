

public class Answer2_1{   
    public static int[] answer(int h, int[] q) { 
       int[] array = new int[q.length];
       Integer height = new Integer(h);
       Double root = Math.pow(2,height.doubleValue())-1;
       int placeholder = 0;
       int parent;
       for(int e : q){
          parent = find(e,height.doubleValue(),root);
          array[placeholder] = parent;
          placeholder++;
       }
       return array;
    } 
    private static int find(int val, double exp, double num){

        if(val >= num){
            return -1;
        }
        else if((val==num-1)||(val==num-Math.pow(2,exp-1))){
           Double number = new Double(num);
           return number.intValue();
        }
        //else if(val<(Math.pow(2,exp-1)-1)){
        else if(val<num-Math.pow(2,exp-1)){
            return find(val,exp-1,num-Math.pow(2,exp-1));
        }
        else{ //if(val<(Math.pow(2,exp)-2)){
            return find(val,exp-1,num-1);
        }
    }
    public static void main(String[] args){
       int[] input = new int[]{1,4,7};
       int[] ans = Answer2_1.answer(3,input);
       for (int e: ans){System.out.println(e);}
    }
}