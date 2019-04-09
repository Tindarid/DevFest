package ru.androidacademy.spb.devfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] arr = getResources().getStringArray(R.array.conference_title);

        Button button = findViewById(R.id.conference1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConference();
            }
        });
        button.setText(arr[0]);

        button = findViewById(R.id.conference2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConference();
            }
        });
        button.setText(arr[1]);

        button = findViewById(R.id.conference3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConference();
            }
        });
        button.setText(arr[2]);
    }

    private void startConference() {
        ConferenceActivity.start(this);
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
