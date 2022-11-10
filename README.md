# QURANMASTER

### Background

The Qur-aan is memorised by adults and children alike. The number of memorisers of the Qur-aan may have grown exponentially over time, thanks to various means that make the task easier. Hopefully, this app will be one of them.

### The Precursor

This project is an update to the earlier developed [QPuzzle](https://play.google.com/store/apps/details?id=com.haneef.qpuzzlecomplete), a native Android app that does the same function.

### What it does

The app challenges a user to rearrange a shuffled set of chunks from a single page of the Qur-aan.

### The Project

I'm using Spring Boot to build the app. I'm doing this while learning Spring Boot. With my many years of Java experience, I expect to integrate fast with learning Sring Boot. The app will be hosted on a cloud service for users to connect.

### The future

After I gain some ground in Spring Boot, I wish to explore and implement this app in React.

#### 05/11/2022
* Started the project
* Created Starter project from [spring initializr](http://start.spring.io)
* Added the following dependencies:
    - Spring web
    - Sping Dev tools
    - Thymeleaf
    - Spring Actuator
* Added a folder named qfiles for chunks of a sample page under the /templates/static/ folder 
* Created PlayController.java the controller that will handle user interactions
* Created play.html which will hold page chunks for user interaction

#### 10/11/2022
* Added javascript grid grab and move functionality
* Implemented randomisation of page chunks