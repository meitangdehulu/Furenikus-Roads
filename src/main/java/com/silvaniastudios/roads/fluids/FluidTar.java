package com.silvaniastudios.roads.fluids;

import com.silvaniastudios.roads.FurenikusRoads;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidTar extends Fluid {

	public FluidTar(String fluidName) {
		super(fluidName, new ResourceLocation(FurenikusRoads.MODID, "fluids/" + fluidName + "_still"), new ResourceLocation(FurenikusRoads.MODID, "fluids/" + fluidName + "_flowing"));
		FluidRegistry.addBucketForFluid(this);
	}
}
