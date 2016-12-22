package com.liyudong.home.picasoglide;

import android.content.ContentValues;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/12/20.
 */

public class ImgFragment extends BlankFragment{

    private ImageView glide_Img;
    private ImageView picasso_Img;
    private ScrollView scrollView;

    private int flag;

    private String imgUrl = "https://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";
    private String imgUrl2 = "http://jcodecraeer.com/uploads/20150327/1427445293711143.png";
    private String imgGif = "http://n1.itc.cn/img8/wb/smccloud/2015/06/20/143479484004440591.GIF";

    private String[] imgUrls = {"http://img3.imgtn.bdimg.com/it/u=3047812567,1824275668&fm=214&gp=0.jpg",
            "https://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg",
            imgUrl2};

    private String[] imgGifs = {"http://photocdn.sohu.com/20151115/mp41892660_1447594920672_6.gif",
            "http://n1.itc.cn/img8/wb/smccloud/2015/06/20/143479484004440591.GIF",
            "http://img.zcool.cn/community/0195dd56dec4ab32f875520fa5f843.gif"};

    private ImgFragment(){

    }

    public int getFlag(){
        return this.flag;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

    public static ImgFragment newInstance(int flag){
        ImgFragment fragment = new ImgFragment();
        fragment.setFlag(flag);
        return fragment;
    }

    @Override
    protected void detoryViewAndThing() {

    }

    @Override
    protected int getContentViewId() {
        Log.d("imgVisible", "getContentViewId: ");
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        Log.d("imgVisible", "initViewsAndEvents: ");
        glide_Img = (ImageView) view.findViewById(R.id.glide_img);
        picasso_Img = (ImageView) view.findViewById(R.id.picasso_img);
//        Picasso.with(getActivity())
//                .load(imgUrl)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(picasso_Img);
//
//        Glide.with(this)
//                .load(imgGif)
//                .placeholder(R.mipmap.ic_launcher)
//                .animate(android.R.anim.slide_in_left)
//                .into(glide_Img);
    }

    @Override
    protected void onFirstUserVisible() {

        switch (flag){
            case 0:
                setImgView(imgGifs[0],imgUrls[0]);
                break;
            case 1:
                setImgView(imgGifs[1],imgUrls[1]);
                break;
            case 2:
                setImgView(imgGifs[2],imgUrls[2]);
                break;
        }
        Log.d("imgVisible", "onFirstUserVisible: ");
    }

    private void setImgView(String gif,String url){
        Picasso.with(getActivity())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(picasso_Img);

        Glide.with(this)
                .load(gif)
                .placeholder(R.mipmap.ic_launcher)
                .animate(android.R.anim.slide_in_left)
                .into(glide_Img);
    }

    @Override
    protected void onFirstUserInVisible() {
        Log.d("imgVisible", "onFirstUserInVisible: ");
    }

    @Override
    protected void onUserVisible() {
        Log.d("imgVisible", "onUserVisible: ");
    }

    @Override
    protected void onUserInVisible() {
        Log.d("imgVisible", "onUserInVisible: ");
    }
}
