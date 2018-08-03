package in.co.chicmic.viewtask.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.chicmic.viewtask.R;

public class FourFragment extends Fragment {

    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater pInflater, ViewGroup pContainer,
                             Bundle pSavedInstanceState) {
        // Inflate the layout for this fragment
        return pInflater.inflate(R.layout.fragment_three, pContainer, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
