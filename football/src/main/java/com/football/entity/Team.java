package com.football.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="team")
//@Getter
//@Setter
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//using identity starts from 1 and auto increments
	private Integer teamId;
	private String name;
	private String stadium;
	private long capacity;
	private String city;
	private long value;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="team")
	//@JoinColumn(name="team_id")
	//private List<Player> player;
	
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", stadium=" + stadium + ", capacity=" + capacity
				+ ", city=" + city + ", value=" + value + "]";
	}
	

}
