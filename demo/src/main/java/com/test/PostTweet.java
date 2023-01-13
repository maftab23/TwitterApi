package com.test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class PostTweet {

    static String consumerKeyStr = "Woi2llLrHF9P6QROWstxAzHM9";
    static String consumerSecretStr = "XuApejeQX6HBjHx18miJ3kMNnelseYVxMHYk754eljiqoAn7B0";
    static String accessTokenStr = "767764039019528192-bbgHFt7FmJd4SBqCsLgCAMrkjNPNwYa";
    static String accessTokenSecretStr = "i38ZsKlyj5gS62GQV56QS3T0Syod3Hkm1lEa2mmWrJihb";

    public static void main(String[] args) {

        try { 
            Twitter twitter = new TwitterFactory().getInstance(); 
            twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr); 
            AccessToken accessToken = new AccessToken(accessTokenStr,accessTokenSecretStr);
            twitter.setOAuthAccessToken(accessToken);
            twitter.updateStatus("Hello Once again");
            System.out.println("Successfully updated the status in Twitter.");
         } catch (TwitterException te) { 
            te.printStackTrace();
        }
    }
}
