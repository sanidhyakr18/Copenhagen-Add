package com.sandystudios.copenhagen_add

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.WindowManager
import android.widget.*

const val NAME = "name"
const val AGE = "age"
const val FINAL_SCORE = "final score"

class MainActivity : AppCompatActivity() {

    private val tvDecisive: TextView by lazy {
        findViewById(R.id.tv_decisive)
    }

    private val etName: EditText by lazy {
        findViewById(R.id.et_name)
    }

    private val etAge: EditText by lazy {
        findViewById(R.id.et_age)
    }

    private val tvConsent: TextView by lazy {
        findViewById(R.id.tv_consent)
    }

    private val checkBox: CheckBox by lazy {
        findViewById(R.id.checkBox)
    }

    private val btnStart: Button by lazy {
        findViewById(R.id.btn_start)
    }

    private val btnPrize: ImageButton by lazy {
        findViewById(R.id.btn_prize)
    }

    companion object {
        lateinit var h: Handler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        h = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when (msg.what) {
                    0 -> finish()
                }
            }
        }

        val spannable = SpannableString("Decisive.")
        spannable.setSpan(
            ForegroundColorSpan(getColor(R.color.primaryBlue)),
            8, // start
            9, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        tvDecisive.text = spannable

        val str = "CLICK HERE"
        makeTextLink(tvConsent, str, true, getColor(R.color.primaryBlue))

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            btnStart.isEnabled = isChecked
        }

        btnStart.setOnClickListener {
            completeSetup()
        }

        btnPrize.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val customLayout: View = layoutInflater.inflate(R.layout.custom_dialogue, null)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setView(customLayout)

        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(true)
//        alert.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setBackgroundDrawableResource(android.R.color.transparent)
        this.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        alert.show()
    }

    private fun completeSetup() {
        val name = etName.text.toString()
        val age = etAge.text.toString()
        when {
            name.isEmpty() -> Toast.makeText(this, "Name can not be empty!", Toast.LENGTH_SHORT)
                .show()
            age.isEmpty() -> Toast.makeText(this, "Age can not be empty!", Toast.LENGTH_SHORT)
                .show()
            else -> {
                btnStart.isEnabled = false
                val intent = Intent(this, InstructionsActivity::class.java)
                intent.putExtra(NAME, name)
                intent.putExtra(AGE, age)
                startActivity(intent)
                checkBox.isChecked = false
            }
        }
    }

    private fun makeTextLink(
        textView: TextView,
        str: String,
        underlined: Boolean,
        color: Int?
    ) {
        val spannableString = SpannableString(textView.text)
        val textColor = color ?: textView.currentTextColor
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                startActivity(Intent(this@MainActivity, ConsentActivity::class.java))
            }

            override fun updateDrawState(drawState: TextPaint) {
                super.updateDrawState(drawState)
                drawState.isUnderlineText = underlined
                drawState.color = textColor
            }
        }
        val index = spannableString.indexOf(str)
        spannableString.setSpan(
            clickableSpan,
            index,
            index + str.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.highlightColor = Color.TRANSPARENT
    }
}