package br.com.rodriguesalex.githubstars.features.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.rodriguesalex.githubstars.R
import dagger.android.DaggerActivity

class StarsActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
