package ogoubient.com.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

/**
 *Might need to change the font size in the main_activity, but , overall ,
 * App seems to work fine .
 *
 * Also , I can try to change the way the app works, but letting the user , enter
 * an entire operation , and then displaying the result at the bottom . Also , when
 * the user phone goes into landscape , a scientific calculator opens up .
 */

/**TODO: allow user to enter full operation , then process it ,
 * because in its current state , the app only allows one operation
 * at a time .
 **/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun calcEntry(view: View) {

        val butSelect = view as Button
        var userInput: String = display.text.toString()
        when (butSelect.id) {
        // Reset Pane
            butAC.id -> {
                userInput = ""
            }
        // Add negative in front of number .
            butPlusMinus.id -> {
                userInput = "-" + userInput
            }
            but7.id -> {
                userInput += "7"
            }
            but8.id -> {
                userInput += "8"
            }
            but9.id -> {
                userInput += "9"
            }

            but4.id -> {
                userInput += "4"
            }
            but5.id -> {
                userInput += "5"
            }
            but6.id -> {
                userInput += "6"
            }
            but1.id -> {
                userInput += "1"
            }
            but2.id -> {
                userInput += "2"
            }
            but3.id -> {
                userInput += "3"
            }
            butZero.id -> {
                // if panel is null , you cannot have more than 1 zero
                if (display == null) {
                    userInput=""

                } else {
                    userInput += "0"
                }
            }
            butPi.id -> {
                userInput += "3.14159265"

            }

            butDot.id -> {
                // we cannot have more than 1 dot , in a number .
                if (userInput.contains(".")) {

                } else {
                    userInput += "."
                }
            }


        }
        display.setText(userInput)
    }

    private var firstNumber = ""  // Keep Track of First Number
    private var secondNumber = "" // Keep Track of Second Number
    private var signOp = ""  // Keep Track of operational sign
    private var result: Double? = null


    fun calcOp(view: View) {

        firstNumber = display.text.toString()
        val butSelect = view as Button

        when (butSelect.id) {
            butX.id -> {
                signOp = "*"
                // clear screen
                display.text = null
            }
            butDivide.id -> {
                signOp = "/"
                // clear screen
                display.text = null
            }
            butMinus.id -> {
                signOp = "-"
                // clear screen
                display.text = null
            }
            butPlus.id -> {
                signOp = "+"
                // clear screen
                display.text = null
            }

        }
    }

    fun equal(view: View) {

        secondNumber = display.text.toString()
        val butSelect = view as Button

        try {

            when (signOp) {
                "+" -> {

                    result = firstNumber.toDouble() + secondNumber.toDouble()
                    display.setText(result.toString())

                }
                "*" -> {

                    result = firstNumber.toDouble() * secondNumber.toDouble()
                    display.setText(result.toString())


                }
                "/" -> {
                    result = firstNumber.toDouble() / secondNumber.toDouble()
                    display.setText(result.toString())


                }
                "-" -> {
                    result = firstNumber.toDouble() - secondNumber.toDouble()
                    display.setText(result.toString())


                }
            }

        } catch (ex: Exception) {
            println("Error: " + ex.message)
        }
    }

        fun calcPercent(view: View) {

            val input:Double = display.text.toString().toDouble()
            val butSelect = view as Button

            when (butSelect.id) {
                butPercentage.id -> {

                    try {

                        result = input/100

                        display.setText(result.toString())


                    } catch (ex: Exception) {
                        println("Error: " + ex.message)
                    }
                }
            }

        }
    }




