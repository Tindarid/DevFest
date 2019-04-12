package ru.androidacademy.spb.devfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class ConferenceActivity extends AppCompatActivity {
    private static final String NUMBER = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        final int number = getIntent().getIntExtra(NUMBER, 0);
        Button button = findViewById(R.id.all);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMain();
            }
        });

        TextView view = findViewById(R.id.speaker);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSpeaker(number);
            }
        });

        setData(number, "title");
        setData(number, "speaker");
        setData(number, "text");
    }

    private void setData(int number, String suffix) {
        int dataId = getResources().getIdentifier("conference_" + suffix, "array", getPackageName());
        String data = getResources().getStringArray(dataId)[number];
        int viewId = getResources().getIdentifier(suffix, "id", getPackageName());
        TextView view = findViewById(viewId);
        view.setText(data);
    }

    private void startMain() {
        MainActivity.start(this);
    }

    private void startSpeaker(int number) {
        SpeakerActivity.start(this, number);
    }

    public static void start(Activity activity, int number) {
        Intent intent = new Intent(activity, ConferenceActivity.class);
        intent.putExtra(NUMBER, number);
        activity.startActivity(intent);
    }
}
