package be.achent.noallayreplication.Event;

import be.achent.noallayreplication.NoAllayReplication;
import org.bukkit.Material;
import org.bukkit.entity.Allay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.PlayerInventory;

public class NoAllayReplicationEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void AmethystLock(PlayerInteractEntityEvent event) {
        Entity e = event.getRightClicked();

        // Pas nécessaire de check si l'entity n'est pas un allay
        if (e.getType() != EntityType.ALLAY) {
            return;
        }

        PlayerInventory eq = event.getPlayer().getInventory();
        Allay allay = (Allay)e;

        // On vérifie chaque main indépendamment
        if (event.getHand() == EquipmentSlot.HAND) {
            preventDuplication(event, eq.getItemInMainHand().getType(), allay);
        } else if (event.getHand() == EquipmentSlot.OFF_HAND) {
            preventDuplication(event, eq.getItemInOffHand().getType(), allay);
        }
    }

    private void preventDuplication(PlayerInteractEntityEvent event, Material itemInHand, Allay allay) {
        // Si l'allay ne dance pas, pas besoin d'annuler la duplication
        if (!allay.isDancing()) {
            return;
        }

        // Si l'allay a bien une améthyste en main, on empêche la duplication
        if (itemInHand == Material.AMETHYST_SHARD) {
            allay.setCanDuplicate(false);
            event.setCancelled(true);
            event.getPlayer().sendMessage(NoAllayReplication.getInstance().getMessage("Replication-locked"));
        }
    }
}