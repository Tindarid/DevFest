package ru.androidacademy.spb.devfest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeakerActivity extends AppCompatActivity {
    private static final String NUMBER = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);
        final int number = getIntent().getIntExtra(NUMBER, 0);
        Button button = findViewById(R.id.conference);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConference(number);
            }
        });

        //setData(number, "image");
        //setData(number, "name");
        //setData(number, "work");
        //setData(number, "country");
        //setData(number, "description");
    }

    private void setData(int number, String suffix) {
        int dataId = getResources().getIdentifier("speaker_" + suffix, "array", getPackageName());
        String data = getResources().getStringArray(dataId)[number];
        int viewId = getResources().getIdentifier(suffix, "id", getPackageName());
        TextView view = findViewById(viewId);
        view.setText(data);
    }

    private void startConference(int number) {
        ConferenceActivity.start(this, number);
    }

    public static void start(Activity activity, int number) {
        Intent intent = new Intent(activity, SpeakerActivity.class);
        intent.putExtra(NUMBER, number);
        activity.startActivity(intent);
    }
}
