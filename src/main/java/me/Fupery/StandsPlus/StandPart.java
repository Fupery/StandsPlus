package me.Fupery.StandsPlus;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public enum StandPart {
    HEAD, BODY, LEFT_ARM, RIGHT_ARM, LEFT_LEG, RIGHT_LEG;

    public String fancyName(boolean colour) {
        String name = "";
        String[] words = name().toLowerCase().split("_");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            name += word.substring(0, 1).toUpperCase() + word.substring(1);
            if (i < words.length - 1) name += " ";
        }
        return colour ? "§e•§6 " + name + " §e•" : ChatColor.BOLD + "Editing " + name;
    }

    public void pose(ArmorStand stand, EulerAngle angle) {
        switch (this) {
            case HEAD:
                stand.setHeadPose(angle);
                break;
            case BODY:
                stand.setBodyPose(angle);
                break;
            case LEFT_ARM:
                stand.setLeftArmPose(angle);
                break;
            case RIGHT_ARM:
                stand.setRightArmPose(angle);
                break;
            case LEFT_LEG:
                stand.setLeftLegPose(angle);
                break;
            case RIGHT_LEG:
                stand.setRightLegPose(angle);
                break;
        }
    }

    public EulerAngle getPose(ArmorStand stand) {
        switch (this) {
            case HEAD:
                return stand.getHeadPose();
            case BODY:
                return stand.getBodyPose();
            case LEFT_ARM:
                return stand.getLeftArmPose();
            case RIGHT_ARM:
                return stand.getRightArmPose();
            case LEFT_LEG:
                return stand.getLeftLegPose();
            case RIGHT_LEG:
                return stand.getRightLegPose();
            default:
                return new EulerAngle(0, 0, 0);
        }
    }
}
