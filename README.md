# NASAImageoftheDay 

NASA Image Of the Day
NASA Image of the Day Android App
This Android app displays the NASA Image of the Day, which can be either an image or a video. It uses the NASA API to fetch the latest content.

# Features
Display NASA's Image of the Day.
View the image or play the video (if available).
Pull to refresh to get the latest content.
# Screenshots
Screenshot 1

![imageoftheday](https://github.com/baishakhee93/NASAImageoftheDay/assets/50324744/26d5c753-82e3-453d-95c4-7832567b34a2)

Screenshot Vedio


https://github.com/baishakhee93/NASAImageoftheDay/assets/50324744/ffb21fea-9fa7-474b-ae01-e91eab351868



# Installation
To use this app, follow these steps:

Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/baishakhee93/NASAImageoftheDay.git
Open the project in Android Studio.

Build and run the app on an Android emulator or device.

# Usage
When you open the app, it will automatically fetch the NASA Image of the Day.
You can pull down to refresh and get the latest content.
If the content is an image, it will be displayed on the screen.
If the content is a video, you can click on the play button to watch it in a web view.

# Dependencies
Retrofit for making network requests.
Glide for loading and displaying images.
SwipeRefreshLayout for pull-to-refresh functionality.

# API Key
This app requires a NASA API key to fetch the data. You can obtain an API key from NASA's API Portal.
https://api.nasa.gov/

Once you have the API key, add it to the Constants.NASA_API_KEY field in the code.
https://api.nasa.gov/  

java
Copy code
private void loadData() {
    Call<MainModelResponse> call = apiInterface.getData(Constants.NASA_API_KEY);
    // ...
}


# License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
NASA for providing the API to access their incredible content.
