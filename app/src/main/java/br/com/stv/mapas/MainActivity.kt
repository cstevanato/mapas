package br.com.stv.mapas

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btnMapOnClick(view: View) {
        // Retirado de: https://www.thiengo.com.br/utilizando-intencoes-para-mapas-de-alta-qualidade-no-android
        Log.d("Map", "Map")
        val endereco = Uri.encode( "Shoppin Dom Pedro, campinas, SP, Brasil")

        val navegacao = Uri.parse( "google.navigation:q=$endereco")

        val intent = Intent( Intent.ACTION_VIEW, navegacao )

        intent.setPackage( "com.google.android.apps.maps" )
//
//        if( intent.resolveActivity( packageManager ) == null ){
//
//            val dirAction = "dir_action=navigate"
//            val destination = "destination=$beautySalon"
//            navigation = "https://www.google.com/maps/dir/?api=1&$dirAction&$destination"
//
//            navigationUri = Uri.parse( navigation )
//            intent = Intent( Intent.ACTION_VIEW, navigationUri )
//        }

        if( intent.resolveActivity( packageManager ) != null ){

            startActivity( intent )
        }
        else{
            Toast
                    .makeText(
                            this, "Não foi possível", Toast.LENGTH_LONG
                    )
                    .show()
        }
    }

}
