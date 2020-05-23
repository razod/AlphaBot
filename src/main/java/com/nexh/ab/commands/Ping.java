package com.nexh.ab.commands;

import com.nexh.ab.BotConfig;
import com.nexh.ab.objects.ICommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Ping implements ICommand {
    public void handle(List<String> args, GuildMessageReceivedEvent e) {
        e.getChannel().sendMessage("Pong!").queue((message) ->
                    message.editMessageFormat(":ping_pong: Ping is %sms", e.getJDA().getGatewayPing()).queue()
                );
    }

    @Override
    public String getDesc() {
        return "Pong!";
    }

    public String getHelp() {
        return "Pong!\n" +
                "Usage: `" + BotConfig.PREFIX + getInvoke() + "`";
    }

    public String getInvoke() {
        return "ping";
    }
}
