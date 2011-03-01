package com.deesastudio.cod.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ObjectMap;

public class StageScreen extends Stage implements Screen {
    private ScreenCallback          mCallback;
    
    public StageScreen(Application app, ScreenCallback callback, ObjectMap<String, Object> params) {
        super(app.getGraphics().getWidth(), app.getGraphics().getHeight(), false);
        
        mCallback = callback;
        app.getInput().setInputProcessor(this);
    }

    @Override
    public void update(Application app) {

    }

    @Override
    public void render(Application app) {
        app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
        super.draw();
    }
    
    @Override
    public void dispose () {
        super.dispose();
        
        mCallback = null;
    }
    
    protected void finishWithResults(ObjectMap<String, Object> resultBundle) {
        if (mCallback != null) {
            mCallback.onScreenFinishedWithResults(this, resultBundle);
        }
    }
    
    protected void finish() {
        finishWithResults(null);
    }
}
