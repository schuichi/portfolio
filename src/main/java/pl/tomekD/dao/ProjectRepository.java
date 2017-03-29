package pl.tomekD.dao;


import pl.tomekD.model.Project;

import java.util.List;


public interface ProjectRepository {


    void save(Project project);

    void delete(Long id);

    Project findOne(Long id);

    List<Project> findAll();

    Project findByTitle(String title);


}
