package be.achent.noallayreplication;

import be.achent.noallayreplication.Commands.NoAllayReplicationTabCompleter;
import be.achent.noallayreplication.Commands.NoAllayReplicationCommands;
import be.achent.noallayreplication.Event.NoAllayReplicationEvents;
import be.achent.noallayreplication.chatcolorhandler.ChatColorHandler;
import be.achent.noallayreplication.chatcolorhandler.parsers.custom.MiniMessageParser;
import be.achent.noallayreplication.chatcolorhandler.parsers.custom.PlaceholderAPIParser;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class NoAllayReplication extends JavaPlugin {

    public static NoAllayReplication plugin;
    private Messages messages;

    public void onEnable() {
        plugin = this;
        this.messages = new Messages();
        this.messages.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new NoAllayReplicationEvents(), this);

        getCommand("noallayreplication").setExecutor(new NoAllayReplicationCommands());
        getCommand("noallayreplication").setTabCompleter(new NoAllayReplicationTabCompleter());
    }

    public static NoAllayReplication getInstance() {
        return plugin;
    }

    public String getMessage(String path) {
        return ChatColorHandler.translateAlternateColorCodes(this.messages.get().getString(path), List.of(PlaceholderAPIParser.class, MiniMessageParser.class));
    }

    public void reloadMessages() {
        this.messages.reload();
    }

    public void saveDefaultsMessages() {
        this.messages.saveDefaultConfig();
    }
}