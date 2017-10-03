# News Aggregator Mobile App
A generalized news aggregator android app which provide headlines from 70 worldwide sources. News
sources include but not limited to...

    + BBC News
    + Bloomberg
    + ESPN
    + TechCrunch
    + Associated Press
    + ABC News
    + BuzzFeed
    + HackerNews and more...


![App Screenshot](./appScreenshot.png)

Simply modify the config.properties file within the `app/src/main/assets/` directory with a property to indicate the news source:
```
source=reuters
```

This app includes the following features:

+ JSON REST API integration with [newsapi.org](newsapi.org)

+ Networking using [Retrofit](https://square.github.io/retrofit/) to parse news API

+ Integration with [Firebase](https://firebase.google.com/)

+ Smooth image scrolling for loading & caching images using [glide](https://github.com/bumptech/glide)

+ Java serialization/deserialization library to convert Java Objects into JSON and back using [GSON](https://github.com/google/gson)

### Generate a SHA key for Firebase Integration
`keytool -exportcert -list -v -alias androiddebugkey -keystore ~/.android/debug.keystore`

Special thanks to [1](newsapi.org) & [2](https://www.safaribooksonline.com/library/view/learning-android-n/9781785880506/)
