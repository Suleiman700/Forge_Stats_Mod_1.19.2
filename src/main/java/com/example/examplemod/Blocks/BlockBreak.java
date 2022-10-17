package com.example.examplemod.Blocks;

import com.example.examplemod.Data;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BlockBreak {

    static int BrokenBlocks = 0;

    @SubscribeEvent
    public void onBlockBreakEvent(BlockEvent.BreakEvent event) {
        String self_player_name = Data.get_player_name();
        String event_player_name = event.getPlayer().getName().getString();
        if (event_player_name.equals(self_player_name)) {
            BrokenBlocks++;
        }
    }

    public static void reset_counters() {
        BrokenBlocks = 0;
    }

    public static int get_counter() {
        return BrokenBlocks;
    }

}
