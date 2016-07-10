package me.Fupery.StandsPlus.GUI.API;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public interface MenuListener extends Listener {

    @EventHandler
    void onMenuInteract(final InventoryClickEvent event);

    @EventHandler
    void onItemDrag(InventoryDragEvent event);

    @EventHandler
    void onMenuClose(InventoryCloseEvent event);

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent event);

    @EventHandler
    void onPlayerDeath(PlayerDeathEvent event);

    ConcurrentHashMap<UUID, InventoryMenu> getOpenMenus();
}
