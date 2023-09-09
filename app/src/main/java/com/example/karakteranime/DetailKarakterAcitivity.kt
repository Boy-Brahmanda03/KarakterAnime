package com.example.karakteranime

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.karakteranime.databinding.ActivityDetailKarakterBinding

class DetailKarakterAcitivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailKarakterBinding

    companion object {
        const val DATA_KARAKTER = "data_karakter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKarakterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val karakter = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Karakter>(DATA_KARAKTER, Karakter::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Karakter>(DATA_KARAKTER)
        }

        if (karakter != null) {
            Glide.with(this)
                .load(karakter.photo)
                .into(binding.ivDetailPhoto)
            binding.tvDetailName.text = karakter.name
            binding.tvDetailDescription.text = karakter.description
            binding.tvDetailBirthday.text = karakter.birthday
            binding.tvDetailHeight.text = "${karakter.height} CM"

            binding.layoutShare.actionShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TITLE, "Bagikan detail dari ${karakter.name}")
                    putExtra(Intent.EXTRA_TEXT, "${karakter.name} dengan tinggi ${karakter.height} dan berulang tahun pada ${karakter?.birthday}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

    }

}