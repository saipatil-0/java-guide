/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		//i/p :{ 1, 0, 1, 0, 1, 0, 0, 1 }
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] binArray = new int[n];
		for(int i=0;i<n;i++)
		{
		    int value = sc.nextInt();
		    binArray[i] = value;
		}
		int zerosCount =0;
		
		for(int i=0;i<n;i++)
		{
		    if(binArray[i]==0)
		    {
		        zerosCount++;
		    }
		}
		
		for(int k =0;k<n;k++)
		{
		    if(k<zerosCount)
		    {
		        binArray[k]=0;
		    }
		    else
		    {
		        binArray[k]=1;
		    }
		    System.out.println("value at\t"+k+"\tis\t"+binArray[k]);
		}
	
		
	}
}
