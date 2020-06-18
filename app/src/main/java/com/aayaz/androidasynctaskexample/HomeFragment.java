package com.aayaz.androidasynctaskexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.aayaz.androidasynctaskexample.databinding.FragmentHomeBinding;

import java.util.Calendar;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        setRetainInstance(true);

        new DemoTask(Calendar.getInstance().getTime().toString()).execute("");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    class DemoTask extends AsyncTask<String, String, String> {

        private String dateTime;

        public DemoTask(String dateTime) {
            this.dateTime = dateTime;
        }

        @Override
        protected String doInBackground(String... strings) {


            for (int i = 0; i < 500; i++) {

                Log.d(TAG, "doInBackground: " + "dateTime=" + dateTime + ": i=" + i);
                Log.d(TAG, "doInBackground: ===============================>> ");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                } finally {
                    publishProgress("" + i);
                }

            }

            return "Complete";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            binding.progressBar.setProgress(Integer.parseInt(values[0]));

        }
    }

}
