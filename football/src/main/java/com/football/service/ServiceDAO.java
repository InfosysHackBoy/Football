package com.football.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.football.dto.PlayerDTO;
import com.football.dto.TeamDTO;
import com.football.entity.Player;

public interface ServiceDAO {
	
	PlayerDTO addPlayerService(PlayerDTO playerDTO);
	
	List<PlayerDTO> getPlayerService();
	
	TeamDTO addTeamService(TeamDTO teamDTO);
	
	List<TeamDTO> getTeamService();
	
	String deletePlayerService(Integer sqnum);
	
	String deleteTeamService(Integer id);
	
	PlayerDTO getPlayerServiceById(Integer sqnum);
	
	TeamDTO getTeamServiceById(Integer id);
	
	PlayerDTO updatePlayerService(Integer sqnum, Map<String, Object> field);
	
	PlayerDTO replacePlayerService(Integer sqnum, PlayerDTO playerDTO);

}
