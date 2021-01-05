package minMaxExperiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MinMaxExperiments
{

	public static void main(String[] args)
	{
		
		MinMaxExperiments minMaxExperiments = new MinMaxExperiments();
		minMaxExperiments.experimentWithIntStream();
		minMaxExperiments.experimentsWithStringObjectStream();
		minMaxExperiments.experimentWithCompositeObjectStream();
		minMaxExperiments.experimentWithStatsClass();
	}

	private void experimentWithStatsClass()
	{

		System.out.println(" ****************** MinMaxExperiments.experimentWithStatsClass() ******************\\n");
		List<PlayerInfo> playerList = new ArrayList<>(Arrays.asList(new PlayerInfo[] {
				new PlayerInfo("MSD", "Wicket Keeper Batsman", 7),
				new PlayerInfo("Viru", "Opening Batsman", 8),
				new PlayerInfo("Bhuvi", "Opening Bowler", 16),
				new PlayerInfo("Yuvi", "All-Rounder", 12),
				new PlayerInfo("Bumrah", "Death Over Bowler", 27),
		}));

		Comparator<PlayerInfo> playerComparator = (new Comparator<PlayerInfo>()
		{
			@Override
			public int compare(PlayerInfo player1, PlayerInfo player2)
			{
				return player1.getJersyNumber() - player2.getJersyNumber();
			}
		});
		
		Stats<PlayerInfo> playerStats = playerList.stream().collect(Stats.collector(playerComparator));
		System.out.println("Element Count: " + playerStats.count);
		System.out.println("Min Value: " + playerStats.min.getPlayerName());
		System.out.println("Max Value: " + playerStats.max.getPlayerName());
		
	}

	private void experimentWithCompositeObjectStream()
	{
		System.out.println(" ****************** MinMaxExperiments.experimentWithCompositeObjectStream() ******************\\n");
		List<PlayerInfo> playerList = new ArrayList<>(Arrays.asList(new PlayerInfo[] {
				new PlayerInfo("MSD", "Wicket Keeper Batsman", 7),
				new PlayerInfo("Viru", "Opening Batsman", 8),
				new PlayerInfo("Bhuvi", "Opening Bowler", 16),
				new PlayerInfo("Yuvi", "All-Rounder", 12),
				new PlayerInfo("Bumrah", "Death Over Bowler", 27),
		}));
		
		System.out.println("Element Count: " + playerList.stream().count());
		
		//Max Value of the Object based Stream
		Optional<PlayerInfo> maxValue = playerList.stream().max(new Comparator<PlayerInfo>()
		{

			@Override
			public int compare(PlayerInfo player1, PlayerInfo player2)
			{
				return player1.getJersyNumber() - player2.getJersyNumber();
			}
		});
		PlayerInfo playerInfo = maxValue.get();
		System.out.println("Max Value of the Object based Stream: " + playerInfo.getPlayerName());
		
		//Min Value of the Object based Stream
		Optional<PlayerInfo> minValue = playerList.stream().min(new Comparator<PlayerInfo>()
		{

			@Override
			public int compare(PlayerInfo player1, PlayerInfo player2)
			{
				return player1.getJersyNumber() - player2.getJersyNumber();
			}
		});
		playerInfo = minValue.get();
		System.out.println("Min Value of the Object based Stream: " + playerInfo.getPlayerName());
				
	}

	private void experimentsWithStringObjectStream()
	{
		System.out.println(" ****************** MinMaxExperiments.experimentsWithStringObjectStream() ******************\\n");
		
		String[] s1 = new String[] {"MSD","YUVI","Raina","Kohli","Jaddu","Viru","Gambhir"};
		System.out.println("Element Count: " + Arrays.stream(s1).count());
		
		//Max Value of the String based Stream
		Optional<String> maxValue = Arrays.stream(s1).max(new Comparator<String>()
		{
			@Override
			public int compare(String stringValue1, String stringValue2)
			{
				return stringValue1.compareTo(stringValue2);
			}
		});
		System.out.println("Max Value of the String based Stream: " + maxValue.get());
		
		//Min Value of the String based Stream
		Optional<String> minValue = Arrays.stream(s1).min(new Comparator<String>()
		{

			@Override
			public int compare(String stringValue1, String stringValue2)
			{
				return stringValue1.compareTo(stringValue2);
			}
		});
		System.out.println("Min Value of the String based Stream: " + minValue.get());
	} 

	private void experimentWithIntStream()
	{
		System.out.println(" ****************** MinMaxExperiments.experimentWithIntStream() ******************\n");
		IntStream integerStream = IntStream.of(47,48,49,50,1,2,3,4,5,6,7,8,11,12);
		System.out.println("Max Value: " + integerStream.max().getAsInt());
		
		// Stream can be used only once. For two separate operations in two separate lines, we needs to create the stream once more. 
		
		IntStream integerStream1 = IntStream.of(47,48,49,50,1,2,3,4,5,6,7,8,11,12);
		System.out.println("Min Value: " + integerStream1.min().getAsInt());
		
		// Number of Elements in a Stream:
		IntStream integerStream2 = IntStream.of(47,48,49,50,1,2,3,4,5,6,7,8,11,12);
		System.out.println("Element Count: " + integerStream2.count());
	}
}
