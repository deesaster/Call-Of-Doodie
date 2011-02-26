package com.deesastudio.cod.desktop;

import com.badlogic.gdx.backends.jogl.JoglApplication;
import com.deesastudio.cod.CallOfDoodie;

public class CallOfDoodieApplication {
    public static final String  APP_NAME = "Call Of Doodie";
    public static final int     DEFAULT_WIDTH = 480;
    public static final int     DEFAULT_HEIHT = 320;
    
    public static void main(String[] argv) {
        new JoglApplication(new CallOfDoodie(), APP_NAME, DEFAULT_WIDTH, 
                DEFAULT_HEIHT, false);
    }
}
