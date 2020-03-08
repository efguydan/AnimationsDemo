plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.Sdk.compile)
    buildToolsVersion(Apps.Misc.buildTools)

    defaultConfig {
        applicationId = Apps.Misc.applicationID
        minSdkVersion(Apps.Sdk.min)
        targetSdkVersion(Apps.Sdk.target)
        versionCode = Apps.Version.code
        versionName = Apps.Version.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
        isQuiet = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.legacySupport)
    implementation(Libs.kotlin)
    implementation(Libs.appCompat)
    implementation(Libs.androidxCore)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUI)
    implementation(Libs.materialLibrary)

    testImplementation(TestLibs.jUnit)

    androidTestImplementation(AndroidTestLibs.jUnit)
    androidTestImplementation(AndroidTestLibs.espresso)
}
