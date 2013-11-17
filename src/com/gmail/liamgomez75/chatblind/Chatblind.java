package com.gmail.liamgomez75.chatblind;
 
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.Location;
/**
 *
 * @author Liam Gomez
 */
public class Chatblind extends JavaPlugin
{
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("Chatblind"))
        {
            if (args.length > 1)
            {
                if (args[0].equalsIgnoreCase("alert"))
                {
                    if (sender instanceof Player)
                    {
                        Player player = (Player) sender;
                        if (!player.hasPermission("chatblind.alert"))
                        {
                            player.sendMessage(ChatColor.RED + "You do not have permission 'chatblind.alert'");
                            return true;
                        }
                    }

                    Player target = getServer().getPlayer(args[1]);
                    if(target != null)
                    {
                        Location location = target.getLocation();
                        target.playSound(location,Sound.NOTE_PLING,1,0);
                        target.sendMessage(ChatColor.GOLD + sender.getName() + " is trying to get your attention.");
                        sender.sendMessage(ChatColor.GRAY + "Alert sent");
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.RED + "No player named '" + args[1] + "' online right now");
                    }

                    return true;
                }
            }
        }
        return false;
    }
}