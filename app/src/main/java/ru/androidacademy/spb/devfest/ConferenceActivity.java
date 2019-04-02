package ru.androidacademy.spb.devfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class ConferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
    }

    public void startMain() {
        MainActivity.start(this);
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ConferenceActivity.class));
    }
}
