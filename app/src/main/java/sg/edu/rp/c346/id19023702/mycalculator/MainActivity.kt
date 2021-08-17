package sg.edu.rp.c346.id19023702.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var firstNum = ""
    var secondnum = ""
    var total = 0.0
    var next = false
    var dot = false
    var op = ""
    var number = -1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonPN.setOnClickListener {
            if (tvEqu.text.toString().toDouble() < 0.0) {
                if (next == false) {
                    val percent = tvEqu.text.toString().toDouble() * number
                    firstNum = "$percent"
                    tvEqu.text = firstNum
                } else if (next == true) {
                    val percent = tvEqu.text.toString().toDouble() * number
                    secondnum = "$percent"
                    tvEqu.text = secondnum
                }
            } else {
                if (next == false) {
                    val percent = tvEqu.text.toString().toDouble() * number
                    firstNum = "$percent"
                    tvEqu.text = firstNum
                } else if (next == true) {
                    val percent = tvEqu.text.toString().toDouble() * number
                    secondnum = "$percent"
                    tvEqu.text = secondnum
                }
            }
        }
    }

    fun btnOnClick(view: View) {
        val btnSelected = view as Button
        if (next == false && tvEqu.text.toString() == "0") {
            when (btnSelected.id) {
                button0.id -> firstNum = "0"
                button1.id -> firstNum = "1"
                button2.id -> firstNum = "2"
                button3.id -> firstNum = "3"
                button4.id -> firstNum = "4"
                button5.id -> firstNum = "5"
                button6.id -> firstNum = "6"
                button7.id -> firstNum = "7"
                button8.id -> firstNum = "8"
                button9.id -> firstNum = "9"
            }
            tvEqu.text = "$firstNum"
            total = firstNum.toDouble()
        } else if (next == false && tvEqu.text.toString() != "0") {
            when (btnSelected.id) {
                button0.id -> firstNum += "0"
                button1.id -> firstNum += "1"
                button2.id -> firstNum += "2"
                button3.id -> firstNum += "3"
                button4.id -> firstNum += "4"
                button5.id -> firstNum += "5"
                button6.id -> firstNum += "6"
                button7.id -> firstNum += "7"
                button8.id -> firstNum += "8"
                button9.id -> firstNum += "9"
            }
            tvEqu.text = "$firstNum"
            total = firstNum.toDouble()
        } else if (next == true && tvEqu.text.toString() == "0") {
            when (btnSelected.id) {
                button0.id -> secondnum = "0"
                button1.id -> secondnum = "1"
                button2.id -> secondnum = "2"
                button3.id -> secondnum = "3"
                button4.id -> secondnum = "4"
                button5.id -> secondnum = "5"
                button6.id -> secondnum = "6"
                button7.id -> secondnum = "7"
                button8.id -> secondnum = "8"
                button9.id -> secondnum = "9"
            }
            tvEqu.text = "$secondnum"
        }
        else {
            when (btnSelected.id) {
                button0.id -> secondnum += "0"
                button1.id -> secondnum += "1"
                button2.id -> secondnum += "2"
                button3.id -> secondnum += "3"
                button4.id -> secondnum += "4"
                button5.id -> secondnum += "5"
                button6.id -> secondnum += "6"
                button7.id -> secondnum += "7"
                button8.id -> secondnum += "8"
                button9.id -> secondnum += "9"
            }
            tvEqu.text = "$secondnum"
        }
    }

    fun btnOnOpClick(view: View) {
        val btnSelected = view as Button
        op = ""
        when (btnSelected.id) {
            buttonAdd.id -> op += "+"
            buttonSub.id -> op += "-"
            buttonDiv.id -> op += "/"
            buttonTimes.id -> op += "*"
            buttonPN.id -> op += "+/-"
        }
        tvEqu.text = "$op"
        if (op == "+" && secondnum != "") {
            total = firstNum.toDouble() + secondnum.toDouble()
            firstNum = total.toString()
            secondnum = ""
            total = 0.0
        } else if (op == "-" && secondnum != "") {
            total = firstNum.toDouble() - secondnum.toDouble()
            firstNum = total.toString()
            secondnum = ""
            total = 0.0
        } else if (op == "*" && secondnum != "") {
            total = firstNum.toDouble() * secondnum.toDouble()
            firstNum = total.toString()
            secondnum = ""
            total = 0.0
        } else if (op == "/" && secondnum != "") {
            total = firstNum.toDouble() / secondnum.toDouble()
            firstNum = total.toString()
            secondnum = ""
            total = 0.0
        }
        next = true
        dot = false
        buttonDot.isEnabled = true

    }

    fun btnEqualsClick(view: View) {
        if (secondnum == "") {
            total = firstNum.toDouble()
        } else {
            if (op == "+") {
                total = firstNum.toDouble() + secondnum.toDouble()
                total.toBigDecimal()
            } else if (op == "-") {
                total = firstNum.toDouble() - secondnum.toDouble()
                total.toBigDecimal()
            } else if (op == "*") {
                total = firstNum.toDouble() * secondnum.toDouble()
                total.toBigDecimal()
            } else if (op == "/") {
                total = firstNum.toDouble() / secondnum.toDouble()
                total.toBigDecimal()
            }
        }
        tvEqu.text = total.toString().trim()
        firstNum = total.toString()
        total = 0.0
        secondnum = ""
        dot = false
        buttonDot.isEnabled = true
    }


    fun btnACClick(view: View) {
        tvEqu.text = "0"
        firstNum = ""
        secondnum = ""
        op = ""
        next = false
        dot = false
        buttonDot.isEnabled = true
    }

    fun btnPercent(view: View){
        if (next == false){
            val percent = tvEqu.text.toString().toDouble()/100
            firstNum = "$percent"
            tvEqu.text = firstNum
        }else if (next == true) {
            val percent = tvEqu.text.toString().toDouble()/100
            secondnum = "$percent"
            tvEqu.text = secondnum
        }else{
            total = tvEqu.text.toString().toDouble()/100
            tvEqu.text = "$total"
        }
    }

    fun btnDotClick(view: View) {
        if (next == false) {
            firstNum = firstNum + "."
            tvEqu.text = "$firstNum"
        } else if (next == true) {
            secondnum = secondnum + "."
            tvEqu.text = "$secondnum"
        }
        if (dot == false) {
            dot = true
            buttonDot.isEnabled = false
        }
    }

//    fun btnPM(view: Double) {
//        if (tvEqu.text.toString().toDouble() < 0.0) {
//            var result = tvEqu.text.toString().toDouble() * number
//            tvEqu.text = result.toString()
//        } else {
//            var result = tvEqu.text.toString().toDouble() * number
//            tvEqu.text = result.toString()
//        }
//    }

    fun btnPm(view: View) {
        if (tvEqu.text.toString().toDouble() < 0.0) {
            if (next == false) {
                val percent = tvEqu.text.toString().toDouble() * number
                firstNum = "$percent"
                tvEqu.text = firstNum
            } else if (next == true) {
                val percent = tvEqu.text.toString().toDouble() * number
                secondnum = "$percent"
                tvEqu.text = secondnum
            }
        } else {
            if (next == false) {
                val percent = tvEqu.text.toString().toDouble() * number
                firstNum = "$percent"
                tvEqu.text = firstNum
            } else if (next == true) {
                val percent = tvEqu.text.toString().toDouble() * number
                secondnum = "$percent"
                tvEqu.text = secondnum
            }
        }
    }
}
