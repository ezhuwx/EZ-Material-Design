/*
 * Copyright (C) 2014 pengjianbo(pengjianbosoft@gmail.com), Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.ez.gallery.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.ez.gallery.Picseler;
import com.ez.gallery.R;
import com.ez.gallery.model.PhotoInfo;
import com.ez.gallery.widget.GFImageView;
import cn.finalteam.toolsfinal.adapter.ViewHolderAdapter;
import java.util.List;

/**
 * Desction:
 * Author:pengjianbo
 * Date:15/10/10 下午4:59
 */
public class PhotoListAdapter extends ViewHolderAdapter<PhotoListAdapter.PhotoViewHolder, PhotoInfo> {

    private List<PhotoInfo> mSelectList;
    private int mScreenWidth;
    private int mRowWidth;

    private Activity mActivity;

    public PhotoListAdapter(Activity activity, List<PhotoInfo> list, List<PhotoInfo> selectList, int screenWidth) {
        super(activity, list);
        this.mSelectList = selectList;
        this.mScreenWidth = screenWidth;
        this.mRowWidth = mScreenWidth/3;
        this.mActivity = activity;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflate(R.layout.gf_adapter_photo_list_item, parent);
        setHeight(view);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        PhotoInfo photoInfo = getDatas().get(position);

        String path = "";
        if (photoInfo != null) {
            path = photoInfo.getPhotoPath();
        }

        holder.mIvThumb.setImageResource(R.drawable.ic_gf_default_photo);
        Drawable defaultDrawable = mActivity.getResources().getDrawable(R.drawable.ic_gf_default_photo);
        Picseler.getCoreConfig().getImageLoader().displayImage(mActivity, path, holder.mIvThumb, defaultDrawable, mRowWidth, mRowWidth);
        holder.mView.setAnimation(null);
        if (Picseler.getCoreConfig().getAnimation() > 0) {
            holder.mView.setAnimation(AnimationUtils.loadAnimation(mActivity, Picseler.getCoreConfig().getAnimation()));
        }
        holder.mIvCheck.setImageResource(Picseler.getGalleryTheme().getIconCheck());
        if ( Picseler.getFunctionConfig().isMutiSelect() ) {
            holder.mIvCheck.setVisibility(View.VISIBLE);
            if (mSelectList.contains(photoInfo)) {
                holder.mIvCheck.setBackgroundColor(Picseler.getGalleryTheme().getCheckSelectedColor());
            } else {
                holder.mIvCheck.setBackgroundColor(Picseler.getGalleryTheme().getCheckNornalColor());
            }
        } else {
            holder.mIvCheck.setVisibility(View.GONE);
        }
    }

    private void setHeight(final View convertView) {
        int height = mScreenWidth / 3 - 8;
        convertView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
    }

    public static class PhotoViewHolder extends ViewHolderAdapter.ViewHolder {

        public GFImageView mIvThumb;
        public ImageView mIvCheck;
        View mView;
        public PhotoViewHolder(View view) {
            super(view);
            mView = view;
            mIvThumb = (GFImageView) view.findViewById(R.id.iv_thumb);
            mIvCheck = (ImageView) view.findViewById(R.id.iv_check);
        }
    }
}
