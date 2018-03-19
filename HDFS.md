# HDFS

### HDFS *- Master/Slave*

NameNode - Gère et expose l'ensemble des métadonnées du Filesystem. Il permet de savoir ou sont stockés les blocks de données que l'on cherche à atteindre.
DataNode - Contient les données.

**Le Namenode:**
- Ne stocke pas la donnée
- À l'état global du cluster
 - Topologie
 - Etat du FS
 - Exposer les metadonnées
- Connait les points d'entrés
- Garantie la consistance du cluster

**Le Datanode**
- Les fichiers sont traités par blocks - unité atomique de gestion (lecture/écriture et distribution)


- - -

## HDFS 

- Formattage
 - Initialise l'arborescence des path locaux à utiliser.
 > /bin/hdfs namenode -format

### IF ERROR:
- regarder les logs...


### Lancement de HDFS en mode pseudo-distribué
> /sbin/hdfs start-dfs.sh


### Verifier le bon fonctionnement
- jps -> process java qui tournent
```
$ jps [ENTER]
79554 SparkSubmit
27528 DataNode
79832 Jps
27247 SecondaryNameNode
27039 NameNode
```
- netstat -an | grep LISTEN


### Requêtage sur le system de fichier distribué
> /bin/hdfs dfs -ls /

> /bin/hdfs dfs -mkdir /user/{username}

> /bin/hdfs dfs -ls /user/{username}/


### Problème: DataNode non démarré
> ./logs/hadoop[TAB]-datanode[TAB].log

Remove datas

> rm -fr /tmp/hadoop-yoannis/dfs/data/

Relaunch cluster, will replicate

> ./sbin/start-dfs.sh




### Playing with HDFS

Create empty file

> ./bin/hdfs dfs -touchz mon_fichier.txt

Copy file from local to HDFS

> ./bin/hdfs dfs -put MY_FILE.BIN



### Où est stocké dans notre FS le FS HDFS?

On cherche dans le répertoire de création de HDFS ``/tmp/hadoop-{username}/dfs/`

On entre dans le datanode > `data/`


### HDFS *que se passe-t-il quand un client fait une demande*
- Le client fait une demande au NN
- le NN vérifie les droits, existence et lui donne un token qui contient les informations suivantes: 
  - les pointeurs pour se connecter sur les Datanodes où le client est autorisé à écrire
  - les blocks sur ces Datanodes où il peut écrire
  - les fallback (plusieurs Datanodes / blocks)
- Commencer à écrire sur le Datanode
  - Si un seul block et réplicas, DN envoi un ACK lors de la fin de l'écriture
  - Si plusieurs réplicas à faire, DN réplique sur DN suivant, et ainsi de suite de manière sequentiel 
 
