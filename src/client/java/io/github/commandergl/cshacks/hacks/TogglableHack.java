package io.github.commandergl.cshacks.hacks;

import net.minecraft.network.chat.Component;

public class TogglableHack extends Hack<Boolean> {
    public Component stateMessageBase;

    public void init() {
        super.init();
        stateMessages.put(true, stateMessageBase.copy().append(" ").append(Component.translatable("gui.cshacks.hacks.toggleable.on")));
        stateMessages.put(false, stateMessageBase.copy().append(" ").append(Component.translatable("gui.cshacks.hacks.toggleable.off")));
    }
    public void setState(Boolean newState) {
        super.setState(newState);
        this.onChange();
        if (state) {
            this.onEnable();
            return;
        }
        this.onDisable();
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onChange() {

    }

    public void onConfigButtonClicked() {
        this.setState(!this.state);
    }
}
