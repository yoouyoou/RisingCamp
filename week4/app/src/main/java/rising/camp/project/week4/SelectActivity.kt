package rising.camp.project.week4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock.sleep
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rising.camp.project.week4.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectBinding
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }
    var point: PointF? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이미지, x축, y축, 시간
        imagemove(binding.ivArrow, 1000f, 2000L)
//        Thread.sleep(2000L)
//        imagemove2(binding.ivArrow, 1000f, 2000L)
    }

    private fun imagemove(image1: ImageView, posix:Float, duration1: Long){
        runnable = object :Runnable{
            override fun run() {
                ObjectAnimator.ofFloat(image1, "translationX", posix).apply {
                    repeatCount = ValueAnimator.INFINITE    //무한 반복
                    repeatMode = ValueAnimator.REVERSE      //다시 돌아가기
                    duration = duration1
                    start()
                }
//                handler.postDelayed(runnable, duration1)
            }
        }
        handler.post(runnable)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        point = PointF(event!!.x, event!!.y)
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                Toast.makeText(this, "좌표: ${point?.x}, ${point?.y}", Toast.LENGTH_SHORT).show()
                if(point?.x!! > 1620 && point?.x!! < 1719) {
                    Toast.makeText(this, "손잡이 클릭", Toast.LENGTH_SHORT).show()
                    handler.sendEmptyMessage(0)
                    handler.removeCallbacks({
                        if(527 < binding.ivArrow.x && binding.ivArrow.x < 710)
                            Toast.makeText(this, "첫번째 얼굴", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
        return true
    }
}