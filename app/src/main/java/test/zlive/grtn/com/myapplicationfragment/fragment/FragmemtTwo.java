package test.zlive.grtn.com.myapplicationfragment.fragment;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.LineBackgroundSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.zlive.grtn.com.myapplicationfragment.R;

/**
 * Created by hp on 2017/12/11.
 */

public class FragmemtTwo extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_two, container, false);

        SpannableStringBuilder spb = new SpannableStringBuilder();
        String nickName = "逆差大要";
        spb.append(nickName);
        spb.setSpan(nickNameSpan, 0, nickName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spb.append(":");
        spb.append(Html.fromHtml("<font color=#ffe890>:</font>"));
//        spb.append("的");
        spb.append(Html.fromHtml("<font color=#f83d65>的</font>"));
        textView = view.findViewById(R.id.tv_fg_2_content);
        textView.setText(spb);

        return view;
    }

    LineBackgroundSpan lineBackgroundSpan = new LineBackgroundSpan() {
        @Override
        public void drawBackground(Canvas canvas, Paint paint, int i, int i1, int i2, int i3, int i4, CharSequence charSequence, int i5, int i6, int i7) {

        }

    };

    private ClickableSpan nickNameSpan = new ClickableSpan() {

        @Override
        public void onClick(View view) {

        }

        public void updateDrawState(TextPaint ds) {
            ds.setColor(getResources().getColor(R.color.colorPrimaryDark));//set text color
            ds.setUnderlineText(false); // set to false to remove underline
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
