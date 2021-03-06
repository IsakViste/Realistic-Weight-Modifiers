package com.viste.realisticweightmodifiers.handlers;

import com.viste.realisticweightmodifiers.events.CheckInventory;
import com.viste.realisticweightmodifiers.gui.GuiWeight;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGuiHandler {
	private CheckInventory ci;
	private GuiWeight gw;
	public RenderGuiHandler(CheckInventory checkInventory) {
		ci = checkInventory;
		gw = new GuiWeight();
	}
	
	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) {
		if (event.getType() != ElementType.EXPERIENCE) {
			return;
		}
		
		gw.renderWeight(ci.getPlayerCurrentWeight(), ci.getPlayerWeightCap());
	}
	
}
