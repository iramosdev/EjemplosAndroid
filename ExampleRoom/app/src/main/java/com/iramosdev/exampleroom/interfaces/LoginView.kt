package com.iramosdev.exampleroom.interfaces

interface LoginView {

    fun showProgress()
    fun hideProgress()
    fun setErrorUser()
    fun setErrorPassword()
    fun navigateHome()

}