# Feedback DM3

## Application

### Résidents

- On ne peut pas s'inscrire.
- Où est "Modifier ses préférences horaires"? "Faire le suivi d'une requête de travail"? Les notifications?
- On ne peut rien filtrer, on peut juste afficher toutes les entraves et les travaux.

### Intervenants

- On ne peut pas s'inscrire.
- Littéralement le seul truc qui marche c'est consulter les requêtes de travail, et on ne peut même pas y ajouter des candidatures.

### Spécifications

- La configuration minimale est moyennement respectée.
- Aucune donnée ne persiste.

## Code

- Pourquoi il y a 3 fichiers Main ? Pourquoi MainTwo est la classe qui lance l'application ? Pourquoi les classes `Utilisateur` etc sont dans ce même fichier ?
- La gestion des frames dans différentes classes est bien pensée mais il n'y a aucun controller car... il n'y a aucune logique.
- L'erreur `InputMismatchException` n'est pas gérée.

## Tests

AUCUN TEST

## Documentation 

- Aucune des données de départ n'est décrite donc je dois chercher moi-même dans le code où sont les utilisateurs initiaux.
- Aucun JavaDoc.

## Démonstration

Inexistante.