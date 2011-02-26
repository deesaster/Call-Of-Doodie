package com.deesastudio.cod;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.deesastudio.cod.screens.GameLoop;
import com.deesastudio.cod.screens.MenuScreen;
import com.deesastudio.cod.screens.Screen;

public class CallOfDoodie implements ApplicationListener{
    private boolean   mIsInitialized;
    private Screen    mScreen;
    
    @Override
    public void create() {
        if (!mIsInitialized) {
            mScreen = new MenuScreen(Gdx.app);
            mIsInitialized = true;
        }
        
    }

    @Override
    public void dispose() {
        mScreen.dispose();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render() {
        Application app = Gdx.app;
        mScreen.update(app);
        mScreen.render(app);
        
        if (mScreen.isDone()) {
            mScreen.dispose();
            mScreen = new GameLoop(app);
        }
        
    }

    @Override
    public void resize(int arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }
}
