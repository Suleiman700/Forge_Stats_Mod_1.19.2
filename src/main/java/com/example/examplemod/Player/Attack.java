package com.example.examplemod.Player;

import com.example.examplemod.Data;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Attack {

    static float DamageDealtToMobs = 0.0F;

    @SubscribeEvent
    public void LivingAttackEvent(LivingAttackEvent event){

        String attacked_entity_name = event.getEntity().getName().getString();
        DamageSource damage_source = event.getSource();
        Entity attacker_entity = damage_source.getDirectEntity();

        // IF attacker is player
        if (attacker_entity instanceof Player) {
            String attacker_name = attacker_entity.getName().getString();
            // String weapon_name = ((Player) attacker_entity).getMainHandItem().getDisplayName().getString();

            float attacked_entity_max_health = event.getEntity().getMaxHealth();
            float attacked_entity_health = event.getEntity().getHealth();
            float attached_entity_damage_took = attacked_entity_max_health - attacked_entity_health;

            String self_player_name = Data.get_player_name();
            if (attacker_name.equals(self_player_name)) {
                DamageDealtToMobs += attached_entity_damage_took;
                // System.out.println("Attacker: " + attacker_name + " > " + attacked_entity_name + ": " + attacked_entity_health + "/" + attacked_entity_max_health);
            }
        }
    }

    public static float get_damage_dealt_to_mobs() {
        return DamageDealtToMobs;
    }

    public static void reset_damage_dealt_to_mobs_counter() {
        DamageDealtToMobs = 0;
    }
}
