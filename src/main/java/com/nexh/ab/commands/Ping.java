package com.nexh.ab.commands;

import com.nexh.ab.BotConfig;
import com.nexh.ab.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.time.Instant;
import java.util.List;

public class Ping implements ICommand {
    public void handle(List<String> args, GuildMessageReceivedEvent e) {
        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("Pong!")
                .setTimestamp(Instant.now());
        EmbedBuilder builder2 = new EmbedBuilder()
                .setTitle("Pong!")
                .setDescription(":ping_pong: Ping is `" + e.getJDA().getGatewayPing() + "` ms")
                .setTimestamp(Instant.now());
        e.getChannel().sendMessage(builder.build()).queue((msg) -> {
                    e.getMessage().addReaction("🏓").queue();
                    msg.editMessage(builder2.build()).queue();
                });
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
