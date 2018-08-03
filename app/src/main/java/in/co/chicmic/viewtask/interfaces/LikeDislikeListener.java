package in.co.chicmic.viewtask.interfaces;

import android.view.View;
import android.widget.Button;

public interface LikeDislikeListener {
    void changeLikeButtonColor(View view, Button mDislikeButton, int adapterPosition);

    void changeDislikeButtonColor(View view, Button mLikeButton, int adapterPosition);

    void openImageDetailsActivity(int adapterPosition);
}
