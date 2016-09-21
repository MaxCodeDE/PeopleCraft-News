package me.maxcode.PCNews;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Befehle implements CommandExecutor {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "*" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		
		if (cmd.getName().equalsIgnoreCase("news")) {
			
			if (args.length == 0) 
			
			p.sendMessage(str + "Ein News-System von PeopleCraft!");
			
			}
			
		if (args.length == 1) {
		if (args[0].equalsIgnoreCase("hinzu")) {
		if (p.isOp()) {	
		
			File file = new File("plugins/PeopleCraft-News/" + "News.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			int newssize = cfg.getConfigurationSection("News.").getKeys(false).size();
			
			cfg.set("News." + "." + newssize, "News hier eintragen");
			
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			p.sendMessage(str + "Du hast die " + newssize + " News hinzugefuegt!");
			p.sendMessage(str + "Oeffne die News.yml in schreibe dort deine News hin.");
			
			
		}
		}	
		
		
		
		
		
		
		
		
		}
		
		return false;
	}

}
