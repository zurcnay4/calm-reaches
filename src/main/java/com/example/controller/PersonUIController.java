package com.example.controller;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by ayancruz on 3/16/14.
 */
@Controller
@RequestMapping(value="/people")
public class PersonUIController {

    @Autowired
    private PersonService personService;

    public String getPeoplePage(Model model) {
        model.addAttribute("peopleList", personService.listPeople());

        return "people";
    }
}
