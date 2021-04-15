package net.oldschoolminecraft.pf.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Furnace;
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
            if (!isEmpty(((Furnace)event.getBlock().getState()).getInventory().getContents()))
                return;

            event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BURNING_FURNACE, 1));
            event.getBlock().setType(Material.AIR);
            event.setCancelled(true);
        }
    }

    private boolean isEmpty(ItemStack[] inv)
    {
        for (ItemStack stack : inv)
            if (stack != null)
                return false;
        return true;
    }
}
