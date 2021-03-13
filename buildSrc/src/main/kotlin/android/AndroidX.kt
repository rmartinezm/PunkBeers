/** */
object AndroidX {

    /** */
    private object Version {

        /* */
        const val core = "1.3.2"

        /* */
        const val appCompat = "1.2.0"

        /* */
        const val legacy = "1.0.0"

        /* */
        const val constraintLayout = "2.0.4"

    }

    /* */
    const val core = "androidx.core:core-ktx:${Version.core}"

    /* */
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"

    /* */
    const val legacy = "androidx.legacy:legacy-support-v4:${Version.legacy}"

    /* @see [https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout] */
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

}