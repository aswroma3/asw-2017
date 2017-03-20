package asw.springboot.team.domain;

import java.util.Set; 
import javax.persistence.*; 
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement 
@Entity 
public class Team {

	@Id @GeneratedValue
	private Long id; 
	private String name; 
	private String location; 
	private String mascotte; 
	@OneToMany(cascade=CascadeType.ALL) 
	@JoinColumn(name="teamId")
	private Set<Player> players; 
	
	public Team() {
		super(); 
	}

	public Team(String name, String location, Set<Player> players) {
		this(); 
		this.name = name; 
		this.location = location; 
		this.players = players; 
	}
	
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}

	public String getLocation() {
		return location; 
	}
	
	public void setLocation(String location) {
		this.location = location; 
	}

	public String getMascotte() {
		return mascotte; 
	}
	
	public void setMascotte(String mascotte) {
		this.mascotte = mascotte; 
	}
	
	public Set<Player> getPlayers() {
		return players; 
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players; 
	}	
}
