package com.convallyria.taleofkingdoms.common.shop;

import com.convallyria.taleofkingdoms.TaleOfKingdoms;
import com.convallyria.taleofkingdoms.common.world.ConquestInstance;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public abstract class ShopItem {

    public abstract int getCost();

    public abstract Item getItem();

    public abstract String getName();

    public void buy(ConquestInstance instance, PlayerEntity player) {
        if (instance.getCoins() >= getCost()) {
            TaleOfKingdoms.getAPI().ifPresent(api -> {
                api.executeOnMain(() -> {
                    MinecraftServer server = MinecraftClient.getInstance().getServer();
                    if (server != null) {
                        ServerPlayerEntity serverPlayerEntity = server.getPlayerManager().getPlayer(player.getUuid());
                        if (serverPlayerEntity != null) {
                            serverPlayerEntity.inventory.insertStack(new ItemStack(getItem(), 1));
                            instance.setCoins(instance.getCoins() - getCost());
                        }
                    }
                });
            });
        }
    }
}