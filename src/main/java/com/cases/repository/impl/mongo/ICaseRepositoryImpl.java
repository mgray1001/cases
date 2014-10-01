package com.cases.repository.impl.mongo;

import com.cases.model.Case;
import com.cases.repository.ICaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 9/16/14.
 */
@Repository
public class ICaseRepositoryImpl implements ICaseRepository {
    @Autowired
    MongoTemplate mongoTemplate;


}
