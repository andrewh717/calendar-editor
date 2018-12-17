# calendar-editor
This is a simple Java program to edit an ICS file.

## Run 
```
javac CalendarEditor.java
java CalendarEditor inputFile.ics
```
## Why?
I was trying to import my class schedule into Google Calendar and wanted to change one of the event names ("Law And Economics" seemed too long for me). After changing the name in Google Calendar, I noticed that it didn't change the rest of the events with the same name because Google's ICS import feature can't distinguish repeating events from an ICS file. So I decided to write this up real quick to fix that. 
## How?
This program just parses through an ICS file and writes out a new one with the desired changes. Right now it just supports changing the "SUMMARY" of an event, but it could be expanded upon easily to edit other event fields.