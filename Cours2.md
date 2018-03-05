# HDP Cours 2

## Pourquoi on a inventé HDFS alors qu’on avait déjà des systèmes de fichiers distribués ?
- Abstraction du stockage pour faciliter la manipulation des fichiers
- Fiabilité, résilience, disponibilité
- Expose une interface pour optimiser le processing
- Scalabilité

## HBase vs HDFS
- HBase plus performant que HDFS en accès Random.
- HDFS ouvre juste une socket pour lire le fichier

## HDFS : Filesystem distribué

- Parallélisé : Ce même job va avoir un état partagé (exemple massive processing)
- Distribué : Aucun mapper n’est conscient de l’existence de l’autre, notion d’indépendance

## Exemple : Comment calculer la moyenne totale avec des élèves, des notes, des matières
- Merge and Sort

## Système distribué :
- Exemple de Cassandra => Les nœuds font stockage et routage

## Dans ce cas là, comment retrouver sa donnée ?
- Par exemple fonction de hashing mais si un nœud particulier tombe comment faire ?
- Exemple du consistent hashing 

## HDFS : NameNode / DataNode
### NameNode ne stocke pas la donnée
### NameNode seul nœud qui a l’état global du cluster 
- Topologie : Qu’est ce que sont mes nœuds
- Etat du FileSystem
- Expose les metadonnées
- Point d’entrée 
- Garantie la consistence
### DataNode stocke les données
- Fichiers traités par blocks (unité atomique d’écriture)
- Ce qu’on gère réellement c’est les blocks, le fichier n’est qu’un regroupement de blocks

## Event sourcing :
- Exemple d’une cagnotte, au lieu de modifier une valeur dans un champ, on conserve les infos de qui a ajouté quoi. Ainsi, possibilité de reproduire

- NameNode va ainsi garder l’état du FileSystem de manière similaire

## Pratique
- Configs dans etc/hadoop/core-site.xml et etc/hadoop/hdfs-site.xml
- Avant : ./bin/hdfs namenode -format
- ./sbin/start-dfs.sh
- netstat –an | grep LISTEN
- ./bin/hdfs dfs –mkdir /user
- ./bin/hdfs dfs –mkdir /user/rafgros
- ./bin/hdfs dfs –touchz empty_file
- ./bin/hdfs dfs –ls
- Les blocks sont dans /tmp/hadoop-rafgros/dfs/data/current/BP-112…./current/finalized/subdir0/subdir0
- Facteur de replication 3 : ./bin/hdfs dfs –setrep 3 /user/rafgros/LICENSE.txt
- Override : ./bin/hdfs dfs –D dfs.replication=3 –put yarn-site.xml /user/rafgros

