package codeguru.canyonbunny.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import codeguru.canyonbunny.game.objects.Clouds;
import codeguru.canyonbunny.game.objects.Mountains;
import codeguru.canyonbunny.game.objects.Rock;
import codeguru.canyonbunny.game.objects.WaterOverlay;

public class Level {
    public enum BLOCK_TYPE {
        EMPTY(0, 0, 0),                   // black
        ROCK(0, 255, 0),                  // green
        PLAYER_SPAWNPOINT(255, 255, 255), // white
        ITEM_FEATHER(255, 0, 255),        // purple
        ITEM_GOLD_COIN(255, 255, 0);      // yellow

        private int color;

        BLOCK_TYPE(int r, int g, int b) {
            color = r << 24 | g << 16 | b << 8 | 0xff;
        }

        public boolean sameColor(int color) {
            return this.color == color;
        }

        public int getColor() {
            return color;
        }

    }

    // objects
    public Array<Rock> rocks;

    // decoration
    public Clouds clouds;
    public Mountains mountains;
    public WaterOverlay waterOverlay;

    public Level(String filename) {
        init(filename);
    }

    private void init(String filename) {

    }

    public void render(SpriteBatch batch) {

    }
}
