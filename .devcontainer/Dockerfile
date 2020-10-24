FROM openjdk:15-jdk-slim

RUN apt-get update && apt-get install curl gpg git -y

COPY library-scripts/zsh.sh /tmp/library-scripts/
RUN bash /tmp/library-scripts/zsh.sh