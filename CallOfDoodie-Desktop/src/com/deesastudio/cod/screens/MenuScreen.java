package com.deesastudio.cod.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Button;

public class MenuScreen implements Screen, InputProcessor {
    private final SpriteBatch       mSpriteBatch;
    private final Texture           mBackgroundTexture;
    private final Texture           mButtonTexture;
    private final Matrix4           mViewMatrix = new Matrix4();
    private final Matrix4           mTransformMatrix = new Matrix4();
    private Stage                   mStage;
    private TextureRegion           mUnpressedRegion;
    private TextureRegion           mPressedRegion;
    
    public MenuScreen(Application app) {
        mSpriteBatch = new SpriteBatch();
        mBackgroundTexture = new Texture(Gdx.files.internal("graphics/background.png"));
        mBackgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        
        mButtonTexture = new Texture(Gdx.files.internal("graphics/button_simple.png"));
        mButtonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        
        mStage = new Stage(app.getGraphics().getWidth(), app.getGraphics().getHeight(), true);
        mPressedRegion = new TextureRegion(mButtonTexture, 0, 128, 256, 128);
        mUnpressedRegion = new TextureRegion(mButtonTexture, 0, 0, 256, 128);
        
        Button testButton = new Button("testButton1", mUnpressedRegion, mPressedRegion);
        testButton.width = 100;
        testButton.height = 50;
        
        testButton.clickListener = new Button.ClickListener() {
            
            @Override
            public void clicked(Button button) {
                Gdx.app.log("test", "test");
            }
        };
        mStage.addActor(testButton);
        
        Button testButton2 = new Button("testButton2", mUnpressedRegion, mPressedRegion);
        testButton2.width = 100;
        testButton2.height = 50;
        testButton2.x = app.getGraphics().getWidth() - testButton2.width;
        mStage.addActor(testButton2);
        
        app.getInput().setInputProcessor(mStage);
    }
    
    @Override
    public void update(Application app) {

    }

    @Override
    public void render(Application app) {
        app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        mViewMatrix.setToOrtho2D(0, 0, app.getGraphics().getWidth(), app.getGraphics().getHeight());
        mSpriteBatch.setProjectionMatrix(mViewMatrix);
        mSpriteBatch.setTransformMatrix(mTransformMatrix);
        mSpriteBatch.begin();
        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(mBackgroundTexture, 0, 0, 480, 320, 0, 0, 480, 320, false, false);
        mSpriteBatch.enableBlending();
//        mSpriteBatch.draw(mButtonTexture, 0, 0, 150, 50, 0, 0, 128, 128, false, false);
        mStage.draw();
        mSpriteBatch.end();
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        return false;
    }

    @Override
    public boolean touchMoved(int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
