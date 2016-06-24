/*
 * (c) 2016 tylerhyperHD
 */
package com.tylerhyperhd.profreedommod.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class EndResulter {
    
    public static void blowup(Player player) {
        World w = player.getWorld();
        
        for (Player cp : Bukkit.getOnlinePlayers()) {
            World nw = cp.getWorld();
            w.playSound(cp.getLocation(), Sound.ENTITY_GHAST_SCREAM, 10, 1);
        }
        
        w.createExplosion(player.getLocation(), 0F, false);
    }
    
}
