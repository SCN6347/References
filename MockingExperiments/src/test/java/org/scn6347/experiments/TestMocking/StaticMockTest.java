package org.scn6347.experiments.TestMocking;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scn6347.experiments.TestMocking.staticMock.Calculator;
import org.scn6347.experiments.TestMocking.staticMock.MathUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MathUtil.class)
public class StaticMockTest
{

	/** Unit under test. */
	private Calculator calc;

	@Before
	public void setUp()
	{
		calc = new Calculator();

		PowerMock.mockStatic(MathUtil.class);
		EasyMock.expect(MathUtil.addInteger(1, 1)).andReturn(0);
		EasyMock.expect(MathUtil.addInteger(2, 2)).andReturn(1);
		PowerMock.replayAll();
	}

	@Test
	public void shouldCalculateInAStrangeWay()
	{
		Assert.assertEquals(0, calc.add(1, 1));
		Assert.assertEquals(1, calc.add(2, 2));
		PowerMock.verifyAll();
	}
	
	@Test
	public void testStaticMethodMocking()
	{
		Assert.assertEquals(0, MathUtil.addInteger(1, 1));
		Assert.assertEquals(1, MathUtil.addInteger(2, 2));
	}
}