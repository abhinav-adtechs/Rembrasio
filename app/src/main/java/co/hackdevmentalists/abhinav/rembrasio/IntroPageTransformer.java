package co.hackdevmentalists.abhinav.rembrasio;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class IntroPageTransformer implements ViewPager.PageTransformer {



    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes

        // it possible to know which page index you're

        // currently transforming - and that can be used

        // to make some important performance improvements.
        int pagePosition = (int) page.getTag();

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        Log.d("The page position is",""+pagePosition);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            //Log.d("Process entered","Second Page");
            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {



            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out
          //  View title = page.findViewById(R.id.title);
           // title.setAlpha(1.0f - absPosition);

            // Now the description. We also want this one to
            // fade, but the animation should also slowly move
            // down and out of the screen
           /* View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);
*/
            // Now, we want the image to move to the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            View card1 = page.findViewById(R.id.card1);
            View card2 = page.findViewById(R.id.card2);
            View card3 = page.findViewById(R.id.card3);
            View card4 = page.findViewById(R.id.card4);



            View c1 = page.findViewById(R.id.circle1);
            View c2 = page.findViewById(R.id.circle2);
            View c3 = page.findViewById(R.id.circle3);


            // We're attempting to create an effect for a View
            // specific to one of the pages in our ViewPager.
            // In other words, we need to check that we're on
            // the correct page and that the View in question
            // isn't null.
            if (pagePosition == 0 && card4 != null) {

                //computer.setAlpha(1.0f - absPosition);

                card1.setTranslationY(-pageWidthTimesPosition * 0.5f);
                card1.setTranslationX(pageWidthTimesPosition * 0.1f);
                card2.setTranslationY(-pageWidthTimesPosition * 0.3f);
                card2.setTranslationX(pageWidthTimesPosition * 0.2f);
                card3.setTranslationX(pageWidthTimesPosition * 0.4f);
                card4.setTranslationX(pageWidthTimesPosition * 0.5f);
                card4.setTranslationY(pageWidthTimesPosition * 0.3f);

                c1.setTranslationX(-pageWidthTimesPosition * 1f);
                c2.setTranslationX(-pageWidthTimesPosition * 1f);
                c3.setTranslationX(-pageWidthTimesPosition * 1f);
                //computer1.setTranslationY(pageWidthTimesPosition * 0.3f);
                                                    }

            if (pagePosition == 1 && card4 != null) {
                //computer.setAlpha(1.0f - absPosition);
                card4.setTranslationX(pageWidthTimesPosition * 0.0f);
                card4.setTranslationY(-pageWidthTimesPosition * 0.2f);
                card2.setTranslationY(pageWidthTimesPosition * 0.2f);

                c1.setTranslationX(-pageWidthTimesPosition * 1f);
                c2.setTranslationX(-pageWidthTimesPosition * 1f);
                c3.setTranslationX(-pageWidthTimesPosition * 1f);


               // card2.setTranslationY(-pageWidthTimesPosition * 0.2f);
               // computer.setTranslationY(pageWidthTimesPosition * 0.5f);
            }

            if (pagePosition == 2 && card4 != null) {
                //computer.setAlpha(1.0f - absPosition);
                card4.setTranslationX(pageWidthTimesPosition * 0.0f);
                card4.setTranslationY(-pageWidthTimesPosition * 0.2f);
                card2.setTranslationY(pageWidthTimesPosition * 0.2f);

                c1.setTranslationX(-pageWidthTimesPosition * 1f);
                c2.setTranslationX(-pageWidthTimesPosition * 1f);
                c3.setTranslationX(-pageWidthTimesPosition * 1f);


                // card2.setTranslationY(-pageWidthTimesPosition * 0.2f);
                // computer.setTranslationY(pageWidthTimesPosition * 0.5f);
            }
            /*View bluecircle = page.findViewById(R.id.blue_circle);
            if ((pagePosition >0)&&(pagePosition<=1) && bluecircle != null) {
                //computer.setAlpha(1.0f - absPosition);
                bluecircle.setTranslationX(-pageWidthTimesPosition * 3.5f);
            }*/

           // View blue_circle = page.findViewById(R.id.blue_circle);

          /*  if (pagePosition == 1 && blue_circle != null) {
                //computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(pageWidthTimesPosition * 0.5f);
                computer.setTranslationY(pageWidthTimesPosition * 0.5f);
            }*/
            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:

            if (position < 0) {
                // Create your out animation here
            } else if(position>1.0f) {


                // Create your in animation here
            }
        }


    }

}