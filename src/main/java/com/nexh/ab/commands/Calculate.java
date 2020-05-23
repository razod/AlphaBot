package com.nexh.ab.commands;

import com.nexh.ab.BotUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] msg = e.getMessage().getContentRaw().split(" ");
        if(BotUtils.getCommand("calculate", msg[0])) {
            e.getChannel().sendMessage("hello").queue();
        }
    }
}
