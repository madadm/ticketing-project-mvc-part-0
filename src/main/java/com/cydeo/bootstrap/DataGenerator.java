package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");


        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John","Kesy",
                "john@cydeo.com", "Abc1", true, "74567899", adminRole, Gender.MALE);

        UserDTO user2 = new UserDTO("Mike","Smith",
                "mike@cydeo.com", "Abc2", true, "749869869", managerRole, Gender.MALE);

        UserDTO user3 = new UserDTO("Craig","Jark",
                "craig@cydeo.com", "Abc3", true, "74567899", employeeRole, Gender.MALE);

        UserDTO user4 = new UserDTO("Delisa","Noree",
                "delisa@cydeo.com", "Abc4", true, "74567899", employeeRole, Gender.FEMALE);

        UserDTO user5 = new UserDTO("Elizabeth","Loren",
                "elizabeth@cydeo.com", "Abc1", true, "74567899", employeeRole, Gender.FEMALE);

        UserDTO user6 = new UserDTO("Maria","Ada",
                "maria@cydeo.com", "Abc1", true, "74567899", managerRole, Gender.FEMALE);


        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);

        ProjectDTO pr1 = new ProjectDTO("Spring MVC", "PR001", user2, LocalDate.now(), LocalDate.now().plusDays(25), "Creating controllers", Status.OPEN );
        ProjectDTO pr2 = new ProjectDTO("Spring ORM", "PR002", user6, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS );
        ProjectDTO pr3 = new ProjectDTO("Spring Container", "PR003", user6, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS );

        projectService.save(pr1);
        projectService.save(pr2);
        projectService.save(pr3);

        TaskDTO task1 = new TaskDTO(1L,pr1, user5, "Controller", "Request Mapping", Status.IN_PROGRESS,LocalDate.now());
        TaskDTO task2 = new TaskDTO(2L,pr2, user4, "Configuration", "Database Connection", Status.IN_PROGRESS,LocalDate.now().minusDays(15));
        TaskDTO task3 = new TaskDTO(3L,pr3, user3, "Dependency Injection", "Autowire", Status.IN_PROGRESS,LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);

    }
}
