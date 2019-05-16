
public class TestA {
	
	public static void main(String[] args) {
        int[] arr=new int[41];
        int point=0;
        int deal=0;
        int num=0;
        while(deal<39){
            if(arr[point]==0){
                num++;
            }
            if(num==3){
                arr[point]=1;
                deal++;
                num=0;   //第三个后念出的数字注意清0
            }
            point=(point+1)%41;   //point递增但不超出循环
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                System.out.println(i+1);  //序号需要加1
            }
        }
    }

}
