package ru.androidacademy.spb.devfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        //recyclerView.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String[] arr = getResources().getStringArray(R.array.conference_title);
        Adapter adapter = new MainAdapter(arr, this);
        recyclerView.setAdapter(adapter);
    }

    private void startConference(int number) {
        ConferenceActivity.start(this, number);
    }

    /*
    String[] arr = getResources().getStringArray(R.array.conference_title);
    for (int i = 0; i < 3; ++i) {
        final int ind = i;
        int buttonId = getResources().getIdentifier("conference" + (i + 1), "id", getPackageName());
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConference(ind);
            }
        });
        button.setText(arr[i]);
    }
    */
    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
