package com.nitwit.mixin;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
public class RemoveNitwit {
	@Inject(at = @At("TAIL"), method = "tick")
	private void tick(CallbackInfo info) {
		Villager villager = (Villager)(Object)this;
		if (villager.getVillagerData().getProfession() == VillagerProfession.NITWIT){
			villager.setVillagerData(villager.getVillagerData().setProfession(VillagerProfession.NONE));
		}
	}
}