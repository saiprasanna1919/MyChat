package com.example.mychat.AdapterClasses

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mychat.MainActivity
import com.example.mychat.MessageChatActivity
import com.example.mychat.ModleClasses.Users
import com.example.mychat.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_searh_item_layout.view.*
import kotlinx.android.synthetic.main.user_searh_item_layout.view.profile_image

class UserAdapter(
    mContext : Context ,
    mUsers : List<Users> ,
    isChatChek : Boolean) : RecyclerView.Adapter<UserAdapter.ViewHolder?>()
{

    private val mContext : Context
    private val mUsers : List<Users>
    private var isChatChek : Boolean

    init {
        this.mUsers = mUsers
        this.mContext = mContext
        this.isChatChek = isChatChek
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.user_searh_item_layout , viewGroup , false)
        return  UserAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, i : Int) {

        val user: Users = mUsers[i]
        holder.userNameTxt.text = user!!.getUsername()
        Picasso.get().load(user.getProfile()).placeholder(R.drawable.download).into(holder.profileImageView)

        holder.itemView.setOnClickListener{

            val options = arrayOf<CharSequence>(

                "Send Message",
                "Visit Profile"

            )

            val builder : AlertDialog.Builder = AlertDialog.Builder(mContext)
            builder.setTitle("What do you want.?")
            builder.setItems(options, DialogInterface.OnClickListener{ dialog, position ->
                if (position == 0){

                    val intent = Intent(mContext , MessageChatActivity::class.java)
                    intent.putExtra("visit_id" , user.getuid())
                    mContext.startActivity(intent)


                }

                if (position == 1){



                }

            })

            builder.show()

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userNameTxt : TextView
        var profileImageView : CircleImageView
        var onlineImageView : CircleImageView
        var offlineImageView : CircleImageView
        var lastMessageTxt : TextView

        init {
            userNameTxt = itemView.findViewById(R.id.username)
            profileImageView = itemView.findViewById(R.id.profile_image)
            onlineImageView = itemView.findViewById(R.id.image_online)
            offlineImageView = itemView.findViewById(R.id.image_offline)
            lastMessageTxt = itemView.findViewById(R.id.message_last)

        }




    }



}