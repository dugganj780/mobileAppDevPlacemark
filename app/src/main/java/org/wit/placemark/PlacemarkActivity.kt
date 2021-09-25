package org.wit.placemark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.placemark.databinding.ActivityPlacemarkBinding
import timber.log.Timber
import timber.log.Timber.i
import com.google.android.material.snackbar.Snackbar

class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)



        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Placemark Activity started...")

        binding.btnAdd.setOnClickListener(){
            val placemarkTitle = binding.placemarkTitle.text.toString()
            if(placemarkTitle.isNotEmpty()) {
                i("add Button Pressed: $placemarkTitle")
            }
            else{
                Snackbar.make(it,"Please Enter a Title",Snackbar.LENGTH_LONG).show()
            }
        }
    }
}