package com.cases.repository.impl.mongo;

import com.cases.model.Case;
import com.cases.model.UserProfile;
import com.cases.repository.ICaseRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mario on 7/22/14.
 */
@RepositoryRestResource(itemResourceRel = "caseone", collectionResourceRel = "cases", path = "case")
public interface CaseMongoRepository extends MongoRepository<Case, String>, ICaseRepository {

    @Query("{ 'plantiff.userProfile.userId' : ?0 }")
    List<Case> findByPlantiff(@Param("userId") Long userId);

    @Query("{ 'defendant.userProfile.userId' : ?0 }")
    List<Case> findByDefendant(@Param("userId") Long userId);

    List<Case> findByCaseId(@Param("caseId") String caseId);

    @Query("{ 'end $ne \'\'' ")
    List<Case> findOpenCases();

    @Query(" { 'description': /.*?0.*/ }")
    List<Case> findByDescriptionLike(@Param("description") String desc);

    Case findByJid(@Param("roomId") String roomId);

}
