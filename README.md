#Networking in an Android app.

This project contains two branches. The master one is the one following the awesone codepath's tutorial :
https://github.com/codepath/android_guides/wiki/RottenTomatoes-Networking-Tutorial
The second branch (feature/networking/volley) use the library volley to handle Networking.

I made some changes : 
* For the listView, I put an @android:id/list and a Textview @android:id/empty in order to handle emptiness from the beginning.
* The factory: I kept the BoxOfficeMovie class as a simple POJO
* In the ListViewAdapter, I used a viewHolder for the  performance (http://developer.android.com/training/improving-layouts/smooth-scrolling.html))
