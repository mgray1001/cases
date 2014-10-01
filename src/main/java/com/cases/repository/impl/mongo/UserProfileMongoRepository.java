package com.cases.repository.impl.mongo;

import com.cases.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mario on 7/14/14.
 */
@RepositoryRestResource(collectionResourceRel = "user", path="user")
public interface UserProfileMongoRepository extends MongoRepository<UserProfile, Long> {

    UserProfile findByUserId(@Param("userId") Long id);
    UserProfile findByEmail(@Param("email") String email);
    UserProfile findByFbToken(@Param("fbToken") String fbToken);
    UserProfile findByTwitterToken(@Param("twitterToken") String twoken);
}
