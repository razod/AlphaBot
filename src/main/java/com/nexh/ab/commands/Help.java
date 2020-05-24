package com.nexh.ab.commands;

import com.nexh.ab.BotConfig;
import com.nexh.ab.command.CommandManager;
import com.nexh.ab.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class Help implements ICommand {

    private final CommandManager manager;
    public Help(CommandManager manager) {
        this.manager = manager;
    }
    private final Random random = new Random();

    @Override
    public String getDesc() {
        return "Shows a list of all the commands.";
    }

    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {

        if(args.isEmpty()) {
            generateAndSendEmbed(event);
            return;
        }

        ICommand cmd = manager.getCommand(String.join("", args));
        if(cmd == null) {
            event.getChannel().sendMessage("This command does not exist!\nUse `" + BotConfig.PREFIX + getInvoke() + "` for a list of commands!").queue();
            return;
        }

        String message = "Command help for `" + cmd.getInvoke() + "`\n" + cmd.getHelp();
        event.getChannel().sendMessage(message).queue();
    }

    private void generateAndSendEmbed(GuildMessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("List of commands")
                .setTimestamp(Instant.now())
                .setColor(getRandomColor());

        StringBuilder desc = builder.getDescriptionBuilder();

        manager.getCommands().forEach((cmd) ->
                        desc.append('`').append(cmd.getInvoke()).append("` - `").append(cmd.getDesc()).append("`\n")
                );

        event.getChannel().sendMessage(builder.build()).queue();
    }

    private Color getRandomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();

        return new Color(r, g, b);
    }

    @Override
    public String getHelp() {
        return "Shows a list of all the commands.\n" +
                "Usage: `" + BotConfig.PREFIX + getInvoke() + " [command]`";
    }

    @Override
    public String getInvoke() {
        return "help";
    }
}
