package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserServiceImpl userService;

    public DataGenerator(RoleService roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
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
                "john@cydeo.com", "Abc1", true, "74567899", managerRole, Gender.MALE);

        UserDTO user2 = new UserDTO("Mike","Smith",
                "mike@cydeo.com", "Abc2", true, "749869869", managerRole, Gender.MALE);

        UserDTO user3 = new UserDTO("Craig","Jark",
                "craig@cydeo.com", "Abc3", true, "74567899", managerRole, Gender.MALE);

        UserDTO user4 = new UserDTO("Delisa","Noree",
                "delisa@cydeo.com", "Abc4", true, "74567899", managerRole, Gender.FEMALE);

        UserDTO user5 = new UserDTO("Elizabeth","Loren",
                "elizabeth@cydeo.com", "Abc1", true, "74567899", managerRole, Gender.FEMALE);

        UserDTO user6 = new UserDTO("Maria","Ada",
                "maria@cydeo.com", "Abc1", true, "74567899", managerRole, Gender.FEMALE);


        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);



    }
}
