package com.youth.youthpro.webcontroller;

import com.youth.youthpro.Utils.Utils;
import com.youth.youthpro.Utils.UtilsConstants;
import com.youth.youthpro.beans.People;
import com.youth.youthpro.webservice.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebService;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private MainService webservice;

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("get-all-Peoples")
    public List<People> getALLPeoples(){

        return webservice.getALlPeoples();
    }

    @PostMapping("save-People")
    public People savePerson(@RequestBody People People){
        People.setModifiedTime(Utils.getCurrentDate());
        if(People.getDeleted() == null) {
            People.setDeleted(UtilsConstants.DELETEd_FLAG);
            People.setCreatedTime(Utils.getCurrentDate());
        }
        return  webservice.savePeople(People);
    }

    @GetMapping("get-People/{PeopleId}")
    public People getPersonByPersonId(@PathVariable("PeopleId") String PeopleId){
        return webservice.findById(PeopleId);
    }

    @PatchMapping("delete-People/{PeopleId}")
    public People deletePerson(@PathVariable("PeopleId") String PeopleId){
        People persistedPerson = this.getPersonByPersonId(PeopleId);
        persistedPerson.setDeleted(UtilsConstants.DELETEd_FLAG);
        return this.savePerson(persistedPerson);
    }
}
