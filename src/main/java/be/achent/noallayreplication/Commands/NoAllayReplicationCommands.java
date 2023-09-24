package be.achent.noallayreplication.Commands;

import be.achent.noallayreplication.NoAllayReplication;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.io.File;

public class NoAllayReplicationCommands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        NoAllayReplication plugin = NoAllayReplication.getInstance();
        if (args.length == 0) {
            if (sender.hasPermission("noallayreplication.reload") || sender.hasPermission("noallayreplication.help")) {
                sender.sendMessage("");
                sender.sendMessage(ChatColor.GOLD + "/noallayreplication" + ChatColor.WHITE + ": Commandes de NoAllayReplication");
                sender.sendMessage(ChatColor.GOLD + "/noallayreplication reload" + ChatColor.WHITE + ": Recharge le fichier de config.");
                sender.sendMessage("");
            } else {
                sender.sendMessage(plugin.getMessage("NoPermission"));
            }
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("noallayreplication.reload")) {
                if (args.length == 1) {
                    File language = new File(plugin.getDataFolder(), "language.yml");
                    if (!language.exists()) {
                        plugin.saveDefaultsMessages();
                    } else {
                        plugin.reloadMessages();
                    }
                    sender.sendMessage(plugin.getMessage("Reloaded"));
                } else {
                    sender.sendMessage("reload");
                }
            } else {
                sender.sendMessage(plugin.getMessage("NoPermission"));
            }
        }
        return false;
    }
}
