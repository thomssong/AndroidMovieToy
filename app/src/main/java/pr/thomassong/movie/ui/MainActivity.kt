package pr.thomassong.movie.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pr.thomassong.movie.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
