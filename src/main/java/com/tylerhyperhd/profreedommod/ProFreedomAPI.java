package com.tylerhyperhd.profreedommod;

import com.tylerhyperhd.profreedommod.utils.EndResulter;
import org.bukkit.entity.Player;

public class ProFreedomAPI {
    private static ProFreedomMod plugin;
    
    public ProFreedomAPI(ProFreedomMod plugin) {
        ProFreedomAPI.plugin = plugin;
    }
    
    public static boolean isAdminAPI(Player player) {
        return plugin.al.isAdmin(player);
    }
    
    public static boolean isOwnerAPI(Player player) {
        return plugin.cg.isOwner(player);
    }
    
    public static void blowupAPI(Player player) {
        EndResulter.blowup(player);
    }
}
