/*
 * (c) 2016 tylerhyperHD
 */
package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import com.tylerhyperhd.profreedommod.utils.EndResulter;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_ban extends ProCmd {

    private final ProFreedomMod plugin;

    public Command_ban(ProFreedomMod plugin) {
        super("ban", "ban [player] [reason]", "Bans a player.", PERM_MESSAGE, Arrays.asList("gtfo"));
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }

}
