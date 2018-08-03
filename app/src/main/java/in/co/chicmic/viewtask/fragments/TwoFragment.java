package in.co.chicmic.viewtask.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.activities.ImageDetailsActivity;
import in.co.chicmic.viewtask.adapters.LikeDislikeRecyclerViewAdapter;
import in.co.chicmic.viewtask.interfaces.LikeDislikeListener;
import in.co.chicmic.viewtask.utilities.AppConstants;

public class TwoFragment extends Fragment implements LikeDislikeListener {

    RecyclerView mRecyclerView;
    private int[] mData = new int[]{AppConstants.sNONE_SELECTED, AppConstants.sNONE_SELECTED};
    private int[] mImageData = new int[]{R.drawable.img_nature_pic, R.drawable.img_nature_pic};

    public TwoFragment() {
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
        View view = pInflater.inflate(R.layout.fragment_two, pContainer, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        LikeDislikeRecyclerViewAdapter mAdapter
                = new LikeDislikeRecyclerViewAdapter(mData, this, mImageData);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void changeLikeButtonColor(View pView, Button pDislikeButton, int pAdapterPosition) {
        mData[pAdapterPosition] = AppConstants.sLIKED;
        pView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pDislikeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void changeDislikeButtonColor(View pView, Button pLikeButton, int pAdapterPosition) {
        mData[pAdapterPosition] = AppConstants.sDISLIKED;
        pView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pLikeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void openImageDetailsActivity(int adapterPosition) {
        Intent intent = new Intent(getContext(), ImageDetailsActivity.class);
        intent.putExtra(AppConstants.sIMAGE_ID, mImageData[adapterPosition]);
        intent.putExtra(AppConstants.sLIKED_OR_NOT, mData[adapterPosition]);
        intent.putExtra(AppConstants.sCHECK_WHICH_ACTIVITY_FIRED_INTENT, true);
        startActivity(intent);
    }
}
