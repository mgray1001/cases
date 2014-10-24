package com.cases.baratine;

import com.cases.model.mongo.UserProfile;
import io.baratine.core.*;

/**
 * Created by mario on 9/9/14.
 */
@Service
@ResourceService("public:///voter/{email}")
public class VoterRepositoryImpl {

    String email;
    UserProfile voter;

    @BeforeDelete
    public void delete() {
        // nothing needed
    }

    @Modify
    public void update(UserProfile p) {
        this.voter = p;
    }
    @BeforeCreate
    public void create(UserProfile p) {
        this.voter = p;
    }
    @BeforeCreate
    public void quickCreate(String email, String firstName, String lastName ) {
        UserProfile u = new UserProfile(email, firstName, lastName);
        this.voter = u;
    }

    public UserProfile get() {
        return voter;
    }

}
