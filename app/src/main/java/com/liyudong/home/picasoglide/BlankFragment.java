package com.liyudong.home.picasoglide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BlankFragment extends Fragment {

    protected boolean isFirstVisible = true;
    protected boolean isFirstInVisible = true;
    protected boolean isPrepared;
    public String params;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(getContentViewId()!=0){
            return inflater.inflate(getContentViewId(), container, false);
        }else{
            return super.onCreateView(inflater,container,savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndEvents(view);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
        Log.d("imgVisible", "setUserVisibleHint: " + isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInVisible) {
                isFirstInVisible = false;
                onFirstUserInVisible();
            } else {
                onUserInVisible();
            }
        }
    }

    @Override
    public void onDestroy() {
        detoryViewAndThing();
        super.onDestroy();
    }

    protected abstract void detoryViewAndThing();
    protected abstract int getContentViewId();
    protected abstract void initViewsAndEvents(View view);
    protected abstract void onFirstUserVisible();
    protected abstract void onFirstUserInVisible();
    protected abstract void onUserVisible();
    protected abstract void onUserInVisible();
}
