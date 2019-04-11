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
        for (int i = 1; i <= 3; ++i) {
            final int ind = i;
            int buttonId = getResources().getIdentifier("conference" + i, "id", getPackageName());
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startConference(ind);
                }
            });
            button.setText(arr[i - 1]);
        }
    }

    private void startConference(int number) {
        ConferenceActivity.start(this, number);
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
