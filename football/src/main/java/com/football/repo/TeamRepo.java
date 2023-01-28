package com.football.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.entity.Player;
import com.football.entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer>{
	
	

}
