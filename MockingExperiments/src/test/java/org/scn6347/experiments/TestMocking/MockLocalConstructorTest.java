package org.scn6347.experiments.TestMocking;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scn6347.experiments.TestMocking.localObject.ActualClass;
import org.scn6347.experiments.TestMocking.localObject.ActualClassLocalConsumer;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ ActualClassLocalConsumer.class })
public class MockLocalConstructorTest
{

	private ActualClassLocalConsumer instance;

	@Test
	public final void testMockConstructor() throws Exception
	{

		instance = new ActualClassLocalConsumer();

		ActualClass anyClass = PowerMock.createMockAndExpectNew(ActualClass.class);

		final String expected = "MY_OTHER_RESULT";
		expect(anyClass.testMethod()).andReturn(expected);

		replay(ActualClass.class, anyClass);
		String result = instance.createThing();
		verify(ActualClass.class, anyClass);
		assertEquals(expected, result);
	}

}
