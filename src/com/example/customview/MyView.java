package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View{
	private Paint mPaint;
	private String mString;
	private Bitmap mBitmap;
	public MyView(Context context){
		super(context);
	}
	public MyView(Context context,AttributeSet attrs){
		super(context,attrs);
		mPaint=new Paint();
		//�õ��Զ�������Լ���MyView��declare-styleable������
		TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.MyView);
		//�õ��Զ��������ֵ
		int textColor=a.getColor(R.styleable.MyView_textColor, 0);
	    float textSize=a.getDimension(R.styleable.MyView_textSize, 36);
	    mString =a.getString(R.styleable.MyView_text);
	    int imageId=a.getResourceId(R.styleable.MyView_background, 0);
	    //��ͼƬ��id��ȡbitmapͼƬ��Դ
	    mBitmap=BitmapFactory.decodeResource(getResources(), imageId);		
		mPaint.setColor(textColor);
		mPaint.setTextSize(textSize);
		//���Լ�ʹ�����Ҫ����
		a.recycle();
	}
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		mPaint.setStyle(Style.FILL);
		canvas.drawRect(10, 10, 800, 200, mPaint);
		mPaint.setColor(Color.BLUE);
		canvas.drawText(mString, 200, 100, mPaint);
		//canvas.drawBitmap(mBitmap, 10, 10, null);
		canvas.drawBitmap(mBitmap, null,new RectF(10,10,200,200), null);
		//drawBitmap(bitmap,rect,rectF,paint)������rectF�淶ͼƬ�Ĵ�С��ͼƬҪ����rectF�涨���ı�����
	}
}
