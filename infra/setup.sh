#!/bin/bash

readonly DEPLOY_USER="deploy"
readonly CONTENT_DIR="/srv"

if ! id "$DEPLOY_USER" &>/dev/null; then
    useradd -m -s /bin/bash "$DEPLOY_USER"
    echo "Deploy user created."
fi

mkdir -p "$CONTENT_DIR"
chown -R "${DEPLOY_USER}:${DEPLOY_USER}" "$CONTENT_DIR"

apt-get update
apt-get -y install docker.io docker-compose fail2ban

systemctl enable --now docker
systemctl enable --now fail2ban
