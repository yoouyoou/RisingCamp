package rising.camp.project.week2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import rising.camp.project.week2.databinding.ActivityMainBinding.bind
import rising.camp.project.week2.databinding.RecyclerItemBinding
import java.security.AccessController.getContext

class ProfileAdapter:RecyclerView.Adapter<Holder>(){
    var items = mutableListOf<Profile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Holder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Click " + item.name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView?.context, ProfileActivity::class.java)
            intent.putExtra("name", item.name)
            //intent.putExtra("user", item)
            //ContextCompat: Resource에서 값을 가져오거나 퍼미션을 사용할 때 sdk버전을 고려하지않아도 되도록 처리해둔 클래스
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class Holder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun setData(pf: Profile){
        if(pf.music == "")
            binding.btnMusic.visibility = View.GONE

        binding.civImage.setImageDrawable(pf.profileImage)
        binding.tvName.text = pf.name
        binding.btnMusic.text = pf.music
    }
}