package codeguru.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject {
    public Vector2 position = new Vector2();
    public Vector2 dimension = new Vector2(1, 1);
    public Vector2 origin = new Vector2();
    public Vector2 scale = new Vector2(1, 1);
    public float rotation = 0.0f;

    public void update(float deltaTime) {
    }

    public abstract void render(SpriteBatch batch);
}
