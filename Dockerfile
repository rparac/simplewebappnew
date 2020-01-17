FROM maven:3.6.3-jdk-11-openj9

RUN apt-get update

# install latex
RUN apt-get -y install texlive

# install pandoc
RUN apt -y install pandoc

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN mvn package
CMD ["sh", "target/bin/simplewebapp"]
