package com.yude.judicialauctionproject.views.voice;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MediaManager {


	private static MediaPlayer mPlayer;
	
	private static boolean isPause;

	public static  void playSound(Context context,String filePathString,
								  OnCompletionListener onCompletionListener) {
		// TODO Auto-generated method stub
//		if (mPlayer==null) {
//			mPlayer=new MediaPlayer();
//			//保险起见，设置报错监听
//			mPlayer.setOnErrorListener(new OnErrorListener() {
//
//				@Override
//				public boolean onError(MediaPlayer mp, int what, int extra) {
//					// TODO Auto-generated method stub
//					mPlayer.reset();
//					return false;
//				}
//			});
//		}else {
//			mPlayer.reset();//就回复
//
//
//		}

		if(mPlayer != null){
			mPlayer.release();
			mPlayer=null;

		}

//		mPlayer=new MediaPlayer();
		
		try {



			File soundFile =new  File(filePathString);
			if (soundFile.exists()){
				mPlayer=MediaPlayer.create(context, Uri.parse(filePathString));
//				mPlayer.setAudioStreamType(AudioManager.);
				mPlayer.setOnCompletionListener(onCompletionListener);
//				mPlayer.setDataSource(filePathString);
//				if(mPlayer.isPlaying()){
//					mPlayer.stop();
//				}
//				mPlayer.reset();
//				mPlayer.start();
				mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
					@Override
					public void onPrepared(MediaPlayer mediaPlayer) {
						mPlayer.start();
					}
				});
//				mPlayer.prepare();

			}else {
				Log.e(""," 文件："+ filePathString +" \t 不存在  ！！！");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//停止函数
	public static void pause(){
		if (mPlayer!=null&&mPlayer.isPlaying()) {
			mPlayer.pause();
			isPause=true;
		}
	}
	
	//继续
	public static void resume()
	{
		if (mPlayer!=null&&isPause) {
			mPlayer.start();
			isPause=false;
		}
	}
	

	public  static void release()
	{
		if (mPlayer!=null) {
			mPlayer.release();
			mPlayer=null;
		}
	}



}
