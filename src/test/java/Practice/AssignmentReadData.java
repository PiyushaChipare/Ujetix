package Practice;

import org.testng.annotations.DataProvider;

public class AssignmentReadData 
{
	@DataProvider
	public Object[][] data33() 
	{
		Object [][]arr=new Object[3][3];
		arr[0][0]="33Alex1";
		arr[0][1]="33Mumbai1";
		arr[0][2]=11;
		
		arr[1][0]="33Alex2";
		arr[1][1]="33Mumbai2";
		arr[1][2]=22;
		
		arr[2][0]="33Alex3";
		arr[2][1]="33Mumbai3";
		arr[2][2]=33;
		return arr;
	}
	
	@DataProvider
	public Object[][] data44() 
	{
		Object [][]arr=new Object[4][4];
		arr[0][0]="44Alex1";
		arr[0][1]="44Mumbai1";
		arr[0][2]="44Delhi1";
		arr[0][3]=111;
		
		arr[1][0]="44Alex2";
		arr[1][1]="44Mumbai2";
		arr[1][2]="44Delhi2";
		arr[1][3]=222;
		
		arr[2][0]="44Alex3";
		arr[2][1]="44Mumbai3";
		arr[2][2]="44Delhi3";
		arr[2][3]=333;
		
		arr[3][0]="44Alex4";
		arr[3][1]="44Mumbai4";
		arr[3][2]="44Delhi4";
		arr[3][3]=444;
		return arr;
	}

	@DataProvider
	public Object[][] data45() 
	{
		Object [][]arr=new Object[4][5];
		arr[0][0]="45Alex1";
		arr[0][1]="45Mumbai1";
		arr[0][2]="45Delhi1";
		arr[0][3]="45Bus01";
		arr[0][4]=10001;
		
		arr[1][0]="45Alex2";
		arr[1][1]="45Mumbai2";
		arr[1][2]="45Delhi2";
		arr[1][3]="45Bus02";
		arr[1][4]=20002;
		
		arr[2][0]="45Alex3";
		arr[2][1]="45Mumbai3";
		arr[2][2]="45Delhi3";
		arr[2][3]="45Bus03";
		arr[2][4]=30003;
		
		arr[3][0]="45Alex4";
		arr[3][1]="45Mumbai4";
		arr[3][2]="45Delhi4";
		arr[3][3]="45Bus04";
		arr[3][4]=40004;
		return arr;
	}
	
	@DataProvider
	public Object[][] data32() 
	{
		Object [][]arr=new Object[3][2];
		arr[0][0]="44Alex1";
		arr[0][1]="44Mumbai1";
		
		arr[1][0]="44Alex2";
		arr[1][1]="44Mumbai2";
		
		arr[2][0]="44Alex3";
		arr[2][1]="44Mumbai3";
		return arr;
	}
	
	@DataProvider
	public Object[][] data22() 
	{
		Object [][]arr=new Object[2][2];
		arr[0][0]="22Alex1";
		arr[0][1]="22Mumbai1";
		
		arr[1][0]="22Alex2";
		arr[1][1]="22Mumbai2";
		return arr;
	}
}
