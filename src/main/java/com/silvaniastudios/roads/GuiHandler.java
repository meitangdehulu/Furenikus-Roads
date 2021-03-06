package com.silvaniastudios.roads;

import com.silvaniastudios.roads.blocks.tileentities.crusher.CrusherContainer;
import com.silvaniastudios.roads.blocks.tileentities.crusher.CrusherEntity;
import com.silvaniastudios.roads.blocks.tileentities.distiller.TarDistillerContainer;
import com.silvaniastudios.roads.blocks.tileentities.distiller.TarDistillerEntity;
import com.silvaniastudios.roads.blocks.tileentities.paintfiller.PaintFillerContainer;
import com.silvaniastudios.roads.blocks.tileentities.paintfiller.PaintFillerEntity;
import com.silvaniastudios.roads.blocks.tileentities.roadfactory.RoadFactoryContainer;
import com.silvaniastudios.roads.blocks.tileentities.roadfactory.RoadFactoryEntity;
import com.silvaniastudios.roads.blocks.tileentities.tarmaccutter.TarmacCutterContainer;
import com.silvaniastudios.roads.blocks.tileentities.tarmaccutter.TarmacCutterEntity;
import com.silvaniastudios.roads.client.gui.GuiCrusher;
import com.silvaniastudios.roads.client.gui.GuiPaintFiller;
import com.silvaniastudios.roads.client.gui.GuiRoadFactory;
import com.silvaniastudios.roads.client.gui.GuiTarDistiller;
import com.silvaniastudios.roads.client.gui.GuiTarmacCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null) {
			if (ID == 1) {
				return new PaintFillerContainer(player.inventory, (PaintFillerEntity) te);
			}
			if (ID == 2) {
				return new TarDistillerContainer(player.inventory, (TarDistillerEntity) te);
			}
			if (ID == 3) {
				return new RoadFactoryContainer(player.inventory, (RoadFactoryEntity) te);
			}
			if (ID == 4) {
				return new TarmacCutterContainer(player.inventory, (TarmacCutterEntity) te);
			}
			if (ID == 5) {
				return new CrusherContainer(player.inventory, (CrusherEntity) te);
			}
			
			System.out.println("You forgot to register GUI ID " + ID + " server-side, idiot.");
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null) {
			if (ID == 1) {
				PaintFillerEntity entity = (PaintFillerEntity) te;
				return new GuiPaintFiller(entity, new PaintFillerContainer(player.inventory, entity));
			}
			if (ID == 2) {
				TarDistillerEntity entity = (TarDistillerEntity) te;
				return new GuiTarDistiller(entity, new TarDistillerContainer(player.inventory, entity));
			}
			if (ID == 3) {
				RoadFactoryEntity entity = (RoadFactoryEntity) te;
				return new GuiRoadFactory(entity, new RoadFactoryContainer(player.inventory, entity));
			}
			if (ID == 4) {
				TarmacCutterEntity entity = (TarmacCutterEntity) te;
				return new GuiTarmacCutter(entity, new TarmacCutterContainer(player.inventory, entity));
			}
			if (ID == 5) {
				CrusherEntity entity = (CrusherEntity) te;
				return new GuiCrusher(entity, new CrusherContainer(player.inventory, entity));
			}
			
			System.out.println("You forgot to register GUI ID " + ID + " client-side, idiot.");
		}
		return null;
	}

}
