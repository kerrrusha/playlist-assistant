# Playlist Assistant

Java MVC web-application on servlets, that uses PostgreSQL via JDBC. This app is used to suggest new songs for you, analyzing your musical preferences.
As of 11/25/2022, the site is hosting in the Google Cloud and available at: https://playlist-assistant-369622.oa.r.appspot.com/

## Technical notes

The application uses artists and tracks data from public APIs, such as: iTunes, LastFM and Deezer. 
Architecture - Monolith. In the case of a possible transition to a microservice architecture, such modules can be distinguished: 
  - Infrastructure (work with database)
  - Parser (receiving JSON information with API and subsequent mapping)
  - Playlist Assistant (an service that generates suitable playlist based on selected artists).
The project uses caching to avoid frequent requests to third-party APIs. To update the list of current artists, there is a background daily task. 

## Playlist Assistant Workflow

![playlist-assistant-workflow](https://user-images.githubusercontent.com/73041091/203847214-46ba660b-7c31-4663-b316-8b69b0eeff44.png)

## Usage features

To work with the application you need to register. It is necessary in order to maintain your musical preferences and the playlist formed on them. So, you can return to it after time, and get set of your offered songs. 
After registration, you will be asked to choose your favorite artists. Based on your choice, musical preferences will be formed.
After that, you’ll be able to see your suggested playlists on the main page. If you would want to change your favourite artist choice, you can deal with it via corresponding button on this page.

## User Workflow

![user-workflow](https://user-images.githubusercontent.com/73041091/203847364-9110b05b-cad2-405f-9f66-e51917cdb121.png)

## Class Diagram

![class-diagram](https://user-images.githubusercontent.com/73041091/203847469-837084f9-a4c0-4b6f-bb3f-fb216d54e090.png)

## Auth Page

![image](https://user-images.githubusercontent.com/73041091/203847497-89006339-d755-4705-8088-0d1d44d2a2dc.png)

## Select Favourite Artists Page

![image](https://user-images.githubusercontent.com/73041091/203847586-aa30c2f4-13b1-40b7-bb80-a0cc437b442c.png)

## Suitable Tracks Playlist Page

![image](https://user-images.githubusercontent.com/73041091/203847622-e8bfcbf7-3133-466d-82b5-15c7b5b902c0.png)
