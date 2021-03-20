package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5t34BPrR5fg4bpqPB6zNBj9WKNzBGjRNVR787hE0")
                .clientKey("P5tsS8C9jlavwB310wdqQmHF9HLo8wkbkvj6t3w6")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
