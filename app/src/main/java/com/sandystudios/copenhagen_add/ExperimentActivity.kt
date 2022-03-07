package com.sandystudios.copenhagen_add

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.imageview.ShapeableImageView


class ExperimentActivity : AppCompatActivity() {

    private val tvHeading: TextView by lazy {
        findViewById(R.id.tv_heading)
    }

    private val tvAmount: TextView by lazy {
        findViewById(R.id.tv_amount)
    }

    private val ivImage: ShapeableImageView by lazy {
        findViewById(R.id.iv_image)
    }

    private val btnNext: Button by lazy {
        findViewById(R.id.btn_next)
    }

    private val progressBar: ProgressBar by lazy {
        findViewById(R.id.progressBar)
    }

    private var isImage = false
    private var num = 0
    private var repeat = 0
    private var shuffle = 4
    private var amount = 1000

    private var mResources = intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7,
        R.drawable.img8,
        R.drawable.img9
    )

    private var hashMap: HashMap<Int, Int> = HashMap()

    private lateinit var name: String
    private lateinit var age: String

    private var i = 0

    private var finalBtnPress = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiment)

        try {
            name = intent.getStringExtra(NAME)!!
            age = intent.getStringExtra(AGE)!!
        } catch (e: Exception) {
            Toast.makeText(this, "Data not found, Try Again!", Toast.LENGTH_SHORT).show()
        }

        hashMap[R.drawable.img1] = -428
        hashMap[R.drawable.img2] = -321
        hashMap[R.drawable.img3] = -241
        hashMap[R.drawable.img4] = -107
        hashMap[R.drawable.img5] = 0
        hashMap[R.drawable.img6] = 107
        hashMap[R.drawable.img7] = 241
        hashMap[R.drawable.img8] = 321
        hashMap[R.drawable.img9] = 428

        mResources.shuffle()

        btnNext.isEnabled = false

        progressBar(2000)

        btnNext.setOnClickListener {
            btnNext.isEnabled = false
            if (num == 9) {
                if (shuffle == 0) {
                    if (!finalBtnPress) {
                        finalBtnPress = true
                        finalBtnAction()
                    } else {
                        val intent = Intent(this, GambleInstructionsActivity::class.java)
                        intent.putExtra(NAME, name)
                        intent.putExtra(AGE, age)
                        intent.putExtra(FINAL_SCORE, amount)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    num = 0
                    shuffle--
                    mResources.shuffle()
                    btnAction()
                }
            } else {
                btnAction()
            }
        }
    }

    private fun finalBtnAction() {
        isImage = !isImage

        if (!isImage) {
            tvHeading.text = getString(R.string.new_amount)
            tvAmount.text = amount.toString()
        } else {
            tvHeading.text = getString(R.string.symbol)
        }

        tvAmount.isVisible = !isImage
        ivImage.isVisible = isImage
        btnNext.visibility = if (isImage) View.INVISIBLE else View.VISIBLE

        if (isImage) {
            mResources.shuffle()
            ivImage.setImageResource(mResources[0])
            amount += hashMap[mResources[0]]!!
            Log.d(ContentValues.TAG, "${hashMap[mResources[0]]} - $amount")
        } else {
            tvHeading.text = "Final Amount"
            btnNext.text = getString(R.string.finish)
        }

        if (isImage) {
            progressBar(5000)
        } else {
            progressBar(2000)
        }
    }

    private fun btnAction() {
        isImage = !isImage

        if (!isImage) {
            tvHeading.text = getString(R.string.new_amount)
            tvAmount.text = amount.toString()
            repeat++
            if (repeat == 3) {
                repeat = 0
                num++
            }
        } else {
            tvHeading.text = getString(R.string.symbol)
        }

        tvAmount.isVisible = !isImage
        ivImage.isVisible = isImage
        btnNext.visibility = if (isImage) View.INVISIBLE else View.VISIBLE
        if (isImage && num < 9) {
            ivImage.setImageResource(mResources[num])
            amount += hashMap[mResources[num]]!!
            Log.d(ContentValues.TAG, "${hashMap[mResources[num]]} - $amount")
        }

        if (isImage) {
            progressBar(5000)
        } else {
            progressBar(2000)
        }
    }

    private fun progressBar(millisCountDown: Long) {
        i = 0
        progressBar.progress = i
        val mCountDownTimer = object : CountDownTimer(millisCountDown, 10) {
            override fun onTick(millisUntilFinished: Long) {
//                Log.v("Log_tag", "Tick of Progress$i$millisUntilFinished")
                i++
                progressBar.progress = (i * 100 / (millisCountDown / 10)).toInt()
            }

            override fun onFinish() {
                i++
                progressBar.progress = 100
                if (isImage) {
                    if (finalBtnPress) {
                        finalBtnAction()
                    } else {
                        btnAction()
                    }
                } else {
                    btnNext.isEnabled = true
                }
            }
        }
        mCountDownTimer.start()
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                MainActivity.h.sendEmptyMessage(0)
                this@ExperimentActivity.finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}