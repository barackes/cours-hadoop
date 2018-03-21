Examen Hadoop : 
Questions : 
•	citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix
•	Qu’avez-vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible
•	Qu’avez-vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible
•	Peut-on faire du spark sans HDFS? et sans YARN?
•	Quelles sont les différences entre Hadoop v1 et Hadoop v2?


Question 1 : J’ai choisi 3 composants de l’écosystème Hadoop ci-dessous : 
a)	Pour le système de fichiers distribué j’ai choisi HDFS,  qui est un système de fichiers distribué et la couche native de stockage et d'accès à des données d'Hadoop. Il permet de stocker des fichiers de très grande taille dans un cadre distribué.
b)	Le gestionnaire de ressource  que j’ai choisi est  YARN, car il permet de faire coexister dans la même installation Hadoop plusieurs modèles de calcul distribué. Il reprend une partie les tâches de gestion de ressources qui étaient effectuées par MapReduce dans la première version d’Hadoop.  YARN crée pour chaque job du modèle de calcul un container auquel il alloue des ressources et suit l’exécution de ces différentes ressources. Par exemple, si l’on exécute un job Spark et un job MapReduce,  YARN va les encapsuler chacun dans un container différent, allouer des ressources précises à chaque container, et suivre l’exécution des containers dans les nœuds de données. 

c)	J’ai enfin choisi le framework de calcul Open source Spark ,  il permets le traitement de données et a la particularité d’ écrire les données en RAM. Je l’ai choisi car il permet une plus grande rapidité de traitement des calculs. 
Question 2 : 
Qu’avez-vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible
HDFS est un système de fichiers distribué, il fournit une abstraction du découpage et de la répartition des fichiers dans le cluster, ainsi les données et les services sont stockées sur plusieurs machines différentes. 
HDFS fonctionne selon un principe maître/esclaves: les données y sont stockées sur les DATANODES (esclaves) tandis que les localisations des blocs de données sont répertoriées par le NAMENODE (maître)
Principe de Lecture d’un fichier :
1.	L’utilisateur indique au Namenode qu'il souhaite lire un fichier.
2.	Le Namenode indique la taille du fichier ainsi que les différents Datanodes contenant les blocs qui composent ce fichier.
3.	Le client  récupère chacun des blocs sur le Datanode désigné.
4.	Si un des Datanodes est indisponible, Le client en contacte un autre.

   Principe d’écriture d’un fichier : 
1.	Le client indique au Namenode qu'il souhaite écrire un bloc.
2.	Le Namenode retourne au client le Datanode à contacter.
3.	Le client envoie le bloc au Datanode.
4.	Les Datanodes répliquent les blocs entre eux.
5.	Le cycle se répète pour le bloc suivant.

Avantage et inconvénient HDFS : 

Le système de fichiers est distribué sur plusieurs  serveurs, et chaque nœud stocke une partie du système fichier. Pour éviter le risque de perdre des données, chaque donnée peut être stockée à trois emplacements ou plus. 
HDFS évite également la congestion de réseau en privilégiant le déplacement des opérations plutôt que le déplacement des données. Ainsi, les applications peuvent accéder aux données à l’endroit où elles sont entreposées. Dernier point fort : sa portabilité. Il peut fonctionner sur différents types de commodity hardwares et résouds ainsi des problèmes de compatibilité.
Inconvenients : 
Un des problèmes est le stockage des fichiers de petite taille qui  occupe inutilement de l’espace et augmenter la latence des traitements. 
Question 3 : 

Question 3 : Spark : 
La couche d'abstraction que fournit Spark permet de ne pas se soucier de l'architecture sur laquelle tourne une  application. Cela nous permet de prototyper des applications en local avant de les envoyer vers un cluster de plusieurs machines pour traiter des données de taille plus conséquentes sans se préoccuper du changement d'architecture. 
Spark repose sur le principe de RDD : Resilient Distributed Dataset, donc si un dataset sur un noeud est perdu (un switch tombe), on peut reconstruire le RDD à l'aide du parent et des opérations effectués. 
La répartition des données se fait de la façon suivante : les données sont découpées en partitions. Chaque partition est assignée à un des executors. Le traitement d'une partition représente une tâche. Un cluster Spark ne peut traiter qu'une tâche à la fois par Executor, et en général il y a un executor par cœur de processeur. Par ailleurs, la taille d'une partition doit rester inférieure à la mémoire disponible pour son executor. 
Un ensemble de tâches réalisées en parallèle, une par partition d'un RDD, constitue une étape (stage). Toutes les tâches d'une étape doivent être terminées avant que l'on puisse passer à l'étape suivante. Un job Spark est composé d'une succession d'étapes ; la progression d'un job peut donc être mesurée au nombre d'étapes qui ont été réalisées. Un job Spark est créé pour chaque action qu'on réalise sur un RDD.

Question 4 :  Peut on faire du spark sans HDFS? et sans YARN?
On peut faire Spark sans HDFS , en mode standAlone. 
Spark peut fonctionner en se connectant à des cluster managers de types différents :On peut utiliser Spark avec ou sans Yarn,
Exemple des modes possibles : 
1)	le cluster manager autonome de Spark (standalone)
2)	Yarn 
3)	Mesos
4)	Kubernetes 

Question 5 )  Quelles sont les differences entre Hadoop v1 et Hadoop v2?

Hadoop2 réponds à certaines limites et restrictions de Hadoop1 
En effet, Hadoop1 restreint l'utilisation du cluster hadoop avec un seul engin de traitement MapReduce pour les jobs , transformer un algorithme en MapReduce demande beaucoup d'effort, de même, pour traiter des problèmes complexes, les deux étapes MAP et REDUCE ne suffisent pas, il est très souvent nécessaire d'enchaîner des séquences de MapReduce ce qui est très coûteux car cela nécessite de démarrer un job MapReduce à chaque fois.
 Sur Hadoop2 , Yarn arrive pour répondre au problème du Map Reduce, car Le job tracker du MapReduce avait une double responsabilité :Il doit gérer les ressources du cluster et il doit ordonnancer les jobs. Ce qui pose un problème si le tracker est défaillant. Yarn permets de gérer les ressources.
Par ailleurs, sur Hadoop2, Yarn permets d'exécuter n'importe quel type d'application distribuée sur un cluster Hadoop et pas uniquement les applications MapReduce et propose en effet de séparer la gestion des ressources du cluster et la gestion des jobs MapReduce, permettant ainsi de généraliser cette gestion des ressources à d'autres applications comme TEZ et Spark. L'idée principale est de considérer que les nœuds ont des ressources (mémoire et CPU) qui seront allouées aux applications quand elles le demandent.
