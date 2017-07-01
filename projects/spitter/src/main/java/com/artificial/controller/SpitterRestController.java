package com.artificial.controller;

import com.artificial.model.Spitter;
import com.artificial.services.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lav on 18.10.2016.
 */
@RestController
public class SpitterRestController {

    @Autowired
    SpitterService spitterService;

    @RequestMapping(value = "/spitters", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Spitter> getSpitters() {
        List<Spitter> listOfSpitters = spitterService.getRecentSpittles();
        return listOfSpitters;
    }

    @RequestMapping(value = "/spitterss/", method = RequestMethod.GET)
    public ResponseEntity<List<Spitter>> listAllUsers() {
        List<Spitter> users = spitterService.getRecentSpittles();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Spitter>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Spitter>>(users, HttpStatus.OK);
    }
}
