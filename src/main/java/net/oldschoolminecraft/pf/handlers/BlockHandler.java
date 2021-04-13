package net.oldschoolminecraft.pf.handlers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class BlockHandler extends BlockListener
{
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (event.getBlock().getType().equals(Material.BURNING_FURNACE))
        {
            event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BURNING_FURNACE, 1));
            event.getBlock().setType(Material.AIR);
            event.setCancelled(true);
        }
    }
}
