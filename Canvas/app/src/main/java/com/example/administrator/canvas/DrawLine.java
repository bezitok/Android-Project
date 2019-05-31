package com.example.administrator.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawLine extends View {

    Paint paint = new Paint();

    public DrawLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawLine(149, 256, 572, 578, paint);
    }
}
