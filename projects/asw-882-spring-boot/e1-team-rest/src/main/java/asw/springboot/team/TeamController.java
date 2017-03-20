package asw.springboot.team;

import asw.springboot.team.domain.*; 

import java.util.Set; 
import java.util.HashSet; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;

@RestController
public class TeamController {

	private Team team; 
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>(); 
		players.add( new Player("Charlie Brown", "pitcher") ); 
		players.add( new Player("Snoopy", "shortstop") ); 
		team = new Team( "Peanuts", "California", players );
	}

	@RequestMapping("/team")
	public Team getTeam() {
		return team; 
	}
	
}
