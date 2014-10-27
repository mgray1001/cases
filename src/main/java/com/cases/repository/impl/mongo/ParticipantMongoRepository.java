package com.cases.repository.impl.mongo;

import com.cases.model.mongo.ParticipantUser;
import com.cases.repository.ParticipantRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mario on 10/1/14.
 */
@RepositoryRestResource(itemResourceRel = "participant", collectionResourceRel = "participants", path = "participant")
public interface ParticipantMongoRepository extends MongoRepository<ParticipantUser, String>, ParticipantRepository {


    @Query("{ 'participantCase.$id' : ?0 }")
    List<ParticipantUser> findByParticipantCaseCaseId(@Param("caseId") ObjectId caseId);

    @Query("{ 'userProfile.$id' : ?0 }")
    List<ParticipantUser> findByUserProfile(@Param("userId") ObjectId userProfileId);

    @Query("{ 'participantCase.$id':  ?0  ,  'userProfile.$id' : ?1  }")
    ParticipantUser findByParticipantCaseCaseIdAndUserProfileUserId(@Param("caseId") ObjectId caseId, @Param("userId")ObjectId userId);

}
