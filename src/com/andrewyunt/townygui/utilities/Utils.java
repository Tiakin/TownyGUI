package com.andrewyunt.townygui.utilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import com.gmail.filoghost.hiddenstring.HiddenStringUtils;

import net.minecraft.server.v1_9_R1.NBTTagCompound;
import net.minecraft.server.v1_9_R1.NBTTagList;

public class Utils {
	
	public int getInventorySize(int max) {
		
	    if(max <= 0)
	    	return 9;
	    
	    int quotient = (int)Math.ceil(max / 9.0);
	    
	    return quotient > 5 ? 54: quotient * 9;
	}
	
	public List<String> colorizeStringList(List<String> input) {
		
		List<String> colorized = new ArrayList<String>();
		
		for(String line : input)
			colorized.add(ChatColor.translateAlternateColorCodes('&', line));
		
		return colorized;
	}
	
	public List<String> hideStringInLore(List<String> inputLore, String hiddenString) {
		
		List<String> outputLore = new ArrayList<String>();
		
		outputLore.add(HiddenStringUtils.encodeString(hiddenString));
		
		for(String line : inputLore)
			outputLore.add(line);
		
		return outputLore;
	}
	
	public ItemStack addGlow(ItemStack is) {
		
		net.minecraft.server.v1_9_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(is);
		
		NBTTagCompound nbt = nmsItem.getTag() == null ? new NBTTagCompound() : nmsItem.getTag();
		
		NBTTagList ench = new NBTTagList();
		
		nbt.set("ench", ench);
		
		nmsItem.setTag(nbt);
		
		return CraftItemStack.asBukkitCopy(nmsItem);
	}
}