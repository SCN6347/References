package org.scn6347.experiments.TestMocking;

import org.easymock.EasyMock;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConstructorMocker.class)
public class ConstructorMockerTest
{

	@Test
	public void test_not_mocked() throws Throwable
	{
		MatcherAssert.assertThat(new ConstructorMocker("random string").check(), Matchers.equalTo("checked random string"));
	}

	@Test
	public void test_mocked() throws Throwable
	{
		ConstructorMocker constructorMocker = PowerMock.createMockAndExpectNew(ConstructorMocker.class, "random string");
		EasyMock.expect(constructorMocker.check()).andReturn("test");
		PowerMock.replay(ConstructorMocker.class, constructorMocker);

		String mockValue = new ConstructorMocker("random string").check();
		MatcherAssert.assertThat(mockValue, Matchers.equalTo("test"));
	}

}