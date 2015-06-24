package codeguru.canyonbunny;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import codeguru.canyonbunny.game.WorldController;
import codeguru.canyonbunny.game.WorldRenderer;

public class CanyonBunnyGame extends ApplicationAdapter {
    private WorldController controller;
    private WorldRenderer renderer;

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
