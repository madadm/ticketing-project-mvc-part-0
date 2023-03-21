package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;

import java.util.List;

public class TaskServiceImpl extends AbstractMapService <TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {
        return super.save(task.getId(), task);
    }

    @Override
    public TaskDTO findById(Long taskId) {
        return super.findById(taskId);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long taskId) {

        super.deleteById(taskId);
    }

    @Override
    public void update(TaskDTO task) {

        super.update(task.getId(),task);
    }
}
