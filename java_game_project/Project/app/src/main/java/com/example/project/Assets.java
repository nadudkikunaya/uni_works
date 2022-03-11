package com.example.project;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Assets {
    public static final int GRID_WIDTH = 64, GRID_HEIGHT = 64;
    private static final Bitmap bg = BitmapFactory.decodeResource(Device.resources,R.drawable.bg);
    public static Bitmap bgScaled = Bitmap.createScaledBitmap(bg,1080,1920,false);

    private static final Bitmap brick = BitmapFactory.decodeResource(Device.resources,R.drawable.brick);
    public static Bitmap brickScaled = Bitmap.createScaledBitmap(brick,64,64,false);

    private static final Bitmap toxic = BitmapFactory.decodeResource(Device.resources,R.drawable.toxicwater);
    public static Bitmap toxicScaled = Bitmap.createScaledBitmap(toxic,64,64,false);

    private static final Bitmap bg3 = BitmapFactory.decodeResource(Device.resources,R.drawable.bg3);
    public static Bitmap testBlock = Bitmap.createScaledBitmap(bg3,64,64,false);

    private static final Bitmap player = BitmapFactory.decodeResource(Device.resources,R.drawable.player_model);
    public static Bitmap playerScaled = Bitmap.createScaledBitmap(player,128,64,false);

    private static final Bitmap goblin = BitmapFactory.decodeResource(Device.resources,R.drawable.globlin_model);
    public static Bitmap goblinScaled = Bitmap.createScaledBitmap(goblin,128,64,false);



    private static final Bitmap key0 = BitmapFactory.decodeResource(Device.resources,R.drawable.keyup);
    private static final Bitmap key1 = BitmapFactory.decodeResource(Device.resources,R.drawable.keydown);
    private static final Bitmap key2 = BitmapFactory.decodeResource(Device.resources,R.drawable.keyleft);
    private static final Bitmap key3 = BitmapFactory.decodeResource(Device.resources,R.drawable.keyright);
    public static Bitmap keyUp = Bitmap.createScaledBitmap(key0,64,128,false);
    public static Bitmap keyDown = Bitmap.createScaledBitmap(key1,64,128,false);
    public static Bitmap keyLeft = Bitmap.createScaledBitmap(key2,128,64,false);
    public static Bitmap keyRight = Bitmap.createScaledBitmap(key3,128,64,false);
}
