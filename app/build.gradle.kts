plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger)
}

android {
    namespace = "com.rana.edge"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rana.edge"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kapt {
        correctErrorTypes = true
        arguments {
            arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.recyclerview)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.logging.interceptor)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)

//    implementation(libs.dagger)
//    annotationProcessor(libs.dagger.compiler)
    implementation(libs.hilt.android)
    kapt(libs.dagger.hilt.compiler)
//    implementation(libs.androidx.hilt.lifecycle.viewmodel)

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.fragment:fragment-ktx:1.7.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}