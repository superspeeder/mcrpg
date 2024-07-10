package dev.superspeeder.mcrpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.navigation.ScreenAxis;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class TestScreen extends Screen {
    private Button testButton;
    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mcrpg", "parchment_background");

    public TestScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
        var rect = getRectangle();
        var inner_rect = new ScreenRectangle(rect.left() + 64, rect.top() + 64, rect.width() - 128, rect.height() - 128);
        var center_y = inner_rect.top() + inner_rect.height() / 2;

        testButton = Button.builder(Component.literal("Test"), button -> {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Hello!"));
        }).bounds(inner_rect.left() + 64, center_y - 16, inner_rect.width() - 128, 32).build();
        addRenderableWidget(testButton);
    }

    @Override
    protected void renderMenuBackground(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        super.renderMenuBackground(guiGraphics, x, y, width, height);
        guiGraphics.blitSprite(BACKGROUND, x + 64, y + 64, width - 128, height - 128);
    }
}
