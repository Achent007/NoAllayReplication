package be.achent.noallayreplication.Event;

import org.bukkit.Material;
import org.bukkit.entity.Allay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.PlayerInventory;

import static be.achent.noallayreplication.NoAllayReplication.plugin;

public class Event implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void AmethystLock(PlayerInteractAtEntityEvent event) {

        Entity e = event.getRightClicked();
        PlayerInventory eq = event.getPlayer().getInventory();

        if ((e.getType() == EntityType.ALLAY && eq.getItemInMainHand().getType() == Material.AMETHYST_SHARD)){
            event.setCancelled(true);
            Allay allay = (Allay)e;
            allay.setCanDuplicate(false);
            event.getPlayer().sendMessage(plugin.getMessage("Replication-locked"));
        }
    }
}