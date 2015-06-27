package codeguru.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import codeguru.canyonbunny.game.Assets;

public class Rock extends AbstractGameObject {
    private TextureRegion edge = Assets.instance.rock.edge;
    private TextureRegion middle = Assets.instance.rock.middle;
    private int length;

    public Rock() {
        init();
    }

    private void init() {
        dimension.set(1.0f, 1.5f);
        setLength(1);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void increaseLength(int amount) {
        setLength(length + amount);
    }

    @Override
    public void render(SpriteBatch batch) {
        float relX = 0.0f;

        // Draw left edge
        relX -= dimension.x / 4;
        batch.draw(edge,
                position.x + relX, position.y,
                origin.x, origin.y,
                dimension.x / 4, dimension.y,
                scale.x, scale.y,
                rotation);

        // Draw middle
        relX = 0.0f;
        for (int i = 0; i < length; i++) {
            batch.draw(middle,
                    position.x + relX, position.y,
                    origin.x, origin.y,
                    dimension.x, dimension.y,
                    scale.x, scale.y,
                    rotation);
            relX += dimension.x;
        }

        // Draw right edge
        batch.draw(edge.getTexture(),
                position.x + relX, position.y,
                origin.x + dimension.x / 8, origin.y,
                dimension.x / 4, dimension.y,
                scale.x, scale.y,
                rotation,
                edge.getRegionX(), edge.getRegionY(),
                edge.getRegionWidth(), edge.getRegionHeight(),
                true, false);
    }
}
