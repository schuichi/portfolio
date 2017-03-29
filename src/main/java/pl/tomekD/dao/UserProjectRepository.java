package pl.tomekD.dao;


import org.springframework.data.repository.CrudRepository;
import pl.tomekD.model.UserProject;

public interface UserProjectRepository extends CrudRepository<UserProject, Integer> {
}
