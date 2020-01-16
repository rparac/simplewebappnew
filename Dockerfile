FROM ubuntu:18.04

RUN apt-get update

# install latex
RUN apt-get -y install texlive

# install pandoc
RUN apt -y install pandoc

RUN apt-get -y install maven
RUN apt-get -y install openjdk-11-jre openjdk-11-jdk

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN mvn package
CMD ["sh", "target/bin/simplewebapp"]
