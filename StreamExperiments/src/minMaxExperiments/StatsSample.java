package minMaxExperiments;

import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.LongStream;

/**
 * Stats of a stream of objects, including `count`, `min`, and `max`.
 * Note that `min` and `max` are undefined if `count==0`.
 * <p>
 *     This is intended to be used with `Stream.collect()`, for example
 * </p>
 * <pre>
 *     Stats&lt;String&gt; stats = stringStream.collect(Stats.collector());
 *
 *     fooStream.collect(Stats.collector(fooComparator));
 * </pre>
 * <p>
 *     See http://stackoverflow.com/questions/41816264
 * </p>
 * <p>
 *     License: Public Domain
 * </p>
 */
public class StatsSample<T>
{
    int count;

    final Comparator<? super T> comparator;
    T min;
    T max;

    public StatsSample(Comparator<? super T> comparator)
    {
        this.comparator = comparator;
    }

    public int count(){ return count; }

    public T min(){ return min; }
    public T max(){ return max; }

    public void accept(T val)
    {
        if(count==0)
            min = max = val;
        else if(comparator.compare(val, min)<0)
            min = val;
        else if(comparator.compare(val, max)>0)
            max = val;

        count++;
    }

    public StatsSample<T> combine(StatsSample<T> that)
    {
        if(this.count==0) return that;
        if(that.count==0) return this;

        this.count += that.count;
        if(comparator.compare(that.min, this.min)<0)
            this.min = that.min;
        if(comparator.compare(that.max, this.max)>0)
            this.max = that.max;

        return this;
    }

    public static <T> Collector<T, StatsSample<T>, StatsSample<T>> collector(Comparator<? super T> comparator)
    {
        return Collector.of(
            ()->new StatsSample<>(comparator),
            StatsSample::accept,
            StatsSample::combine,
            Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH
        );
    }

    public static <T extends Comparable<? super T>> Collector<T, StatsSample<T>, StatsSample<T>> collector()
    {
        return collector(Comparator.naturalOrder());
    }

    static class Test
    {
        public static void main(String[] args)
        {
            StatsSample<Long> stats = LongStream.rangeClosed(-123, +1000_000_000).boxed()
                .parallel()
                .collect(StatsSample.collector());
            if(stats.count>0)
                System.out.printf("min=%d, max=%d %n", stats.min, stats.max);

            Comparator<Long> comparator = Comparator.<Long>naturalOrder().reversed();
            stats = LongStream.rangeClosed(-123, +1000_000_000).boxed()
                .parallel()
                .collect(StatsSample.collector(comparator));
            if(stats.count>0)
                System.out.printf("min=%d, max=%d %n", stats.min, stats.max);
        }
    }

}