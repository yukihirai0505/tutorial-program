FROM ubuntu:14.04
MAINTAINER Yuki Hirai <yukihirai0505@gmail.com>

ENV PLAY_VERSION 1.2.7
ENV PLAY_CODE_DIR /home/play/Code
ENV PYTHON_VERSION 2.7.13
ENV ANT_VERSION 1.9.9

# Create editor userspace
RUN groupadd play
RUN useradd play -m -g play -s /bin/bash
RUN passwd -d -u play
RUN echo "play ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/play
RUN chmod 0440 /etc/sudoers.d/play
RUN mkdir ${PLAY_CODE_DIR}
RUN chown play:play ${PLAY_CODE_DIR}

# Install dependencies
RUN apt-get update \
    && apt-get upgrade -y \
    && apt-get install -y \
    build-essential \
    ca-certificates \
    gcc \
    git \
    checkinstall \
    curl \
    wget \
    zip \
    unzip \
    software-properties-common \
    libreadline-gplv2-dev \
    libncursesw5-dev \
    libssl-dev \
    libsqlite3-dev \
    tk-dev \
    libgdbm-dev \
    libc6-dev \
    libbz2-dev \
    libpq-dev \
    make \
    python-pip \
    python2.7 \
    python2.7-dev \
    ssh \
    openjdk-7-jdk \
    && apt-get autoremove \
    && apt-get clean

RUN pip install -U "setuptools==3.4.1"
RUN pip install -U "pip==1.5.4"
RUN pip install -U "Mercurial==2.9.1"
RUN pip install -U "virtualenv==1.11.4"

WORKDIR /tmp

# Install Java8 and dependencies
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections \
    && add-apt-repository -y ppa:webupd8team/java \
    && apt-get update \
    && apt-get install -y oracle-java8-installer wget unzip tar \
    && rm -rf /var/lib/apt/lists/* \
    && rm -rf /var/cache/oracle-jdk8-installer

# Install jenv
RUN git clone https://github.com/gcuisinier/jenv.git /opt/.jenv

# Install play1.2.7
RUN wget https://downloads.typesafe.com/play/${PLAY_VERSION}/play-${PLAY_VERSION}.zip \
    && unzip play-${PLAY_VERSION}.zip \
    && mv play-${PLAY_VERSION} /opt/play \
    && chown -R play:play /opt/play \
    && rm play-${PLAY_VERSION}.zip

# Install maven
RUN apt-get install software-properties-common \
    && apt-add-repository universe \
    && apt-get update \
    && apt-get -y install maven

# Instsall ant1.9.9
RUN wget http://ftp.riken.jp/net/apache//ant/binaries/apache-ant-${ANT_VERSION}-bin.zip \
    && unzip apache-ant-${ANT_VERSION}-bin.zip \
    && mv apache-ant-${ANT_VERSION} /opt/ant \
    && rm apache-ant-${ANT_VERSION}-bin.zip

# jenv setting
RUN echo 'export PATH="/opt/.jenv/bin:$PATH"' >> /home/play/.bashrc
RUN echo 'eval "$(jenv init -)"' >> /home/play/.bashrc
# play setting
RUN echo 'export PLAY_HOME="/opt/play"' >> /home/play/.bashrc
RUN echo 'export PATH="$PATH:$PLAY_HOME"' >> /home/play/.bashrc
# ant setting
RUN echo 'export ANT_HOME="/opt/ant"' >> /home/play/.bashrc
RUN echo 'export PATH="$PATH:$ANT_HOME/bin"' >> /home/play/.bashrc

# Define user home. play will store ivy2 and sbt caches on /home/play/Code volume
RUN echo "export _JAVA_OPTIONS='-Duser.home=/home/play/Code'" >> /home/play/.bashrc

# Change user, launch bash
USER play
WORKDIR /home/play
CMD ["/bin/bash"]

# Expose Code volume and play ports 9000 default 9999 debug 8888 activator ui
VOLUME ${PLAY_CODE_DIR}
EXPOSE 9000
EXPOSE 9999
EXPOSE 8888

WORKDIR ${PLAY_CODE_DIR}
ADD . ${PLAY_CODE_DIR}