package me.noodles.update;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	private UpdateChecker checker;
	public static Main plugin;
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents((Listener) new JoinExample(), (Plugin) this);
		Main.plugin = this;
		this.checker = new UpdateChecker(this);
		if (this.checker.isConnected()) {
			if (this.checker.hasUpdate()) {
				getServer().getConsoleSender().sendMessage("------------------------");
				getServer().getConsoleSender().sendMessage("PluginName is outdated!");
				getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
				getServer().getConsoleSender().sendMessage("Your version: " + Main.plugin.getDescription().getVersion());
				getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/IDHERE");
				getServer().getConsoleSender().sendMessage("------------------------");
			} else {
				getServer().getConsoleSender().sendMessage("------------------------");
				getServer().getConsoleSender().sendMessage("PluginName is up to date!");
				getServer().getConsoleSender().sendMessage("------------------------");
			}
		}
	}
	
}

