package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import static com.tylerhyperhd.profreedommod.commands.ProCmd.PERM_MESSAGE;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_help extends ProCmd {

    private final ProFreedomMod plugin;

    public Command_help(ProFreedomMod plugin) {
        super("help", "help [args]", "Shows the help menu", PERM_MESSAGE, Arrays.asList("prohelp"));
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player sender_p = getSenderP(sender);

        if (args.length == 0) {
            msg(sender, ChatColor.GOLD + "# ProFreedom Cmds #");
            msg(sender, ChatColor.GOLD + "/pro - Displays ProFreedom info");
            msg(sender, ChatColor.GOLD + "/survival - go in survival");
            msg(sender, ChatColor.GOLD + "/creative - go in creative");
            msg(sender, ChatColor.GOLD + "More commands are coming, so stay tuned!");
            if (plugin.al.isAdmin(sender_p)) {
                msg(sender, ChatColor.RED + "Look at admin commands using '/help admin'");
            }
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("admin")) {
                if (!plugin.al.isAdmin(sender_p)) {
                    msgNoPerms(sender);
                    return true;
                }
                msg(sender, ChatColor.RED + "# Admin Commands #");
                if (plugin.al.isAtLeastSAdmin(sender_p)) {
                    msg(sender, ChatColor.RED + "/ban - Ban a player");
                    msg(sender, ChatColor.RED + "/opall - Op all players on the server");
                }
                msg(sender, ChatColor.RED + "More commands are coming, so stay tuned!");
                return true;
            }
        }
        return true;
    }
}
