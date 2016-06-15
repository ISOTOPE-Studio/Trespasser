package cc.isotopestudio.Trespasser;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Mars on 6/14/2016.
 * Copyright ISOTOPE Studio
 */
public class Trespasser extends JavaPlugin {

    private static final String pluginName = "Trespasser";
    private static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("ϵͳ").append("]").append(ChatColor.RED).toString();

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (final Player player : Bukkit.getOnlinePlayers()) {
                    if (!player.hasPermission("world." + player.getLocation().getWorld().getName())) {
                        player.setHealth(0);
                        player.sendMessage(prefix + "��û��Ȩ�����������");
                    }
                }
            }
        }.runTaskTimer(this, 40, 20);
        getLogger().info(pluginName + "�ɹ�����!");
        getLogger().info(pluginName + "��ISOTOPE Studio����!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "�ɹ�ж��!");
    }

}
