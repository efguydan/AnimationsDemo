// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath(ProjectDependencies.buildTools)
        classpath(ProjectDependencies.kotlin)
        classpath(ProjectDependencies.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}
