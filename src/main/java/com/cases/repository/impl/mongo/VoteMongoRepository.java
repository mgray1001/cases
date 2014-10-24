package com.cases.repository.impl.mongo;

import com.cases.model.mongo.CaseVote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by mario on 7/20/14.
 */

@RepositoryRestResource(itemResourceRel = "vote", collectionResourceRel = "votes", path="vote")
public interface VoteMongoRepository
        extends  MongoRepository<CaseVote, String> {

    @Query("{ 'participantCase.caseId': '?0' }")
    public List<CaseVote> findByCase(@PathParam("caseId") String caseId);


    @Query("{ 'participantCase.participantUser.userProfile.userId': '?0' }")
    public List<CaseVote> findByUser(@PathParam("userId") String caseId);

}
