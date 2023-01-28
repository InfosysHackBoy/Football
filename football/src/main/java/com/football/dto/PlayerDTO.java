package com.football.dto;

import com.football.entity.Team;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class PlayerDTO {
	
	private Integer squadNumber;
	private String name;
	private Integer age;
	private String position;
	private long wage;
	private long value;
	@NotNull(message="team ref ID must not be null")
	private Integer teamId;

	
	public Integer getSquadNumber() {
		return squadNumber;
	}
	public void setSquadNumber(Integer squadNumber) {
		this.squadNumber = squadNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public long getWage() {
		return wage;
	}
	public void setWage(long wage) {
		this.wage = wage;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	@Override
	public String toString() {
		return "PlayerDTO [squadNumber=" + squadNumber + ", name=" + name + ", age=" + age + ", position=" + position
				+ ", wage=" + wage + ", value=" + value + ", teamId=" + teamId + "]";
	}
	
	
	
}