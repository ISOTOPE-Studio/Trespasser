package cc.isotopestudio.Trespasser;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Mars on 6/14/2016.
 * Copyright ISOTOPE Studio
 */
public class Trespasser extends JavaPlugin implements Listener {

    private static final String pluginName = "Trespasser";
    static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("ϵͳ").append("]").append(ChatColor.RED).toString();

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(pluginName + "�ɹ�����!");
        getLogger().info(pluginName + "��ISOTOPE Studio����!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "�ɹ�ж��!");
    }

    @EventHandler
    public void onTp(PlayerTeleportEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPermission("world" + event.getTo().getWorld().getName())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.setHealth(0);
                    player.sendMessage(prefix + "��û��Ȩ�����������");
                }
            }.runTaskLater(this, 2);
        }
    }
}
