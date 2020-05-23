package com.nexh.ab;

import com.nexh.ab.commands.*;
import com.nexh.ab.objects.ICommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.*;
import java.util.regex.Pattern;

public class CommandManager {
    private final Map<String, ICommand> cmds = new HashMap<>();

    private CommandManager() {
        addCommands(new Ping());
        addCommands(new Help(this));
    }

    private void addCommands(ICommand cmd) {
        if(!cmds.containsKey(cmd.getInvoke())) {
            cmds.put(cmd.getInvoke(), cmd);
        }
    }

    public Collection<ICommand> getCommands() {
        return cmds.values();
    }

    public ICommand getCommand(String name) {
        return cmds.get(name);
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        final String[] split = e.getMessage().getContentRaw().replaceFirst(
                 "(?i)" + Pattern.quote(BotConfig.PREFIX), "").split("\\s+");
        final String invoke = split[0].toLowerCase();
        if(cmds.containsKey(invoke)) {
            final List<String> args = Arrays.asList(split).subList(1, split.length);

            cmds.get(invoke).handle(args, e);
        }
    }
}
