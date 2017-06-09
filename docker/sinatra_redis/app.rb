#!/usr/bin/env ruby
#
require 'sinatra'
require 'redis'
require 'json'

r = Redis.new host: ENV["REDIS_HOST"], port:"6379"

get '/value/:key' do
  value = r.get params[:key]
  v = {
    key: params[:key],
    value: value
  }
  v.to_json
end

post '/data/:key' do
  msg = request.body.read
  r.set params[:key], msg
end