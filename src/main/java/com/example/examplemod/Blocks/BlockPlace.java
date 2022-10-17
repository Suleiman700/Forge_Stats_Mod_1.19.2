package com.example.examplemod.Blocks;

import com.example.examplemod.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BlockPlace {

    static int PlacedBlocks = 0;


    @SubscribeEvent
    public void onBlockPlaceEvent(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof Player) {
            String self_player_name = Data.get_player_name();
            String event_player_name = event.getEntity().getName().getString();
            if (event_player_name.equals(self_player_name)) {
                PlacedBlocks++;
            }
        }
    }

    public static void reset_counters() {
        PlacedBlocks = 0;
    }

    public static int get_counter() {
        return PlacedBlocks;
    }
}
