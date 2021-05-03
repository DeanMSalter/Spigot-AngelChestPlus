package de.jeff_media.angelchest.utils;

import de.jeff_media.angelchest.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public final class ProtectionUtils {

    public static boolean playerMayBuildHere(final Player p, final Location loc) {
        final Main main = Main.getInstance();
        final BlockPlaceEvent event = new BlockPlaceEvent(loc.getBlock(), loc.getBlock().getState(), loc.getBlock().getRelative(BlockFace.DOWN), new ItemStack(Material.DIRT), p, true, EquipmentSlot.HAND);
        main.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            if(main.debug) main.debug("AngelChest spawn prevented because player " + p.getName() + " is not allowed to place blocks at " + loc.toString());
            return false;
        }
        return true;

    }

}
