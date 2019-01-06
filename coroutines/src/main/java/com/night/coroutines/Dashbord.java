package com.night.coroutines;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;
import okhttp3.*;

import java.io.IOException;

/**
 * <p>作者：Night  2019/1/6 20:12
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
public class Dashbord {
    private final OkHttpClient mClient = new OkHttpClient();
    private final Request mRequest = new Request.Builder().url("https://baidu.com").get().build();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public void display(final TextView mText) {
        mClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("onError", "failed", e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String msg = response.body() != null ? response.body().string() : "";
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mText.setText(msg);
                    }
                });
            }
        });
    }

}
