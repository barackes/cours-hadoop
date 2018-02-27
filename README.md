# cours-hadoop


## installer hadoop hdfs sur la machine locale

- telecharger hadoop http://hadoop.apache.org/releases.html
- verifier si on peut faire un ssh sur localhost:
```
ssh localhost
```

- pour generer une clé (sans passphrase):
```
ssh-keygen -t rsa
```

    - pour mac os, il faut activer le remote login

```
sudo systemsetup -setremotelogin on
```

    - pour ubuntu
installer open-ssh 

```
apt-get install -y open-ssh

systemctl start openssh
```    
- installer java (version 8 de preference)
