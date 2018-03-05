# cours-hadoop
cours hadoop sio 2018

## Installation de hadoop sous ubuntu

- Installation de java : apt-get install oracle-java8-jdk (par exemple)

- Dans le fichier /etc/environment ajouter la ligne : JAVA_HOME="/usr/lib/jvm/oracle-java8-jdk-amd64"

- Commande : source /etc/environment

- Commande : export JAVA_HOME

- Telecharger le binaire hadoop depuis le lien suivant : http:/hadoop.apache.org/releases.html

- Decompresser l'archive dans le dossier de votre choix : tar -xzvf [Nom de l'archive]

- Installer openssh server : sudo apt-get install openssh-server

- Si ssh localhost ne marche pas : generer cle sans passphrase (ssh-keygen -t rsa)
