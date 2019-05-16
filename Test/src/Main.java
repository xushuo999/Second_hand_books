import java.util.Scanner;

public class Main{ 
    
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		while(true) {
			int m=scanner.nextInt();
			int n=scanner.nextInt();
			if(m==0 && n == 0)
				break;
			int arr[][]=new int[m][m];
			int arr1[][]=new int[n+1][2];
			for (int i = 0; i < n; i++) {
				arr1[i][0]=scanner.nextInt();
				arr1[i][1]=scanner.nextInt();
			}
			System.out.println(n-m+1);
		}
		
		
        }

}
