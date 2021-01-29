package experimentJunitSuite;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModule1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Initializer for Test Module 1 Called");
	}

	@Test
	public void test()
	{
		Assert.assertTrue(true);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		System.out.println("Cleanup for Test Module 1 Called");
	}

}
