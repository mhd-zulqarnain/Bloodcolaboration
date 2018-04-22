package zulqarnain.suuet.acadmy.com.bloodcolaboration.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

import zulqarnain.suuet.acadmy.com.bloodcolaboration.R
import zulqarnain.suuet.acadmy.com.bloodcolaboration.model.BloodRequest
import zulqarnain.suuet.acadmy.com.bloodcolaboration.model.Comment
import zulqarnain.suuet.acadmy.com.bloodcolaboration.utils

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

class RequestFragement : Fragment() {
    internal var tv: TextView? = null
    private val addBtn: ImageButton? = null
    lateinit var ref: DatabaseReference
    lateinit var auth: FirebaseAuth
    lateinit var btn_post: Button
    private val area: String? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.request_fragment_view, container, false);
        ref = FirebaseDatabase.getInstance().getReference("Requestdetails")
        auth = FirebaseAuth.getInstance()

        val spinner_blood_group = view.findViewById<Spinner>(R.id.spinner_blood_group).selectedItem.toString()
        val spinner_urgency = view.findViewById<Spinner>(R.id.spinner_urgency).selectedItem.toString()
        val spinner_country = view.findViewById<Spinner>(R.id.spinner_country).selectedItem.toString()
        val spinner_state = view.findViewById<Spinner>(R.id.spinner_state).selectedItem.toString()
        val spinner_city = view.findViewById<Spinner>(R.id.spinner_city).selectedItem.toString()
        val spinner_hospital = view.findViewById<Spinner>(R.id.spinner_hospital).selectedItem.toString()
        val spinner_relation = view.findViewById<Spinner>(R.id.spinner_relation).selectedItem.toString()
        btn_post = view.findViewById<Button>(R.id.btn_post)

//        val userkey: String = auth.currentUser.toString()
        val userkey: String = "test123"
        val comment = arrayListOf<Comment>()


        btn_post.setOnClickListener {

            val ed_num_unit = view.findViewById<EditText>(R.id.ed_num_unit).text.toString()
            val ed_contact = view.findViewById<EditText>(R.id.ed_contact).text.toString()
            val ed_additonal_info = view.findViewById<EditText>(R.id.ed_additonal_info).text.toString()
            val rkey: String = ref.push().key

            if (ed_num_unit.equals("") || ed_contact.equals("") || ed_additonal_info.equals("")) {
                utils.messege(activity!!, "fill all filed")
            } else {
                val req = BloodRequest(userkey, rkey, "0", comment, spinner_blood_group, spinner_urgency, spinner_country, spinner_state,
                        spinner_city, spinner_hospital, spinner_relation, ed_num_unit, ed_contact, ed_additonal_info)

                ref.child(rkey).setValue(req)

                view.findViewById<EditText>(R.id.ed_num_unit).setText(" ")
                view.findViewById<EditText>(R.id.ed_contact).setText(" ")
                view.findViewById<EditText>(R.id.ed_additonal_info).setText(" ")
            }
        }

        return view;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        fun newInstance(): RequestFragement {
            val args = Bundle()
            return RequestFragement()
        }
    }

}
