package rising.camp.project.week2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import rising.camp.project.week2.databinding.ActivityProfileBinding
import java.io.Serializable

class ProfileActivity : AppCompatActivity() {
    lateinit var binding:ActivityProfileBinding

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "${intent.getStringExtra("name")}님의 프로필입니다", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater);
        val view = binding.root
        setContentView(view)

        var name = intent.getStringExtra("name")
        binding.tvProfileName.setText(name)

//        var profile = intent.getSerializableExtra("user")
//        profile as Profile
//        binding.ivProfileImage.setImageDrawable(profile.profileImage)

        binding.ibChat.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("chat_name", name)
            ContextCompat.startActivity(this, intent, null)
        }

        binding.ibCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678"))
            startActivity(intent)
        }

        binding.ibCash.setOnClickListener{
            Log.d("ProfileActivity", "인텐트 값: ${intent.getStringExtra("name")}")
            val intent = Intent(this, WireActivity::class.java)
            intent.putExtra("wire_name", name)
            ContextCompat.startActivity(this, intent, null)
        }
    }
}