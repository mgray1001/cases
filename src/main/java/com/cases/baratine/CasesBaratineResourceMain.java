package com.cases.baratine;

import com.cases.baratine.VoterRepositoryImpl;
import com.cases.model.UserProfile;
import com.caucho.amp.hamp.ClientHamp;
import com.caucho.baratine.Baratine;
import io.baratine.core.*;
import io.baratine.db.DatabaseService;

/**
 * Created by mario on 9/9/14.
 */
public class CasesBaratineResourceMain {
              static  void log(String msg) {System.out.println(msg); }
    public static void main(String[] args) {

        ServiceManager localSM = testEmbedded();
        DatabaseService _db =
            localSM.lookup("bardb:///").as(DatabaseService.class);
        String ql = "email = 'makg.com'";

        _db.findOne(ql);


    }

    static void testRemoteCall() {
        String url = "http://localhost:8085/s/pod/";
        String suffix="/makg.com";

        ClientHamp client = new ClientHamp(url);
        client.connect();
        boolean isAct =  client.isActive()       ;
        StringBuffer msg = new StringBuffer();
        client.currentMessage().getHeaders().forEach(
                o -> msg.append( o.getKey() + "," + o.getValue() )
        );

        log (" - " + msg + " // " + isAct );

        ServiceRef myRef =  client.lookup("/voter" + suffix);
        VoterRepositoryImpl repo = myRef.as(VoterRepositoryImpl.class);

        UserProfile p = repo.get();
        if(p!=null)
            log("Profile name: " + repo.get().getFirstName());
        else
            log("Not there.");
        //  System.out.println("email: " + profile.getEmail());

    }

    static ServiceManager testEmbedded() {
        ServiceManager sm = Baratine.newManager().build();

        VoterRepositoryImpl voteRepo = sm.service(new VoterRepositoryImpl()).bind("/voter/makg.com").as(VoterRepositoryImpl.class);

        voteRepo.quickCreate("makg.com","ma","gr");


        return sm;
    }
}
