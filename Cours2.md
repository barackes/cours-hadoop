# HDP Cours 2

## Pourquoi on a invent� HDFS alors qu�on avait d�j� des syst�mes de fichiers distribu�s ?
- Abstraction du stockage pour faciliter la manipulation des fichiers
- Fiabilit�, r�silience, disponibilit�
- Expose une interface pour optimiser le processing
- Scalabilit�

## HBase vs HDFS
- HBase plus performant que HDFS en acc�s Random.
- HDFS ouvre juste une socket pour lire le fichier

## HDFS : Filesystem distribu�

- Parall�lis� : Ce m�me job va avoir un �tat partag� (exemple massive processing)
- Distribu� : Aucun mapper n�est conscient de l�existence de l�autre, notion d�ind�pendance

## Exemple : Comment calculer la moyenne totale avec des �l�ves, des notes, des mati�res
- Merge and Sort

## Syst�me distribu� :
- Exemple de Cassandra => Les n�uds font stockage et routage

## Dans ce cas l�, comment retrouver sa donn�e ?
- Par exemple fonction de hashing mais si un n�ud particulier tombe comment faire ?
- Exemple du consistent hashing 

## HDFS : NameNode / DataNode
### NameNode ne stocke pas la donn�e
### NameNode seul n�ud qui a l��tat global du cluster 
- Topologie : Qu�est ce que sont mes n�uds
- Etat du FileSystem
- Expose les metadonn�es
- Point d�entr�e 
- Garantie la consistence
### DataNode stocke les donn�es
- Fichiers trait�s par blocks (unit� atomique d��criture)
- Ce qu�on g�re r�ellement c�est les blocks, le fichier n�est qu�un regroupement de blocks

## Event sourcing :
- Exemple d�une cagnotte, au lieu de modifier une valeur dans un champ, on conserve les infos de qui a ajout� quoi. Ainsi, possibilit� de reproduire

- NameNode va ainsi garder l��tat du FileSystem de mani�re similaire

## Pratique
- Configs dans etc/hadoop/core-site.xml et etc/hadoop/hdfs-site.xml
- Avant : ./bin/hdfs namenode -format
- ./sbin/start-dfs.sh
- netstat �an | grep LISTEN
- ./bin/hdfs dfs �mkdir /user
- ./bin/hdfs dfs �mkdir /user/rafgros
- ./bin/hdfs dfs �touchz empty_file
- ./bin/hdfs dfs �ls
- Les blocks sont dans /tmp/hadoop-rafgros/dfs/data/current/BP-112�./current/finalized/subdir0/subdir0
- Facteur de replication 3 : ./bin/hdfs dfs �setrep 3 /user/rafgros/LICENSE.txt
- Override : ./bin/hdfs dfs �D dfs.replication=3 �put yarn-site.xml /user/rafgros

