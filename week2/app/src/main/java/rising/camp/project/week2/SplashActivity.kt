package rising.camp.project.week2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import rising.camp.project.week2.databinding.ActivityMainBinding
import rising.camp.project.week2.databinding.SplashBinding

lateinit var binding: SplashBinding

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //뷰바인딩
        binding = SplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        }, 1000)
    }
}