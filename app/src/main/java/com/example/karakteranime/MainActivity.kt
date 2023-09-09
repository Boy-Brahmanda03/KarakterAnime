package com.example.karakteranime

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karakteranime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Karakter>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvKarakter.setHasFixedSize(true)
        list.addAll(getListKarakter())

        showRecylerList()
    }

    private fun showRecylerList() {
        binding.rvKarakter.layoutManager = LinearLayoutManager(this)
        val listKarakterAdapter = ListKarakterAdapter(list) {
            val intent = Intent(this@MainActivity, DetailKarakterAcitivity::class.java)
            intent.putExtra(DetailKarakterAcitivity.DATA_KARAKTER, it)
            startActivity(intent)
        }
        binding.rvKarakter.adapter = listKarakterAdapter

    }

    private fun getListKarakter(): ArrayList<Karakter> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataHeight = resources.getIntArray(R.array.data_height)

        val listKarakter = ArrayList<Karakter>()
        for (i in dataName.indices) {
            val karakter = Karakter(
                dataName[i],
                dataDescription[i],
                dataPhoto[i],
                dataBirthday[i],
                dataHeight[i]
            )
            listKarakter.add(karakter)
        }

        return listKarakter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}