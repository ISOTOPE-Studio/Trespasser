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
            .append("系统").append("]").append(ChatColor.RED).toString();

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "成功卸载!");
    }

    @EventHandler
    public void onTp(PlayerTeleportEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPermission("world" + event.getTo().getWorld().getName())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.setHealth(0);
                    player.sendMessage(prefix + "你没有权限在这个世界");
                }
            }.runTaskLater(this, 2);
        }
    }
}
