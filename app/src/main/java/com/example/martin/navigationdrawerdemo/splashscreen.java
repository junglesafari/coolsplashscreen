package com.example.martin.navigationdrawerdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import static android.view.View.*;

public class splashscreen extends AppCompatActivity {
    LottieAnimationView root1;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splashscreen );
        root1=findViewById( R.id.animation_view );
        handler= new Handler(  );
       handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                presentActivity(root1);
            }
        } ,4000);
    }






    public void presentActivity(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY  = (int) (view.getY() + view.getHeight() / 2);

//        int = this.getResources().getDisplayMetrics().widthPixels;
//        int = this.getResources().getDisplayMetrics().heightPixels;

        root1.cancelAnimation();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(MainActivity.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       handler.removeCallbacks( null );
        root1.cancelAnimation();


    }


}