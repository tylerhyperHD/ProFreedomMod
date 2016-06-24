package com.tylerhyperhd.profreedommod.commands;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import static com.tylerhyperhd.profreedommod.commands.ProCmd.PERM_MESSAGE;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_opall extends ProCmd {

    private final ProFreedomMod plugin;

    public Command_opall(ProFreedomMod plugin) {
        super("opall", "opall [-c | -s]", "Op all players on the server.", PERM_MESSAGE, Arrays.asList("op-all"));
        this.plugin = plugin;
    }

    public void opPpl(Player player_p) {
        adminAnnounce(player_p, ChatColor.AQUA, "Opping all players on the server");
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setOp(true);
            player.sendMessage(U_R_OP);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player sender_p = getSenderP(sender);

        if (!plugin.al.isAdmin(sender_p)) {
            msgNoPerms(sender);
            return true;
        }

        if (args.length == 0) {
            opPpl(sender_p);
            return true;
        }
        if (args.length == 1) {

            if (args[0].equalsIgnoreCase("-c")) {
                opPpl(sender_p);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.setGameMode(GameMode.CREATIVE);
                }
                return true;
            }
            else if (args[0].equalsIgnoreCase("-s")) {
                opPpl(sender_p);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.setGameMode(GameMode.SURVIVAL);
                }
                return true;
            }

        }
        return true;
    }
}
