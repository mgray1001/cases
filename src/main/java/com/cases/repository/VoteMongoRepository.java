package com.cases.repository;

import com.cases.model.CaseVote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mario on 7/20/14.
 */
@RepositoryRestResource(collectionResourceRel = "user", path="user")
public interface VoteMongoRepository extends MongoRepository<CaseVote, Long> {



    void    forfeit(@Param("caseId")String caseId, @Param("userId")Long userId);

    void    dismiss(@Param("caseId")String caseId, @Param("userId")Long pId);

}
