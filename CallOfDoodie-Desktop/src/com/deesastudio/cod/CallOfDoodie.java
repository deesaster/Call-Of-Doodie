package com.deesastudio.cod;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.deesastudio.cod.screens.GameLoop;
import com.deesastudio.cod.screens.MenuScreen;
import com.deesastudio.cod.screens.Screen;
import com.deesastudio.cod.screens.ScreenCallback;

public class CallOfDoodie implements ScreenCallback, ApplicationListener {
    
    public static final int SCREEN_MENU = 1;
    public static final int SCREEN_GAME = 2;
    public static final int SCREEN_GAME_RESULT = 4;
    
    private boolean         mIsInitialized;
    private Screen          mCurrentScreen;
    
    @Override
    public void create() {
        if (!mIsInitialized) {
            setScreen(SCREEN_MENU, null);
            mIsInitialized = true;
        }
    }
    
    @Override
    public void dispose() {
        mCurrentScreen.dispose();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render() {
        Application app = Gdx.app;
        mCurrentScreen.update(app);
        mCurrentScreen.render(app);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    protected void setScreen(int screenId, ValueBundle params) {
        if (mCurrentScreen != null) {
            mCurrentScreen.dispose();
        }
        
        switch(screenId) {
        case SCREEN_MENU:
            mCurrentScreen = new MenuScreen(Gdx.app, this, params);
            break;
        case SCREEN_GAME:
            mCurrentScreen = new GameLoop(Gdx.app, this, params);
            break;
        }
    }

    @Override
    public void onScreenFinishedWithResults(Screen screen,
            ValueBundle resultBundle) {
        
        if (screen != null && screen instanceof MenuScreen) {
            ValueBundle params = new ValueBundle();
            params.put("levelNum", new Integer(5));
            setScreen(SCREEN_GAME, params);
        } else {
            setScreen(SCREEN_MENU, null);
        }
        
    }
}
