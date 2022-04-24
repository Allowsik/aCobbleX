package pl.allowsik;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class cxPlace implements Listener {
    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        //If placed block is cobblestone with displayname §c§lCOBBLEX cancel the event and remove the item from the player's inventory
        if (e.getBlock().getType() == org.bukkit.Material.COBBLESTONE && e.getBlock().getMetadata("displayName").get(0).asString().equals("§c§lCOBBLEX")) {
            e.setCancelled(true);
            e.getPlayer().getInventory().remove(e.getItemInHand());
        }
    }
}
