package me.Fupery.StandsPlus.Recipe;

import me.Fupery.StandsPlus.Utils.Lang;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class StandKey extends ItemStack {
    private static String STAND_KEY = "§b§oStandKey";

    private StandKey() {
        super(Material.TRIPWIRE_HOOK);
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(Lang.STAND_KEY_NAME.message());
        meta.setLore(Arrays.asList(STAND_KEY,
                Lang.STAND_KEY_LORE_CLICK.message(),
                Lang.STAND_KEY_LORE_ROTATE.message()));
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
