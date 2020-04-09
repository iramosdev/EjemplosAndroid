package com.iramosdev.exampleroom.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.iramosdev.exampleroom.R
import com.iramosdev.exampleroom.interactor.LoginInteractor
import com.iramosdev.exampleroom.interfaces.LoginView
import com.iramosdev.exampleroom.presenters.LoginPresenter
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity(),LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        btnLogin.setOnClickListener(){
            this.validacion()
        }
    }

    override fun showProgress() {
        //TODO("Not yet implemented")
        progressBar.visibility=View.VISIBLE
    }

    override fun hideProgress() {
        //TODO("Not yet implemented")
        progressBar.visibility=View.GONE
    }

    override fun setErrorUser() {
        //TODO("Not yet implemented")
        editUser.error="El campo usuario es obligatorio"
    }

    override fun setErrorPassword() {
        //TODO("Not yet implemented")
        editClave.error="El campo password es obligatorio"
    }

    override fun navigateHome() {
        //TODO("Not yet implemented")
        startActivity(Intent(this,home::class.java))
    }

    fun validacion() {
        this.presenter.validarCredencial(editUser.text.toString(),editClave.text.toString())
    }


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onStop() {
        progressBar.visibility=View.GONE
        editClave.text=Editable.Factory.getInstance().newEditable("")
        editUser.text= Editable.Factory.getInstance().newEditable("")
        //editClave.value=""
        super.onStop()

    }
}
