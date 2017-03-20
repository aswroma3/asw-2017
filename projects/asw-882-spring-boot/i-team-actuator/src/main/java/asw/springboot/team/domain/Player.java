package asw.springboot.team.domain;

import javax.persistence.*; 

@Entity 
public class Player {

	@Id @GeneratedValue
	private Long id; 
	private String name; 
	private String position; 
	
	public Player() {
		super(); 
	}
	
	public Player(String name, String position) {
		this(); 
		this.name = name; 
		this.position = position; 
	}

	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}

	public String getPosition() {
		return position; 
	}
	
	public void setPosition(String position) {
		this.position = position; 
	}

}
