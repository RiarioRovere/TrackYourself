# TrackYourself
SelfTracking application for life quality analysis 

mvn package ??--clean

docker build . -t track-yourself-front:latest-back

docker run -p 8080:8080 track-yourself-front:latest-back

docker commit 4082bc46e030 track-yourself-front:latest-back

docker tag track-yourself-front:latest-back riariorovere/track-yourself-front:latest-back

docker login

docker push riariorovere/track-yourself-front:latest-back

