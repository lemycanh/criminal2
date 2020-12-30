package com.uni.officecriminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class CriminalDetailFragment extends Fragment {

    private TextView mTvTitle;

    public CriminalDetailFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new CriminalDetailFragment();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCriminalClick(CriminalClickEvent ev) {
        mTvTitle.setText(ev.getCriminal().getTitle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_criminal_detail, container, false);
        mTvTitle = v.findViewById(R.id.criminal_title);
        EventBus.getDefault().register(this);
        return v;
    }
}
