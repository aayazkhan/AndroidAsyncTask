package com.aayaz.androidasynctaskexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aayaz.androidasynctaskexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private FragmentManager fragmentManager = null;
    private Fragment homefragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        initateHomeFragment();
    }

    private void initateHomeFragment() {

        homefragment = fragmentManager.findFragmentByTag("HomeFragment");
        homefragment = homefragment == null ? HomeFragment.newInstance() : homefragment;

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container_home, homefragment, "HomeFragment");
        transaction.commit();
    }

}