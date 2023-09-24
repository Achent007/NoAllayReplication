package be.achent.noallayreplication;

import be.achent.noallayreplication.Commands.NoAllayReplicationTabCompleter;
import be.achent.noallayreplication.Commands.NoAllayReplicationCommands;
import be.achent.noallayreplication.Event.Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoAllayReplication extends JavaPlugin {

    public static NoAllayReplication plugin;
    private Messages messages;

    public void onEnable() {
        plugin = this;
        this.messages = new Messages();
        this.messages.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Events(), this);

        getCommand("noallayreplication").setExecutor(new NoAllayReplicationCommands());
        getCommand("noallayreplication").setTabCompleter(new NoAllayReplicationTabCompleter());
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
}