package com.football.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils.FieldFilter;

import com.football.dto.PlayerDTO;
import com.football.dto.TeamDTO;
import com.football.entity.Player;
import com.football.entity.Team;
import com.football.exception.PlayerTransferException;
import com.football.exception.TeamNotFoundException;
import com.football.repo.PlayerRepo;
import com.football.repo.TeamRepo;

import jakarta.transaction.Transactional;

@Service(value="serviceDAO")
@Transactional
public class ServiceDAOImpl implements ServiceDAO{

	@Autowired
	private PlayerRepo playerRepo;
	
	@Autowired
	private TeamRepo teamRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PlayerDTO addPlayerService(PlayerDTO playerDTO) {

		Player pdto = playerRepo.saveAndFlush(modelMapper.map(playerDTO, Player.class));
		
		return modelMapper.map(pdto, PlayerDTO.class);
	}



	@Override
	public TeamDTO addTeamService(TeamDTO teamDTO) {
	
		Team tdto = teamRepo.saveAndFlush(modelMapper.map(teamDTO, Team.class));
	
		return modelMapper.map(tdto, TeamDTO.class);
	}



	@Override
	public List<PlayerDTO> getPlayerService() {
		
		List<Player> p = playerRepo.findAll();
		
		List<PlayerDTO> pl = new ArrayList();
		
		for(Player a: p) {
			
			pl.add(modelMapper.map(a, PlayerDTO.class));
			
		}
		
		return pl;
				
	}



	@Override
	public List<TeamDTO> getTeamService() {

		List<Team> t = teamRepo.findAll();
		
		List<TeamDTO> tdto = new ArrayList();
		
		for(Team a: t) {
			
			tdto.add(modelMapper.map(a, TeamDTO.class));
			
		}
		
		/*Iterator<Team> t1 = t.iterator();

		while(t1.hasNext()) {
		    //System.out.println(t1.next());
		    tdto.add(modelMapper.map(t1, TeamDTO.class));
		    
		}*/	
			
		return tdto;
		
	}



	@Override
	public String deletePlayerService(Integer sqnum) {

		playerRepo.deleteById(sqnum);
		
		return "Player number " + sqnum + " has been sold!";
		
	}
	
	@Override
	public String deleteTeamService(Integer id) {

		teamRepo.deleteById(id);
		
		return "Team " + id + " has been relegated!";
		
	}



	@Override
	public PlayerDTO getPlayerServiceById(Integer sqnum) {

		Optional<Player> op = playerRepo.findById(sqnum);//.orElseThrow(TeamNotFoundException::new);
		
		PlayerDTO pdto = null;
		
		if(!op.isPresent()) {		
			
			throw new PlayerTransferException("No player is present at this ID");
			
		} else {
			
			Player p = op.get();
			
			pdto = modelMapper.map(p, PlayerDTO.class);
			
		}
		
		return pdto;
		
	}



	@Override
	public TeamDTO getTeamServiceById(Integer id) {

		Team ot = teamRepo.findById(id).orElseThrow(TeamNotFoundException::new);//if not using else throw then make team optional
		
		return modelMapper.map(ot, TeamDTO.class);
		
	}



	@Override
	public PlayerDTO updatePlayerService(Integer sqnum, Map<String, Object> fields) {

		Optional<Player> p = playerRepo.findById(sqnum);
		
		if(p.isPresent()) {
			
			fields.forEach((key, value)->{
				
				Field field = ReflectionUtils.findRequiredField(Player.class, key);
				
				field.setAccessible(true);
				
				ReflectionUtils.setField(field, p.get(), value);
				
			});
			
			return modelMapper.map(playerRepo.save(p.get()), PlayerDTO.class);
			
		}
	
		return null;
		
	}



	@Override
	public PlayerDTO replacePlayerService(Integer sqnum, PlayerDTO playerDTO) {

		Optional<Player> p = playerRepo.findById(sqnum);
		
		Optional<Team> t = teamRepo.findById(playerDTO.getTeamId());
		
		if(p.isPresent() & t.isPresent()) {
			
			p.get().setName(playerDTO.getName());
			p.get().setAge(playerDTO.getAge());
			p.get().setPosition(playerDTO.getPosition());
			p.get().setWage(playerDTO.getWage());
			p.get().setValue(playerDTO.getValue());
			p.get().setTeam(t.get());
			
		}
		
		return modelMapper.map(playerRepo.save(p.get()), PlayerDTO.class);
		
	}

}
