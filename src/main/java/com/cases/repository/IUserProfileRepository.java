package com.cases.repository;

import com.cases.model.mongo.UserProfile;

import java.util.List;

/**
 * Created by mario.gray on 6/30/14.
 */
public interface IUserProfileRepository {

    UserProfile loginUser(String token, String password );

    UserProfile getUserProfileByJid(String jabberId);

    UserProfile getUserProfileByUid(String userId);

    List<UserProfile> gerUserProfilesByCaseId(String participantCaseId);


}
