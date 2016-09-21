package me.maxcode.PCNews;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileChecker {

	
	public void checkFiles() {
		
		File file = new File("plugins/PeopleCraft-News/" + "News.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists()) {
			
			try {
				
				
				cfg.set("News." + ".0", "Ich bin die 1 News!");
				cfg.set("News." + ".1", "Ich bin die 2 News!");
				
				
				
				
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	
}
