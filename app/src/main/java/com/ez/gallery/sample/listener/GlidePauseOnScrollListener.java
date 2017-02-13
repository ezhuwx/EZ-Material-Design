package com.ez.gallery.sample.listener;

import com.bumptech.glide.Glide;

import com.ez.gallery.PauseOnScrollListener;

/**
 * Desction:
 * Author:pengjianbo
 * Date:2016/1/9 0009 18:18
 */
public class GlidePauseOnScrollListener extends PauseOnScrollListener {

    public GlidePauseOnScrollListener(boolean pauseOnScroll, boolean pauseOnFling) {
        super(pauseOnScroll, pauseOnFling);
    }

    @Override
    public void resume() {
        Glide.with(getActivity()).resumeRequests();
    }

    @Override
    public void pause() {
        Glide.with(getActivity()).pauseRequests();
    }
}
