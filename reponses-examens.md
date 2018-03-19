
### 1-citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix
* HDFS, filesysteme distribué de Hadoop, crée pour ajouter une Abstraction du stockage pour faciliter la manipulation des fichiers, je l'ai choisi comme composant parce que grâce aux caractéristiques de Fiabilité, de résilience et de disponibilité ainsi que de la scalabilité, il permet des calculs fiables et extrêmement rapides

* Spark, un moteur de traitement et de calcul distribué, il exécute la totalité des opérations d'analyse de données en mémoire et en temps réel, j'ai choisi Spark comme composant et non MapReduce de Hadoop, du fait que Spark est plus rapide parce qu’il peut travailler sur la totalité de la donnée en même temps contrairement à MapReduce de Hadoop qui travaille par étape ;

* YARN, est une ressource manager il a été créer dans la logique de séparer entre ce qui est calcul/traitement de donnée et la partie gestion de ressource, il est important parce qu’il permet de gérer les différents ressource mis à disposition aux services des composants de l'écosystème de Hadoop

### 2-Qu’avez vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible

HDFS est un filesystem distribué à Access séquentiel ; repose sur une architecture HDFS maître/esclave, il comprend deux composants principaux : les espaces de noms et le service de stockage des blocs. Le service d'espace de noms gère les opérations sur les fichiers et les répertoires, tels que la création et la modification de fichiers et de répertoires. Le service de stockage par blocs met en œuvre la gestion des clusters de nœuds de données, les opérations de bloc et la réplication ;
* Name Node - Gère et expose l'ensemble des métadonnées du Filesystem. Il permet de savoir où sont stockés les blocks de données que l'on cherche à atteindre. 
* Data node - Contient les données par block.
```
Son point fort : fiable, résilience et scalable 
Son point faible : Lecture/écriture séquentielle, pour avoir une donnée dans un fichier faut parcourir tout le bloc qui lui correspond ;
```
### 3-Qu’avez-vous retenu de Spark : architecture, fonctionnement, éléments de conception, points fort/faible

Spark :  un moteur de traitement et de calcul distribué, en s’appuyant sur des graphes orientés acycliques (DAG) Spark a la particularité de maintenir les résultats intermédiaires en mémoire plutôt que sur le disque, sa capacité a utilisé les RDD lui facilitent le calcul et la récupération de donnée dans le cas de lors corruption ;
```
Point fort : Temps de calcul supérieur a celui de MapReduce Hadoop, in-memory, calcul distribué,
Point faible : a besoin d'un filesystem,
```

### 4-Peut-on faire du Spark sans HDFS ? et sans YARN ?

Oui, c'est possible de faire du Spark sans HDFS et sans YARN;

Sans hdfs, il est possible de passer notre jeu de donnée en local directement en spark et l'utiliser sans pour autant avoir besoin d'un filesystem manager,
Sans Yarn, Spark utilise son mode Standalone sans yarn et sans Mesos

### 5-Quelles sont les differences entre Hadoop v1 et Hadoop v2?


Dans Hadoop V1, Le MapReduce de Hadoop se chargé à la fois de traiter la donnée ainsi que de la gestion de ressource des clusters, avec l'arrivée de YARN dans la V2, la gestion des ressources et traitement de donnée est réalisé par différents processus, et un autre point avantageux dans la V2 par rapport à la V1 est bien le nombre de Name Node , dans la version 1, il y'a qu'un seul namenode qui gère tout le Nam espace, avec la version 2 il est possible d'avoir plusieurs namenode qui gère plusieurs namespace


