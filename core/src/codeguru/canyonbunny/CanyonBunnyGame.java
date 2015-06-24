package codeguru.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import codeguru.canyonbunny.game.WorldController;
import codeguru.canyonbunny.game.WorldRenderer;

public class CanyonBunnyGame extends ApplicationAdapter {
    private WorldController controller;
    private WorldRenderer renderer;
    private boolean paused;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        controller = new WorldController();
        renderer = new WorldRenderer(controller);
        paused = false;
    }

    @Override
    public void render () {
        if (!paused) {
            controller.update(Gdx.graphics.getDeltaTime());
        }
        Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }
}
