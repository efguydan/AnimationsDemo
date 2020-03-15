object Apps {
    object Sdk {
        const val compile = 29
        const val min = 21
        const val target = 29
    }

    object Version {
        const val code = 1
        const val name = "1.0.0"
    }

    object Misc {
        const val buildTools = "29.0.2"
        const val applicationID = "com.efedaniel.animationsdemo"
    }
}

object Versions {
    object Libs {
        const val gradle = "3.6.1"
        const val kotlin = "1.3.70"
        const val legacySupport = "1.0.0"
        const val appCompat = "1.1.0"
        const val androidxCore = "1.2.0"
        const val constraintLayout = "1.1.3"
        const val navigation = "2.3.0-alpha03"
        const val materialLibrary = "1.1.0"
    }

    object Test {
        const val jUnit = "4.12"
    }

    object AndroidTest {
        const val jUnit = "1.1.1"
        const val espresso = "3.2.0"
    }
}

object ProjectDependencies {
    const val buildTools = "com.android.tools.build:gradle:${Versions.Libs.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Libs.kotlin}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Libs.navigation}"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Libs.kotlin}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.Libs.legacySupport}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.Libs.appCompat}"
    const val preferences = "androidx.preference:preference:${Versions.Libs.appCompat}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.Libs.androidxCore}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Libs.constraintLayout}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Libs.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.Libs.navigation}"
    const val materialLibrary = "com.google.android.material:material:${Versions.Libs.materialLibrary}"
}

object TestLibs {
    const val jUnit = "junit:junit:${Versions.Test.jUnit}"
}

object AndroidTestLibs {
    const val jUnit = "androidx.test.ext:junit:${Versions.AndroidTest.jUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTest.espresso}"
}