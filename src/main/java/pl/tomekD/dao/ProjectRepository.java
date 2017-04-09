package pl.tomekD.dao;


import org.springframework.data.repository.CrudRepository;
import pl.tomekD.model.Project;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findOne(Long id);



}
