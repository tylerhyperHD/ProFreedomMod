/*
 * This command isn't associated with the handler, but is associated with a listener
*/
package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_help {
    
    private static ProFreedomMod plugin;
    
    public Command_help(ProFreedomMod plugin) {
        Command_help.plugin = plugin;
    }
    
    public boolean run(Player player, String command) {
        if (command.equals("!help")) {
            player.sendMessage(ChatColor.GOLD + "ProFreedom Cmds");
            player.sendMessage(ChatColor.GOLD + "/pro - Displays ProFreedom info");
            player.sendMessage(ChatColor.GOLD + "/survival - go in survival");
            player.sendMessage(ChatColor.GOLD + "/creative - go in creative");
            player.sendMessage(ChatColor.GOLD + "More commands are coming, so stay tuned!");
        }
        
        return true;
    }
}
