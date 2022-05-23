package com.example.recycleryfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserListActivity : AppCompatActivity() {


    private lateinit var dbref:DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        userRecyclerView=findViewById(R.id.userlist)
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList= arrayListOf<User>()
        getUserData()

        val cargar=findViewById<Button>(R.id.cargar)
        cargar.setOnClickListener{
            val database = Firebase.database
            val myRef = database.getReference("prueba").child("id")

            myRef.removeValue()

        }

    }

    private fun getUserData() {

        dbref=FirebaseDatabase.getInstance().getReference("mascotas").child("perros")

        dbref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snashot: DataSnapshot) {

                if (snashot.exists()){
                    for(userSnapshot in snashot.children){
                        val user=userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter=MyAdapter(userArrayList)
                }


            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

}