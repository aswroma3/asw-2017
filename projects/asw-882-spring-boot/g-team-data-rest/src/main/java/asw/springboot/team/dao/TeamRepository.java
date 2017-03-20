package asw.springboot.team.dao;

import asw.springboot.team.domain.*; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 

@RepositoryRestResource(path="teams", collectionResourceRel="teams", itemResourceRel="team")
public interface TeamRepository extends CrudRepository<Team, Long> {

	public Team findByName(String name); 

}

