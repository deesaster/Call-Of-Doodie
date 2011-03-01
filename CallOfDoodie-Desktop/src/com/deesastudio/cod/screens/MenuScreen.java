package com.deesastudio.cod.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.deesastudio.cod.ValueBundle;

public class MenuScreen extends StageScreen {
    
    private final Texture           mBackgroundTexture;
    private final Texture           mButtonTexture;
    private TextureRegion           mUnpressedRegion;
    private TextureRegion           mPressedRegion;
    
    public MenuScreen(Application app, ScreenCallback callback, ValueBundle params) {
        super(app, callback, params);
        
        mBackgroundTexture = new Texture(Gdx.files.internal("graphics/background.png"));
        mBackgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        
        mButtonTexture = new Texture(Gdx.files.internal("graphics/button_simple.png"));
        mButtonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        
        mPressedRegion = new TextureRegion(mButtonTexture, 0, 128, 256, 128);
        mUnpressedRegion = new TextureRegion(mButtonTexture, 0, 0, 256, 128);
        
        Image background = new Image("background", mBackgroundTexture);
        background.height = this.height;
        background.width = this.width;
        
        addActor(background);
        
        Button testButton = new Button("testButton1", mUnpressedRegion, mPressedRegion);
        testButton.width = 100;
        testButton.height = 50;
        
        testButton.clickListener = new Button.ClickListener() {
            
            @Override
            public void clicked(Button button) {
                finishWithResults(null);
            }
        };
        addActor(testButton);
        
        Button testButton2 = new Button("testButton2", mUnpressedRegion, mPressedRegion);
        testButton2.width = 100;
        testButton2.height = 50;
        testButton2.x = app.getGraphics().getWidth() - testButton2.width;
        addActor(testButton2);
    }
    
    @Override
    public void update(Application app) {
        super.update(app);
    }

    @Override
    public void dispose() {
        super.dispose();
        
        mBackgroundTexture.dispose();
        mButtonTexture.dispose();
        
    }
}
