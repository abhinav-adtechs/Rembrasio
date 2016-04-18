package co.hackdevmentalists.abhinav.rembrasio;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#10806E"), position); // blue
            case 1:
                return IntroFragment.newInstance(Color.parseColor("#10806E"), position);
            default:
                return IntroFragment.newInstance(Color.parseColor("#10806E"), position);//

            // green

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    
}