FROM ruby:2.2.0
MAINTAINER Yuki Hirai <yukihirai0505@gmail.com>
# RUN: buildするときに実行される
RUN apt-get update -qq && apt-get install -y build-essential libpq-dev
RUN mkdir /myapp
# CMD: runするときに実行される
CMD ["echo", "now running..."]
WORKDIR /myapp
ADD Gemfile /myapp/Gemfile
RUN bundle install
ADD . /myapp