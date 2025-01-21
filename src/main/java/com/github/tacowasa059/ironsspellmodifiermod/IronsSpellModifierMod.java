package com.github.tacowasa059.ironsspellmodifiermod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(IronsSpellModifierMod.MODID)
public class IronsSpellModifierMod {
    public static final String MODID = "ironsspellmodifiermod";
    public IronsSpellModifierMod() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
