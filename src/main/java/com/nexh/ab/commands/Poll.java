package com.nexh.ab.commands;

import com.nexh.ab.BotConfig;
import com.nexh.ab.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class Poll implements ICommand {

    private final Random random = new Random();

    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {
        String msg = String.join(" ", args);
        EmbedBuilder builder = new EmbedBuilder()
                .setDescription(msg)
                .setTimestamp(Instant.now())
                .setColor(getRandomColor());
        event.getMessage().delete().queue();
        event.getChannel().sendMessage(builder.build()).queue(message -> {
                    message.addReaction("👍").queue();
                    message.addReaction("👎").queue();
                });
    }

    @Override
    public String getHelp() {
        return "Create a simple poll!\n" +
                "Usage: `" + BotConfig.PREFIX + getInvoke() + "`";
    }

    @Override
    public String getInvoke() {
        return "poll";
    }

    @Override
    public String getDesc() {
        return "Create a simple poll!";
    }

    private Color getRandomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();

        return new Color(r, g, b);
    }
}
