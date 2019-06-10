package com.example.deeplinkplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deeplinkplayground.utils.startDeepLink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val clientID = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButtonConfirmUber.setOnClickListener { startUberDeepLink(mButtonConfirmUber.text.toString()) }
        mButtonConfirmGoogle.setOnClickListener { startGooglePlayDeepLink(mButtonConfirmGoogle.text.toString()) }
    }

    private fun startUberDeepLink(promoCode: String) {
        startUberDeepLink(getUberPromoCodeURI(clientID, promoCode))
    }

    private fun startGooglePlayDeepLink(promoCode: String) {
        startDeepLink(getGooglePlayPromoCodeURI(promoCode))
    }

    private fun getUberPromoCodeURI(clientID: String, promoCode: String = ""): String {
        return resources.getString(R.string.uber_promo_code_uri, clientID, promoCode)
    }

    private fun getGooglePlayPromoCodeURI(promoCode: String = ""): String {
        return resources.getString(R.string.googleplay_promo_code_uri, promoCode)
    }

    private fun startDeepLink(uri: String) {
        startDeepLink(uri, this)
    }

}