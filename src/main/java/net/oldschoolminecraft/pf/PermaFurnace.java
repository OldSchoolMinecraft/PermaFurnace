package net.oldschoolminecraft.pf;

import net.oldschoolminecraft.pf.handlers.BlockHandler;
import net.oldschoolminecraft.pf.handlers.PlayerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class PermaFurnace extends JavaPlugin
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerHandler(), this);

        System.out.println("PermaFurnace enabled.");
    }

    public void onDisable()
    {
        System.out.println("PermaFurnace disabled.");
    }
}
