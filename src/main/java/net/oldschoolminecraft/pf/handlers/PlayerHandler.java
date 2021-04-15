package net.oldschoolminecraft.pf.handlers;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

public class PlayerHandler extends PlayerListener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType().equals(Material.BURNING_FURNACE) && isEmpty(((Furnace)event.getClickedBlock().getState()).getInventory().getContents()))
            event.setUseInteractedBlock(Event.Result.DENY);
    }

    private boolean isEmpty(ItemStack[] inv)
    {
        for (ItemStack stack : inv)
            if (stack != null)
                return false;
        return true;
    }
}
