package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//spinner part:
        var flag:String="MARGHERITA"
        val spinnerval: Spinner = findViewById(R.id.spinner)
        var options= arrayOf("SPICY CHICKEN RANCH","MARGHERITA","VEGETARIAN",
            "PEPPERONI","SUPER SUPREME","BBQ CHICKEN","GRILLED CHICKEN")
        spinnerval.adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinnerval.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


//fragment part:
//submit button

        val sizebtn:Button=findViewById(R.id.sizebtn)
       sizebtn.setOnClickListener{
            var dialog_var=CustomDialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
           val result2:TextView=findViewById(R.id.Result2)
           result2.text=flag
        }
//add button
        val addbtn:Button=findViewById(R.id.addbtn)
        addbtn.setOnClickListener{


            val text ="Your Order Has Been Added"
            val duration = Toast.LENGTH_LONG
            Toast.makeText(applicationContext, text, duration).show()

        }
    }









//menu part:
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater =menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1-> Toast.makeText(this,"EAT IN selected", Toast.LENGTH_SHORT).show()
            R.id.item2-> Toast.makeText(this,"TAKE AWAY selected", Toast.LENGTH_SHORT).show()
        }
        return true;
    }

    fun receiveFeedback(feedback: String) {
val result:TextView=findViewById(R.id.Result1)
        result.text=feedback
    }
}