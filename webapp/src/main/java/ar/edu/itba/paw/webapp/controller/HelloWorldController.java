package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
    private final UserService us;

    @Autowired
    public HelloWorldController(UserService us) {
        this.us = us;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        final ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Pedro puto");
        return mav;
    }
}
