package com.artificial.controller;

import com.artificial.model.Spitter;
import com.artificial.services.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lav on 24.08.2016.
 */
@Controller                                                 //объявить как контроллер
public class HomeController {


    @Autowired
    private SpitterService spitterService;

   /* @Inject                                                 //внедрить SpitterServiceImpl
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }*/


    @RequestMapping({"/", "/home"})                         //обрабатывать запросы на получение главной страницы
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles()); //добавить сообщения в модель

        return "home";                                      //вернуть имя представления
    }

    /*@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
    public String showAddUserPage() {
        return "form";
    }*/

    @RequestMapping(value = "/newSpitter", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Spitter spitter = new Spitter();
        model.addObject("spitter", spitter);
        model.setViewName("form");
        return model;
    }

    @RequestMapping(value = "/saveSpitter", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute Spitter spitter) {
        spitterService.addUser(spitter);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value="/deleteSpitter", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam int id) {

        spitterService.deleteSpitter(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editSpitter")
    public ModelAndView editSpitter(@RequestParam  int id, @ModelAttribute Spitter spitter) {
        Spitter spitterObject = spitterService.getSpitterById(id);
        return new ModelAndView("edit", "spitterObject", spitterObject);
    }

    @RequestMapping(value = "/updateSpitter")
    public ModelAndView updateSpitter(@ModelAttribute Spitter spitter) {
        spitterService.updateSpitter(spitter);
        return new ModelAndView("redirect:home");
    }
}
