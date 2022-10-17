package com.example.examplemod.Keys;

import com.example.examplemod.Blocks.BlockBreak;
import com.example.examplemod.Blocks.BlockPlace;
import com.example.examplemod.Chat;
import com.example.examplemod.Items.*;
import com.example.examplemod.Movements.Fall;
//import com.example.examplemod.Render.Gui;
import com.example.examplemod.Movements.Jump;
import com.example.examplemod.Player.Attack;
import com.example.examplemod.Player.Death;
import com.example.examplemod.Render.ESP;
import com.example.examplemod.World.Radar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.ApiStatus;
import javax.swing.text.JTextComponent;

public class KeysPresses {
    @SubscribeEvent
    public void onKeyInputEvent(InputEvent.Key event) {
        int pressed_key = event.getKey();

//        System.out.println(pressed_key);


        // F12
        if (pressed_key == 301) {
            Radar.enable_radar(true);
            //            int falls = Fall.get_counter();
            //            float max_fall_distance = Fall.get_max_fall_distance();
            //            int jumps = Jump.get_counter();
            //            Chat.SendLine();
            //            Chat.SendMessage("Mob kills: " + Death.mob_kills_counter() + " | Damage dealt: " + Attack.get_damage_dealt_to_mobs());
            //            Chat.SendMessage("Jumps: " + jumps + " | Falls: " + falls + " | Max fall distance: " + max_fall_distance);
            //            Chat.SendMessage("Blocks placed: " + BlockPlace.get_counter() + " | Blocks broken: " + BlockBreak.get_counter());
            //            Chat.SendMessage("Deaths: " + Death.get_counter());
            //            Chat.SendMessage("Items picked: " + ItemPickup.get_item_pickup_counter());
            //            Chat.SendMessage("Diamond: " + Diamond.get_counter() + " | Gold: " + Gold.get_counter() + " | Iron: " + Iron.get_counter() + " | Coal: " + Coal.get_counter());
            //            Chat.SendLine();
        }

        // F10
        else if (pressed_key == 299) {
            Radar.enable_radar(false);
            //            Attack.reset_damage_dealt_to_mobs_counter();
            //            Jump.reset_counters();
            //            Fall.reset_counters();
            //            BlockPlace.reset_counters();
            //            BlockBreak.reset_counters();
            //            Death.reset_counter();
            //            ItemPickup.reset_item_pickup_counter();
            //            Diamond.reset_counter();
            //            Gold.reset_counter();
            //            Iron.reset_counter();
            //            Coal.reset_counter();
            //            Chat.SendMessage("Counters has been rested");
        }



//        System.out.println(event.getKey());
//        if (Minecraft.getInstance().options.keyRight.isDown()) {
//            System.out.println("options.keyRight.isDown");
//        }

//        if (Minecraft.getInstance().player.input.up) {
//
//        }
    }

//    @SubscribeEvent
//    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//
//    }
}
