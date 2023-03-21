package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractMapService <TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {

        if(task.getId()==null)task.setId(UUID.randomUUID().getMostSignificantBits());
        if(task.getAssignedDate()==null)task.setAssignedDate(LocalDate.now());
        if(task.getStatus()==null)task.setStatus(Status.OPEN);

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
        if(task.getStatus()==null){task.setStatus(findById(task.getId()).getStatus());        }
        if(task.getId()==null)task.setId(findById(task.getId()).getId());
        if(task.getAssignedDate()==null)task.setAssignedDate(findById(task.getId()).getAssignedDate());
        super.update(task.getId(),task);
    }
}
