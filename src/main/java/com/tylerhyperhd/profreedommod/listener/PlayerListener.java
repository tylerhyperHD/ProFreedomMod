package com.tylerhyperhd.profreedommod.listener;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private static ProFreedomMod plugin;

    public PlayerListener(ProFreedomMod plugin) {
        PlayerListener.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage(ChatColor.GOLD + "Welcome to ProFreedom, " + player.getName() + "!");
        player.sendMessage(ChatColor.GOLD + "Type \"!help\" for a list of commands.");

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (plugin.cg.isOwner(player)) {
                players.sendMessage(ChatColor.AQUA + player.getName() + " is the " + ChatColor.translateAlternateColorCodes('&', "&9&lOwner &bof &6&lProFreedom"));
            }
            else if (plugin.al.isSAdmin(player)) {
                players.sendMessage(ChatColor.AQUA + player.getName() + " is a " + ChatColor.GOLD + "Solo Admin");
            }
            else if (plugin.al.isProAdmin(player)) {
                players.sendMessage(ChatColor.AQUA + player.getName() + " is a " + ChatColor.RED + "Pro Admin");
            }
            else if (plugin.al.isSrAdmin(player)) {
                players.sendMessage(ChatColor.AQUA + player.getName() + " is a " + ChatColor.GREEN + "Surreal Admin");
            }
            else if (plugin.al.isExecutive(player)) {
                players.sendMessage(ChatColor.AQUA + player.getName() + " is an " + ChatColor.YELLOW + "Executive Admin");
            }
        }
    }
}
