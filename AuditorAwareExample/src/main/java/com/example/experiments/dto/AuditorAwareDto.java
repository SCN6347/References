package com.example.experiments.dto;

import com.example.experiments.dao.entity.AuditorAwareEntity;

public class AuditorAwareDto {

	private Integer id;
	private String playerName;
	private String palyingForTeam;
	
	public AuditorAwareDto() { }
	
	public AuditorAwareDto(AuditorAwareEntity auditorAwareEntity) 
	{
		this.id = auditorAwareEntity.getId();
		this.playerName = auditorAwareEntity.getPlayerName();
		this.palyingForTeam = auditorAwareEntity.getPalyingForTeam();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPalyingForTeam() {
		return palyingForTeam;
	}

	public void setPalyingForTeam(String palyingForTeam) {
		this.palyingForTeam = palyingForTeam;
	}

	@Override
	public String toString() {
		return "AuditorAwareDto [id=" + id + ", playerName=" + playerName + ", palyingForTeam=" + palyingForTeam + "]";
	}
}
