package exceptionHandling;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowableFunction<T, R, E extends Throwable>
{

	/*
	 * Since the Function interface used for mapper didn't specify that an exception can be thrown,
	 * A mapper function used by map method of stream api cannot throw an exception
	 */
	
	R apply(T t) throws E;

	static <T, R, E extends Throwable> Function<T, R> unchecked(ThrowableFunction<T, R, E> f)
	{
		
		return t -> {
			try
			{
				return f.apply(t);
			}
			catch (Throwable e)
			{
				throw new RuntimeException(e);
			}
		};
	}
}