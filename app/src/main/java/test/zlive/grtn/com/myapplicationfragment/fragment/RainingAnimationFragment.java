package test.zlive.grtn.com.myapplicationfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

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



        for (int i = 0; i < 2; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            RainDot + = new RainDot(getContext());
            layoutParams.setMargins(i * 10, 2*10, i*10, 0);
            rainDot.setLayoutParams(layoutParams);
            rainFrame.addView(rainDot);

//            Animation translateAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.view_animation);
//            // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
//            rainDot.startAnimation(translateAnimation);
//            // 步骤3:播放动画

        }
        return contentView;
    }
}
