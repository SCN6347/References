package minMaxExperiments;

public class PlayerInfo
{
	private String playerName;
	private String playerCategory;
	private int jersyNumber;
	
	public PlayerInfo(String playerName, String playerCategory, int jersyNumber)
	{
		this.playerName = playerName;
		this.playerCategory = playerCategory;
		this.jersyNumber = jersyNumber;
	}

	public PlayerInfo() { }

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getPlayerCategory()
	{
		return playerCategory;
	}

	public void setPlayerCategory(String playerCategory)
	{
		this.playerCategory = playerCategory;
	}

	public int getJersyNumber()
	{
		return jersyNumber;
	}

	public void setJersyNumber(int jersyNumber)
	{
		this.jersyNumber = jersyNumber;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + jersyNumber;
		result = prime * result + ((playerCategory == null) ? 0 : playerCategory.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		PlayerInfo other = (PlayerInfo) obj;
		if (jersyNumber != other.jersyNumber) return false;
		if (playerCategory == null)
		{
			if (other.playerCategory != null) return false;
		}
		else if (!playerCategory.equals(other.playerCategory)) return false;
		if (playerName == null)
		{
			if (other.playerName != null) return false;
		}
		else if (!playerName.equals(other.playerName)) return false;
		return true;
	}

}
