package com.youth.youthpro.webservice;

import com.youth.youthpro.Utils.Utils;
import com.youth.youthpro.Utils.UtilsConstants;
import com.youth.youthpro.beans.People;
import com.youth.youthpro.webrepo.PeopleRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MainService {

    @Autowired
    private PeopleRepo peopleRepo;

    public List<People> getALlPeoples() {
        return peopleRepo.findAll().stream().filter(data -> data.getDeleted() != UtilsConstants.NOT_DELETEd_FLAG).collect(Collectors.toList());
    }

    public People savePeople(People people){
        people.setCreatedTime(Utils.getCurrentDate());
        people.setModifiedTime(Utils.getCurrentDate());
        people.setDeleted(UtilsConstants.NOT_DELETEd_FLAG);
        return peopleRepo.save(people);
    }

    public People updatePeople(People people){
        People persistedPeople = this.findById(people.getPeopleId());
        if(persistedPeople != null) {
            persistedPeople.setPersonName(people.getPersonName());
            persistedPeople.setPersonDOB(people.getPersonDOB());
            people.setModifiedTime(Utils.getCurrentDate());
            return peopleRepo.save(people);
        }
        return null;
    }

    public People findById(String peopleId) {
        return peopleRepo.findById(peopleId).orElse(null);
    }

}
