package com.uni.officecriminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uni.officecriminal.model.Criminal;


/**
 * A simple {@link Fragment} subclass.
 */
public class CriminalListFragment extends Fragment {

    public CriminalListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new CriminalListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_criminal_list, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.rclCriminals);
        CriminalAdapter adapter = new CriminalAdapter(Criminal.generateCriminals());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}
