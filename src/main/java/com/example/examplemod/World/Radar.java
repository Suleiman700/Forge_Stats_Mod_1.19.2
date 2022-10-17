package com.example.examplemod.World;

import com.example.examplemod.Chat;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Radar {
    private static boolean enabled = false;

    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {
        double posX = event.player.position().x;
        double posY = event.player.position().y;
        double posZ = event.player.position().z;


        if (enabled) {
            event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2000));
            // double x = event.player.getLookAngle().x;
            // double y = event.player.getLookAngle().y;
            // double z = event.player.getLookAngle().z;

            Chat.SendLine();
            BlockPos pos1 = new BlockPos(posX-5, posY-5, posZ-5);
            BlockPos pos2 = new BlockPos(posX+5, posY+5, posZ+5);
            for (BlockPos p1 : BlockPos.betweenClosed(pos1, pos2)) {
                if (event.player.level.getBlockState(p1).getBlock() == Blocks.DIAMOND_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
                    Chat.SendMessage("Found diamond ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.ANCIENT_DEBRIS) {
                    Chat.SendMessage("Found ancient debris at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.IRON_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_IRON_ORE) {
                    Chat.SendMessage("Found iron ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.EMERALD_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
                    Chat.SendMessage("Found emerald ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                }
                enabled = false;
            }
        }
    }

    public static void enable_radar(boolean option) {
        enabled = option;
        if (option) Chat.SendMessage("Blocks radar is now enabled");
        else Chat.SendMessage("Blocks radar is now disabled");
    }
}
