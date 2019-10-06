# ForzaFootball
This application simply list downs the football team and shows their details.
This application loads the football teams and details hosting service.Each team has following meta information

  - Name of the team
  - Gender of the team
  - Badge icon of the team
  
 ![Alt text](/screenshots/team-list.jpg?raw=true "Teams") ![Alt text](/screenshots/team-detail.jpg?raw=true "Team Detail")
 
 
# Tech Stack
This application is written in Kotlin, tried to separate the modules as much as possible. For network communication have created separate module called api which has set of api to load the teams and details from network. The idea was to have keep the api related stuff in separate module so that can be used in any other application as well. Think of this module provides set of Facebook API's and have OneToMany client application who can simply use this module to get the facebook api's such as login, friends, messages, photos etc.  

To build this application have used following libraries/pattern
- [Picasso](https://square.github.io/picasso/)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger](https://google.github.io/dagger/android.html)
- [Android architecture components](https://developer.android.com/topic/libraries/architecture)
- [Android Navigation Component](https://developer.android.com/guide/navigation)
