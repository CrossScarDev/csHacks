package io.github.commandergl.cshacks;

import io.github.commandergl.cshacks.hacks.*;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("csHacks");

	@Override
	public void onInitializeClient() {
		new FlyHack().init();
		new FullBrightHack().init();
		new XrayHack().init();

		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			for (Hack<?> hackInstance : HackGlobal.hacks.values()) hackInstance.tick();
		});

		Main.LOGGER.info("csHacks Initialized.");
	}
}