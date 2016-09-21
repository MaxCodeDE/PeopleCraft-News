package me.maxcode.PCNews;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PCNews extends JavaPlugin {
	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "*" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	public int newsgezeigt = 0;
	
	@Override
	public void onEnable()  {
		
		getCommand("news").setExecutor(new Befehle());
		
		FileChecker fc = new FileChecker();
		fc.checkFiles();
		
		System.out.println("[PeopleCraft-News] wurde aktiviert!");
		news();
		
	}
	
	
	@Override
	public void onDisable() {
		
		System.out.println("[PeopleCraft-News] wurde deaktiviert!");
		
	}
	
	
	
	
	public void news() {
		
		File file = new File("plugins/PeopleCraft-News/" + "News.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		INT_getNewsSize igns = new INT_getNewsSize();
		int newsSize = igns.getNewsSize();
		
		if (!(newsgezeigt == newsSize)) {
			
		Bukkit.broadcastMessage(str + cfg.getString("News." + "." + newsgezeigt));
		newsgezeigt++;
		reRunNews();
		
			
		} else {
			newsgezeigt = 0;
			reRunNews();
		}
		
		
		
	}
	
	public void reRunNews() {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				news();
			}
				
		}, 2400);
		
	}
	
	
	
}
