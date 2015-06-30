package codeguru.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import codeguru.canyonbunny.game.Assets;

public class Clouds extends AbstractGameObject {
    private float length;
    private Array<TextureRegion> regClouds = new Array<>();
    private Array<Cloud> clouds;

    private class Cloud extends AbstractGameObject {
        private TextureRegion cloud;

        public void setRegion(TextureRegion region) {
            this.cloud = region;
        }

        @Override
        public void render(SpriteBatch batch) {
            batch.draw(cloud,
                    position.x + origin.x, position.y + origin.y,
                    origin.x, origin.y,
                    dimension.x, dimension.y,
                    scale.x, scale.y,
                    rotation);
        }
    }

    public Clouds(float length) {
        this.length = length;
        init();
    }

    private void init() {
        dimension.set(3.0f, 1.5f);
        regClouds.add(Assets.instance.levelDecoration.cloud01);
        regClouds.add(Assets.instance.levelDecoration.cloud02);
        regClouds.add(Assets.instance.levelDecoration.cloud03);

        int distFac = 5;
        int numClouds = (int)(length / distFac);
        clouds = new Array<>(2* numClouds);
        for (int i = 0; i < numClouds; i++) {
            Cloud cloud = spawnCloud();
            cloud.position.x = i * distFac;
            clouds.add(cloud);
        }
    }

    private Cloud spawnCloud() {
        Cloud cloud = new Cloud();
        cloud.dimension.set(dimension);
        cloud.setRegion(regClouds.random());
        Vector2 pos = new Vector2();
        pos.x = length + 10.0f;
        pos.y += 1.75;
        pos.y += MathUtils.random(0.2f) * (MathUtils.randomBoolean() ? 1 : -1);
        cloud.position.set(pos);

        return cloud;
    }

    @Override
    public void render(SpriteBatch batch) {
        for (Cloud cloud : clouds) {
            cloud.render(batch);
        }
    }
}
