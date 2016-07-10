package me.Fupery.StandsPlus.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by aidenhatcher on 10/07/2016.
 */
public class StandKey extends ItemStack {
    private static String STAND_KEY = "§b§oStandKey";

    private StandKey() {
        super(Material.TRIPWIRE_HOOK);
        ItemMeta meta = getItemMeta();
        meta.setDisplayName("§e§l•§6§lArmor Stand Hook§e§l•");
        meta.setLore(Arrays.asList(
                ChatColor.AQUA + "§oStandKey",
                ChatColor.GRAY + "Right-Click an §aArmor Stand",
                ChatColor.GRAY + "To rotate and edit its parts."));
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 1);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        setItemMeta(meta);
    }

    public static boolean isValidMaterial(ItemStack itemStack) {
        return itemStack.getType() == Material.TRIPWIRE_HOOK && itemStack.hasItemMeta()
                && itemStack.getItemMeta().hasLore() && itemStack.getItemMeta().getLore().get(0).equals(STAND_KEY);
    }

    public static void addRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new StandKey());
        recipe.shape(".w.", "sxs", ".w.");
        recipe.setIngredient('w', Material.WEB);
        recipe.setIngredient('s', Material.SLIME_BALL);
        recipe.setIngredient('x', Material.TRIPWIRE_HOOK);
        Bukkit.addRecipe(recipe);
    }
}
