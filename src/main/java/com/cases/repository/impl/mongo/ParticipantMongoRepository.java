package com.cases.repository.impl.mongo;

import com.cases.model.CaseVote;
import com.cases.model.ParticipantUser;
import com.cases.repository.ParticipantRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mario on 10/1/14.
 */
@RepositoryRestResource(collectionResourceRel = "participant", path = "participant")
public interface ParticipantMongoRepository extends MongoRepository<CaseVote, Long>, ParticipantRepository {


    @Query("{ 'participantCase.caseId' : '?0' }")
    List<ParticipantUser> findByParticipantCase(@Param("caseId") String caseId);

    @Query("{ 'userProfile.userId' : '?0' }")
    ParticipantUser findByUserProfile(@Param("userId") String userProfileId);

}
