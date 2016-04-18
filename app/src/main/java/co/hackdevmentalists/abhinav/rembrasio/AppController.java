package co.hackdevmentalists.abhinav.rembrasio;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class AppController extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "vqzPvVkozVXiBWLHUTiHDP1UM";
    private static final String TWITTER_SECRET = "AOX1pXcjauCl4b333CQ2aCWa75n76ehyHftjJA7t80xgp8xjuc";

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

    }
}
