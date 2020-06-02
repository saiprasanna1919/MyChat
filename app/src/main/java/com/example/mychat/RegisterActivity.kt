package com.example.mychat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var refUsers :DatabaseReference
    private var FireBaseUserID : String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val toolbar: Toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this@RegisterActivity , WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        mAuth = FirebaseAuth.getInstance()

        register_btn.setOnClickListener{
            registeruser()
        }



    }

    private fun registeruser() {
        val Username : String = username_register.text.toString()
        val Email : String = Email_register.text.toString()
        val Password : String = password_register.text.toString()

        if(Username == ""){
            Toast.makeText(this@RegisterActivity, "Please Enter correct User Name", Toast.LENGTH_LONG).show()
        }

        else if(Email == ""){
            Toast.makeText(this@RegisterActivity, "Please Enter correct Email", Toast.LENGTH_LONG).show()
        }

        else if (Password == ""){
            Toast.makeText(this@RegisterActivity, "Please Enter correct Password", Toast.LENGTH_LONG).show()
        }

        else {
            mAuth.createUserWithEmailAndPassword(Email , Password).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    FireBaseUserID = mAuth.currentUser!!.uid
                    refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(FireBaseUserID)

                    val UserHashMap = HashMap<String, Any>()
                    UserHashMap["uid"] = FireBaseUserID
                    UserHashMap["Username"] = Username
                    UserHashMap["Profile"] = "https://firebasestorage.googleapis.com/v0/b/mychat-eca4a.appspot.com/o/download.jpg?alt=media&token=e3da5580-a9d1-49c5-88f8-acad05f878ad"
                    UserHashMap["Cover"] = "https://firebasestorage.googleapis.com/v0/b/mychat-eca4a.appspot.com/o/cover.jpg?alt=media&token=1b136f66-ad61-45e8-9931-dee015368638"
                    UserHashMap["Status"] = "Offline"
                    UserHashMap["Search"] = Username.toLowerCase()
                    UserHashMap["FaceBook"] = "https://m.facebook.com"
                    UserHashMap["Instagram"] = "https://m.instagram.com"


                    refUsers.updateChildren(UserHashMap)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val intent = Intent(this@RegisterActivity , MainActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(intent)
                                finish()
                            }
                        }

                }

                else{

                    Toast.makeText(this@RegisterActivity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}
