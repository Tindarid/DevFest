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
        int number = getIntent().getIntExtra(NUMBER, 1) - 1;
        Button button = findViewById(R.id.all);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMain();
            }
        });
        String title = getResources().getStringArray(R.array.conference_title)[number];
        TextView view = findViewById(R.id.title);
        view.setText(title);
    }

    private void startMain() {
        MainActivity.start(this);
    }

    public static void start(Activity activity, int number) {
        Intent intent = new Intent(activity, ConferenceActivity.class);
        intent.putExtra(NUMBER, number);
        activity.startActivity(intent);
    }
}
