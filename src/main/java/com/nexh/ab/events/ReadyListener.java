package com.nexh.ab.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent e) {
        System.out.printf("Logged in as %#s\n", e.getJDA().getSelfUser());
    }
}
