package com.nearmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nearmusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegister.setOnClickListener{ haceRegistro() }
        binding.btLogin.setOnClickListener{ haceLogin() }

    }

    private fun haceLogin() {
        val correo = binding.etEmail.text.toString()
        val contrasena = binding.etContrasena.text.toString()

        auth.signInWithEmailAndPassword( correo, contrasena )
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? =null

                if (task.isSuccessful){
                    Log.d("Iniciando sesión", "Sesión iniciada")
                    user = auth.currentUser

                }else {

                    Log.d("Autenticando", "Error al iniciar sesión")

                }
                actualiza(user)
            }
    }

    private fun haceRegistro() {

        val correo = binding.etEmail.text.toString()
        val contrasena = binding.etContrasena.text.toString()
        auth.createUserWithEmailAndPassword( correo, contrasena )
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? =null

                if (task.isSuccessful){
                    Log.d("Registrando", "Usuario registrado")
                    user = auth.currentUser

                }else {

                    Log.d("Registrando", "Error al registrar usuario")
                }
                actualiza(user)
            }
    }

    private fun actualiza(user: FirebaseUser?) {

        if (user != null){

            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }

    }

    public override fun onStart() {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }


}
