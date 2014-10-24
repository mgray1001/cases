package com.cases.baratine;

import com.cases.model.mongo.CaseVote;
import com.cases.model.mongo.SimpleVote;
import com.cases.model.mongo.UserProfile;
import com.cases.repository.IVoteRepository;
import io.baratine.core.*;
import org.springframework.data.repository.query.Param;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mario on 8/13/14.
 * TODO: how would one implement a collection of these items
 */
//@ResourceService("public:///case/{caseId}")
public class CaseRepositoryImpl implements IVoteRepository {

    String caseId;
    Set<SimpleVote> votes = new HashSet<SimpleVote>();

    @BeforeCreate
    public void cast(SimpleVote vote) {
                votes.add(vote);

    }


    @BeforeCreate
    public void castVote(String caseId, String pId, String value) {
        if(votes==null) votes = new HashSet<SimpleVote>();
        votes.add(new SimpleVote(pId, value, this.caseId) );

          System.out.println("VOTE CASTED for "  + caseId);
    }

    @Inject
    @Lookup("/voter")
    ResourceManager _resManager;

    public CaseVote findByUser(String voterId) {
        String ql = "email = 'makg.com'";
        ServiceRef serviceRef = _resManager.findOne(ql);
        System.out.println("SVC: " + serviceRef);
        UserProfile profile =  serviceRef.as(UserProfile.class);

        if(profile !=null ) {
            System.out.println(profile.getEmail() +","+profile.getFirstName());
            SimpleVote thisVote = new SimpleVote(voterId, null, null);
            if (votes.contains(thisVote)) {
                for (SimpleVote v : votes) {
                    if (v.equals(thisVote))
                        return findForUser(v.getVoterId());
                }
            }
        }
        return null;
    }

    public CaseVote findForUser( String voterId  ) {return null;} // placeholder

    public void revoke(String voterId) {
        votes.remove(new SimpleVote(voterId,null,null));
    }

    public CaseRepositoryImpl get() {
        return this;

    }

    @BeforeDelete
    public void delete() {
                   // This will delete the resource pointed by the above parameters
        System.out.println("Looks like we're deleting " + caseId)   ;
    }

    @Override
    public void forfeit(@Param("caseId") String caseId, @Param("userId") Long userId) {

    }

    @Override
    public void dismiss(@Param("caseId") String caseId, @Param("userId") Long pId) {

    }
}