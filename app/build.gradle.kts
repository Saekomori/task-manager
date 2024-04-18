plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.tm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tm"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.navigation.compose)

    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)

    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.okhttp3)

    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.compose.material:material:1.4.2")

    implementation ("com.maxkeppeler.sheets-compose-dialogs:core:1.3.0")

    // INFO
  //  implementation ("com.maxkeppeler.sheets-compose-dialogs:info:1.3.0")

    // COLOR
    implementation ("com.maxkeppeler.sheets-compose-dialogs:color:1.3.0")

    // CALENDAR
    implementation ("com.maxkeppeler.sheets-compose-dialogs:calendar:1.3.0")

    // CLOCK
    implementation ("com.maxkeppeler.sheets-compose-dialogs:clock:1.3.0")

    // DATE TIME
        //implementation ("com.maxkeppeler.sheets-compose-dialogs:date_time:1.3.0")

    // DURATION
  //  implementation ("com.maxkeppeler.sheets-compose-dialogs:duration:1.3.0")

    // OPTION
  //  implementation ("com.maxkeppeler.sheets-compose-dialogs:option:1.3.0")

    // LIST
   // implementation ("com.maxkeppeler.sheets-compose-dialogs:list:1.3.0")

    // INPUT
   // implementation ("com.maxkeppeler.sheets-compose-dialogs:input:1.3.0")

    // EMOJI
  //  implementation ("com.maxkeppeler.sheets-compose-dialogs:emoji:1.3.0")

    // STATE
    implementation ("com.maxkeppeler.sheets-compose-dialogs:state:1.3.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)



}