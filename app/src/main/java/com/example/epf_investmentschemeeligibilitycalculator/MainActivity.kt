package com.example.epf_investmentschemeeligibilitycalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dob_display.setOnClickListener(){
            val c:Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                view, year, month, day -> dob_display.setText(day.toString() + "/" +
                                                                (month + 1).toString() +"/" +
                                                                year.toString())

                    //todo
                    val age = currentYear - year
                    age_display.text = age.toString();
                    val minbasicsaving:Double = getSaving(age);
                    val investmentAllowed:Double = getInvestmentAllowed(minbasicsaving)

                    mbs_display.text = minbasicsaving.toString();
                    investment_display.text = investmentAllowed.toString();
                    //...



            }, currentYear, currentMonth, currentDay)

            dpd.show()
        }
    }

    fun getSaving(age:Int): Double{
        when(age){
            in 16..20 -> return 5000.00
            in 21..25 -> return 14000.00
            in 26..30 -> return 29000.00
            in 31..35 -> return 50000.00
            in 36..40 -> return 78000.00
            in 41..45 -> return 116000.00
            in 46..50 -> return 165000.00
            in 51..55 -> return 14000.00
            else -> return 0.00
        }

    }

    fun getInvestmentAllowed(mbs:Double): Double{
        return mbs*30/100;

    }
}
