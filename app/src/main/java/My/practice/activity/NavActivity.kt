package My.practice.activity

import My.practice.R
import My.practice.databinding.ActivityNavBinding
import My.practice.fragment.ApplicationFragment
import My.practice.fragment.HomeFragment
import My.practice.fragment.ProfileFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class NavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(R.id.container1, HomeFragment.newInstance("", ""))

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    //open fragment home
                    showFragment(R.id.container1, HomeFragment.newInstance("", ""))
                }
                R.id.menu_application -> {
                    //open fragment application
                    showFragment(R.id.container1, ApplicationFragment.newInstance("", ""))
                }
                R.id.menu_profile -> {
                    //open fragment profile
                    showFragment(R.id.container1, ProfileFragment.newInstance("", ""))
                }
            }
            true
        }
    }

    fun showFragment(id:Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }

}