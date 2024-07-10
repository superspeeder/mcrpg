package dev.superspeeder.mcrpg.item;

import dev.superspeeder.mcrpg.gui.TestScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TestItem extends Item {
    public TestItem(Item.Properties p) {
        super(p);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (level.isClientSide()) {
            Minecraft.getInstance().setScreen(new TestScreen(Component.literal("Test")));
        }

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }
}
