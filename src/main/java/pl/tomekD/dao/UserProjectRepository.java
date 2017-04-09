package pl.tomekD.dao;


import org.springframework.data.repository.CrudRepository;
import pl.tomekD.model.UserProject;

@org.springframework.stereotype.Repository
public interface UserProjectRepository extends CrudRepository<UserProject, Long> {
    UserProject findByUsername(String username);
}
