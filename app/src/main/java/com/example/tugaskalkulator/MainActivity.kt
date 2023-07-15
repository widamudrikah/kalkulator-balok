package com.example.tugaskalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaskalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCari.setOnClickListener {
            val panjang = binding.edtPanjang.text.toString()
            val lebar = binding.edtLebar.text.toString()
            val tinggi = binding.edtTinggi.text.toString()
            validasi(panjang,lebar,tinggi)
        }
    }

    private fun validasi(panjang:String, lebar:String, tinggi:String) {
        if (panjang.isEmpty()) {
            binding.edtPanjang.error = "isi panjang balok"
        }
        if (lebar.isEmpty()){
            binding.edtLebar.error = "Isi lebar balok"
        }
        if (tinggi.isEmpty()){
            binding.edtTinggi.error = "Isi tinggi balok"
        }
        if (panjang.isNotEmpty() && lebar.isNotEmpty() && tinggi.isNotEmpty()) {
            hitung(panjang.toDouble(), lebar.toDouble(), tinggi.toDouble())
        }
    }

    private fun hitung(panjang: Double, lebar: Double, tinggi: Double) {
        var hasil = 0.0
        hasil = panjang * lebar * tinggi
        binding.tvHasil.text = hasil.toString()
    }


}