package experimentJunitSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestModule1.class, TestModule2.class, TestModule3.class})
public class AllTests 
{

	@BeforeClass
	public static void masterInitializer()
	{
		System.out.println("Master Initializer");
	}
	
	
	@AfterClass
	public static void masterCleanup()
	{
		System.out.println("Master Teardown");
	}
}
