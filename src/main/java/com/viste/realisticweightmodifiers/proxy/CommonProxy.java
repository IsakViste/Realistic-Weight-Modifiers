package com.viste.realisticweightmodifiers.proxy;

import java.io.File;

import com.viste.realisticweightmodifiers.Config;
import com.viste.realisticweightmodifiers.Reference;
import com.viste.realisticweightmodifiers.events.CheckInventory;
import com.viste.realisticweightmodifiers.handlers.RenderGuiHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {
		Reference.log = e.getModLog();
		
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), Reference.MODID + ".cfg"));
		Config.readConfig();
		
		// Inventory
		MinecraftForge.EVENT_BUS.register(new CheckInventory());
	}

	public void init(FMLInitializationEvent e) {
		
	}

	public void postInit(FMLPostInitializationEvent e) {
		if (config.hasChanged()) {
			config.save();
		}
		
		// GUI
		MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
	}
}