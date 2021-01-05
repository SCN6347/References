package org.scn6347.experiments.TestMocking;

public class ConstructorMocker
{
	private final String test;

	public ConstructorMocker(String test)
	{
		this.test = test;
	}

	public String check()
	{
		return "checked " + this.test;
	}
}