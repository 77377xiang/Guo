package com.yude.judicialauctionproject.activitys.mark_activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.utils.BitmapUtil;
import com.yude.judicialauctionproject.utils.ImageUtil;
import com.yude.judicialauctionproject.views.DragImageView;
import com.yude.judicialauctionproject.views.view.TouchImageView;

import java.io.InputStream;

/**
 * 手势放缩
 */
public class ImageActivity extends BaseActivity {


    private int window_width, window_height;
    private DragImageView dragImageView;
    private int state_height;
    private ViewTreeObserver viewTreeObserver;

    @Override
    public int getContentViewId() {
        return R.layout.activity_image;
    }

    @Override
    protected void initViews(Bundle bundle) {
        // requestWindowFeature(Window.FEATURE_NO_TITLE);

        String uil = getIntent().getStringExtra("uil");

        TouchImageView image_touch = (TouchImageView) findViewById(R.id.image_touch);

        ImageUtil.setImgwithOptions(uil,image_touch);
        image_touch.setOnTouchImageViewListener(new TouchImageView.OnTouchImageViewListener() {

            @Override
            public void onMove() {

            }
        });




        /*WindowManager manager = getWindowManager();
        window_width = manager.getDefaultDisplay().getWidth();
        window_height = manager.getDefaultDisplay().getHeight();
        dragImageView = (DragImageView) findViewById(R.id.fxy_image);

        Bitmap bmp = BitmapUtil.ReadBitmapById(this, R.drawable.a2,
                window_width, window_height);

        Bitmap bmp1 = BitmapFactory.decodeFile(uil);

        dragImageView.setImageBitmap(bmp1);
        dragImageView.setmActivity(this);

        viewTreeObserver = dragImageView.getViewTreeObserver();
        viewTreeObserver
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        if (state_height == 0) {
                            // ��ȡ״�����߶�
                            Rect frame = new Rect();
                            getWindow().getDecorView()
                                    .getWindowVisibleDisplayFrame(frame);
                            state_height = frame.top;
                            dragImageView.setScreen_H(window_height - state_height);
                            dragImageView.setScreen_W(window_width);
                        }

                    }
                });

*/
    }

    @Override
    protected void initData() {

    }


//    public static Bitmap ReadBitmapById(Context context, int resId) {
//        BitmapFactory.Options opt = new BitmapFactory.Options();
//        opt.inPreferredConfig = Bitmap.Config.RGB_565;
//        opt.inPurgeable = true;
//        opt.inInputShareable = true;
//
//        InputStream is = context.getResources().openRawResource(resId);
//        return BitmapFactory.decodeStream(is, null, opt);
//    }
}
