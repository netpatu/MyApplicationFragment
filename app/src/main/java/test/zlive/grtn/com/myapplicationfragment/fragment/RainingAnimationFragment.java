package test.zlive.grtn.com.myapplicationfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import java.util.Random;

import test.zlive.grtn.com.myapplicationfragment.R;
import test.zlive.grtn.com.myapplicationfragment.animation.RainDot;

/**
 * Created by hp on 2018/1/9.
 */

public class RainingAnimationFragment extends Fragment {
    private LinearLayout rainFrame;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.rain_fragment, container, false);
        rainFrame = contentView.findViewById(R.id.rain_frame);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(4, 50);
        layoutParams.setMargins(0, 0, 5, 0);
        Random random = new Random(1500);
//        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();

        for (int i = 0; i < 300; i++) {
            int offset = random.nextInt(1500);
            Log.d("ramdom", "" + offset);
            RainDot rainDot = new RainDot(getContext());
            rainDot.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

            rainDot.setLayoutParams(layoutParams);
            rainFrame.addView(rainDot);

            Animation translateAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.view_animation);
//            Animation translateAnimation = new TranslateAnimation(0, 0, -100, 2000);
//            translateAnimation.setDuration(5000);
//            translateAnimation.setRepeatMode(Animation.RESTART);
//            translateAnimation.setRepeatCount(Animation.INFINITE);
            translateAnimation.setStartOffset(offset);
//            translateAnimation.setInterpolator(accelerateInterpolator);
            // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
//            rainDot.startAnimation(translateAnimation);
            // 步骤3:播放动画

//            Animation scaleAnimation = new ScaleAnimation(0,0,50,100);

        }
        return contentView;
    }
}
