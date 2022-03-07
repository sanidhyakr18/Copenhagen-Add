package com.sandystudios.copenhagen_add

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GambleInstructionsActivity : AppCompatActivity() {

    private val tvGambleMatter: TextView by lazy {
        findViewById(R.id.tv_gamble_matter)
    }

    private val btnOkayGamble: Button by lazy {
        findViewById(R.id.btn_okay_gamble)
    }

    private lateinit var name: String
    private lateinit var age: String
    private var finalScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamble_instructions)

        try {
            name = intent.getStringExtra(NAME)!!
            age = intent.getStringExtra(AGE)!!
            finalScore = intent.getIntExtra(FINAL_SCORE, 0)
        } catch (e: Exception) {
            Toast.makeText(this, "Number not found, Try Again!", Toast.LENGTH_SHORT).show()
        }

        btnOkayGamble.setOnClickListener {
            val intent = Intent(this, GambleActivity::class.java)
            intent.putExtra(NAME, name)
            intent.putExtra(AGE, age)
            intent.putExtra(FINAL_SCORE, finalScore)
            startActivity(intent)
            finish()
        }

        // TODO: Ask for instructions
        tvGambleMatter.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(
                "<p>\n" +
                        "    With the score accumulated in the passive phase, you will play gambles composed of the same images. In each trial,\n" +
                        "    you will be presented with two of the images that you have learned about in the passive phase. By pressing the\n" +
                        "    buttons in the scanner to move a cursor, you now have the option to choose to either: a) Accept gamble one, in which\n" +
                        "    case you will be assigned one of one set of two images, or. . . b) Accept gamble two, in which case you will be\n" +
                        "    assigned one of another set of two images.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br>The outcomes of your gambles will be hidden from you, and <b>only 10 of them will be randomly chosen and applied\n" +
                        "        to your current score.</b>\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br>Your final score will be recorded. <b>Out of the top scorers, three will be given cash prizes as follows: <b />\n" +
                        "</p>\n" +
                        "<p><b> 1st prize will be Rs 1500</b></p>\n" +
                        "<p><b> 2nd prize will be Rs 1000 </b></p>\n" +
                        "<p><b> 3rd prize will be Rs 500 </b></p>", Html.FROM_HTML_MODE_COMPACT
            );
        } else {
            Html.fromHtml(
                "<p>\n" +
                        "    With the score accumulated in the passive phase, you will play gambles composed of the same images. In each trial,\n" +
                        "    you will be presented with two of the images that you have learned about in the passive phase. By pressing the\n" +
                        "    buttons in the scanner to move a cursor, you now have the option to choose to either: a) Accept gamble one, in which\n" +
                        "    case you will be assigned one of one set of two images, or. . . b) Accept gamble two, in which case you will be\n" +
                        "    assigned one of another set of two images.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br>The outcomes of your gambles will be hidden from you, and <b>only 10 of them will be randomly chosen and applied\n" +
                        "        to your current score.</b>\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br>Your final score will be recorded. <b>Out of the top scorers, three will be given cash prizes as follows: <b />\n" +
                        "</p>\n" +
                        "<p><b> 1st prize will be Rs 1500</b></p>\n" +
                        "<p><b> 2nd prize will be Rs 1000 </b></p>\n" +
                        "<p><b> 3rd prize will be Rs 500 </b></p>"
            );
        }
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                MainActivity.h.sendEmptyMessage(0)
                this@GambleInstructionsActivity.finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}