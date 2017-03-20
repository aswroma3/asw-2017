package asw.springboot.team;

import asw.springboot.team.domain.*; 
import asw.springboot.team.dao.*; 

import java.util.Set; 
import java.util.HashSet; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class TeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamApplication.class, args);
	}

	@Autowired 
	private TeamRepository teamRepository; 

	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
 		players.add( new Player("Charlie Brown", "pitcher") );
 		players.add( new Player("Snoopy", "shortstop") );
 		Team team = new Team( "Peanuts", "California", players );
		teamRepository.save(team); 
	}
	
}
