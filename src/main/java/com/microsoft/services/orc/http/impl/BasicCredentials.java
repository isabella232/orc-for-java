package com.microsoft.services.orc.http.impl;

import com.microsoft.services.orc.http.Base64Encoder;
import com.microsoft.services.orc.http.Credentials;
import com.microsoft.services.orc.http.Request;

public class BasicCredentials implements Credentials {

    private String user;
    private String password;
    private Base64Encoder encoder;

    public BasicCredentials(String user, String password, Base64Encoder encoder) {
        this.user = user;
        this.password = password;
        this.encoder = encoder;
    }

    @Override
    public void prepareRequest(Request request) {
        request.addHeader("Authorization", "Basic " + encoder.encode((user + ":" + password).getBytes()));
    }

}
