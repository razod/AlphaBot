package com.nexh.ab;

import com.nexh.ab.commands.*;
import com.nexh.ab.events.HelloEvent;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import com.nexh.ab.BotConfig;

public class Main {
    public static void main(String[] args) throws LoginException {
        new JDABuilder()
                .setToken(BotConfig.TOKEN)
                .addEventListeners(new HelloEvent(), new Calculate())
                .build();
    }
}
