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

cp /etc/ssh/sshd_config /etc/ssh/sshd_config.bak
sed -i 's/^#\?PasswordAuthentication .*/PasswordAuthentication no/' /etc/ssh/sshd_config
sed -i 's/^#\?PermitEmptyPasswords .*/PermitEmptyPasswords no/' /etc/ssh/sshd_config
sed -i 's/^#\?PermitRootLogin .*/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config
systemctl restart ssh
echo "SSH rules updated."
