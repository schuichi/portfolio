package pl.tomekD.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.tomekD.model.Project;

import java.util.List;

@Repository
public class ProjectRepoImp extends GenericDao<Project> implements ProjectRepository {

//    @Autowired
//    ProjectRepository projectRepository;

//    public Object findAll(){
//        return projectRepository.findAll();
//    }

    @Transactional
    public List<Project> findAll() {
        javax.persistence.Query query = entityManager.createQuery("Select p From Project p");

        return query.getResultList();
    }


    @Transactional
    public void delete(Long id){
        Project project = entityManager.getReference(Project.class, id);
        entityManager.remove(project);
    }

    @Transactional
    public Project findOne(Long id) {
        return entityManager.find(Project.class, id);
    }


    public Project findByTitle(String title) {
        return null;
    }

}
