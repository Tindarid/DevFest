package ru.androidacademy.spb.devfest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {
    private String[] dataset;
    private Activity parent;

    public static class Holder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Holder(View v, final Activity parent) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ConferenceActivity.start(parent, getAdapterPosition());
                }
            });
            textView = v.findViewById(R.id.textView);
        }
    }

    public MainAdapter(String[] dataset, Activity parent) {
        this.dataset = dataset;
        this.parent = parent;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.text_view, parent, false);
        return new Holder(v, this.parent);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.textView.setText(dataset[position]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
