package com.example.examplemod.Movements;

import com.example.examplemod.Data;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Jump {

    static int Jumps = 0;


//    @SubscribeEvent
//    public void jumpEffect(LivingEvent.LivingJumpEvent event)
//    {
//        if (event.getEntity() instanceof Player) {
//            Jumps++;
//            System.out.println("jumpEvent: Entity is EntityPlayer: " + Jumps);
//        }
//    }

    @SubscribeEvent
    public void onEvent(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player) {
            String self_player_name = Data.get_player_name();
            String event_player_name = event.getEntity().getName().getString();
            if (event_player_name.equals(self_player_name)) {
//                System.out.println("jumpEvent: Entity is EntityPlayer: " + Jumps);
                Jumps++;
            }
        }
    }

    public static int get_counter() {
        return Jumps;
    }

    public static void reset_counters() {
        Jumps = 0;
    }
}
