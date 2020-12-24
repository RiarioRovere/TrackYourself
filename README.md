# TrackYourself
SelfTracking application for life quality analysis 

mvn package ??--clean

sudo docker build . -t track-yourself-front:latest-back

sudo docker run -p 8080:8080 track-yourself-front:latest-back

sudo docker commit 4082bc46e030 track-yourself-front:latest-back

sudo docker tag track-yourself-front:latest-back riariorovere/track-yourself-front:latest-back

sudo docker login

sudo docker push riariorovere/track-yourself-front:latest-back

