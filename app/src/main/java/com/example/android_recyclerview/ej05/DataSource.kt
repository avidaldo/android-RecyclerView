package com.example.android_recyclerview.ej05

import android.net.Uri

class LenguajeProg5 private constructor(val nombre: String, val uriImagen: Uri) {
    constructor(nombre: String, urlImagenString: String) : this(nombre, Uri.parse(urlImagenString))
}

fun getData() = mutableListOf(
    LenguajeProg5("Java", "https://ubiqum.com/assets/uploads/2019/10/screenshot-2021-02-11-at-115416.png"),
    LenguajeProg5("Kotlin", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kotlin_Icon.svg/2048px-Kotlin_Icon.svg.png"),
    LenguajeProg5("JavaScript", "https://i.pinimg.com/originals/12/49/49/1249492264f909cc540ddc8e87419e42.png"),
    LenguajeProg5("Swift", "https://miro.medium.com/max/1138/1*6-G_o5PZSzppyfdLTbFu-A.png"),
    LenguajeProg5("Python", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1200px-Python-logo-notext.svg.png"),
    LenguajeProg5("PHP", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/1280px-PHP-logo.svg.png"),
    LenguajeProg5("C#", "https://seeklogo.com/images/C/c-sharp-c-logo-02F17714BA-seeklogo.com.png"),
    LenguajeProg5("Go", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Go_Logo_Blue.svg/1200px-Go_Logo_Blue.svg.png"),
    LenguajeProg5("Rust", "Esto va a fallar al convertir a URL")
)
