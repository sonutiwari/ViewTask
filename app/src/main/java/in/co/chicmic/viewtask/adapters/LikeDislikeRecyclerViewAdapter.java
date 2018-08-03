package in.co.chicmic.viewtask.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.interfaces.LikeDislikeListener;
import in.co.chicmic.viewtask.utilities.AppConstants;

public class LikeDislikeRecyclerViewAdapter
        extends RecyclerView.Adapter<LikeDislikeRecyclerViewAdapter.ViewHolder> {

    private int[] mData;
    private int[] mImageData;
    private LikeDislikeListener mListener;

    public LikeDislikeRecyclerViewAdapter(int[] pData, LikeDislikeListener pListener
            , int[] pImageData) {
        mData = pData;
        mListener = pListener;
        mImageData = pImageData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup pParent, int pViewType) {
        View view = LayoutInflater
                .from(pParent.getContext())
                .inflate(R.layout.like_dislike_card, pParent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder pHolder, int pPosition) {
        if (mData[pPosition] == AppConstants.sLIKED) {
            mListener.changeLikeButtonColor(pHolder.mLikeButton, pHolder.mDislikeButton
                    , pHolder.getAdapterPosition());
        }
        if (mData[pPosition] == AppConstants.sDISLIKED) {
            mListener.changeDislikeButtonColor(pHolder.mDislikeButton, pHolder.mLikeButton
                    , pHolder.getAdapterPosition());
        }
        pHolder.mImageView.setImageResource(mImageData[pPosition]);
        pHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openImageDetailsActivity(pHolder.getAdapterPosition());
            }
        });
        pHolder.mLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.changeLikeButtonColor(view, pHolder.mDislikeButton
                        , pHolder.getAdapterPosition());
            }
        });
        pHolder.mDislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.changeDislikeButtonColor(view, pHolder.mLikeButton
                        , pHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Button mLikeButton;
        Button mDislikeButton;
        ImageView mImageView;

        ViewHolder(View pItemView) {
            super(pItemView);
            mLikeButton = pItemView.findViewById(R.id.like);
            mDislikeButton = pItemView.findViewById(R.id.dislike);
            mImageView = pItemView.findViewById(R.id.img_image_to_be_liked);
        }
    }
}
