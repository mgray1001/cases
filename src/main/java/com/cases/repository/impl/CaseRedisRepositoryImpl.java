package com.cases.repository.impl;

import com.cases.model.Case;
import com.cases.repository.ICaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mario on 7/1/14.
 */
@Repository
public class CaseRedisRepositoryImpl implements ICaseRepository {

    static final String VISIT_PART = "VISITPART";
    static final String ACTIVE_PART = "ACTIVEPART";
    static final String OPEN_CASE = "OPEN";

    @Autowired
    RedisTemplate<String, Case> caseRedisTemplate;

    @Resource(name="redisTemplate")
    ListOperations<String, Case> listOps;

    @Override
    public List<Case> getCasesByParticipantId(String pid, int start, int end) {
       return caseRedisTemplate.opsForList().range(VISIT_PART+pid, start, end);
    }

    @Override
    public List<Case> getMyCases(String pid, int start, int end) {
        return caseRedisTemplate.opsForList().range(ACTIVE_PART+pid, start, end);
    }

    @Override
    public List<Case> getAllOpenCases(int start, int end) {
        return caseRedisTemplate.opsForList().range(OPEN_CASE, start, end);
    }

    @Override
    public boolean putCase(Case c) {
        Long i = listOps.leftPush(OPEN_CASE, c);
                 return i!=null && i>0;
    }

}
