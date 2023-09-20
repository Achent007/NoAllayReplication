package be.achent.noallayreplication.Commands;

import be.achent.noallayreplication.NoAllayReplication;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Commands implements TabCompleter {

    List<String> arguments = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if(arguments.isEmpty()){
            arguments.add("reload");
        }

        List<String> result = new ArrayList<>();
        if(args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
                return result;
            }
        }
        return null;
    }

    public void init() {
        NoAllayReplication plugin = NoAllayReplication.getInstance();
        plugin.getCommand("noallayreplication").setExecutor(new noallayreplication());

    }
}
