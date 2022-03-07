package com.sandystudios.copenhagen_add

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.TextView

class ConsentActivity : AppCompatActivity() {

    private val tvConsentMatter: TextView by lazy {
        findViewById(R.id.tv_consent_matter)
    }

    private val btnBack: ImageButton by lazy {
        findViewById(R.id.btn_back)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consent)

        btnBack.setOnClickListener {
            finish()
        }

        tvConsentMatter.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(
                "<p>Greetings! \uD83C\uDF3B</p>\n" +
                        "<p><br>\n" +
                        "    We are a group of students, pursuing MA in Psychology from the University of Delhi. As a part of our academic\n" +
                        "    research project, we are conducting an experiment to examine decision making under uncertainty and the role of\n" +
                        "    personality in it.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    The experiment consists of two phases – <b>passive and active phases.</b> During the <b> passive (training\n" +
                        "        phase), </b> you are required to attend to the relationship between your score and the image that follows\n" +
                        "    your score. <b>Active phase </b> will follow at the end of the passive phase. During active phase, you are\n" +
                        "    required to\n" +
                        "    use what you learned of\n" +
                        "    the relationship between your score and different images that follow it. You will be given a choice between two\n" +
                        "    gambles and out of those two choices you will be required to choose the option that you think will maximize your\n" +
                        "    score.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br><b> As a participant, the overall aim is to maximize your score. </b></p>\n" +
                        "<p><br><b> Out of the top scorers, three will be given cash prizes as follows:</b></p>\n" +
                        "<p><b> 1st prize will be Rs 1500</b></p>\n" +
                        "<p><b> 2nd prize will be Rs 1000 </b></p>\n" +
                        "<p><b> 3rd prize will be Rs 500 </b></p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    We request you to participate as honestly as possible.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Please note that confidentiality will be maintained at all times and your responses will be used only for the\n" +
                        "    purpose of this research. Your participation in this research is completely voluntary. You can choose to\n" +
                        "    withdraw from the study at any time by simply closing the app.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    We highly value your participation in this study.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Thank you for your time.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Name of the researchers: <b>Faizy Rahman, Preeti Mehra, Sumit Shandilya, Mehak Gupta, Prerna Monica Tete,\n" +
                        "        Harshita and Purvi khurana</b>\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    For any queries or details you can reach out to us at:\n" +
                        "    <br><u>faizy.rahman1@gmail.com</u>\n" +
                        "    <br><u>harshitabarua99@gmail.com</u>\n" +
                        "</p>", Html.FROM_HTML_MODE_COMPACT
            );
        } else {
            Html.fromHtml(
                "<p>Greetings! \uD83C\uDF3B</p>\n" +
                        "<p><br>\n" +
                        "    We are a group of students, pursuing MA in Psychology from the University of Delhi. As a part of our academic\n" +
                        "    research project, we are conducting an experiment to examine decision making under uncertainty and the role of\n" +
                        "    personality in it.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    The experiment consists of two phases – <b>passive and active phases.</b> During the <b> passive (training\n" +
                        "        phase), </b> you are required to attend to the relationship between your score and the image that follows\n" +
                        "    your score. <b>Active phase </b> will follow at the end of the passive phase. During active phase, you are\n" +
                        "    required to\n" +
                        "    use what you learned of\n" +
                        "    the relationship between your score and different images that follow it. You will be given a choice between two\n" +
                        "    gambles and out of those two choices you will be required to choose the option that you think will maximize your\n" +
                        "    score.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br><b> As a participant, the overall aim is to maximize your score. </b></p>\n" +
                        "<p><br><b> Out of the top scorers, three will be given cash prizes as follows:</b></p>\n" +
                        "<p><b> 1st prize will be Rs 1500</b></p>\n" +
                        "<p><b> 2nd prize will be Rs 1000 </b></p>\n" +
                        "<p><b> 3rd prize will be Rs 500 </b></p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    We request you to participate as honestly as possible.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Please note that confidentiality will be maintained at all times and your responses will be used only for the\n" +
                        "    purpose of this research. Your participation in this research is completely voluntary. You can choose to\n" +
                        "    withdraw from the study at any time by simply closing the app.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    We highly value your participation in this study.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Thank you for your time.\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    Name of the researchers: <b>Faizy Rahman, Preeti Mehra, Sumit Shandilya, Mehak Gupta, Prerna Monica Tete,\n" +
                        "        Harshita and Purvi khurana</b>\n" +
                        "</p>\n" +
                        "\n" +
                        "<p><br>\n" +
                        "    For any queries or details you can reach out to us at:\n" +
                        "    <br><u>faizy.rahman1@gmail.com</u>\n" +
                        "    <br><u>harshitabarua99@gmail.com</u>\n" +
                        "</p>"
            );
        }
    }
}