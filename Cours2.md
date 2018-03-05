# HDP Cours 2

### Pourquoi on a inventé HDFS alors qu’on avait déjà des systèmes de fichiers distribués ?
- Abstraction du stockage pour faciliter la manipulation des fichiers
- Fiabilité, résilience, disponibilité
- Expose une interface pour optimiser le processing
- Scalabilité

### HBase vs HDFS
- HBase plus performant que HDFS en accès Random.
- HDFS ouvre juste une socket pour lire le fichier

### HDFS : Filesystem distribué

- Parallélisé : Ce même job va avoir un état partagé (exemple massive processing)
- Distribué : Aucun mapper n’est conscient de l’existence de l’autre, notion d’indépendance

### Exemple : Comment calculer la moyenne totale avec des élèves, des notes, des matières
- Merge and Sort

### Système distribué :
- Exemple de Cassandra => Les nœuds font stockage et routage

### Dans ce cas là, comment retrouver sa donnée ?
- Par exemple fonction de hashing mais si un nœud particulier tombe comment faire ?
- Exemple du consistent hashing 
