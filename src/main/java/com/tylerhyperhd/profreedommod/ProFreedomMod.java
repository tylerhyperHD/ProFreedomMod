package com.tylerhyperhd.profreedommod;

import com.tylerhyperhd.profreedommod.commands.Command_ban;
import com.tylerhyperhd.profreedommod.commands.Command_creative;
import com.tylerhyperhd.profreedommod.commands.Command_help;
import com.tylerhyperhd.profreedommod.commands.Command_pro;
import com.tylerhyperhd.profreedommod.commands.Command_survival;
import com.tylerhyperhd.profreedommod.commands.ProCmd;
import com.tylerhyperhd.profreedommod.listener.CommandListener;
import com.tylerhyperhd.profreedommod.listener.PlayerListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ProFreedomMod extends JavaPlugin {

    public static ProFreedomMod plugin;
    public static PluginLogger logger;
    public ConfigGrabber cg;
    public AdminList al;
    public Command_help ch;
    private File defaultConfigFile = null;
    private FileConfiguration defaultConfig = null;
    private FileConfiguration banConfig = null;
    private File banConfigFile = null;

    @Override
    public void onLoad() {
        ProFreedomMod.plugin = this;
        ProFreedomMod.logger = new PluginLogger(plugin);
        this.cg = new ConfigGrabber(plugin);
        this.al = new AdminList(plugin);
        this.ch = new Command_help(plugin);
    }

    @Override
    public void onEnable() {
        registerCmds();
        saveDefaultConfig();
        getBanConfig();
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(plugin), plugin);
        pm.registerEvents(new CommandListener(plugin), plugin);
        
        PluginLogger.info("ProFreedomMod has been enabled!");
        PluginLogger.info("ProFreedomMod by tylerhyperHD");
        PluginLogger.info("ProFreedomMod v" + plugin.getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        saveBanConfig();
        PluginLogger.info("ProFreedomMod has been disabled!");
    }

    public void registerCmds() {
        ProCmd pro = new Command_pro(plugin);
        pro.register();
        ProCmd ban = new Command_ban(plugin);
        ban.register();
        ProCmd creative = new Command_creative(plugin);
        creative.register();
        ProCmd survival = new Command_survival(plugin);
        survival.register();
    }

    @Override
    public void saveDefaultConfig() {
        if (defaultConfig == null || defaultConfigFile == null) {
            return;
        }
        try {
            getDefaultConfig().save(defaultConfigFile);
        } catch (IOException ex) {
            PluginLogger.severe("Could not save config to " + defaultConfigFile + "\n" + ex);
        }
    }

    public FileConfiguration getDefaultConfig() {
        if (defaultConfig == null) {
            try {
                reloadDefaultConfig();
            } catch (UnsupportedEncodingException ex) {
                PluginLogger.severe(ex);
            }
        }
        return defaultConfig;
    }

    public void reloadDefaultConfig() throws UnsupportedEncodingException {
        if (defaultConfigFile == null) {
            PluginLogger.info("config.yml doesn't exist, creating it.");
            defaultConfigFile = new File(getDataFolder(), "config.yml");
        }
        defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigFile);

        // Look for defaults in the jar
        Reader defConfigStream = new InputStreamReader(plugin.getResource("config.yml"), "UTF8");
            if (defConfigStream != null) {
                YamlConfiguration defConfigc = YamlConfiguration.loadConfiguration(defConfigStream);
                defaultConfig.setDefaults(defConfigc);
            }
    }

    public FileConfiguration getBanConfig() {
        if (banConfig == null) {
            try {
                reloadBanConfig();
            } catch (UnsupportedEncodingException ex) {
                PluginLogger.severe(ex);
            }
        }
        return banConfig;
    }

    public void saveBanConfig() {
        if (banConfig == null || banConfigFile == null) {
            return;
        }
        try {
            getBanConfig().save(banConfigFile);
        } catch (IOException ex) {
            PluginLogger.severe("Could not save config to " + banConfigFile + "\n" + ex);
        }
    }

    public void reloadBanConfig() throws UnsupportedEncodingException {
        if (banConfigFile == null) {
            PluginLogger.info("bans.yml doesn't exist, creating it.");
            banConfigFile = new File(getDataFolder(), "bans.yml");
        }
        banConfig = YamlConfiguration.loadConfiguration(banConfigFile);

        // Look for defaults in the jar
        Reader banConfigStream = new InputStreamReader(plugin.getResource("bans.yml"), "UTF8");
            if (banConfigStream != null) {
                YamlConfiguration banConfigc = YamlConfiguration.loadConfiguration(banConfigStream);
                banConfig.setDefaults(banConfigc);
            }
    }
}
