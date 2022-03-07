package com.sandystudios.copenhagen_add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        val highFive = findViewById<ImageView>(R.id.image_highfive)
        Glide.with(applicationContext).load(R.drawable.animation_highfive).into(highFive)
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                MainActivity.h.sendEmptyMessage(0);
                this@ThankYouActivity.finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}