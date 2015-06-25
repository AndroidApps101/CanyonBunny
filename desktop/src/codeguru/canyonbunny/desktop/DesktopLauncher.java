package codeguru.canyonbunny.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import codeguru.canyonbunny.CanyonBunnyGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Canyon Bunny";
        config.width = 800;
        config.height = 400;
        new LwjglApplication(new CanyonBunnyGame(), config);
    }
}
