package com.test;

import java.util.*;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTimeLine {
    public static void main(String []args) throws TwitterException {
        ConfigurationBuilder cf=new ConfigurationBuilder();
        cf.setDebugEnabled(true)
        .setOAuthConsumerKey("Woi2llLrHF9P6QROWstxAzHM9")
        .setOAuthConsumerSecret("XuApejeQX6HBjHx18miJ3kMNnelseYVxMHYk754eljiqoAn7B0")
        .setOAuthAccessToken("767764039019528192-bbgHFt7FmJd4SBqCsLgCAMrkjNPNwYa")
        .setOAuthAccessTokenSecret("i38ZsKlyj5gS62GQV56QS3T0Syod3Hkm1lEa2mmWrJihb"); 

        TwitterFactory tf=new TwitterFactory(cf.build());
        twitter4j.Twitter twitter=tf.getInstance();

        List<Status> status=twitter.getHomeTimeline(); 
        for(Status st:status) { 
            System.out.println(st.getUser().getName()+"----------------"+st.getText());
        }
    }
}