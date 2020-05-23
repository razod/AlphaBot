package com.nexh.ab.events;


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String messageSent = e.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("pickle") || messageSent.equalsIgnoreCase("pickles")) {
            e.getChannel().sendMessage("`LOL!` You must love pickles!").queue();
        }

    }
}
