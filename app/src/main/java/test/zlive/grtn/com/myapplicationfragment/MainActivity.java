package test.zlive.grtn.com.myapplicationfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.zlive.grtn.com.myapplicationfragment.fragment.FragmemtOne;
import test.zlive.grtn.com.myapplicationfragment.fragment.FragmemtTwo;
import test.zlive.grtn.com.myapplicationfragment.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment01 = new FragmemtOne();
        Fragment fragment02 = new FragmemtTwo();
        ActivityUtil.addFragment2Activity(getSupportFragmentManager(), fragment01, R.id.contentFrame);
        ActivityUtil.replaceFragment2Activity(getSupportFragmentManager(), fragment02, R.id.contentFrame);
    }
}
