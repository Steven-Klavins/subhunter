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

    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;


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

        blankBitmap = Bitmap.createBitmap(numberOfHorizontalPixels,
        numberOfVerticalPixels, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();

        setContentView(R.layout.activity_main);

        Log.d("Debugging", "onCreate");

        newGame();
        draw();
    }

    void newGame () {
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "newGame");
    }

    void draw () {
        gameView.setImageBitmap(blankBitmap);
        canvas.drawColor(Color.argb(255,255,255,255));
        Log.d("Debugging", "draw");
        printDebugging();
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
        Log.d("Horizontal pixels", "" + numberOfHorizontalPixels);
        Log.d("Vertical pixels", "" + numberOfVerticalPixels);
        Log.d("Block size", "" + blockSize);
        Log.d("Grid width", "" + gridWidth);
        Log.d("Grid height", "" + gridHeight);
        Log.d("Horizontal touched", "" + horizontalTouched);
        Log.d("Vertical touched", "" + verticalTouched);
        Log.d("Sub horizontal position", "" + subHorizontalPosition);
        Log.d("Sub vertical position", "" + subVerticalPosition);
        Log.d("Hit", "" + hit);
        Log.d("Shots taken", "" + shotsTaken);
        Log.d("Debugging", "" + debugging);
        Log.d("Distance from sub", "" + distanceFromSub);
    }
}