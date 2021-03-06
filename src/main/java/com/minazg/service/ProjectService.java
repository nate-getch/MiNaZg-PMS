package com.minazg.service;

import com.minazg.model.Project;
import com.minazg.model.Release;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {
    public void save(Project project);
    public List<Project> findAll();
    public Project findOne(Long id);
    public void updateProject(Project project);
    public List<Project> findByName(String name);
    public List<Release> getProjectDetail(Long id);
}
