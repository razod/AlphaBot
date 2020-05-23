package com.nexh.ab;

public class BotUtils {
    public static boolean getCommand(String cmd, String msg) {
            if (msg.equalsIgnoreCase(BotConfig.PREFIX + cmd)) {
                return true;
            }
        return false;
    }
}
