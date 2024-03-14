package com.example.simpleapp.UserAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.simpleapp.R
import com.example.simpleapp.UserListModel.UserListModel

class UserListAdapter(
    private var context: Context,
    private var userList: MutableList<UserListModel>
) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){

        inner class UserViewHolder(userItemView: View): RecyclerView.ViewHolder(userItemView){
            val userName: TextView = userItemView.findViewById(R.id.user_firstName)
            val userLastName: TextView = userItemView.findViewById(R.id.user_lastName)
        }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdapter.UserViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.user_list_type, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserViewHolder, position: Int) {
        holder.userName.text = userList[position].firstName
        holder.userLastName.text = userList[position].lastName
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}