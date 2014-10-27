package com.cases.repository;

import com.cases.model.mongo.ParticipantUser;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by mario on 10/1/14.
 */
public interface ParticipantRepository {

    List<ParticipantUser> findByParticipantCaseCaseId(ObjectId caseId);
    List<ParticipantUser> findByUserProfile(ObjectId userProfileId);

}
