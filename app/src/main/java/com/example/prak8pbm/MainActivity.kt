package com.example.prak8pbm

import android.accessibilityservice.GestureDescription
import android.gesture.Gesture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    //variable untuk mendeteksi gesture yang diberi nilai awal yaitu null
    var gDetector : GestureDetectorCompat? = null
    override fun onDoubleTap(e: MotionEvent?): Boolean {
        gestur_status.text = "onDoubleTap"
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //membuat class turunan gestureDetectorCompat
        this.gDetector = GestureDetectorCompat(this, this)
        //mendeteksi ketukan ganda
        gDetector?.setOnDoubleTapListener(this)
    }
    //mencegah sentuhan tap/ dan meneruskanya ke instance GestureDetectorCompat
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        //memastikan untuk memanggil implementasi superClass
        return super.onTouchEvent(event)
    }
    //implementasi untuk ketukan berulang dua kali atau onDoubleTap
    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        gestur_status.text = "onDoubleTap"
        return true
    }
    //implemenatasi untuk satu kali ketukan dikonfirmasi atau onsingleTapconfirmed
    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        gestur_status.text = "OnSingleTapConfirmed"
        return true
    }
    //implementasi untuk menekan atau onShowPress
    override fun onShowPress(e: MotionEvent?) {
        gestur_status.text = "onShowPress"
    }
    //implementasi untuk sekali ketuk atau onSingleTapUp
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        gestur_status.text = "onSingleTapUp"
        return true
    }
    //implementasi untuk ketukan kebawah atau onDown
    override fun onDown(e: MotionEvent?): Boolean {
        gestur_status.text = "onDown"
        return true
    }
    //implementasi untuk ketukan melempar atau onFiling
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        gestur_status.text = "onShowPress"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        gestur_status.text = "onScroll"
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        gestur_status.text = "onLongPress"
    }
}
