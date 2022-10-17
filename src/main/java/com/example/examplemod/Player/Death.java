package com.example.examplemod.Player;

import com.example.examplemod.Data;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Death {

    static int Counter = 0;
    static int MobKills = 0;

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event){
        // If died entity is player
        if (event.getEntity() instanceof Player) {
            String self_player_name = Data.get_player_name();
            String event_player_name = event.getEntity().getName().getString();
            if (event_player_name.equals(self_player_name)) {
                Counter++;
            }
        }
        // If died entity is mob
        else if (event.getEntity() instanceof Mob) {
            String mob_name = event.getEntity().getName().getString();
            DamageSource damage_source = event.getSource();
            Entity attacker_entity = damage_source.getEntity();

            // Mob killed by player
            if (attacker_entity instanceof Player) {
                String self_player_name = Data.get_player_name();
                String attacker_name = attacker_entity.getName().getString();
                if (attacker_name.equals(self_player_name)) {
                    MobKills++;
                }
                //System.out.println(mob_name + " died by player");
            }
            else {
//                System.out.println(mob_name);
            }
        }
    }

    public static int get_counter() {
        return Counter;
    }

    public static int mob_kills_counter() {
        return MobKills;
    }

    public static void reset_counter() {
        Counter = 0;
        MobKills = 0;
    }
}
