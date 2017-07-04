package com.artificial.controller.rest;

import com.artificial.model.User;
import com.artificial.services.srvc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/get/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable Integer userId) {
        User user = userService.get(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer userId) {
        userService.delete(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
