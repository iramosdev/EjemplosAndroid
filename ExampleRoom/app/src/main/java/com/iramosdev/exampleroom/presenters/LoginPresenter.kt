package com.iramosdev.exampleroom.presenters

import com.iramosdev.exampleroom.interactor.LoginInteractor
import com.iramosdev.exampleroom.interfaces.LoginView

class LoginPresenter (var loginView:LoginView?,val interactor: LoginInteractor):LoginInteractor.OnLoginFinishedListener {

    fun validarCredencial(username:String,password:String){
        loginView?.showProgress()
        interactor.login(username,password,this)
    }

    override fun onUsernameError() {
       loginView?.apply {
           setErrorUser()
           hideProgress()
       }
    }

    override fun onPasswordError() {
       loginView?.apply {
           setErrorPassword()
           hideProgress()
       }
    }

    override fun onSuccess() {
        loginView?.navigateHome()
    }


    fun onDestroy() {
        loginView = null
    }

}