package xyz.baston.forcesleep;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	void onPlayerViolationCommand(final PlayerBedEnterEvent e) {
		if (e.getBedEnterResult() == BedEnterResult.OK) {
			new BukkitRunnable() {
				@Override
				public void run() {
					e.getPlayer().getWorld().setTime(0L);
					e.getPlayer().getWorld().setStorm(false);
					e.getPlayer().getWorld().setThundering(false);

				}
			}.runTaskLater(this, 3 * 20);
		}

	}

}
