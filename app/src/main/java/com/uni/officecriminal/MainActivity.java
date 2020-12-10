package com.uni.officecriminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindFragmentToPlaceHolder();
    }

    private void BindFragmentToPlaceHolder() {
        Fragment listFragment = CriminalListFragment.newInstance();
        Fragment detailFragmnt = CriminalDetailFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_criminal_list, listFragment);
        if(findViewById(R.id.fragment_criminal_detail) != null) {
            transaction.replace(R.id.fragment_criminal_detail, detailFragmnt);
        }
        transaction.commit();
    }
}
