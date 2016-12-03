import java.lang.Math;
public class brento_problem{
   public static void main(String[] args){
   long now = System.currentTimeMillis();
       System.out.println(answer(200));
       System.out.println(System.currentTimeMillis()-now);
   }
   public static int answer(int brick){
      Double num =  Math.floor((brick-1)/2);
      int sum = num.intValue();
      //at least 3 steps
      for(int i = getMaxSteps(brick);i>2;i--){
          sum+=getTotal(brick,brick-1,i);
      }
      return sum;
   }
   //n:total bricks left
   //stepNum:current step
   //prev:bricks in prev step
   public static int getTotal(int n,int prev,int stepNum){
       int ac = stepNum*(stepNum+1)/2;
       if(ac==n){
          return 1;
       }else if(ac>n){
           return 0;
       }else if(stepNum==1){
           if(n<prev){
               return 1;
           }else{
               return 0;
           }
       }
       int total = 0;
       for(int i = prev-1;i>stepNum-1;i--){
           int ham=getTotal(n-i,i,stepNum-1);
//            System.out.print("n "+n);
//            System.out.print(" n-i "+(n-i));
//            System.out.print(" i: "+i);
//            System.out.print(" step "+(stepNum-1));
//            System.out.println(" "+ham);
           total+=ham;
       }
       return total;
   }
   public static int getMaxSteps(int n){
       int num = 0;
       while(((num*(num+1))/2)<=n){
          num++;
       }
       return num-1;
   }
//    public static int doubles(int n){
//        Double num =  Math.floor((n-1)/2);
//        return num.intValue();
//    }
}