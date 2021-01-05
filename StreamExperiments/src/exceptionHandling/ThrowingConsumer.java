package exceptionHandling;

import java.util.function.Consumer;

public interface ThrowingConsumer<T, E extends Throwable>
{

	/*
	 * Since the method used by Consumer interface used for for each operation didn't specify that an exception can be thrown,
	 * accept method used by for each operation cannot throw an exception.
	 */
	
	void accept(T t) throws E;
	
	static <T, E extends Throwable> Consumer<T> unchecked(ThrowingConsumer<T, E> consumer)
	{

		return (t) -> {
			try
			{
				consumer.accept(t);
			}
			catch (Throwable e)
			{
				throw new RuntimeException(e);
			}
		};
	}
}