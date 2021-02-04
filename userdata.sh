#!/bin/sh
sudo yum update -y
sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -a -G docker ec2-user
sudo chkconfig docker on
sudo docker run -d --restart unless-stopped -p 80:8080 geronimomark/spring-boot:0.0.2
