package com.ez.gallery.sample.listener;

import com.squareup.picasso.Picasso;

import com.ez.gallery.PauseOnScrollListener;

/**
 * Desction:
 * Author:pengjianbo
 * Date:2016/1/9 0009 18:53
 */
public class PicassoPauseOnScrollListener extends PauseOnScrollListener {

    public PicassoPauseOnScrollListener(boolean pauseOnScroll, boolean pauseOnFling) {
        super(pauseOnScroll, pauseOnFling);
    }

    @Override
    public void resume() {
        Picasso.with(getActivity()).resumeTag(getActivity());
    }

    @Override
    public void pause() {
        Picasso.with(getActivity()).pauseTag(getActivity());
    }
}
