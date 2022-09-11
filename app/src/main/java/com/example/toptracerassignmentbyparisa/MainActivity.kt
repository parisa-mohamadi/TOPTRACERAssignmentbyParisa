package com.example.toptracerassignmentbyparisa


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toptracerassignmentbyparisa.view.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {

            val username = et_username.text
            val password = et_password.text
            if (username.toString().trim().isNullOrEmpty() || password.toString().trim()
                    .isNullOrEmpty()
            ) {
                ShowAlertDialog.show("Oops!","It looks like you forgot to provide a username or password",this)

            } else {
                if (password.toString() == "password") {

                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putExtra("username", username.toString())
                    startActivity(intent)
                    finish()

                } else {
                    ShowAlertDialog.show("Oops!","The password you provided does't match our records",this)

                }
            }
        }
    }
}