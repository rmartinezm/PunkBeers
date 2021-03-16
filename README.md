# Punk Beers

Author: Roberto Martínez Medina
Android Studio required version: 4.1.2

Punk Beers it's a simple android application that makes use of [PunkApi](https://punkapi.com/) as remote data source.
Punk Beers implements some of most popoular libraries and usefull concepts in the Android Dev's world. Let me list some ones:
* Kotlin (1.4.30) as programming languaje.
* Kotlin Coroutines (1.4.2).
* Modular Android app architecture.
* buildSrc directory for Dependencies and versions management.
* Koin (2.2.2) as service locator.
* Most popular Android Jetpack libraries (Databinding, Navigation, Room  and Paging).
* Retrofit as http client.
* MVVM + Clean Architecture (UseCase, Repository and DataSource Remote and Local)

Punk Beers project manage 4 main modules:
* app: Manage presentation layer for features data flow.
* shared: Are user-facing functionality (UseCase definition flow).
* shared-pool: Pool of modules required by one or more shared modules.
* core: Kotlin modules that defines global interactions.

### Some references for more effective understanding of concepts
- [Intro to App Modularization](https://proandroiddev.com/intro-to-app-modularization-42411e4c421e)
- [Build a Modular Android App Architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82)
- [Gradle dependency management with Kotlin (buildSrc)](https://proandroiddev.com/gradle-dependency-management-with-kotlin-94eed4df9a28)
- [The Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Why you need Use Cases/Interactors](https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576)
- [Either](https://arrow-kt.io/docs/apidocs/arrow-core-data/arrow.core/-either/#either)
- [Kotlin Delegation](https://kotlinlang.org/docs/delegation.html)
