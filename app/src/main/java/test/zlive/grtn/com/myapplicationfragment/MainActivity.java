package test.zlive.grtn.com.myapplicationfragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.zlive.grtn.com.myapplicationfragment.fragment.FragmemtOne;
import test.zlive.grtn.com.myapplicationfragment.fragment.FragmemtTwo;
import test.zlive.grtn.com.myapplicationfragment.fragment.RainingAnimationFragment;
import test.zlive.grtn.com.myapplicationfragment.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment01 = new FragmemtOne();
        Fragment fragment02 = new FragmemtTwo();
        RainingAnimationFragment rainAnimFrag = new RainingAnimationFragment();

        ActivityUtil.addFragment2Activity(getSupportFragmentManager(), fragment01, R.id.contentFrame);
        ActivityUtil.replaceFragment2Activity(getSupportFragmentManager(), fragment02, R.id.contentFrame);
        ActivityUtil.replaceFragment2Activity(getSupportFragmentManager(), rainAnimFrag, R.id.contentFrame);

//        intent2WebViewActivity();

    }

    private void intent2WebViewActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, WebViewActivity.class);
        startActivity(intent);
    }

    private void okHttpRequest() {
        Log.d("MainActivity", "main thread name " + Thread.currentThread().getName());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("MainActivity", "current thread name " + Thread.currentThread().getId());

                // Run on UI Thread
                new Handler(MainActivity.this.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("MainActivity", "current thread name " + Thread.currentThread().getId());
                // Run on UI Thread
                new Handler(MainActivity.this.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
