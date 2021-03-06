package com.settlements.utils;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.settlements.Settlements;

public class UtilsHologram {
	ArmorStand as;
	Location location;
	
	public UtilsHologram(Location loc, String name) {
		this.location = loc;
		as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		as.setArms(false);
		as.setGravity(true);
		as.setVisible(false);
		as.setCustomName(name);
		as.setCustomNameVisible(false);
	}
	
	public UtilsHologram setVisible(boolean visible) {
		as.setCustomNameVisible(visible);
		return this;
	}
	
	public UtilsHologram move() {
		final Vector to = new Vector(0, 1, 0).multiply(0.01);
		
		new BukkitRunnable() {
			@Override
			public void run() {
				as.setVelocity(to);
			}
		}.runTaskTimer(Settlements.plugin, 0, 1);
		
		return this;
	}
	
	public void destroy() {
		as.remove();
	}
}
