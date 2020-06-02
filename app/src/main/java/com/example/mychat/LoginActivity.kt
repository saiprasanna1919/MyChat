package com.example.mychat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {


    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar: Toolbar = findViewById(R.id.toolbar_login)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Login"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this@LoginActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }


        mAuth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener {
            loginuser()
        }

    }

    private fun loginuser() {

        val Email : String = Email_login.text.toString()
        val Password : String = password_login.text.toString()

        if(Email == ""){
            Toast.makeText(this@LoginActivity, "Please Enter correct Email", Toast.LENGTH_LONG).show()
        }

        else if (Password == ""){
            Toast.makeText(this@LoginActivity, "Please Enter correct Password", Toast.LENGTH_LONG).show()
        }
        else{
            mAuth.signInWithEmailAndPassword(Email , Password)
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        val intent = Intent(this@LoginActivity , MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this@LoginActivity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }

    }



}
