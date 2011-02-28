package com.deesastudio.cod.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class MenuScreen implements Screen {
    private final SpriteBatch     mSpriteBatch;
    private final Texture         mBackgroundTexture;
    private final Matrix4         mViewMatrix = new Matrix4();
    private final Matrix4         mTransformMatrix = new Matrix4();
    
    public MenuScreen(Application app) {
        mSpriteBatch = new SpriteBatch();
        mBackgroundTexture = new Texture(Gdx.files.internal("graphics/background.png"));
        mBackgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }
    
    @Override
    public void update(Application app) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Application app) {
        app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        mViewMatrix.setToOrtho2D(0, 0, 480, 320);
        mSpriteBatch.setProjectionMatrix(mViewMatrix);
        mSpriteBatch.setTransformMatrix(mTransformMatrix);
        mSpriteBatch.begin();
        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(mBackgroundTexture, 0, 0, 480, 320, 0, 0, 480, 320, false, false);
        mSpriteBatch.end();
    }

    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}
