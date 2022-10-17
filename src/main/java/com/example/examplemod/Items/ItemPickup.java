package com.example.examplemod.Items;

import com.example.examplemod.Data;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemPickup {

    static int ItemPickupCounter = 0;

    @SubscribeEvent
    public void ItemPickupEvent(EntityItemPickupEvent event) {

        if (event.getEntity() instanceof Player) {
            String self_player_name = Data.get_player_name();
            String event_player_name = event.getEntity().getName().getString();
            if (event_player_name.equals(self_player_name)) {
                String item_name = event.getItem().getName().getString(); // The item name that player has picked
                int item_count = event.getItem().getItem().getCount(); // The count of items that player has picked

                ItemPickupCounter+=item_count;

                System.out.println(item_name + " | " + item_count);

                switch (item_name) {
                    case "Diamond":
                    case "Diamond Ore":
                    case "Deepslate Diamond Ore":
                        Diamond.increase_counter(item_count);
                        break;

                    case "Gold Ingot":
                    case "Gold Ore":
                    case "Deepslate Gold Ore":
                        Gold.increase_counter(item_count);
                        break;

                    case "Iron Ingot":
                    case "Raw Iron":
                    case "Deepslate Iron Ore":
                    case "Iron Ore":
                        Iron.increase_counter(item_count);
                        break;

                    case "Coal":
                    case "Coal Ore":
                    case "Deepslate Coal Ore":
                        Coal.increase_counter(item_count);
                        break;
                }
            }
        }
    }

    public static int get_item_pickup_counter() {
        return ItemPickupCounter;
    }

    public static void reset_item_pickup_counter() {
        ItemPickupCounter = 0;
    }
}
