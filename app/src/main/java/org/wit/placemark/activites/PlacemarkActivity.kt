package org.wit.placemark.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.placemark.databinding.ActivityPlacemarkBinding
import org.wit.placemark.models.PlacemarkModel
import timber.log.Timber
import timber.log.Timber.i
import com.google.android.material.snackbar.Snackbar


class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding

    var placemark = PlacemarkModel()
    val placemarks = ArrayList<PlacemarkModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Placemark Activity started...")

        binding.btnAdd.setOnClickListener(){
            placemark.title = binding.placemarkTitle.text.toString()
            if(placemark.title.isNotEmpty()) {
                i("add Button Pressed: ${placemark.title}")
                placemarks.add(placemark.copy())
                i("Current placemarks: $placemarks")
            }
            else{
                Snackbar.make(it,"Please Enter a Title",Snackbar.LENGTH_LONG).show()
            }
        }
    }
}