package com.stevenklavins.sub_hunter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.util.Log;
import android.widget.ImageView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int numberOfHorizontalPixels;
    int numberOfVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int subHorizontalPosition;
    int subVerticalPosition;
    boolean hit = false;
    int shotsTaken;
    int distanceFromSub;
    boolean debugging = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        numberOfHorizontalPixels = size.x;
        numberOfVerticalPixels = size.y;
        blockSize = numberOfHorizontalPixels/gridWidth;
        gridHeight = numberOfVerticalPixels/blockSize;

        setContentView(R.layout.activity_main);

        Log.d("Debugging", "onCreate");

        newGame();
        draw();
    }

    void newGame () {
        Log.d("Debugging", "newGame");

    }

    void draw () {
        Log.d("Debugging", "draw");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Debugging", "onTouchEvent");
        takeShot();
        return true;
    }

    void takeShot () {
        Log.d("Debugging", "takeShot");

    }

    void boom () {
        Log.d("Debugging", "boom");

    }

    void  printDebugging () {

    }
}