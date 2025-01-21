package com.github.tacowasa059.ironsspellmodifiermod.event;

import com.github.tacowasa059.ironsspellmodifiermod.IronsSpellModifierMod;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IronsSpellModifierMod.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.DEDICATED_SERVER)
public class SpellCastListener {
    @SubscribeEvent
    public static void onCast(SpellPreCastEvent event){
        Player player = event.getEntity();
        if(player.isSpectator()){
            // メッセージをクライアントに送信
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.sendSystemMessage(Component.literal("Spectators cannot cast spells."));
                // イベントをキャンセル
                event.setCanceled(true);
            }
        }
    }
}
