import java.util.*;
public class variableEncoding {
	private void decToBinary(int n) 
	{ 
	    for (int i = 7; i >= 0; i--) 
		{ 
	    	int k = n >> i; 
	        if (k != 0) 
	            System.out.print("1"); 
	        else
	        	System.out.print("0"); 
	    } 
	    System.out.print("\n");
	} 
	  

	public static void main(String [] args)
	{
		int i;
		int j;
		long[] ID=new long[100];
		long num;
		long[] gap=new long[100];
		long[][] r=new long[100][100];
		long[] q=new long[100];
		variableEncoding vbe=new variableEncoding();
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter no. of DocIDs");
		num=sc.nextInt();
		System.out.println("Enter the DocIds");
		for(i=0;i<num;i++)
		{
			ID[i]=sc.nextInt();;
		}
		
		//finding gap values
		gap[0]=ID[0];
		for(i=1;i<num;i++)
		{
			gap[i]=ID[i]-ID[i-1];
		}
		
		//print gap values
		System.out.println("Gap value( decimal value ):");
		for(i=0;i<num;i++)
		{
			System.out.print(gap[i]+"\t");
		}
		
		System.out.println("");
		
		//processing
		for(i=0;i<num;i++)
		{
			j=0;
			if(gap[i]<128)
			{
				r[i][j]=gap[i];
			}
			
			else
			{
				while(gap[i]>127)
				{
					r[i][j]=gap[i]%128;			
					q[i]=gap[i]/128;
					gap[i]=q[i];
					j++;
					if (q[i]<128)
						break;
				}
			}		
		}
		
		// printing variable byte codes(binary digits)
		System.out.println();
		System.out.println("code in decimal value:");
		for(i=0;i<num;i++)
		{
			int n=(int)q[i];
			vbe.decToBinary(n);
			for(j=i;j>=0;j--)
			{
				if(j==0)
				{
					r[i][j]+=128;
					n=(int)r[i][j];				
				}
				else
					n=(int)r[i][j];
					
				if(n!=0)
					vbe.decToBinary(n);
			}
			System.out.println("");
		}
	}

}
