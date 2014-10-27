package com.cases.repository.impl.mongo;

import com.cases.model.mongo.Forum;
import com.cases.repository.ICaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mario on 7/22/14.
 */
@RepositoryRestResource(itemResourceRel = "forum", collectionResourceRel = "forums", path = "forum")
public interface CaseMongoRepository extends MongoRepository<Forum, String>, ICaseRepository {

    @Query("{ 'plantiff.userProfile.userId' : ?0 }")
    List<Forum> findByPlantiff(@Param("userId") Long userId);

    @Query("{ 'defendant.userProfile.userId' : ?0 }")
    List<Forum> findByDefendant(@Param("userId") Long userId);

    List<Forum> findByCaseId(@Param("caseId") String caseId);

    @Query("{ 'end' :{'$ne':''} } ")
    List<Forum> findOpenCases();

    //@Query(" { 'description': /?0/ }")
    List<Forum> findByDescriptionLike(@Param("description") String desc);

    Forum findByJid(@Param("roomId") String roomId);

}
