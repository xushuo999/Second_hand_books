package zzz;
import java.util.Scanner;

public class Main
{

public static void main(String[] args){
	int dp[]=new int[100];
	 int arr[]=new int[4];
	 dp[0]=1;
	 arr[1]=1; arr[2]=2; arr[3]=5;
	 Scanner scanner=new Scanner(System.in);
	 int x=scanner.nextInt();
	x=x-8;
	 for (int i = 1; i <= 3; ++i) {
		for (int j = arr[i]; j <= x; ++j) {
			dp[j]=dp[j-arr[i]]+dp[j];
		}
	}
	 System.out.println(dp[x]);
}
}

