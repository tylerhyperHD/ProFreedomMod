/*
 * (c) 2016 tylerhyperHD
 */
package com.tylerhyperhd.profreedommod;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ConfigGrabber {
    
    private static ProFreedomMod plugin;
    
    public ConfigGrabber(ProFreedomMod plugin) {
        ConfigGrabber.plugin = plugin;
    }
    
    public String getOwner() {
        FileConfiguration config = plugin.getDefaultConfig();
        
        return config.getString("server_owner");
    }
    
    public boolean isOwner(Player player) {
        if (player.getName().equals(getOwner())) {
            return true;
        }
        else {
            return false;
        }
    }
}