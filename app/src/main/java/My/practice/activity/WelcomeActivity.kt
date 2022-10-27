package My.practice.activity

import My.practice.databinding.ActivityWelcomeBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashScreen.setKeepOnScreenCondition{ true }

        val isLogin = false
        if(isLogin) {
            openNavActivity()
        }else{
            openLoginActivity()
        }

    }

    private fun openNavActivity(){
        val intent = Intent(this@WelcomeActivity, NavActivity::class.java)
        startActivity(intent)
    }

    private fun openLoginActivity(){
        val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
        startActivity(intent)

}
}
