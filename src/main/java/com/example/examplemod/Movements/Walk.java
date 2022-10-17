package com.example.examplemod.Movements;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class Walk {

    @SubscribeEvent
    public void LivingTickEvent(LivingEvent.LivingTickEvent event) {
        Entity entity = event.getEntity();
        String name = event.getEntity().getName().getString();
        System.out.println(name);
        if (entity instanceof Player) {
            entity.setGlowingTag(true);
        }
    }

    // Add name tag to entities
//    @SubscribeEvent
//    public void RenderLivingEvent(RenderLivingEvent event) {
//        Entity mob = event.getEntity();
//        mob.setCustomNameVisible(true);
//        mob.setGlowingTag(true);
//        mob.addTag("TEST");
//        mob.isCurrentlyGlowing();
//        System.out.println(event.getEntity().getName().getString());
//    }




//    @SubscribeEvent
//    public void onTick(TickEvent.RenderTickEvent event){
//        List<Entity> entities = Minecraft.getInstance().get
//        for (int i = 0; i < entities.size(); i++) {
//            if (entities.get(i) instanceof EntityItem && entities.get(i) instanceof EntityItem) {
//                entities.get(i).setGlowing(Enabled);
//                entities.get(i).setCustomNameTag("hello");
//                entities.get(i).setAlwaysRenderNameTag(true);
//            }
//        }
//    }

//    @SubscribeEvent
//    public void onPlayerRender(EntityViewRenderEvent event) {
//        System.out.println("here");
//
////        Vec3 pos1= new Vec3 (0,5,0);  // [b]Vector from 0,0,0 to 0,5,0 -> Blockcoords[/b]
////        Vec3 pos2= new Vec3 (5,5,0);  // [b]Vector from 0,0,0 to 5,5,0 -> Blockcoords[/b]
//
////you will need to supply your own position vectors
////        drawLineWithGL();
//
//        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
//        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
//        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
//        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
//        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
//
//        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
//        GL11.glDisable(GL11.GL_CULL_FACE);
//        GL11.glDisable(GL11.GL_LIGHTING);
//        GL11.glDisable(GL11.GL_TEXTURE_2D);
//
//        GL11.glPushMatrix();
//        GL11.glDisable(GL11.GL_TEXTURE_2D);
//        GL11.glDisable(GL11.GL_LIGHTING);
//        GL11.glDisable(GL11.GL_DEPTH_TEST);
//        GL11.glDepthMask(false);
//        GL11.glColor4d(1, 1, 1, 1);
//
//        GL11.glLineWidth(3f);
//        GL11.glBegin(GL11.GL_LINES);
//        {
//            GL11.glVertex3d(0, 0, 0);
//            GL11.glVertex3d(18, 64, 18);
//        }
//        GL11.glEnd();
//        GL11.glPopMatrix();
//    }



    private void drawLineWithGL() {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(20);
        GL11.glColor4f(100, 100, 100, 100);
        GL11.glBegin(2);
        GL11.glVertex2d(18, 64);
        GL11.glVertex2d(18, 68);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }
}
