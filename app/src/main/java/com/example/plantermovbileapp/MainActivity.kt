package com.example.plantermovbileapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions()

        val goToSecondAct = findViewById<Button>(R.id.goToSecondAct);
        goToSecondAct.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun hasInternetPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.INTERNET
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasSendSMSPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.SEND_SMS
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasReceiveSMSPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.RECEIVE_SMS
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasReadSMSPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if (!hasInternetPermission()) {
            permissionsToRequest.add(Manifest.permission.INTERNET)
        }
        if (!hasSendSMSPermission()) {
            permissionsToRequest.add(Manifest.permission.SEND_SMS)
        }
        if (!hasReceiveSMSPermission()) {
            permissionsToRequest.add(Manifest.permission.RECEIVE_SMS)
        }
        if (!hasReadSMSPermission()) {
            permissionsToRequest.add(Manifest.permission.READ_SMS)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionsRequested", "${permissions[i]} has all been granted.")
                }
            }
        }
    }
}