package exceptionHandling;

import java.util.List;

public class ThrowExamples
{

	public static void main(String[] args)
	{
		// Throwing Consumer
		List<String> test = List.of("MSD", "YUVI", "VIRU", "Jaddu");
		test.forEach(ThrowingConsumer.unchecked(System.out::println));
		try
		{
			test.forEach(ThrowingConsumer.unchecked(name -> {
				System.out.println(name.substring(4));
			}));
		}
		catch (Exception e)
		{
			System.out.println("Exception Generated");
		}
		
		test.stream().map(name->name.toLowerCase()).forEach(System.out::println);

	}

}
