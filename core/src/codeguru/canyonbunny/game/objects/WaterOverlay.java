package codeguru.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import codeguru.canyonbunny.game.Assets;

public class WaterOverlay extends AbstractGameObject {
    private TextureRegion waterOverlay = Assets.instance.levelDecoration.waterOverlay;
    private float length;

    public WaterOverlay(float length) {
        this.length = length;
        init();
    }

    private void init() {
        dimension.set(length * 10.0f, 3.0f);
        origin.x = -dimension.x / 2;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(waterOverlay,
                position.x + origin.x, position.y + origin.y,
                origin.x, origin.y,
                dimension.x, dimension.y,
                scale.x, scale.y,
                rotation);
    }
}
