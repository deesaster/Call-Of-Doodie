package com.deesastudio.cod.screens;

import com.badlogic.gdx.utils.ObjectMap;

public interface ScreenCallback {
    public void onScreenFinishedWithResults(Screen screen, ObjectMap<String, Object> resultBundle);
}
