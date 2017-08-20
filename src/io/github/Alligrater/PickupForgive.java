package io.github.Alligrater;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.meta.ItemMeta;


public class PickupForgive implements Listener{
	
	  @EventHandler
	  public void onItemSpawn(ItemSpawnEvent event)
	  {
		  if(event.getEntity().getItemStack().getItemMeta().hasDisplayName()) {
			  if (event.getEntity().getItemStack().getItemMeta().getDisplayName().contains("Forgive")) {
				  Item dropped = event.getEntity();
				  dropped.setCustomName("§a§lForgiveness");
				  dropped.setCustomNameVisible(true);
			  }
			  else {
				  Item dropped = event.getEntity();
				  if (dropped.getItemStack().getItemMeta().hasDisplayName()) {
					  dropped.setCustomName(dropped.getItemStack().getItemMeta().getDisplayName());
					  dropped.setCustomNameVisible(true);
				  }
			  }

			  
			  if (event.isCancelled()) {
				  return;
			  }
		  }
		  else {
			  return;
		  }
	    
	  }
	
	@EventHandler
	@SuppressWarnings("deprecation")
	public void onPickupForgive(PlayerPickupItemEvent event) {
		if(event.getItem().getItemStack().getItemMeta().hasDisplayName()) {
			if(event.getItem().getItemStack().getItemMeta().getDisplayName().contains("Forgive")) {
				String iname = event.getItem().getItemStack().getItemMeta().getDisplayName();
				String sname = iname.substring(iname.indexOf("from") + 5);
				String pname = event.getPlayer().getName();
				
				Item picked = event.getItem();
				ItemMeta pmeta = picked.getItemStack().getItemMeta();
				pmeta.setDisplayName("§a§lForgiveness");
				
				List<String> lores = new ArrayList<String>();
				pmeta.setLore(lores);
				
				picked.getItemStack().setItemMeta(pmeta);
				
				if (pname.equals(sname)) {
					Bukkit.broadcastMessage(ChatColor.GREEN + sname + ChatColor.GREEN + "原谅了他自己！");
					event.getPlayer().sendTitle(ChatColor.GREEN + "你本尊", ChatColor.GREEN + "原谅了你！");
					//event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITCH_AMBIENT, 10, 10);
				}
				else {
					if(sname.equals("Forgiveness")) {
						Bukkit.broadcastMessage(ChatColor.GREEN + "隔壁老王原谅了" + ChatColor.GREEN + pname + ChatColor.GREEN + "!");
						event.getPlayer().sendTitle(ChatColor.GREEN + "隔壁老王", ChatColor.GREEN + "原谅了你！");
					}
					else {
						Bukkit.broadcastMessage(ChatColor.GREEN + sname + ChatColor.GREEN + "原谅了" + ChatColor.GREEN + pname + ChatColor.GREEN + "!");
						event.getPlayer().sendTitle(ChatColor.GREEN + sname, ChatColor.GREEN + "原谅了你！");
					}

				}


			}
		}

		else {
			return;
		}
	}
	
	@EventHandler
	public void onDropForgive(PlayerDropItemEvent event) {
		if(event.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
			if(event.getItemDrop().getItemStack().getItemMeta().getDisplayName().toLowerCase().contains("forgive")) {
				Item dropped = event.getItemDrop();
				ItemMeta dmeta = dropped.getItemStack().getItemMeta();
				dmeta.setDisplayName("§a§lForgive from " + event.getPlayer().getName());
				dropped.getItemStack().setItemMeta(dmeta);

			}
		}
		else {
			return;
		}
	}
}
