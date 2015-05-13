package com.example.dt.testmotionevent2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public static final String TAG="TestMotionEvent2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        setContentView(new TestMotionView(this));
    }
public class TestMotionView extends View{
    private Paint mPaint = new Paint();
    private float mX;
    private float mY;
    int mAction;
    public TestMotionView(Context c){
        super(c);
        mAction= MotionEvent.ACTION_UP;
        mX=0;
        mY=0;
    }

    protected void onDraw(Canvas canvas){
        Paint paint=mPaint;
        canvas.drawColor(Color.WHITE);
        if(MotionEvent.ACTION_MOVE == mAction)
            paint.setColor(Color.RED);
        else if(MotionEvent.ACTION_UP == mAction)
            paint.setColor(Color.GREEN);
        else if(MotionEvent.ACTION_DOWN == mAction)
            paint.setColor(Color.BLUE);

        canvas.drawCircle(mX,mY,20,paint);
        setTitle("A="+mAction+"["+mX+","+mY+"]");

    }

    public boolean onTouchEvent(MotionEvent event){
           Log.v(TAG,event.toString());
            mX=event.getX();
            mY=event.getY();
            mAction=event.getAction();
            invalidate();

        return true;
    }

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
