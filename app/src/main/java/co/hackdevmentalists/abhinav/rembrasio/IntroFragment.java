package co.hackdevmentalists.abhinav.rembrasio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class IntroFragment extends Fragment implements View.OnClickListener{

    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String PAGE = "page";
    ImageView iv;
    private CardView cardViewTwitter ;

    TwitterLoginButton twitterLoginButton ;

    private int mBackgroundColor, mPage;

    public static IntroFragment newInstance(int backgroundColor, int page) {
        IntroFragment frag = new IntroFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, backgroundColor);
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (!getArguments().containsKey(BACKGROUND_COLOR))
            throw new RuntimeException("Fragment must contain a \"" + BACKGROUND_COLOR + "\" argument!");
        mBackgroundColor = getArguments().getInt(BACKGROUND_COLOR);

        if (!getArguments().containsKey(PAGE))
            throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        mPage = getArguments().getInt(PAGE);
                                                    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Select a layout based on the current page
        int layoutResId;



        switch (mPage) {
            case 0:
                layoutResId = R.layout.fragment_intro_layout_1;
                break;
            case 1:
                layoutResId = R.layout.fragment_intro_layout_2;
                break;
            case 2:
                layoutResId = R.layout.fragment_intro_layout_3;
                break;
            default:
                layoutResId = R.layout.fragment_intro_layout_2;
                break;

        }

        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        view.setTag(mPage);
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        twitterLoginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button) ;

        cardViewTwitter = (CardView) view.findViewById(R.id.card3) ;

        cardViewTwitter.setOnClickListener(this);

        super.onViewCreated(view, savedInstanceState);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
        ImageView iv1 = (ImageView) view.findViewById(R.id.circle1);
        ImageView iv2=(ImageView)view.findViewById(R.id.circle2);
        ImageView iv3=(ImageView)view.findViewById(R.id.circle3);
        iv1.startAnimation(animation);
        iv2.startAnimation(animation);
        iv3.startAnimation(animation);
        // Set the background color of the root view to the color specified in newInstance()
        View background = view.findViewById(R.id.intro_background);
        background.setBackgroundColor(mBackgroundColor);

        handleLogin() ;
    }

    private void handleLogin() {


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.card3){
            Intent intent = new Intent(getActivity(), LoginActivity.class) ;
            startActivity(intent);
        }

    }
}