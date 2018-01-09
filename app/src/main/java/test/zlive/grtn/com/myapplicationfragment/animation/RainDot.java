package test.zlive.grtn.com.myapplicationfragment.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hp on 2018/1/9.
 */

public class RainDot extends View {
    private Paint mPaint;

    public RainDot(Context context) {
        this(context, null);
    }

    public RainDot(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RainDot(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 定义一个画笔
     */
    private void initPaint() {
        mPaint = new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        //颜色
        mPaint.setColor(Color.RED);
        //设置样式
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.画直线

        float startX = 10; //起始点X点
        float stopX = 10; //结束点X
        float startY = 0;//起始点Y点
        float stopY = 100; //结束点Y
        //Paint()是画笔
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }
}
