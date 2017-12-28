package test.zlive.grtn.com.myapplicationfragment.datasource;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by hp on 2017/12/25.
 */

public class Task {
    private int mId;
    private String mTitle;
    private String mDesc;
    private boolean mComplete;
    private long time;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public boolean ismComplete() {
        return mComplete;
    }

    public void setmComplete(boolean mComplete) {
        this.mComplete = mComplete;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object obj) {

        //值比较;obj是个变量,它带的值是一个引用,这个引用是内存地址.
        if (this == obj)//比较是不是同一个内存地址
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Task task = (Task) obj;
        if (mId == task.getmId() && mTitle.equals(task.getmTitle()) && mDesc.equals(task.getmDesc()))
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        String[] objects = {String.valueOf(mId), mTitle, mDesc};
        return Arrays.hashCode(objects);
    }

    @Override
    public String toString() {
        return "Task with title " + mTitle;
    }
}
