package rising.camp.project.week2

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import rising.camp.project.week2.databinding.ActivityChatBinding
import rising.camp.project.week2.databinding.ActivityProfileBinding

class ChatActivity : AppCompatActivity() {
    lateinit var binding: ActivityChatBinding
    private lateinit var sp : SharedPreferences
    private var time: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //chatLog라는 파일이름, 해당파일은 자기 앱내에서 사용하고 외부에서 접근불가
        sp = getSharedPreferences("test", MODE_PRIVATE)

        binding.tvChatName.text = "   " + intent.getStringExtra("chat_name").toString()
    }

    override fun onStart() {
        super.onStart()

        //sp가져오기
        val content = sp.getString("chatLog", "")
        val name = content.toString().split(" ")[0]
        val chatting = content.toString().split(" ")[1]
        if(intent.getStringExtra("chat_name") == name)
            binding.etContent.setText(chatting)
    }

    override fun onPause() {
        super.onPause()

        //1. edit()메소드를 통해 SharedPreferences.Editor 객체 가져오기
        val editor : SharedPreferences.Editor = sp.edit()
        //2. putter메소드로 데이터 저장
        var info = intent.getStringExtra("chat_name").toString() + " " + binding.etContent.text.toString()
        editor.putString("chatLog", info)
        //3. apply()메소드로 데이터 최종 저장
        editor.apply()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ChatActivity", "onRestart")

        time = System.currentTimeMillis().toInt() - time
        time = (time/(1000 * 60)) % 60

        var builder = AlertDialog.Builder(this)
        builder.setTitle("카카오톡")
            .setMessage("${time}분 동안 채팅방을 보지 않았습니다. \n채팅을 이어하시겠습니까?")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("확인",
                DialogInterface.OnClickListener{
                        dialog, id-> null
                })
            .setNegativeButton("취소",
                DialogInterface.OnClickListener{ dialog, id->
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                })
        builder.show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("ChatActivity", "시간재기 시작")
        time = System.currentTimeMillis().toInt()
    }
}