package fr.noalegeek68.noaplugin.enums;

import fr.noalegeek68.noaplugin.utils.InventoryBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public enum GUI {

    KITS(Bukkit.createInventory(null, 27, ChatColor.GREEN + "Kits")),
    REPORT(new InventoryBuilder("Report").build()),
    INVSEE(Bukkit.createInventory(null, 27, "Inventaire"));

    public final Inventory inventory;

    GUI(Inventory inventory){
        this.inventory = inventory;
    }
}
