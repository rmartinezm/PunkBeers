/** */
object Retrofit {

    /** */
    private object Version {

        /* */
        const val retrofit = "2.9.0"

        /* */
        const val interceptor = "4.8.0"

    }

    /* */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"

    /* */
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"

}