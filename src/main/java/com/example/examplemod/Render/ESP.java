package com.example.examplemod.Render;

import com.example.examplemod.Chat;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.shaders.Effect;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.ContainerScreenEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.lwjgl.opengl.GL11;

import javax.xml.stream.Location;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;


public class ESP {
    public static boolean player_esp = false;

    @SubscribeEvent
    public void playerRendering(RenderPlayerEvent.Post event) throws IOException {
        if (event.getEntity() instanceof Player) {
//            event.getEntity().setGlowingTag(true);
//            event.getEntity().setCustomNameVisible(true);
//            System.out.println(event.getEntity().hasGlowingTag()); // true for singleplayer, multiplayer & realms
            // event.getEntity().addEffect(); Should I use this ?
            event.getEntity().addEffect(new MobEffectInstance(MobEffects.GLOWING, 99999, 255));
            event.getEntity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 99999, 255));

            System.out.println(event.getEntity().getName().getString() + " | " + event.getEntity().isCurrentlyGlowing());

//            Minecraft.getInstance().player.setGlowingTag(true);

            double posX = event.getEntity().position().x;
            double posY = event.getEntity().position().y;
            double posZ = event.getEntity().position().z;
            event.getEntity().level.addParticle(ParticleTypes.FIREWORK, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {
        double posX = event.player.position().x;
        double posY = event.player.position().y;
        double posZ = event.player.position().z;
//        event.player.level.addParticle(ParticleTypes.FIREWORK, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
//        event.player.setCustomNameVisible(true);
//
        event.player.setGlowingTag(true);

        if (player_esp) {
            double x = event.player.getLookAngle().x;
            double y = event.player.getLookAngle().y;
            double z = event.player.getLookAngle().z;
//            event.player.setPos(x, y, z);

//            BlockPos pos = new BlockPos(posX+x, posY, posZ+z);
//            System.out.println(event.player.level.getBlockState(pos).getBlock().getName().getString());
//            if(event.player.level.getBlockState(pos).getBlock() == Blocks.DIAMOND_BLOCK){
//                System.out.println("FOUND DIAMOND BLOCK");
//            }

            BlockPos pos1 = new BlockPos(posX-5, posY-5, posZ-5);
            BlockPos pos2 = new BlockPos(posX+5, posY+5, posZ+5);
            for (BlockPos p1 : BlockPos.betweenClosed(pos1, pos2)) {
                if (event.player.level.getBlockState(p1).getBlock() == Blocks.DIAMOND_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
                    Chat.SendMessage("Found diamond ore at " + p1);
                    player_esp = false;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.ANCIENT_DEBRIS) {
                    Chat.SendMessage("Found ancient debris at " + p1);
                    player_esp = false;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.IRON_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_IRON_ORE) {
                    Chat.SendMessage("Found iron ore at " + p1);
                    player_esp = false;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.EMERALD_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
                    Chat.SendMessage("Found emerald ore at " + p1);
                    player_esp = false;
                }
//                System.out.println(event.player.level.getBlockState(p1).getBlock().getName().getString());
            }

            // Get blocks around player
//            for(int start_x = (int) (posX-5); start_x <= (int) (posX+5); start_x++) {
//                BlockPos pos = new BlockPos(start_x, posY, posZ);
//                if(event.player.level.getBlockState(pos).getBlock() != Blocks.AIR){
//                    System.out.println(event.player.level.getBlockState(pos).getBlock().getName().getString());
//                }
//            }
        }

//        CompoundTag compoundtag = new CompoundTag();
//        compoundtag.putString("id", "minecraft:chicken");
//        Entity entity = EntityType.loadEntityRecursive(compoundtag, this.level, (e) -> {
//            e.moveTo(x, y, z, yRot, xRot);
//            return e;
//        });

        // Spawn chickens (tested)
//        Chicken chickenentity = EntityType.CHICKEN.create(event.player.level);
//        chickenentity.setAge(10);
//        chickenentity.moveTo(posX, posY+20, posZ, 50, 0.0F);
//        event.player.level.addFreshEntity(chickenentity);
//        Minecraft.getInstance().player.setGlowingTag(true);
//
//        Vec3 pos1= new Vec3 (0,5,0);  // [b]Vector from 0,0,0 to 0,5,0 -> Blockcoords[/b]
//        Vec3 pos2= new Vec3 (5,5,0);  // [b]Vector from 0,0,0 to 5,5,0 -> Blockcoords[/b]

//        event.player.level.getNearbyEntities();
//        drawLineWithGL(pos1, pos2);
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onEvent(LivingEvent.LivingTickEvent event) {
        // Works for singleplayer only
//        if (event.getEntity() instanceof Player) {
//            System.out.println("hi: " + event.getEntity().getName().getString());
//            event.getEntity().setGlowingTag(true);
//        }
    }

    @SubscribeEvent
    public void EntityRenderersEvent(RenderPlayerEvent.Post event) {
//        System.out.println("EntityRenderersEvent");
//        Vec3 pos1= new Vec3 (0,5,0);  // [b]Vector from 0,0,0 to 0,5,0 -> Blockcoords[/b]
//        Vec3 pos2= new Vec3 (5,5,0);  // [b]Vector from 0,0,0 to 5,5,0 -> Blockcoords[/b]

//        drawLineWithGL(pos1, pos2);

//        event.getRenderer().getModel().leftArm.xRot = (float) Math.toRadians(90);
    }

    private void drawLineWithGL(Vec3 blockA, Vec3 blockB)
    {
        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glColor3f(0F, 1F, 0F);
        GL11.glBegin(GL11.GL_LINE_STRIP);

        //you will want to modify these offsets.
        GL11.glVertex3d(blockA.x + 0.5,blockA.y - 0.01,blockA.z + 0.5);
        GL11.glVertex3d(blockB.x + 0.5,blockB.y - 0.01,blockB.z + 0.5);

        GL11.glEnd();
    }


//    @SubscribeEvent
//    public void LivingTickEvent(LivingEvent.LivingTickEvent event) {
//        Entity entity = event.getEntity();
//        String name = event.getEntity().getName().getString();
//        entity.setGlowingTag(true);
//        if (entity instanceof Player) {
//            if (player_esp) {
//                entity.setGlowingTag(true);
//            }
//            else {
//                entity.setGlowingTag(false);
//            }
//        }
//    }

    public static void enable_player_esp(boolean option) {
        player_esp = option;
        System.out.println(player_esp);
    }

    @SubscribeEvent
    public static void RenderWorldLastEvent(double posX, double posY, double posZ) {
        Player player = Minecraft.getInstance().player;

        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);

        double d0 = posX-1 + (posX - posX) * 20.0;
        double d1 = posY-1 + (posY - posY) * 20.0;
        double d2 = posZ-1 + (posZ - posZ) * 2.0;
        Vector3d player_pos = new Vector3d(d0, d1, d2);

        GL11.glTranslated(-player_pos.x, -player_pos.y, -player_pos.z);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        Vector3d blockA = new Vector3d (0,0,0);
        Vector3d blockB = new Vector3d (0,10,0);

        GL11.glColor4f(1,1,1,1);
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(blockA.x, blockA.y, blockA.z);
        GL11.glVertex3d(blockB.x, blockB.y, blockB.z);
        GL11.glEnd();

        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
}
