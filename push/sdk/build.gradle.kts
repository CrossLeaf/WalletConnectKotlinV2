plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.sqldelight")
    id("com.google.devtools.ksp") version kspVersion
    id("publish-module-android")
    id("de.mannodermaus.android-junit5") version "1.9.3.0"
}

project.apply {
    extra[KEY_PUBLISH_ARTIFACT_ID] = "push"
    extra[KEY_PUBLISH_VERSION] = PUSH_VERSION
    extra[KEY_SDK_NAME] = "Push"
}

android {
    compileSdk = COMPILE_SDK

    defaultConfig {
        minSdk = MIN_SDK
        targetSdk = TARGET_SDK

        aarMetadata {
            minCompileSdk = MIN_SDK
            targetSdk = TARGET_SDK
        }

        buildConfigField(type = "String", name = "SDK_VERSION", value = "\"${requireNotNull(extra.get(KEY_PUBLISH_VERSION))}\"")
        testInstrumentationRunnerArguments += mutableMapOf("runnerBuilder" to "de.mannodermaus.junit5.AndroidJUnit5Builder", "clearPackageData" to "true")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "${rootDir.path}/gradle/proguard-rules/sdk-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = jvmVersion
        targetCompatibility = jvmVersion
    }

    kotlinOptions {
        jvmTarget = jvmVersion.toString()
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.time.ExperimentalTime"
    }

    testOptions.unitTests {
        isIncludeAndroidResources = true
        isReturnDefaultValues = true
    }
}

sqldelight {
    database("PushDatabase") {
        packageName = "com.walletconnect.push"
        schemaOutputDirectory = file("src/main/sqldelight/databases")
        verifyMigrations = true
    }
}

dependencies {
    debugImplementation(project(":androidCore:sdk"))
    releaseImplementation("com.walletconnect:android-core:$CORE_VERSION")

    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    moshiKsp()
    androidXTest()
    fcm()
    jUnit5()
    robolectric()
    mockk()
    testJson()
    coroutinesTest()
    scarletTest()
    sqlDelightTest()
}