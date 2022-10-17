package com.example.examplemod.Movements;

import com.example.examplemod.Chat;
import com.example.examplemod.Data;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Fall {

    static int Falls = 0;
    static float MaxFallDistance = 0.0F;
    static float FallMinVal = 4.0F; // 4 blocks are considered as a fall

    @SubscribeEvent
    public void onEvent(LivingFallEvent event) {
        if (event.getEntity() instanceof Player) {

            String self_player_name = Data.get_player_name();
            String event_player_name = event.getEntity().getName().getString();
            if (event_player_name.equals(self_player_name)) {
                float distance = event.getDistance();
                if (distance >= FallMinVal) {
                    // Set max fall distance
                    if (distance > MaxFallDistance) {
                        MaxFallDistance = distance;
                    }

                    System.out.println("Player falls: " + Falls + " | Max fall: " + MaxFallDistance);
                    Falls++;
                }
            }
        }
    }

    public static int get_counter() {
        return Falls;
    }

    public static float get_max_fall_distance() {
        return MaxFallDistance;
    }

    public static void reset_counters() {
        Falls = 0;
        MaxFallDistance = 0;
    }
}
