package com.nexh.ab;

import com.nexh.ab.events.CommandListener;
import com.nexh.ab.events.ReadyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;

public class Main {
    private Main() throws LoginException {
        new JDABuilder(AccountType.BOT)
                .setToken(BotConfig.TOKEN)
                .addEventListeners(new ReadyListener(), new CommandListener())
                .build();
    }
    public static void main(String[] args) throws LoginException {
        new Main();
    }
}
