# Adyen Android Assignment

Architecture used
**MVVM** 
*used this architecture in this project because orientation change is handled by viewmodel*
*easy to add new feature quickly(flexible to extend easily)*
*easy to understand*
*maintainability*
*reusable*

Dependency Injection
**KOIN**
*easy implementation*
*Code Reusability*
*Good for small project*

**UI Implementation**
*ConstraintLayout*
*Used MaterialAlertDialog* -Implemented with default Dialog layout
*Used SwipeRefreshLayout on Home Screen*
*used Picasso for imageload*
-I used the above lib because its good for small apps(if we have less image)
-library size is also less as compare to other imager loader lib

*Tried minimal API call*
*handled portrait and landscape orientations*

**Paging implementation pending**
TODO:APP Was not consistent(random crash on scroll) so I removed the code for now.