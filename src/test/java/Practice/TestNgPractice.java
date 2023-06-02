package Practice;


import org.testng.annotations.Test;

public class TestNgPractice 
{
	//welcome to practice1 all
	//Hello Hii and bye Hiiiiiiiiii
	@Test(groups = "trial")
	public void update()
	{
		System.out.println("Update");
	}
	
	@Test(groups = "trial")
	public void create() 
	{
		System.out.println("Create");
	}
	
	@Test (dependsOnMethods = "create")
	public void delete() 
	{
		System.out.println("Delete");
	}
	
	@Test(dependsOnGroups = "trial")
	public void demo() 
	{

		if(true)
			System.out.println("true");
			
		else
			System.out.println("fail");
		
	}
}
