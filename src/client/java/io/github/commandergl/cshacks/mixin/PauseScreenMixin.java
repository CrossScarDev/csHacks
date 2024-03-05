package io.github.commandergl.cshacks.mixin;

import io.github.commandergl.cshacks.gui.GuiGlobal;
import io.github.commandergl.cshacks.gui.HacksScreen;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public abstract class PauseScreenMixin extends Screen {
    public PauseScreenMixin(Component title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "init()V")
    protected void init(CallbackInfo info) {
        this.addRenderableWidget(Button.builder(Component.translatable("gui.cshacks"), (p_232779_) -> {
            assert this.minecraft != null;
            this.minecraft.setScreen(new HacksScreen(this));
        }).bounds(GuiGlobal.margin, GuiGlobal.margin, 80, 20).build());
    }
}