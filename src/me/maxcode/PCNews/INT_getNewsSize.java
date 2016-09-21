package me.maxcode.PCNews;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class INT_getNewsSize {

	
	
	public int getNewsSize() {
		
		File file = new File("plugins/PeopleCraft-News/" + "News.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		
		int newsSize = 0;
		
		for (String s : cfg.getConfigurationSection("News.").getKeys(false)) {
			
			newsSize++;
			s.getBytes();
			
		}
		
		
		
		
		
		return newsSize;
		
		
		
	}
	
	
	
	
	
}
