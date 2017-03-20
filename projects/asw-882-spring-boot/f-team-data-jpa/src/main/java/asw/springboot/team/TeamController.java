package asw.springboot.team;

import asw.springboot.team.domain.*; 
import asw.springboot.team.dao.*; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable; 

@RestController
public class TeamController {

	@Autowired 
	private TeamRepository teamRepository; 
	
	@RequestMapping("/teams/{name}")
	public Team getTeam(@PathVariable String name) {
		return teamRepository.findByName(name);
	}
	
}
