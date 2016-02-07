package codeguru.canyonbunny.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import codeguru.canyonbunny.CanyonBunnyGame;

public class DesktopLauncher {
    private static final boolean REBUILD_ATLAS = true;
    private static final boolean DRAW_DEBUG_OUTLINE = false;

    public static void main (String[] arg) {
        if (REBUILD_ATLAS) {
            TexturePacker.Settings settings = new TexturePacker.Settings();
            settings.maxWidth = 1024;
            settings.maxHeight = 1024;
            settings.debug = DRAW_DEBUG_OUTLINE;
            TexturePacker.process(settings, "../../desktop/assets-raw/images", "images",
                    "canyonbunny");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Canyon Bunny";
        config.width = 800;
        config.height = 400;
        new LwjglApplication(new CanyonBunnyGame(), config);
    }
}
