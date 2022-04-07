package com.example.assignment2
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class CustomDialogFragment :DialogFragment(R.layout.fragment)  {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val submitbt : Button= view.findViewById(R.id.submitBT)
        val radioGroup= view.findViewById<RadioGroup>(R.id.RatingRadioGroup)

        submitbt.setOnClickListener {
            val selectedOption : Int = radioGroup.checkedRadioButtonId
            val radioButton= view.findViewById<RadioButton>(selectedOption)
//            Toast.makeText(context,radioButton.text,Toast.LENGTH_SHORT).show()
            val text = radioButton.text
            val duration = Toast.LENGTH_SHORT
             Toast.makeText(context, text, duration)

            val m1:MainActivity=getActivity() as MainActivity
            m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }
}