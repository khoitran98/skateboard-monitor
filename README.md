Skateboard Monitor
==========================================================

## Overview

This is a beta version of an Android app to control/monitor an Electric Skateboard for my senior design project. The skateboard is Raspberry Pi controlled with GSM and GPS module and communicates with the app via cellular network. The app can send SMS message to the skateboard to trigger a piezo buzzer on the board (the "ring" feature) or tell the skateboard to send back an SMS message with its current coordinate (the geolocation feature). The app can parse coordinate from the received message, and pinpoint it on the map along with your current location using Google Maps API. The design also initially includes the capability to monitor the skateboard's battery percentage, charge time remaining, etc via Bluetooth Low Energy. However, due to our university sudden shutdown, our team are restricted from accessing our hardware components in the lab and never manage to finish the project. It's still unclear whether we can continue with the project or not.  

## Tech used

- Android SDK v24
- Latest Android Build Tools
- Maps SDK for Android

## Screenshot
<img src="https://user-images.githubusercontent.com/32660699/80317198-f19c1080-87c7-11ea-8f57-7632f392d280.png"/>
<img src="https://user-images.githubusercontent.com/32660699/80317199-f4970100-87c7-11ea-9134-99fdea7f3959.png"/>
<img src="https://user-images.githubusercontent.com/32660699/80317202-f5c82e00-87c7-11ea-82a1-46cc37c3d000.png"/>




