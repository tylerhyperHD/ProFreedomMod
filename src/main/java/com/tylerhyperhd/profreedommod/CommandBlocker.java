/*
 * (c) 2016 tylerhyperHD
 */
package com.tylerhyperhd.profreedommod;

import java.util.Arrays;
import java.util.List;

public class CommandBlocker {
    
    private static ProFreedomMod plugin;
    
    public CommandBlocker(ProFreedomMod plugin) {
        CommandBlocker.plugin = plugin;
    }
    
    private static final List<String> BLOCKED_CMDS = Arrays.asList(
    "antioch",
    "mail",
    "summon",
    "gamemode");
    
    
    public List<String> getBlockedCmds() {
        return BLOCKED_CMDS;
    }
    
}
