package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Users;
import com.rest.playbookrest.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200" )
@RequestMapping(value ="/User", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {

   private UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/UserList")
    public List<Users> findAll(){

        return usersService.findAll();
    }

    @PostMapping("/AddUser")
    public Users addUser(@RequestBody Users user){

        return usersService.saveAndFlush(user);
    }

    @GetMapping("/GetUser/{userId}")
    public Users getUser(@PathVariable("userId") Integer userId){

        return usersService.getReferenceById(userId);
    }

    @GetMapping("/GetUserByName/{userName}")
    public Users getUser(@PathVariable("userName") String userName){

        return usersService.findByName(userName);
    }

    @PutMapping("/UpdateUser")
    public Users updateUser(@RequestBody Users user){

        return usersService.saveAndFlush(user);
    }

    @DeleteMapping("/DeleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId){

        if(userId == null){
            return "User with id "+ userId+" not found!!";
        }

        usersService.deleteById(userId);

        return "User with id "+userId+"was safely deleted!";

    }
}
