package codeguru.canyonbunny.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

import codeguru.canyonbunny.util.Constants;

public class Assets implements Disposable, AssetErrorListener {
    private static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    public Bunny bunny;
    public Rock rock;
    public GoldCoin goldCoin;
    public Feather feather;
    public LevelDecoration levelDecoration;

    private AssetManager assetManager;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
        for (String a : assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + a);
        }

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        for (Texture t : atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        bunny = new Bunny(atlas);
        rock = new Rock(atlas);
        goldCoin = new GoldCoin(atlas);
        feather = new Feather(atlas);
        levelDecoration = new LevelDecoration(atlas);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", throwable);
    }

    public class Bunny {
        public final TextureAtlas.AtlasRegion head;

        public Bunny(TextureAtlas atlas) {
            head = atlas.findRegion("bunny_head");
        }
    }

    public class Rock {
        public final TextureAtlas.AtlasRegion edge;
        public final TextureAtlas.AtlasRegion middle;

        public Rock(TextureAtlas atlas) {
            edge = atlas.findRegion("rock_edge");
            middle = atlas.findRegion("rock_middle");
        }
    }

    public class GoldCoin {
        public final TextureAtlas.AtlasRegion goldCoin;

        public GoldCoin(TextureAtlas atlas) {
            goldCoin = atlas.findRegion("item_gold_coin");
        }
    }

    public class Feather {
        public final TextureAtlas.AtlasRegion feather;

        public Feather(TextureAtlas atlas) {
            feather = atlas.findRegion("item_feather");
        }
    }

    public class LevelDecoration {
        public final TextureAtlas.AtlasRegion cloud01;
        public final TextureAtlas.AtlasRegion cloud02;
        public final TextureAtlas.AtlasRegion cloud03;
        public final TextureAtlas.AtlasRegion mountainLeft;
        public final TextureAtlas.AtlasRegion mountainRight;
        public final TextureAtlas.AtlasRegion waterOverlay;

        public LevelDecoration(TextureAtlas atlas) {
            cloud01 = atlas.findRegion("cloud01");
            cloud02 = atlas.findRegion("cloud02");
            cloud03 = atlas.findRegion("cloud03");
            mountainLeft = atlas.findRegion("mountain_left");
            mountainRight = atlas.findRegion("mountain_right");
            waterOverlay = atlas.findRegion("water_overlay");
        }
    }
}
