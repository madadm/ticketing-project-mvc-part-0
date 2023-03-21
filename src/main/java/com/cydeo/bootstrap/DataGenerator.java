package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
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

    }
}
