package com.tylerhyperhd.profreedommod;

import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Player;

public class AdminList {
    
    private static ProFreedomMod plugin;
    
    public AdminList(ProFreedomMod plugin) {
        AdminList.plugin = plugin;
    }
    
    // Haven't started making config-based admin list, will do in a later release
    private static final List<String> S_ADMINS = Arrays.asList(
            "");
    private static final List<String> PRO_ADMINS = Arrays.asList(
            "");
    private static final List<String> SR_ADMINS = Arrays.asList(
            "DragonFire147");
    private static final List<String> EXECUTIVES = Arrays.asList(
            "Generic_Trees");    
    
    
    public boolean isSAdmin(Player player) {
        if (S_ADMINS.contains(player.getName())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isProAdmin(Player player) {
        if (PRO_ADMINS.contains(player.getName())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isSrAdmin(Player player) {
        if (SR_ADMINS.contains(player.getName())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isExecutive(Player player) {
        if (EXECUTIVES.contains(player.getName())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isAdmin(Player player) {
        if(S_ADMINS.contains(player.getName()) || PRO_ADMINS.contains(player.getName()) || SR_ADMINS.contains(player.getName()) || EXECUTIVES.contains(player.getName()) || plugin.cg.isOwner(player)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isAtLeastSAdmin(Player player) {
        return isAdmin(player);
    }
}
