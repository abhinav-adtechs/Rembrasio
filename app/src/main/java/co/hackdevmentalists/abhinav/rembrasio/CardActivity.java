package co.hackdevmentalists.abhinav.rembrasio;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fl;
    private CardView card;
    private ImageButton ib;
    private ImageView iblike;

    private Animation anim;
    private float x_value;
    private float y_value;
    private int k=0;
    private int c=1;
    private ImageView iv;
    private float elevation_value;
    private ArrayList<CardView> cvList;
    private GestureDetectorCompat mDetector;

    int height, width ;
    DisplayMetrics displaymetrics = new DisplayMetrics();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card);

        // card=(CardView)findViewById(R.id.topCard);

        fl=(FrameLayout)findViewById(R.id.root);

        ib = (ImageButton)findViewById(R.id.imgButton);
        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_card);


        cvList=new ArrayList<CardView>();
        /*fl.setFocusable(true);*/
        x_value=50;
        y_value=200;
        elevation_value=2;

        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;


    }

    @Override
    protected void onStart() {
        super.onStart();

        setInit() ;
    }

    private void setInit() {
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.imgButton:
                card = new CardView(this);
                card.setRadius(12);
                card.setElevation(elevation_value);
                card.setX(x_value);
                card.setY(y_value);

                card.setLayoutParams(new FrameLayout.LayoutParams(width-100, height-350));
                cvList.add(card);
                //Inside the card
                FrameLayout frameLayoutcard=new FrameLayout(this);
                iv=new ImageView(this);
                iv.setImageResource(R.drawable.cyclefirts);
                iv.setY(100);
                iv.setX(10);
                iv.setLayoutParams(new FrameLayout.LayoutParams(600,400));
                iblike=new ImageView(this);
                iblike.setImageResource(R.drawable.greenlike);
                iblike.setY(600);
                iblike.setElevation(10);
                iblike.setX(450);
                iblike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iblike.setImageResource(R.drawable.like);
                        Toast.makeText(getApplicationContext(),"Liked",Toast.LENGTH_SHORT).show();
                    }
                });
                iblike.setLayoutParams(new FrameLayout.LayoutParams(50,50));
                frameLayoutcard.addView(iblike);
                frameLayoutcard.addView(iv);
                card.addView(frameLayoutcard);
                //Inside the card
                fl.addView(card);
                y_value = y_value - 5;
                elevation_value = elevation_value+1;
                break;

            case R.id.imgButtonnext:

                k=cvList.size();
                CardView cv;
                c=k-1;
                if(c>=0)
                {
                    cv = cvList.get(c);
                    cv.startAnimation(anim);
                    cvList.get(c).setVisibility(View.INVISIBLE);
                    cvList.remove(c);
                    y_value = y_value + 5;
                    elevation_value = elevation_value - 1;
                    Log.d("k value=", "" + k);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feeds are empty",Toast.LENGTH_SHORT).show();
                }
        }
    }

}
