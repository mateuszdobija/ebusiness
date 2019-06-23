FROM ubuntu:18.04

MAINTAINER Student Studencki <student.wazny@uj.edu.pl>

RUN useradd ujot --create-home

RUN apt-get update
RUN apt-get install -y vim unzip curl git

RUN apt-get install sudo
RUN curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
RUN apt-get install -y nodejs
RUN npm install npm@latest -g
RUN npm install -g create-react-app
USER ujot

CMD echo "Hello World"
