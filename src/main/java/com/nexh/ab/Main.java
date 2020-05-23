package com.nexh.ab;

import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    private Main() throws LoginException {
        new JDABuilder()
                .setToken("")
                .addEventListeners()
                .build();
    }
}
