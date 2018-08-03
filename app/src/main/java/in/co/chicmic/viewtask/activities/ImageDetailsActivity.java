package in.co.chicmic.viewtask.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import in.co.chicmic.viewtask.R;
import in.co.chicmic.viewtask.utilities.AppConstants;

public class ImageDetailsActivity extends AppCompatActivity {
    private ImageView mDetailImageView;
    private RatingBar mImageRatingBar;
    private Button mLikeButton;
    private Button mDislikeButton;

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_image_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mDetailImageView = findViewById(R.id.img_image_to_be_liked);
        mImageRatingBar = findViewById(R.id.rating);
        mLikeButton = findViewById(R.id.like);
        mDislikeButton = findViewById(R.id.dislike);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mDetailImageView.setImageResource(bundle.getInt(AppConstants.sIMAGE_ID));
            if (bundle.getBoolean(AppConstants.sCHECK_WHICH_ACTIVITY_FIRED_INTENT)) {
                mLikeButton.setVisibility(View.VISIBLE);
                mDislikeButton.setVisibility(View.VISIBLE);
                if (bundle.getInt(AppConstants.sLIKED_OR_NOT) == 1) {
                    mLikeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else if (bundle.getInt(AppConstants.sLIKED_OR_NOT) == 2) {
                    mDislikeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
            } else {
                mImageRatingBar.setVisibility(View.VISIBLE);
                mImageRatingBar.setRating(bundle.getInt(AppConstants.sRATING));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
