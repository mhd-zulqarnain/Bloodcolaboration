package zulqarnain.suuet.acadmy.com.bloodcolaboration.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import zulqarnain.suuet.acadmy.com.bloodcolaboration.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import zulqarnain.suuet.acadmy.com.bloodcolaboration.model.Donner
import zulqarnain.suuet.acadmy.com.bloodcolaboration.utils

class SignUpActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance().getReference("auth")

        sign_up_button.setOnClickListener {
            initUi()
        }
    }

    private fun initUi() {
        val fname: String = first_name.text.toString()
        val lastname: String = last_name.text.toString()
        val email: String = ed_email.text.toString()
        val pass: String = ed_pass.text.toString()
        login_progress.setVisibility(View.VISIBLE)
        val bloodGroup: String = spinner_blood_group.selectedItem.toString()
        if (fname.equals("") || lastname.equals("") || email.equals("") || pass.equals("")) {
            utils.messege(this@SignUpActivity, "Incomplete information")
            return
        } else {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val donner = Donner(fname, lastname, email, bloodGroup)
                    ref.setValue(donner)
                    utils.messege(this@SignUpActivity, "success")
                    login_progress.setVisibility(View.GONE)

                } else {
                    utils.messege(this@SignUpActivity, "failed" + task.exception)
                    login_progress.setVisibility(View.GONE)

                }
            }
        }

    }

}
