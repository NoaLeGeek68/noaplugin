package fr.noalegeek68.noaplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(player.getDisplayName() + " " + player.getName());
            player.sendMessage("§aDites bienvenue à " + player.getDisplayName() + " sur le serveur " + player.getServer().getName() + ".");
            return true;
        }
        return false;
    }
}
