package com.silvaniastudios.roads.client.model;

import com.silvaniastudios.roads.FurenikusRoads;
import com.silvaniastudios.roads.blocks.CatsEyeBlock;
import com.silvaniastudios.roads.blocks.paint.PaintBlockBase;
import com.silvaniastudios.roads.items.PaintGunItemRegistry;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelBakeHandler {
	
	public static final ModelBakeHandler instance = new ModelBakeHandler();
	
	private ModelBakeHandler() {};
	
	@SubscribeEvent
	public void onModelBakeEvent(ModelBakeEvent event) {
		bakePaintGunModel(event);
		bakeCatsEyeModels(event);
		bakeCrusherFurnace(event);
		bakePaintFillerFurnace(event);
		bakeRoadFactoryFurnace(event);
		bakeTarDistillerFurnace(event);
		bakeTarmacCutterFurnace(event);
	}

	private void bakePaintGunModel(ModelBakeEvent event) {
		Object model = event.getModelRegistry().getObject(PaintGunModel.modelResourceLocation);
		
		if (model instanceof IBakedModel) {
			IBakedModel existingModel = (IBakedModel) model;
			PaintGunModel customModel = new PaintGunModel(existingModel);
			event.getModelRegistry().putObject(PaintGunModel.modelResourceLocation, customModel);
		}
	}
	
	private void bakeCatsEyeModels(ModelBakeEvent event) {
		String[] catsEyeList = new String[] {"cats_eye_white", "cats_eye_yellow", "cats_eye_red", "cats_eye_green"};
		String[] colourList = new String[] {"white", "yellow", "red", "green"};
		
		for (int i = 0; i < catsEyeList.length; i++) {
			for (int j = 0; j < CatsEyeBlock.EnumCatsEye.values().length; j++) {
				ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":" + catsEyeList[i], "eye_type=" + CatsEyeBlock.EnumCatsEye.byMetadata(j));
				Object cats_eye = event.getModelRegistry().getObject(mrl);
				
				if (cats_eye instanceof IBakedModel) {
					IBakedModel existingModel = (IBakedModel) cats_eye;
					CatsEyeModel customModel = new CatsEyeModel(existingModel, colourList[i], CatsEyeBlock.EnumCatsEye.byMetadata(j));
					event.getModelRegistry().putObject(mrl, customModel);
				}

				ModelResourceLocation mrl_double = new ModelResourceLocation(FurenikusRoads.MODID + ":" + catsEyeList[i] + "_double", "eye_type=" + CatsEyeBlock.EnumCatsEye.byMetadata(j));
				Object cats_eye_double = event.getModelRegistry().getObject(mrl_double);
				
				if (cats_eye_double instanceof IBakedModel) {
					IBakedModel existingModel = (IBakedModel) cats_eye_double;
					CatsEyeDoubleModel customModel = new CatsEyeDoubleModel(existingModel, colourList[i], CatsEyeBlock.EnumCatsEye.byMetadata(j));
					event.getModelRegistry().putObject(mrl_double, customModel);
				}
			}
		}
	}
	
	private void bakeCrusherFurnace(ModelBakeEvent event) {
		String[] rotations = new String[] {"north", "east", "south", "west"};
		
		for (int i = 0; i < rotations.length; i++) {
			ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":crusher", "furnace_active=true,rotation=" + rotations[i]);
			Object model = event.getModelRegistry().getObject(mrl);
			
			if (model instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model;
				CrusherBakedModel customModel = new CrusherBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl, customModel);
			}
		}
	}
	
	private void bakePaintFillerFurnace(ModelBakeEvent event) {
		String[] rotations = new String[] {"north", "east", "south", "west"};
		
		for (int i = 0; i < rotations.length; i++) {
			ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":paint_filler", "furnace_active=true,gun_loaded=false,rotation=" + rotations[i]);
			Object model = event.getModelRegistry().getObject(mrl);
			
			ModelResourceLocation mrl_gunloaded = new ModelResourceLocation(FurenikusRoads.MODID + ":paint_filler", "furnace_active=true,gun_loaded=true,rotation=" + rotations[i]);
			Object model_gunloaded = event.getModelRegistry().getObject(mrl_gunloaded);
			
			if (model instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model;
				PaintFillerBakedModel customModel = new PaintFillerBakedModel(existingModel, rotations[i], false);
				event.getModelRegistry().putObject(mrl, customModel);
			}
			
			if (model_gunloaded instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model_gunloaded;
				PaintFillerBakedModel customModel = new PaintFillerBakedModel(existingModel, rotations[i], true);
				event.getModelRegistry().putObject(mrl_gunloaded, customModel);
			}
		}
	}
	
	private void bakeRoadFactoryFurnace(ModelBakeEvent event) {
		String[] rotations = new String[] {"north", "east", "south", "west"};
		
		for (int i = 0; i < rotations.length; i++) {
			ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":road_factory", "connected=false,furnace_active=true,rotation=" + rotations[i]);
			ModelResourceLocation mrl_connect = new ModelResourceLocation(FurenikusRoads.MODID + ":road_factory", "connected=true,furnace_active=true,rotation=" + rotations[i]);
			Object model = event.getModelRegistry().getObject(mrl);
			Object model_connect = event.getModelRegistry().getObject(mrl_connect);
			
			if (model instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model;
				RoadFactoryBakedModel customModel = new RoadFactoryBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl, customModel);
			}
			if (model_connect instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model_connect;
				RoadFactoryBakedModel customModel = new RoadFactoryBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl_connect, customModel);
			}
		}
	}
	
	private void bakeTarDistillerFurnace(ModelBakeEvent event) {
		String[] rotations = new String[] {"north", "east", "south", "west"};
		
		for (int i = 0; i < rotations.length; i++) {
			ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":tar_distiller", "connected=false,furnace_active=true,rotation=" + rotations[i]);
			ModelResourceLocation mrl_connect = new ModelResourceLocation(FurenikusRoads.MODID + ":tar_distiller", "connected=true,furnace_active=true,rotation=" + rotations[i]);
			Object model = event.getModelRegistry().getObject(mrl);
			Object model_connect = event.getModelRegistry().getObject(mrl_connect);
			
			if (model instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model;
				TarDistillerBakedModel customModel = new TarDistillerBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl, customModel);
			}
			if (model_connect instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model_connect;
				TarDistillerBakedModel customModel = new TarDistillerBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl_connect, customModel);
			}
		}
	}
	
	private void bakeTarmacCutterFurnace(ModelBakeEvent event) {
		String[] rotations = new String[] {"north", "east", "south", "west"};
		
		for (int i = 0; i < rotations.length; i++) {
			ModelResourceLocation mrl = new ModelResourceLocation(FurenikusRoads.MODID + ":tarmac_cutter", "furnace_active=true,rotation=" + rotations[i]);
			Object model = event.getModelRegistry().getObject(mrl);
			
			if (model instanceof IBakedModel) {
				IBakedModel existingModel = (IBakedModel) model;
				TarmacCutterBakedModel customModel = new TarmacCutterBakedModel(existingModel, rotations[i]);
				event.getModelRegistry().putObject(mrl, customModel);
			}
		}
	}
	
	@SubscribeEvent
	public void stitcherEventPre(TextureStitchEvent.Pre event) {
		ResourceLocation white_paint = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_white");
		ResourceLocation yellow_paint = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_yellow");
		ResourceLocation red_paint = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_red");
		
		ResourceLocation tar_flowing = new ResourceLocation(FurenikusRoads.MODID + ":fluids/tar_flowing");
		ResourceLocation tar_still = new ResourceLocation(FurenikusRoads.MODID + ":fluids/tar_still");
		
		ResourceLocation cats_eye_white  = new ResourceLocation(FurenikusRoads.MODID + ":blocks/cats_eye_white");
		ResourceLocation cats_eye_yellow = new ResourceLocation(FurenikusRoads.MODID + ":blocks/cats_eye_yellow");
		ResourceLocation cats_eye_red    = new ResourceLocation(FurenikusRoads.MODID + ":blocks/cats_eye_red");
		ResourceLocation cats_eye_green  = new ResourceLocation(FurenikusRoads.MODID + ":blocks/cats_eye_green");
		
		ResourceLocation machine_vent_on = new ResourceLocation(FurenikusRoads.MODID + ":blocks/machine_vent_back_on");
		ResourceLocation paint_filler_display = new ResourceLocation(FurenikusRoads.MODID + ":blocks/paint_filler_machine_display");
		
		event.getMap().registerSprite(white_paint);
		event.getMap().registerSprite(yellow_paint);
		event.getMap().registerSprite(red_paint);
		
		event.getMap().registerSprite(tar_flowing);
		event.getMap().registerSprite(tar_still);
		
		event.getMap().registerSprite(cats_eye_white);
		event.getMap().registerSprite(cats_eye_yellow);
		event.getMap().registerSprite(cats_eye_red);
		event.getMap().registerSprite(cats_eye_green);
		
		event.getMap().registerSprite(machine_vent_on);
		event.getMap().registerSprite(paint_filler_display);
		
		for (int i = 0; i < PaintGunItemRegistry.lines.size(); i++) {
			PaintBlockBase block = PaintGunItemRegistry.lines.get(i);
			for (int j = 0; j < 3; j++) {
				if (j == 1) { block = PaintGunItemRegistry.getYellow(block); }
				if (j == 2) { block = PaintGunItemRegistry.getRed(block); }
				String name = block.getUnlocalizedName().substring(20);
				if (PaintGunItemRegistry.linesMeta.get(i) > 0) { name = name + "_" + PaintGunItemRegistry.linesMeta.get(i); }
				ResourceLocation sprite = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_gun_display/" + name);
				event.getMap().registerSprite(sprite);
			}
		}
		for (int i = 0; i < PaintGunItemRegistry.icons.size(); i++) {
			PaintBlockBase block = PaintGunItemRegistry.icons.get(i);
			for (int j = 0; j < 3; j++) {
				if (j == 1) { block = PaintGunItemRegistry.getYellow(block); }
				if (j == 2) { block = PaintGunItemRegistry.getRed(block); }
				String name = block.getUnlocalizedName().substring(20);
				if (PaintGunItemRegistry.iconsMeta.get(i) > 0) { name = name + "_" + PaintGunItemRegistry.iconsMeta.get(i); }
				ResourceLocation sprite = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_gun_display/" + name);
				event.getMap().registerSprite(sprite);
			}
		}
		for (int i = 0; i < PaintGunItemRegistry.letters.size(); i++) {
			PaintBlockBase block = PaintGunItemRegistry.letters.get(i);
			for (int j = 0; j < 3; j++) {
				if (j == 1) { block = PaintGunItemRegistry.getYellow(block); }
				if (j == 2) { block = PaintGunItemRegistry.getRed(block); }
				String name = block.getUnlocalizedName().substring(20);
				if (PaintGunItemRegistry.lettersMeta.get(i) > 0) { name = name + "_" + PaintGunItemRegistry.lettersMeta.get(i); }
				ResourceLocation sprite = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_gun_display/" + name);
				event.getMap().registerSprite(sprite);
			}
		}
		for (int i = 0; i < PaintGunItemRegistry.text.size(); i++) {
			PaintBlockBase block = PaintGunItemRegistry.text.get(i);
			for (int j = 0; j < 3; j++) {
				if (j == 1) { block = PaintGunItemRegistry.getYellow(block); }
				if (j == 2) { block = PaintGunItemRegistry.getRed(block); }
				String name = block.getUnlocalizedName().substring(20);
				ResourceLocation sprite = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_gun_display/" + name);
				event.getMap().registerSprite(sprite);
			}
		}
		for (int i = 0; i < PaintGunItemRegistry.junction.size(); i++) {
			PaintBlockBase block = PaintGunItemRegistry.junction.get(i);
			for (int j = 0; j < 3; j++) {
				if (j == 1) { block = PaintGunItemRegistry.getYellow(block); }
				if (j == 2) { block = PaintGunItemRegistry.getRed(block); }
				String name = block.getUnlocalizedName().substring(20);
				if (PaintGunItemRegistry.junctionMeta.get(i) > 0) { name = name + "_" + PaintGunItemRegistry.junctionMeta.get(i); }
				ResourceLocation sprite = new ResourceLocation(FurenikusRoads.MODID + ":items/paint_gun_display/" + name);
				event.getMap().registerSprite(sprite);
			}
		}
	}
}
