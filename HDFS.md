# HDFS

### HDFS *- Master/Slave*

NameNode - permet de savoir ou sont stockés les blocks de données que l'on cherche à atteindre
DataNode - contient 

NameNode (NN)
|_ DataNode1 (DN)
|_ DataNode2 (DN)
|_ DataNode3 (DN)

-----------De quoi avons nous besoin?
- Ne stock pas la donnée
- Etat global du cluster
 - Topologie
 - Etat du FS
 - Exposer les metadonnées
- Point d'entrée
- Garant de la consistance

- - -

### HDFS 

- Formattage
 - Permet de mapper les paths aux blocks de notre DD
 > /bin/hdfs namenode -format

Le fichier .ckpt contient un checkpoint des transactions faites


Lancement de HDFS 
> /sbin/hdfs start-dfs.sh

Verifier le bon fonctionnement
- jps -> process java qui tournent
- netstat -an | grep LISTEN

Verifier le system de fichier
> /bin/hdfs dfs -ls /
> /bin/hdfs dfs -mkdir /user/{username}
> /bin/hdfs dfs -ls /user/{username}/


