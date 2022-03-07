package com.sandystudios.copenhagen_add

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class InstructionsActivity : AppCompatActivity() {

    private val tvListOfInstructions: TextView by lazy {
        findViewById(R.id.tv_list_of_instructions)
    }

    private val btnBackHome: ImageButton by lazy {
        findViewById(R.id.btn_back_home)
    }

    private val btnOkay: Button by lazy {
        findViewById(R.id.btn_okay)
    }

    private lateinit var name: String
    private lateinit var age: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)

        btnBackHome.setOnClickListener {
            onBackPressed()
        }

        try {
            name = intent.getStringExtra(NAME)!!
            age = intent.getStringExtra(AGE)!!
        } catch (e: Exception) {
            Toast.makeText(this, "Number not found, Try Again!", Toast.LENGTH_SHORT).show()
        }

        btnOkay.setOnClickListener {
            val intent = Intent(this@InstructionsActivity, ExperimentActivity::class.java)
            intent.putExtra(NAME, name)
            intent.putExtra(AGE, age)
            startActivity(intent)
            finish()
        }

        tvListOfInstructions.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(
                "<p>\n" +
                        "    1. <b>For the passive phase, </b> you will see a number in the middle of the screen.\n" +
                        "    <br>(This is your current score for the day in)\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    2. When you see a NEXT button below the number, you are to press the NEXT button.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    3. Shortly after pressing the NEXT button you will see an image on the screen background, and this will cause your\n" +
                        "    score to change.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    4. You are instructed to attend to any relationship between the images and the effect this has on your score.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br> Since in the active phase that follows you will be given the opportunity to choose images to influence your\n" +
                        "    score. Learning theserelationships can make a large difference to your score in the active phase.\n" +
                        "</p>", Html.FROM_HTML_MODE_COMPACT
            );
        } else {
            Html.fromHtml(
                "<p>\n" +
                        "    1. <b>For the passive phase, </b> you will see a number in the middle of the screen.\n" +
                        "    <br>(This is your current score for the day in)\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    2. When you see a NEXT button below the number, you are to press the NEXT button.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    3. Shortly after pressing the NEXT button you will see an image on the screen background, and this will cause your\n" +
                        "    score to change.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    4. You are instructed to attend to any relationship between the images and the effect this has on your score.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p>\n" +
                        "    <br> Since in the active phase that follows you will be given the opportunity to choose images to influence your\n" +
                        "    score. Learning theserelationships can make a large difference to your score in the active phase.\n" +
                        "</p>"
            );
        }
    }
}