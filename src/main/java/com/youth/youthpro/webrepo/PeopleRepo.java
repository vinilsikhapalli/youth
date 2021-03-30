package com.youth.youthpro.webrepo;

import com.youth.youthpro.beans.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends MongoRepository<People , String> {
}
