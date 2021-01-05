package org.scn6347.experiments.TestMocking.localObject;

public class ActualClassLocalConsumer
{

	public String createThing()
	{

		ActualClass myclass = new ActualClass();

		String returnValue = myclass.testMethod();
		return returnValue;
	}
}