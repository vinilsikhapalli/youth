package com.youth.youthpro.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.attribute.standard.DocumentName;
import java.util.Date;

@Document("peoples")
public class People {

    @Id
    private String peopleId;
    private String personName;
    private String personDOB;
    private String createdTime;
    private String modifiedTime;
    private String deleted;

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonDOB() {
        return personDOB;
    }

    public void setPersonDOB(String personDOB) {
        this.personDOB = personDOB;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
