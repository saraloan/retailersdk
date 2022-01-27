# Saraloan Retailer SDK

This library helps you integrate the Saraloan Retailer App in your Android App. This library serves as an interface to the Saraloan Platform and helps your retailers complete their applications, complete eSign & eNACH, view their loan account and make repayments.

## Integration Guide

1. Add Jitpack repository to your build file, `settings.gradle` or `build.gradle`
```gradle
repositories {
  #...
  #...
  #...
  maven {url "https://jitpack.io"}
}
```

2. Add the dependency to your `build.gradle`
```gradle
dependencies {
  #...
  #...
  #...
  implementation 'com.github.saraloan:retailersdk:Tag'
}
```
That's it, you are now ready to use our SDK

3. Initialize the SDK, Replace YOUR_USERNAME and YOUR_PASSWORD with the credentials provided to you.
```kotlin
Saraloan.instance
  .with(application)
  .initialize("YOUR_USERNAME", "YOUR_PASSWORD")
```

4. When you want to launch the Saraloan Retailer App, launch the app. Replace MOBILE_NUMBER with mobile number of the retailer.
```kotlin
Saraloan.instance.launch(this, "MOBILE_NUMBER")
```
