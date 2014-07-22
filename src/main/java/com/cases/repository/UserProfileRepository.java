package com.cases.repository;

import com.cases.model.UserProfile;

import java.util.List;

/**
 * Created by mario.gray on 6/30/14.
 */
public interface UserProfileRepository {

    UserProfile loginUser(String token, String password );

    UserProfile getUserProfileByJid(String jabberId);

    UserProfile getUserProfileByUid(String userId);

    List<UserProfile> gerUserProfilesByCaseId(String participantCaseId);


}
