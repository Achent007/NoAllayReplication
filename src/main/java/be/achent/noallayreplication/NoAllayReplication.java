package be.achent.noallayreplication;

import be.achent.noallayreplication.Commands.Commands;
import be.achent.noallayreplication.Event.Event;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoAllayReplication extends JavaPlugin {

    public Commands commands;
    public static NoAllayReplication plugin;
    private Messages messages;

    public void onEnable() {
        plugin = this;
        this.messages = new Messages();
        this.commands = new Commands();
        this.messages.saveDefaultConfig();
        this.commands.init();
        getServer().getPluginManager().registerEvents((Listener)new Event(), this);
        (this.getCommand("noallayreplication")).setTabCompleter(new Commands());
    }

    public static NoAllayReplication getInstance() {
        return plugin;
    }

    public String getMessage(String path) {
        return ChatColor.translateAlternateColorCodes('&', this.messages.get().getString(path));
    }

    public void reloadMessages() {
        this.messages.reload();
    }

    public void saveDefaultsMessages() {
        this.messages.saveDefaultConfig();
    }

    public static NoAllayReplication getPlugin() {
        return plugin;
    }

}