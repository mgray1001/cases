package com.cases.repository.impl.mongo;

import com.cases.model.CaseVote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by mario on 7/20/14.
 */

//@RepositoryRestResource(collectionResourceRel = "CaseVote", path="vote")
@Repository
public interface VoteMongoRepository
        extends MongoRepository<CaseVote, Long> {

       // castVote


}
