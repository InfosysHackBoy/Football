package com.football.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="player")
//@Getter
//@Setter
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//using identity starts from 1 and auto increments
	private Integer squadNumber;
	private String name;
	private int age;
	private String position;
	private long wage;
	private long value;
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	
	

	@Override
	public String toString() {
		return "Player [squadNumber=" + squadNumber + ", name=" + name + ", age=" + age + ", position=" + position
				+ ", wage=" + wage + ", value=" + value + ", team=" + team + "]";
	}
	
	
	
}
