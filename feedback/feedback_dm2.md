# Feedback DM2

## Révision

- Le diagramme de CUs, les scénarios et l'analyse ont été bien mis à jour.
- Vous n'avez pas appliqué les corrections proposées dans le feedback du devoir 1 sur les diagrammes d'activités.   

## Architecture

- Aucun utilisateur direct (intervenant, admin) ne devrait pouvoir interagir directement avec le backend. 


## Diagramme de classe

- D'après la relation utilisée, la classe MaVille est composée de une ou plusieurs entraves, ce qui ne fait pas
particulièrement de sens, 
- On veut rendre le couplage le plus faible possible, donc faire une relation de composition entre l'intervenant et les travaux
n'est pas une bonne idée car ainsi les travaux dépendent fortement de l'intervenant. Une meilleure idée aurait été de les
stocker dans une base de données, et de faire une classe Database qui a les méthodes pour récupérer les listes de travaux/entraves/requêtes
en fonction de différents filtres, puis les classes ResidentConnecte et IntervenantConnecte ont juste à appeler ces méthodes pour 
ensuite faire afficher ces données dans le menu. 
- La méthode "S'inscrire" ne devrait pas se trouver dans ResidentConnecte et IntervenantConnecte si ces deux classes
servent également à faire les différentes actions dans le projet. Cela va à l'encontre du principe de responsabilité unique.
Cette méthode aurait dû plutôt être dans un controller comme AccountController (avec les méthodes pour se connecter, valider un utilisateur, etc).
- La notification ne doit pas contenir en elle-même la méthode pour s'envoyer à l'utilisateur. Cela est plutôt l'objectif des
controllers (ex: NotificationController).
- La relation de généralisation entre FiltresParInfo et ResidentConnecte/IntervenantConnecte ne devrait pas exister.

## Diagramme de séquence

- Dans "Soumettre une requête de travail", la classe Notification appelle la fonction envoyer() de ResidentConnecte
alors qu'elle ne s'y trouve pas.

## Justification des choix de design

- Il faut un peu mieux préciser de quelle manière l'usage d'un API REST minimise le couplage (séparation bien distincte de la logique
de récupération/traitement des données avec l'interface par exemple).
- La phrase justifiant la forte cohésion du design manque de clarté. Cependant, rassembler les fonctionnalités connexes dans des
composants spécifiques est effectivement ce qui favorise une forte cohésion. 

## Implémentation

- Je suis obligé de chercher manuellement dans le code pour connaître les identifiants préconçus.
- La soumission d'une requête de travail n'est pas arrêtée quand je mets une date au format invalide.
- Mettre une lettre au lieu d'un chiffre pour choisir le menu fait planter l'appli.
- L'implémentation est pas mal éloignée de la conception proposée.
- La classe MaVilleApplication fait absolument tout.

## Tests unitaires

- Ils sont où?

## Rapport et Git

Bien!