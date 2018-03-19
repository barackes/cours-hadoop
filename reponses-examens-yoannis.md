# Yoannis TELPHON

## Citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix


### HDFS
	HDFS est un système de fichiers distribué qui fait une abstraction du stockage pour faciliter la manipulation de fichiers volumineux.
    C'est le file système sur lequel l'écosystème Hadoop est batî. Il a été créer afin de répondre à une problématique de scalabilité horizontale.
    HDFS est un élément essentiel de l'écosystème Hadoop de part la problématique qu'il répond.


### YARN
	YARN est un manageur de resources. Il gère les allocations des ressources du cluster, les surveillent et permet une haute disponibilité.
	YARN est selon moi une composant essentiel pour gérer toutes les resources de son cluster.


### Spark
	Spark est un moteur qui permet le calcule de données distribuée. Il utilise la mémoire vive afin d'accélerer les calcules type MapReduce (mais pas que). Spark est programmable dans des langages haut niveau tel que Scala, Python et R.
	Pour moi Spark est un élement essentiel car il permet de s'affranchir de la pleine puissance d'un cluster. C'est un outil puissant qui permet de traiter des calcule bien plus rapidement que d'autres moteur tels que Hive.

----------

## Qu’avez vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible


### Architecture:
	HDFS est constitué de deux type de nodes: Le NameNode et le DataNode.
	Le NameNode gère l'ensemble des métadonnées du file système. Il indique ou sont stockés les données. De plus il garantie la consistance du cluster.
	Le DataNode contient les données tout simplement. Les fichiers y sont traités par blocks.


	On parle parfois de Secondary NameNode qui sert de backup au NameNode mais cela n'est pas le cas dans un cluster ou l'on cherche à avoir une haute disponibilité, via l'utilisation de deux NameNode en actif / passif.


### Fonctionnement:
	Lors ce qu'un client fait une demande d'accès à une donnée, il passe par le NameNode.
	Ce dernier, suite à une vérification, lui fourni les différents pointeurs pour se connecter aux DataNode, la liste des blocks sur lesquels il peut écrire et les DataNode sur lesquels il peut se rabattre si ces premiers ne sont pas disponible.
	La validation de l'écriture sur les DataNode peut prendre un moment, étant donné que les réplicas se font de manière séquentiel, d'un DataNode à l'autre.


### Avantages & Inconvénients
	Avantages:
		Résilience (Réplicas)
			Grâce à la réplication des données, HDFS peut reconstruire un DataNode s'il viendrait à être corrompu.
		Disponible (Haute Diponibilité)
	Inconvénients:
		Ne convient pas aux petites données
			En effet, les blocks étant d'une taille fixe, si la donnée est inférieur à la taille d'un block, elle prendra tout l'espace block.

----------

## Qu’avez vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible


### Architecture:
	Il y a sept éléments important dans l'architecture de Spark:


	Drive:
		Le **Drive** est le process ou la méthode main s'exécute. Il converti le program en tâches qu'il donnera aux **Executors** pour être accompli.


	Executor:
		Les **Executors** sont des **Work Node**  qui sont en charge d'exécuter différentes **Tâches** d'un **Job** Spark. Ils sont lancés au début de l'application Spark et on pour durée de vie la totalité de la durée de vie de l'application Spark.


	Job:
		Les **Job** sont des opération qui sont exécuté sur un Dataset. Ils sont composés de **Stages**


	Stages:
		Les **Stages** sont des déplacement de données (actions de map / shuffle)


	Tâches:
		Les **Tâches** sont les opérations élémentaires sur les données.


	RDD:
		Le Resilient Distributed Dataset est une API qui permet de nombreuses transformations. C'était la structure utilisé dans les **Job** Spark.


	DataFrame:
		L'API DataFrame, introduit dans Spark 1.3 est le remplaçant du RDD. Il est orienté requêtes relationnels que Spark peut optimiser.
		

### Fonctionnement:
	Spark lance un **Drive** qui permet de lancer des **Work Nodes**.
	Ces Work Nodes contienent des **Executors** qui permettes de lancer différents **Jobs**. Ces **Jobs** sont eux même décomposés en **Stages** qui sont eux même décomposés en **Tâches**.
	
### Avantages & Inconvénients
	Avantages:
		Resilient
		Distribué
		Consomme peu de mémoire
		Optimisé pour l'utilisation de la RAM
		Rapide d'exécution
	Inconvénients:

----------

## Peut on faire du spark sans HDFS? et sans YARN?
	Nous avons exécuter en cours du Spark sans HDFS ou YARN. Cependant cela étant dans l'optique de faire des traitement de calcul simple, sur un jeu de donnée extrêment simpliste.
	L'avantage de HDFS et YARN ne se percevra qu'une fois le traitement d'un large jeu de données qui utilise plusieurs ressources.

----------

## Quelle est la differences entre Hadoop v1 et Hadoop v2
	Hadoop 1 exploitait l'algorithme de MapReduce et démontrait le potentiel du calcule distribué mais ne permetait de n'avoir qu'un seul Node par cluster. Hadoop 2 à été créé afin de répondre à un problème de scalabilité de la solution de par l'introduction de HDFS (10000 nodes par cluster) et YARN (pour optimiser les resources du cluster).
