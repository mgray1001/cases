package com.cases.repository.impl.mongo;

import com.cases.model.ChatLine;
import com.cases.model.ParticipantUser;
import com.cases.repository.ICaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mario on 9/16/14.
 */
public class CaseMongoRepositoryImpl implements ICaseRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void chatToCase(@Param("partId") String partUserId, @Param("text") String text) {
        ParticipantUser p = mongoTemplate.findById(partUserId, ParticipantUser.class);
        mongoTemplate.save(new ChatLine(p, text));
    }


    public List<ChatLine> findChatsByCase(@Param("caseId") String caseId) {
        Query query  = new Query(Criteria.where("relCase.$id").is(new ObjectId(caseId)));


        return mongoTemplate.find(query, ChatLine.class);

    }
}
