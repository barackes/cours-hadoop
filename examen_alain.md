"	Citez 3 composantes de l'écosystème Hadoop: Décrivez les succinctement, expliquez votre choix
Il existe plusieurs outils qui forment l'écosystème Hadoop.
J'ai choisi HIVE et PIG qui sont 2 outils qui permettent d'interagir avec les données contenues dans HDFS permettant d'exécuter des jobs MapReduce de façon transparente et HBASE :
-	Hive étant un outil développé par Facebook, permet d'utiliser HADOOP par le biais de requêtes HiveQL. Ce langage est proche du SQL. 
Il permet de construire un modèle de données relationnel basé sur les données contenues dans HDFS.
Ce modèle de données est stocké dans un métastore qui gère la définition des tables ainsi que les métadonnées.
-	Pig est un outil développé par Yahoo qui permet d'exécuter des jobs mapreduce en utilisant un langage de scripts PigLatin qui permet de travailler sur des données contenues dans HDFS. Ces données sont traitées par MapReduce qui retourne le résultat de ses calculs à Pig.

-	HBASE: C'est une base de données non relationnelle distribuée. Elle a la particularité d'utiliser les données directement dans HDFS sans passer par des tâches. HBASE présente donc des caractéristiques assez similaires à celles de HDFS (capacité à gérer des volumes de données de plusieurs Po, forte tolérance de panne…). HBASE est bien adaptée pour gérer des données contenant une table de plusieurs milliers de colonnes avec une majorité de cellules vides.


"	Qu'avez vous retenu de HDFS : architecture, fonctionnement, éléments de conception, points fort/faible

           L'HDFS : (Hadoop Destributed File System) est un système de stockages de fichiers distribués, permettant d'offrir des fonctionnalités de système d'exploitation pour les applications analytiques Big Data. Cette disposition permet l'exécution simultanée de multiples applications tout en offrant un meilleur suivi de la donnée tout au long de son cycle de vie.
Lorsque que l'on construit un cluster sur lequel va s'exécuter Hadoop (on parle de cluster Hadoop), on dois prendre en compte cinq critères : 
-	le type d'architecture distribuée (consistent à paralléliser l'exécution d'un travail dans un ensemble de machines interconnectées), le cluster computing (grappe de calcul) et le grid computing (grille de calcul)
-	le mode de partage des ressources dans l'architecture distribuée, 
-	le mode de communication des ordinateurs dans l'architecture distribuée, 
-	le mode de traitement des données et le type de parallélisme. 


"	Qu'avez vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible
Spark est un projet permettant la manipulation des données dans un environnement distribué. Il peut aussi bien faire les traitements sur disque ou tout en mémoire. Il va 10 fois plus vite que mapreduce sur disque et 100 fois plus vite en mémoire. Il est enrichi de librairies notamment MLiB qui contient des algorithmes parallélisés de machine learning, GraphX pour les algorithmes de graphes, SparkSQL pour notamment se connecter au metastore de Hive. Spark peut se plugger sur la majorité des systèmes distribués (NoSQL, Hadoop, MPP …). Il peut fonctionner en mode standalone ou être géré par un gestionnaire de ressources tel que Yarn ou Mesos. Il permet nativement de coder en scala, java ou python.

"	Peut on faire du spark sans HDFS? et sans YARN ?
Le YARN (Yet another Research Negotiator) 


"	Quelles sont les différences entre Hadoop v1 et Hadoop v2?
	MapReduce V1 est composé des éléments suivants:
"	API: qui permet de connecter le moteur MapReduce avec les applications clientes.
"	Framework: le core (runtime) qui permet d'exécuter les tâches MapReduce, à savoir, Map, Reduce, Shuffling, Sorting...
"	JobTracker: permet de gérer les noeud, allouer les ressources dans un cluster et scheduler les jobs.
"	TaskTracker: s'exécute sur un noeuds et exécute une des tâches MapReduce.
Cette architecture a connu ses limites dans la partie de gestion de ressources, ce qui a conduit à la l'introduction de MapReduce V2 avec une nouvelle Architecture qui pallie à ces problèmes. Les limites posés par cette architecture V1 sont notamment:
"	Les slots (CPU, RAM) fixes configurés dans noeuds, fait que la gestion de ressources est en manque d'efficience, les ressources du cluster sont souvent sous-utilisées.
"	Les applications non-MR ne peuvent pas partager les ressources du cluster Hadoop
"	Chaque cluster est géré par un seul JobTracker, ce qui pose un problème de scalabilité au-delà d'un certain nombre de noeuds...
MapReduce V2 introduit YARN, un gestionnaire de ressource, pour remplacer les composants JobTracker et TaskTracker, qui permet de dépasser les limites évoquées ci-dessus. YARN permet de :
"	Gérer dynamiquement les ressources sur les noeuds en fonction de disponibilités, ce qui augmente l'efficience de l'utilisation des ressources (via des containers)
"	Permet à des applications non-MR (comme Spark) d'utiliser les ressources du cluster (via une interface)
"	Résoudre le problème de scalabilité (via l'introduction des Application Manager).

YARN introduit les concepts suivants:
"	Resource Manager (RM): le RM est exécuté sur un master node et gère les ressources sur l'ensemble des NM (création de containers) et arbitre des ressources.
"	Node Manager (NM): le NM est exécuté sur les slaves nodes et communique avec le RM. Il contient des containers gérés par le RM. Les containers exécutent les jobs MapReduce.
"	Application Master (AM): spécifique à chaque application MR, s'exécute sur un container et sollicite le RM pour d'autres containers sur les quels l'application sera exécutée.
Dans MapReduce V2, la plupart des fonctions du JobTracker sont déplacés dans l'Application Master.


