package pl.tomekD.dao;


import org.springframework.data.repository.CrudRepository;
import pl.tomekD.model.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
