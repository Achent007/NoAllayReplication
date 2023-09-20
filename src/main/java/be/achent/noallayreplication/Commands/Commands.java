package be.achent.noallayreplication.Commands;

import be.achent.noallayreplication.NoAllayReplication;

public class Commands {
    public void init() {
        NoAllayReplication plugin = NoAllayReplication.getInstance();
        plugin.getCommand("noallayreplication").setExecutor(new noallayreplication());
    }
}
