package com.nexh.ab;

import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import com.nexh.ab.BotConfig;

public class Main {
    public static void main(String[] args) throws LoginException {
        new JDABuilder()
                .setToken(BotConfig.TOKEN)
                // .addEventListeners()
                .build();
    }
}
