object Apps {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.6.1"
    const val kotlin = "1.3.70"
    const val appCompat = "1.1.0"
    const val androidxCore = "1.2.0"
    const val constraintLayout = "1.1.3"

    //Test
    const val jUnit = "4.12"

    //Android Test
    const val ajUnit = "1.1.1"
    const val espresso = "3.2.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object TestLibs {
    const val jUnit = "junit:junit:${Versions.jUnit}"
}

object AndroidTestLibs {
    const val jUnit = "androidx.test.ext:junit:${Versions.ajUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}