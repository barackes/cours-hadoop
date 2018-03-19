# Citez 3 composantes de l��cosyst�me Hadoop: D�crivez les succinctement, expliquez votre choix

Je fais le choix de ne pas �voquer HDFS et Spark dans cette question vu qu'ils seront �voqu�s dans
les questions suivantes.

## Element 1 : YARN
YARN (pour "Yet Another Ressource Negociator") est un gestionnaire de ressources pour un cluster Hadoop. 
Il permet de g�rer l'allocation des ressources de mani�re effective. Il se base sur 2 diff�rents daemon,
un tracker de job et un suivi de l'avancement. Il me semblait important d'�voquer cette composante qui 
est tr�s couramment utilis�e sur un cluster Hadoop et qui est la principale diff�rence entre Hadoop 1 et
Hadoop 2. On peut se passer d'un gestionnaire de ressource mais cela complique vraiment la t�che.
On peut aussi citer son principal concurrent : MESOS.

## Element 2 : HBASE
HBase est une base de donn�e distribu�e oritent� colonne qui s'utilise avec le syst�me de fichiers HDFS.
HBase a �t� d�velopp� en s'inspirant des publications de Google sur BigTable. En pratique, HBase utilise 
le filtre de Bloom qui est un test de pr�sence pour ses requ�tes. J'ai fait le choix de citer cette composante
car elle offre un certain int�r�t quand on veut effectuer des acc�s Random sur des fichiers car elle offre plus
de rapidit� compar� � l'utilisation de HDFS sans HBase.

## Element 3 : MapReduce
MapReduce est un framework d'execution qui est l'impl�mentation Hadoop de l'algorithme de Google du m�me nom.
Il permet de d�composer le traitement des jobs en plusieurs �tapes afin d'optimiser le traitement parall�le des donn�es.
On peut noter qu'il est possible d'utiliser TEZ � la place de MapReduce

# Qu�avez vous retenu de HDFS: architecture, fonctionnement, �l�ments de conception, points fort/faible

HDFS est un syst�me de fichiers distribu�s. Il permet une abstraction du stockage pour faciliter la manipulation
des fichiers et se caract�rise par sa fiabilit�, sa r�silience, sa disponibilit� et sa scalabilit�. Il fonctionne en 
exposant une interface pour optimiser le processing des fichiers. Son architecture, de type Master/Worker repose sur un 
NameNode qui g�re et expose l'ensemble des m�tadonn�es du syst�me de fichiers mais ne stocke pas la donn�e. Il contient notamment
l'�tat global du cluster, sa topologie, les diff�rents point d'entr�e. Il permet de garantir la conistence du cluster. Ce sont les 
DataNodes qui contiennent les donn�es sous forme de blocs qui sont l'unit� atomique de gestion des fichiers. En pratique, quand un client
veut ajouter un fichier sur le cluster, il commence par faire une demande au NameNode qui v�rifie ses droits et lui renvoie un token avec des informations
telles que des pointeurs vers les DataNodes et les blocs sur lesquels il peut �crire. L'�criture sur les DataNodes se fait de mani�re
s�quentielle. Ainsi, il est en g�n�ral plus judicieux d'ins�rer son fichier avec un facteur de r�plication 1 puis de le passer � 3 par la suite. 
Le point faible principal repose sur le mode Master/Worker qui fait que le NameNode est un SPOF. Il est possible d'impl�menter un secondary
NameNode et c'est ZKFC (similaire � ZooKeeper) qui d�cidera de qui est actif et passif.

# Qu�avez vous retenu de Spark: architecture, fonctionnement, �l�ments de conception, points fort/faible

Spark est un engine de calcule de donn�es distribu�es. Il peut �tre lanc� avec des langages tels que Python (Pyspark) ou R mais le mieux est de l'utiliser avec 
le langage Scala qui est son langage natif. Il y a deux types d'op�rations possibles dans Spark : les transformations qui sont juste une prise en compte 
de l'op�ration et les actions qui sont appliqu�es � la donn�e. Les op�rations Spark sont appel�s "jobs" et peuvent �tre repr�sent�s de mani�re logique
sous forme de DAG (Directed Acyclic Graph). Un job se d�compose en plusieurs stages qui se d�composent en m�me en plusieurs op�rations atomiques appel�es des
t�ches. Les t�ches s'executent sur des Executors. En pratique, on peut avoir une vision des diff�rents jobs depuis l'interface graphique accessible sur le port 4040.
Spark peut �tre utilis� sans Ressource Manager ce qu'on appelle le mode Standalone mais ce n'est pas assez solide pour �tre utilis� en production. On r�serve cette option
plutot pour du Dev ou du Test. On peut utiliser un Ressource Manager tel que Yarn ou Mesos gr�ce � l'ajout d'un flag. L'utilisation de Yarn permet de d'avoir un HDFS s�curis�
mais il faut que le HDFS supporte la version 1 du MapReduce. L'utilisation de Mesos pose des grandes contraintes de scheduling. Un point fort de Spark est la possibilit� d'effectuer
des traitements en m�moire pour les acc�l�rer. Spark propose un formattage des donn�es propre se nommant
RDD pour "Resilient Distributed Dataset" qui permet comme son nom l'indique, la r�silience dans un environnement de distibution des donn�es. Un des pont faible notable est qu'en effectuant 
une jointure, on met le RDD en cache ce qui est tr�s couteux. Au contraire, le point fort du RDD c'est le fait qu'une partition soit un bloc comme ca en cas d'erreur, on peut directement aller
chercher le r�plicat du bloc. On a aussi pu �tudier la th�matique de la mod�lisation des donn�es avec la recommendation d'utiliser le format "parquet" qui
utilise par d�faut une compression snappy.

# Peut on faire du spark sans HDFS? et sans YARN?

## Spark sans HDFS
Il est en effet possible de faire du spark sans HDFS en l'utilisant dans un mode standalone sans Hadoop. Spark peut en effet lire et processer des donn�es sur d'autres types de syst�mes de fichiers
en jouant son role d'engine de calcul de donn�es. Etant donn� que Spark n'a pas de layer de stockage, on l'associe en g�n�ral � un syst�me de fichiers distribu� tel que HDFS. Sans HDFS, Spark fait ses calculs
de mani�re distribu�e sur diff�rentes machines sans stockage distribu�.


## Spark sans YARN
C'est aussi possible comme �voqu� plusieurs fois pr�c�demment avec son utilisation en mode Standalone mais on rappelle que cela n'est pas assez solide pour de la production. Cela
nous servira principalement pour du d�veloppement ou du test.

# Quelles sont les differences entre Hadoop v1 et Hadoop v2?

La version 1 de Hadoop �tait uniquement compos�e de Hadoop Common, HDFS et MapReduce. La diff�rence majeure avec la version 2 de Hadoop est l'ajout du gestionnaire de ressources YARN d�crit 
pr�cedemment.
