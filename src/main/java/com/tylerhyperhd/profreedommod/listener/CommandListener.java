package com.tylerhyperhd.profreedommod.listener;

import com.tylerhyperhd.profreedommod.ProFreedomMod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    
    private static ProFreedomMod plugin;
    
    public CommandListener(ProFreedomMod plugin) {
        CommandListener.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String cmd = event.getMessage();
        
        if (cmd.contains("/help") || cmd.equals("help")) {
            event.setCancelled(true);
            player.sendMessage("Unknown command. Type '!help' for help.");
            return;
        }
        
        if (cmd.equals("!help") || cmd.contains("!help")) {
            event.setCancelled(true);
            plugin.ch.run(player, cmd);
        }
    }
}
