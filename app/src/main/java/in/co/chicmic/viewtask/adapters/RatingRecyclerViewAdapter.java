package in.co.chicmic.viewtask.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.interfaces.RatingTouchListener;

public class RatingRecyclerViewAdapter
        extends RecyclerView.Adapter<RatingRecyclerViewAdapter.ViewHolder> {
    private int[] mRating;
    private int[] mData;
    private RatingTouchListener mListener;

    public RatingRecyclerViewAdapter(int[] pData, int[] pRating, RatingTouchListener pListener) {
        this.mData = pData;
        mRating = pRating;
        mListener = pListener;
    }

    @NonNull
    @Override
    public RatingRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup pParent
            , int pViewType) {
        View view = LayoutInflater
                .from(pParent.getContext())
                .inflate(R.layout.rating_recycler_view, pParent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RatingRecyclerViewAdapter.ViewHolder pHolder
            , int position) {
        pHolder.mImageView.setImageResource(mData[position]);
        pHolder.mRatingBar.setRating(mRating[position]);
        pHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showRatingDetails(pHolder.getAdapterPosition());
            }
        });
        pHolder.mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mListener.setNewRating(v, pHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        RatingBar mRatingBar;

        ViewHolder(View pItemView) {
            super(pItemView);
            mImageView = pItemView.findViewById(R.id.image);
            mRatingBar = pItemView.findViewById(R.id.rating);
        }
    }
}
