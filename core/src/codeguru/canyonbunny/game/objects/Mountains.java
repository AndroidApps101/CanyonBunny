package codeguru.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import codeguru.canyonbunny.game.Assets;

public class Mountains extends AbstractGameObject {
    private TextureRegion left = Assets.instance.levelDecoration.mountainLeft;
    private TextureRegion right = Assets.instance.levelDecoration.mountainRight;
    private int length;

    public Mountains(int length) {
        this.length = length;
        init();
    }

    private void init() {
        dimension.set(10.0f, 2.0f);

        // shift mountain and extend length
        origin.x = -dimension.x * 2;
        length += dimension.x * 2;
    }

    private void drawMountain(SpriteBatch batch, float offsetX, float offsetY, float tintColor) {
        batch.setColor(tintColor, tintColor, tintColor, 1.0f);
        float xRel = dimension.x * offsetX;
        float yRel = dimension.y * offsetY;

        // mountains span the whole level
        int mountainLength = 0;
        mountainLength += MathUtils.ceil(length / (2 * dimension.x));
        mountainLength += MathUtils.ceil(0.5f + offsetX);
        for (int i = 0; i < mountainLength; i++) {
            // mountain left
            batch.draw(left,
                    position.x + xRel, position.y + origin.y + yRel,
                    origin.x, origin.y,
                    dimension.x, dimension.y,
                    scale.x, scale.y,
                    rotation);
            xRel += dimension.x;

            // mountain right
            batch.draw(right,
                    position.x + xRel, position.y + origin.y + yRel,
                    origin.x, origin.y,
                    dimension.x, dimension.y,
                    scale.x, scale.y,
                    rotation);
            xRel += dimension.x;
        }

        // reset color to white
        batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void render(SpriteBatch batch) {
        drawMountain(batch, 0.5f, 0.5f, 0.5f);
        drawMountain(batch, 0.25f, 0.25f, 0.25f);
        drawMountain(batch, 0.0f, 0.0f, 0.0f);
    }
}
