package com.example.simpleapp.UserRegistration

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.simpleapp.R
import com.example.simpleapp.UserListModel.UserListModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserRegistrationActivity : AppCompatActivity() {
    private lateinit var userRegisterUserFirstName: EditText
    private lateinit var userRegisterUserLastName: EditText
    private lateinit var userRegisterButton: AppCompatButton

    private lateinit var dataBase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registeration)

        userRegisterUserFirstName = findViewById(R.id.enter_userRegisterName)
        userRegisterUserLastName = findViewById(R.id.enter_userRegisterLastName)
        userRegisterButton = findViewById(R.id.register_YourData)

        dataBase = FirebaseDatabase.getInstance().getReference("Users")

        userRegisterButton.setOnClickListener {
            val firstName = userRegisterUserFirstName.text.toString()
            val lastName = userRegisterUserLastName.text.toString()

            val userId = dataBase.push().key!!

            val user = UserListModel(userId,firstName, lastName)

            dataBase.child(userId).setValue(user)
                .addOnCompleteListener {
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
