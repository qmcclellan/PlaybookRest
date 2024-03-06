package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Users;
import com.rest.playbookrest.Service.CoachService;
import com.rest.playbookrest.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/Login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    private UsersService usersService;
    private CoachService coachService;

    @Autowired
    public LoginController( UsersService usersService, CoachService coachService){

        this.usersService = usersService;
        this.coachService = coachService;
    }


    @GetMapping("/GetUser/{userName}")
    public Users getUser(@PathVariable("userName") String userName){

        return usersService.findByUserName(userName);
    }

    @GetMapping("/GetCoach/{userId}")
    public Coach getCoachByUserName(@PathVariable Integer userId){

      // Users user = usersService.findByUserName(userName);

       return coachService.findCoachByUserId(userId);
    }
}
