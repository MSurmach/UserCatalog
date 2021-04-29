package org.example.catalog.controller;

import org.example.catalog.model.User;
import org.example.catalog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView allUsers() {
        LOGGER.info("The request to retrieve all users was received");
        List<User> userList = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

    @GetMapping(value = "/editUser/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        LOGGER.info("The user with id={} was selected to edit",id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        User user = userService.getById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addPage() {
        LOGGER.info("The request was received to add new user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("user") User user) {
        LOGGER.info("{} was added to catalog", user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.create(user);
        return modelAndView;
    }

    @GetMapping(value = "/seeFullUserDescription/{id}")
    public ModelAndView extraPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("extraPage");
        User user = userService.getById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/deleteUser/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        User removable = userService.getById(id);
        userService.delete(removable);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
