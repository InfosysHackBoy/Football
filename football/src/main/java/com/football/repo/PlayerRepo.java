package com.football.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.entity.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>{
	
	

}
