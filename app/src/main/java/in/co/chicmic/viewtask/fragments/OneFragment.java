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

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.activities.ImageDetailsActivity;
import in.co.chicmic.viewtask.adapters.RatingRecyclerViewAdapter;
import in.co.chicmic.viewtask.interfaces.RatingTouchListener;
import in.co.chicmic.viewtask.utilities.AppConstants;

public class OneFragment extends Fragment implements RatingTouchListener {

    RecyclerView mRecyclerView;
    private int[] mData = new int[]{R.drawable.img_nature_pic, R.drawable.img_nature_pic};
    private int[] mRating = new int[]{AppConstants.sINITIAL_RATING, AppConstants.sINITIAL_RATING};
    private RatingRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater pInflater, ViewGroup pContainer,
                             Bundle pSavedInstanceState) {
        // Inflate the layout for this fragment
        View view = pInflater.inflate(R.layout.fragment_one, pContainer, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RatingRecyclerViewAdapter(mData, mRating, this);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setNewRating(float pRating, int pPosition) {
        int rating = (int) pRating;
        mRating[pPosition] = rating;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRatingDetails(int adapterPosition) {
        Intent intent = new Intent(getContext(), ImageDetailsActivity.class);
        intent.putExtra(AppConstants.sIMAGE_ID, mData[adapterPosition]);
        intent.putExtra(AppConstants.sRATING, mRating[adapterPosition]);
        startActivity(intent);
    }
}
