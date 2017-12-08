# Mvp-Dagger2-Retrofit-Room-RxJava
Project to test android arquitecture with MVP, Dagger2, Retrofit, Room and JavaRx

* [MVP Kotlin Sergioct](https://github.com/Sergioct/Kotlin-Mvp-Dagger2-Retrofit-Room-RxJava/)

## Dependencies
  * MVP
  * Dagger 2
  * Retrofit
  * Room
  * JavaRx
  * ButterKnife

## Hierarchy

```
+-- database
|   +-- entity
|       - User
|       - UserDao
|   +-- repository
|       - UserDataSource
|       - UserRepository
|   - DataSource
|   - MyRoomDatabase
+-- di
|   +-- components
|       - AppComponent
|   +-- modules
|       - ActivityBindingModule // Not used, dagger-android class
|       - ActivityModule
|       - AppModule
|       - DbModule
|       - FragmentModule
|       - NetworkModule
|       - PicassoModule
|   +-- qualifier
|       - ActivityContext
|       - ApplicationContext
|   +-- scopes
|       - ActivityScoped
|       - ApplicationScoped
|       - FragmentScoped
|       - UserScoped
+-- network
|   +-- pojo
|       - Post
|   - ApiControllerRetrofit
+-- ui
|   +-- login
|   +-- main
|   +-- register
|   +-- splash
- MyApplication
```
## Inspired

##### Android Architecture
* [todo‑mvp‑dagger](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/)
* [todo‑mvp‑rxjava](https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava/)

###### TwistedEquations
* [RxMVP](https://www.youtube.com/watch?v=--wragcEDtI&list=PLuR1PJnGR-IgeDuzxoGe3hHV_8OfbHy8c/)
* [Dagger 2](https://www.youtube.com/watch?v=Qwk7ESmaCq0&list=PLuR1PJnGR-Ih-HXnGSpnqjdhdvqcwhfFU/)

##### Benoitletondor
* [Android Studio MVP template](https://github.com/benoitletondor/Android-Studio-MVP-template/)
