package asw.springboot.team.dao;

import asw.springboot.team.domain.*; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 

@RepositoryRestResource(path="players", collectionResourceRel="players", itemResourceRel="players")
public interface PlayerRepository extends CrudRepository<Player, Long> {

	public Player findByName(String name); 

}

