package com.example.experiments.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.experiments.dto.AuditorAwareDto;

@Entity
public class AuditorAwareEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String playerName;
	private String palyingForTeam;
	
	public AuditorAwareEntity() { }
	
	public AuditorAwareEntity(AuditorAwareDto auditorAwareDto) 
	{
		this.id = auditorAwareDto.getId();
		this.playerName = auditorAwareDto.getPlayerName();
		this.palyingForTeam = auditorAwareDto.getPalyingForTeam();
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
		return "AuditorAwareEntity [id=" + id + ", playerName=" + playerName + ", palyingForTeam=" + palyingForTeam
				+ "]";
	}
}
