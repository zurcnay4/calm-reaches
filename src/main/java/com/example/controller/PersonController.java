package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.model.Person;
import com.example.service.PersonService;

import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public @ResponseBody List<Person> listPeople() {
        return personService.listPeople();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {

        personService.addPerson(person);

        return "redirect:/people/";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/people/";
    }


   /* @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public @ResponseBody Person getPersonInJSON(@PathVariable String name) {
        Person p = new Person();
        p.setFirstName(name);
        p.setLastName("JSON");

        return p;
    }*/
}
