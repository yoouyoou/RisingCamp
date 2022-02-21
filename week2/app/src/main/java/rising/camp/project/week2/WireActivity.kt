package rising.camp.project.week2

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import rising.camp.project.week2.databinding.ActivityMainBinding
import rising.camp.project.week2.databinding.ActivityWireBinding

class WireActivity : AppCompatActivity() {
    lateinit var binding: ActivityWireBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        binding = ActivityWireBinding.inflate(layoutInflater)
        val view = binding.root     //뷰 가져오기
        setContentView(view)

        binding.tvWireName.text = intent.getStringExtra("wire_name")
    }

    override fun onResume() {
        super.onResume()
        var builder = AlertDialog.Builder(this)
        builder.setTitle("사기에 주의하세요!")
            .setMessage("${intent.getStringExtra("wire_name")}님에게 송금하시는게 맞습니까?")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("확인",
                DialogInterface.OnClickListener{
                        dialog, id-> null
                })
            .setNegativeButton("취소",
                DialogInterface.OnClickListener{ dialog, id->
                    finish()
                })
        builder.show()
    }
}