package com.example.sqlitexandroiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sqldatabase.DBHelper
import com.example.sqlitexandroiddemo.R


class DatabaseView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_view)
        val dbHelper = DBHelper(applicationContext)
        val fetchDataBtn = this.findViewById<Button>(R.id.fetchDataBtn)
        val textMsg = this.findViewById<TextView>(R.id.textMsg)
        val deleteBtn = this.findViewById<Button>(R.id.deleteBtn)
        val updateBtn = this.findViewById<Button>(R.id.updateBtn)

        fun getUsers(): String? {
            val res = dbHelper.users
            if(res == null) return null
            else return res
        }
        fetchDataBtn.setOnClickListener {
            val res = getUsers()
            if(res == null) Toast.makeText(applicationContext, "Unable to fetch data!", Toast.LENGTH_SHORT).show()
            else textMsg.setText(res)
        }
        deleteBtn.setOnClickListener {
            val id = this.findViewById<EditText>(R.id.idTxt).text.toString()
            dbHelper.deleteUser(id)
            Toast.makeText(applicationContext, "user deleted!", Toast.LENGTH_SHORT).show()
        }
        updateBtn.setOnClickListener {
            val id = this.findViewById<EditText>(R.id.idTxt).text.toString()
            val name = this.findViewById<EditText>(R.id.nameTxt).text.toString()
            val email = this.findViewById<EditText>(R.id.emailTxt).text.toString()
            val manu = this.findViewById<EditText>(R.id.manuTxt).text.toString()
            val model = this.findViewById<EditText>(R.id.modelTxt).text.toString()
            dbHelper.update(id, name, email, manu, model)
            Toast.makeText(applicationContext, "user updated!", Toast.LENGTH_SHORT).show()
        }
    }
}
