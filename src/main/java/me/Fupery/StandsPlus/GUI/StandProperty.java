package me.Fupery.StandsPlus.GUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;

/**
 * Created by aidenhatcher on 10/07/2016.
 */
enum StandProperty {
    VISIBLE("Is Visible", "§7Stand is invisible if off", Material.GLASS_BOTTLE),
    GRAVITY("Has Gravity", "§7Stand has gravity if on", Material.FEATHER),
    BASEPLATE("Show Baseplate", "§7Baseplate is hidden if off", Material.STONE_PLATE),
    ARMS("Show Arms", "§7Arms are hidden if off", Material.STICK),
    SMALL("Is Small", "§7Stand is small if on", Material.EGG);

    private final String propertyName;
    private final String description;
    private final Material icon;

    StandProperty(String name, String description, Material icon) {
        this.propertyName = name;
        this.description = description;
        this.icon = icon;
    }

    String getButtonTitle(boolean value) {
        return String.format("%s: %s", ChatColor.GOLD + propertyName,
                value ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF");
    }

    void apply(ArmorStand stand, boolean value) {
        switch (this) {
            case VISIBLE:
                stand.setVisible(value);
                break;
            case GRAVITY:
                stand.setGravity(value);
                break;
            case BASEPLATE:
                stand.setBasePlate(value);
                break;
            case ARMS:
                stand.setArms(value);
                break;
            case SMALL:
                stand.setSmall(value);
                break;
        }
    }

    boolean getValue(ArmorStand stand) {
        switch (this) {
            case VISIBLE:
                return stand.isVisible();
            case GRAVITY:
                return stand.hasGravity();
            case BASEPLATE:
                return stand.hasBasePlate();
            case ARMS:
                return stand.hasArms();
            case SMALL:
                return stand.isSmall();
            default:
                return false;
        }
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getDescription() {
        return description;
    }

    public Material getIcon() {
        return icon;
    }
}
