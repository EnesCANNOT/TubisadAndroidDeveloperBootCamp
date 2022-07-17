package com.helloworldstudios.paparaclone

import java.io.Serializable

data class User(
    var userTitle: String,
    var userPhoneNo: String,
    var userImageName: String) : Serializable
{

}