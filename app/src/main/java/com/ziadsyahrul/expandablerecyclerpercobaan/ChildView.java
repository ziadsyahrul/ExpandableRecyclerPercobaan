package com.ziadsyahrul.expandablerecyclerpercobaan;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.ziadsyahrul.expandablerecyclerpercobaan.model.ChildLinkItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Layout(R.layout.child_layout)
public class ChildView {

    private static String TAG = "ChildView";
    private Map<String, List<ChildLinkItem>> categoryMap;

    @View(R.id.child_name)
    TextView textViewChild;

    @View(R.id.child_desc)
    TextView textViewDesc;

    @View(R.id.child_image)
    ImageView childImage;

    private Context mContext;
    private List<ChildLinkItem> childLinkItem;
    private ChildLinkItem dd;

    public ChildView(Context mContext, List<ChildLinkItem> childLinkItem) {
        this.mContext = mContext;
        this.childLinkItem = childLinkItem;
    }

    @Resolve
    private void onResolve() {
        Log.d(TAG, "onResolve");

        /*String childLinkItems = new ChildLinkItem().getTitle();*/

        for (ChildLinkItem childLinkItem : childLinkItem){
             textViewChild.setText(childLinkItem.getTitle());
        }

        Glide.with(mContext).load(dd.getAvatar()).apply(RequestOptions.centerCropTransform()).into(childImage);

    }




}
