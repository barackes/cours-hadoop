# HDP Cours 2

### Pourquoi on a invent� HDFS alors qu�on avait d�j� des syst�mes de fichiers distribu�s ?
- Abstraction du stockage pour faciliter la manipulation des fichiers
- Fiabilit�, r�silience, disponibilit�
- Expose une interface pour optimiser le processing
- Scalabilit�

### HBase vs HDFS
- HBase plus performant que HDFS en acc�s Random.
- HDFS ouvre juste une socket pour lire le fichier

### HDFS : Filesystem distribu�

- Parall�lis� : Ce m�me job va avoir un �tat partag� (exemple massive processing)
- Distribu� : Aucun mapper n�est conscient de l�existence de l�autre, notion d�ind�pendance

### Exemple : Comment calculer la moyenne totale avec des �l�ves, des notes, des mati�res
- Merge and Sort

### Syst�me distribu� :
- Exemple de Cassandra => Les n�uds font stockage et routage

### Dans ce cas l�, comment retrouver sa donn�e ?
- Par exemple fonction de hashing mais si un n�ud particulier tombe comment faire ?
- Exemple du consistent hashing 
