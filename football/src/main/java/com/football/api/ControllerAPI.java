package com.football.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import com.football.dto.PlayerDTO;
import com.football.dto.TeamDTO;
import com.football.service.ServiceDAOImpl;

@RestController
@RequestMapping("/api")
@Validated
public class ControllerAPI {
	
	
	@Autowired
	private ServiceDAOImpl serviceDAOImpl;
	
	@PostMapping(value = "/transfer", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<PlayerDTO> addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceDAOImpl.addPlayerService(playerDTO));
		
	}
	
	@PostMapping(value = "/promotion", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<TeamDTO> addTeam(@Valid @RequestBody TeamDTO teamDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceDAOImpl.addTeamService(teamDTO));
		
	}
	
	@GetMapping(value = "/allplayers", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<List<PlayerDTO>> getPlayers(){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.getPlayerService());
		
	}
	
	@GetMapping(value = "/allteams", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<List<TeamDTO>> getTeams(){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.getTeamService());
		
	}
	
	@DeleteMapping(value = "/sell/{sqnum}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<String> deletePlayer(@PathVariable("sqnum") Integer sqnum) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.deletePlayerService(sqnum));
		
	}
	
	@DeleteMapping(value = "/relegation/{id}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<String> deleteTeam(@PathVariable Integer id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.deleteTeamService(id));
		
	}
	
	@GetMapping(value = "/player/{sqnum}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<PlayerDTO> getPlayer(@PathVariable Integer sqnum){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.getPlayerServiceById(sqnum));
		
	}
	
	@PatchMapping(value ="/update/{sqnum}")
	public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Integer sqnum, @RequestBody Map<String, Object> fields) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.updatePlayerService(sqnum, fields));
		
	}
	
	@PutMapping(value ="/replace/{sqnum}")
	public ResponseEntity<PlayerDTO> replacePlayer(@PathVariable Integer sqnum, @RequestBody PlayerDTO playerDTO) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.replacePlayerService(sqnum, playerDTO));
	}

	

}
