package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_pro extends ProCmd {

    private final ProFreedomMod plugin;
    public Command_pro(ProFreedomMod plugin) {
        super("pro", "pro", "Displays information about PFM.", PERM_MESSAGE, Arrays.asList("pfm"));
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        msg(sender, ChatColor.GREEN + "ProFreedomMod, created by tylerhyperHD.");
        msg(sender, ChatColor.GOLD + "More information about the mod coming soon!");
        return true;
    }
}