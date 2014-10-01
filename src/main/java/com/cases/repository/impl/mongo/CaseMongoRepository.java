package com.cases.repository.impl.mongo;

import com.cases.model.Case;
import com.cases.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mario on 7/22/14.
 */
@RepositoryRestResource(collectionResourceRel = "case", path= "case")
public interface CaseMongoRepository extends MongoRepository<Case, String> {

        @Query("{ 'plantiff.userProfile.userId' : ?0 }")
    Case    findByPlantiff(@Param("userId") Long userId);
        @Query("{ 'defendant.userProfile.userId' : ?0 }")
    Case    findByDefendant(@Param("userId") Long userId);

    Case    findByCaseId(@Param("caseId") String caseId);
    Case    findByDescriptionLike(@Param("description") String desc);

    Case    findByJid(@Param("roomId")String roomId);


}
