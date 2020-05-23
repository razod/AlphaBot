package com.nexh.ab;

import com.nexh.ab.commands.Ping;
import com.nexh.ab.objects.ICommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CommandManager {
    private final Map<String, ICommand> cmds = new HashMap<>();

    public CommandManager() {
        addCommands(new Ping());
    }

    private void addCommands(ICommand cmd) {
        if(!cmds.containsKey(cmd.getInvoke())) {
            cmds.put(cmd.getInvoke(), cmd);
        }
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
