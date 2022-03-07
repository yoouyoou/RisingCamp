package rising.camp.project.week3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    lateinit var binding : HomeFragmentBinding

    companion object{
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding =
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}