package com.example.examplemod;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class Chat {

    public static void SendMessage(String message) {
        Player player = Minecraft.getInstance().player;

        // https://forums.minecraftforge.net/topic/117277-linking-item-and-capability/
        player.sendSystemMessage(Component.literal(message).withStyle(ChatFormatting.AQUA));
    }

    public static void SendLine() {
        Player player = Minecraft.getInstance().player;
        player.sendSystemMessage(Component.literal("----------------------------------\n").withStyle(ChatFormatting.RED));
    }
}
