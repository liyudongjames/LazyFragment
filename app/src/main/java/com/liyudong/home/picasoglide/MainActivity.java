package com.liyudong.home.picasoglide;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<BlankFragment> fragments;
    private ViewpagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blank);
        fragments = new ArrayList<>();
        for(int i = 0 ; i < 3; i++){
            BlankFragment fragment = ImgFragment.newInstance(i);
            fragments.add(fragment);
        }

        adapter = new ViewpagerAdapter(getSupportFragmentManager(),fragments);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

    }

}

//  Observable.from(folders)
//        .flatMap(new Func1<File, Observable<File>>() {
//  @Override
//      public Observable<File> call(File file) {
//          return Observable.from(file.listFiles());
//      }
//  })
//        .filter(new Func1<File, Boolean>() {
//  @Override
//      public Boolean call(File file) {
//        return file.getName().endsWith(".png");
//      }
//    })
//    .map(new Func1<File, Bitmap>() {
//@Override
//public Bitmap call(File file) {
//        return getBitmapFromFile(file);
//        }
//        })
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Action1<Bitmap>() {
//@Override
//public void call(Bitmap bitmap) {
//        imageCollectorView.addImage(bitmap);
//        }
//        });
