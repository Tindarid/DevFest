package ru.androidacademy.spb.devfest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeakerActivity extends AppCompatActivity {
    private static final String NUMBER = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);
        final int number = getIntent().getIntExtra(NUMBER, 0);
        TextView view = findViewById(R.id.conference);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int viewId = getResources().getIdentifier("avatar", "id", getPackageName());
        ImageView image = findViewById(viewId);
        int dataId = getResources().getIdentifier("speaker" + number, "drawable", getPackageName());
        image.setImageResource(dataId);
        setData(number, "conference_speaker", "name");
        setData(number, "speaker_work", "work");
        setData(number, "speaker_country", "country");
        setData(number, "speaker_description", "description");
        setData(number, "conference_title", "conference");
    }

    private void setData(int number, String value, String place) {
        int dataId = getResources().getIdentifier(value, "array", getPackageName());
        String data = getResources().getStringArray(dataId)[number];
        int viewId = getResources().getIdentifier(place, "id", getPackageName());
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
