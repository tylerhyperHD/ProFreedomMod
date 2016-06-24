package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_survival extends ProCmd {

    private final ProFreedomMod plugin;
    public Command_survival(ProFreedomMod plugin) {
        super("survival", "survival [player]", "Sets gamemode to survival.", PERM_MESSAGE, Arrays.asList("gms"));
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (args.length == 0) {
            Player sender_p = getSenderP(sender);
            
            msg(sender, ChatColor.GOLD + "You set your gamemode to " + ChatColor.RED + "SURVIVAL");
            sender_p.setGameMode(GameMode.SURVIVAL);
            msg(sender, "Your gamemode has been updated.");
            
            return true;
        }
        if (args.length == 1) {
            Player player = getPlayer(args[0]);
            Player sender_p = getSenderP(sender);
            
            if (player == null) {
                notFound(sender);
            }
            
            if(!plugin.al.isAdmin(sender_p)) {
                msgNoPerms(sender);
                return true;
            }
            
            msg(sender, ChatColor.GOLD + sender.getName() + " set your gamemode to " + ChatColor.RED + "SURVIVAL");
            player.setGameMode(GameMode.SURVIVAL);
            msg(sender, "Your gamemode has been updated.");
        }
        
        
        return true;
    }
}