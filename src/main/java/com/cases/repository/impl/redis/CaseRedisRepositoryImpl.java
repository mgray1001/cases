package com.cases.repository.impl.redis;

import com.cases.model.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mario on 7/1/14.
 */
public class CaseRedisRepositoryImpl  {

    static final String VISIT_PART = "VISITPART";
    static final String ACTIVE_PART = "ACTIVEPART";
    static final String OPEN_CASE = "OPEN";

    @Autowired
    RedisTemplate<String, Forum> caseRedisTemplate;

    @Resource(name="redisTemplate")
    ListOperations<String, Forum> listOps;

    public List<Forum> getCasesByParticipantId(String pid, int start, int end) {
       return caseRedisTemplate.opsForList().range(VISIT_PART+pid, start, end);
    }

    public List<Forum> getMyCases(String pid, int start, int end) {
        return caseRedisTemplate.opsForList().range(ACTIVE_PART+pid, start, end);
    }

    public List<Forum> getAllOpenCases(int start, int end) {
        return caseRedisTemplate.opsForList().range(OPEN_CASE, start, end);
    }

    public boolean putCase(Forum c) {
        Long i = listOps.leftPush(OPEN_CASE, c);
                 return i!=null && i>0;
    }

}
