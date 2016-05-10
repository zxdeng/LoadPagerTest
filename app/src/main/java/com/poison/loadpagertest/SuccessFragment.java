package com.poison.loadpagertest;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class SuccessFragment extends BaseFragment {
    private String str = "加载成功啦";
    @Override
    protected void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    APP.getMainThreadHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            checkData(str);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        tv.setText(str);
        return tv;
    }
}
