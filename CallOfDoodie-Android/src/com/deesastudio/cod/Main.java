package com.deesastudio.cod;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class Main extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new CallOfDoodie(), false);
    }
}