package com.cases.repository;

import com.cases.model.mongo.ParticipantUser;

import java.util.List;

/**
 * Created by mario on 10/1/14.
 */
public interface ParticipantRepository {

    List<ParticipantUser> findByParticipantCase(String caseId);
    ParticipantUser findByUserProfile(String userProfileId);

}
