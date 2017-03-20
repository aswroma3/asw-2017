package asw.springboot.team.dao;

import asw.springboot.team.domain.*; 

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

	public Team findByName(String name); 

}

