package com.example.userinputcontrol

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    val TAG = "mainActivity"
    var genders: Array<String>? = null

    private lateinit var dob: EditText

    private lateinit var tpicker: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val spinner: Spinner = findViewById(R.id.spinner)
//        genders = resources
//            .getStringArray(R.array.gender)
//
//        spinner.setOnItemSelectedListener(this)
//
//        val ad: ArrayAdapter<Any?> = ArrayAdapter<Any?>(
//            this,
//            android.R.layout.simple_spinner_item,
//            genders!!
//        )
//
//        ad.setDropDownViewResource(
//            android.R.layout.simple_spinner_dropdown_item
//        )
//
//        spinner.adapter = ad
//
//        val switch = findViewById<Switch>(R.id.switch1)
//
//        if (switch.isChecked) {
//            Log.i(TAG, "Switch is On")
//        } else {
//            Log.i(TAG, "Switch is Off")
//        }

//        val button: Button = findViewById(R.id.submit)
//        val etName:  EditText = findViewById(R.id.nameET)
//
//        button.setOnClickListener {
//            Log.i(TAG, etName.text.toString())
//        }

        dob = findViewById<EditText>(R.id.dob)
        dob.setOnClickListener{
            var calendar: Calendar = Calendar.getInstance()
            var day = calendar[Calendar.DAY_OF_MONTH]
            var month = calendar[Calendar.MONTH]
            var year = calendar[Calendar.YEAR]

            var dpicker: Unit = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener(){
                        view, year, month, day ->
                    dob.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                },
                year,
                month,
                day).show()
        }

        tpicker = findViewById<EditText>(R.id.tpick)
        tpicker.setOnClickListener{
            var calendar: Calendar = Calendar.getInstance()
            var hour = calendar[Calendar.HOUR]
            var minute = calendar[Calendar.MINUTE]

            var timePicker: Unit = TimePickerDialog(
                this, TimePickerDialog.OnTimeSetListener{
                    view, hour, minute ->
                    tpicker.setText(hour.toString() + ":" + minute.toString())
                },
                hour,
                minute,
                false
            ).show()
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(applicationContext, genders!![p2], Toast.LENGTH_SHORT ).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //Do Nothing
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}