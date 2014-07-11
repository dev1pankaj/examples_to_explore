LoginTrack App
==========
This is very simple application that displays LoginTrack calendar to the logged-in user.

Now what is logintrack calendar?

LoginTrack calendar displays month-view with green-marked dates, green-marked date indicates that user have logged-in to the
portal for that date. Above calendar, message is shown "You have logged-in to portal for 10 times."

For Guest user, it will display message "This portlet is not intended for Guest user"


Technical Details:
-----
In LoginTrack App, we are having one plugin-hook for writing custom post-login-event, 
that will add login-data(ie. userId, log-in-date). App is maintaining this data in custom-table.

LoginTrack App also contains plugin-portlet, that fetches logindata from custom-table and presents it in calendar.



For any issues, you can reach out to kathiriyapankajm@gmail.com or pmkathiria@gmail.com
