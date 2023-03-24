package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String > implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getStatus()==null)project.setStatus(Status.OPEN);
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {

        super.deleteById(projectCode);
    }

    @Override
    public void update(ProjectDTO project) {

        if(project.getStatus()==null){
            project.setStatus(findById(project.getProjectCode()).getStatus());
        }

        super.update(project.getProjectCode(),project);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfFinishedProjectDTO(UserDTO manager) {


        List<ProjectDTO> projectDTOList = super.findAll().stream()
                .filter(project->project.getAssignedManager().equals(manager))

                .map(project->{

                    List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                    int completeTaskCount = (int) taskList.stream().filter(t->t.getProject().equals(project) && t.getStatus()==Status.COMPLETE).count();
                    int unfinishedTaskCount = (int) taskList.stream().filter(t->t.getProject().equals(project) && t.getStatus()!=Status.COMPLETE).count();


                    project.setCompleteTaskCounts(completeTaskCount);
                    project.setUnfinishedTaskCounts(unfinishedTaskCount);


                    return project;
                })
                .collect(Collectors.toList());
        return projectDTOList;
    }


}
