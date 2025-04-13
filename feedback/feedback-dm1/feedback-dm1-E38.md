# Feedback DM1

Disclaimer : Tout ce qui est mentionné dans le feedback sont les points et les détails à améliorer. Si des aspects du devoir n'ont pas été critiqués, c'est qu'ils sont déjà bons.

## Glossaire

- Il faut toujours prioriser les termes les plus importants en faisant un glossaire, quitte à mettre plus de 10 mots. Il manque la définition de l'application MaVille elle-même, code de la ville et planification participative en l'occurence.
- La définition de "S'inscrire n'est pas très claire. On s'inscrit pour se connecter ou se faire un compte?

## Diagramme de CUs

- Il manque le CU pour se connecter en tant qu'intervenant ou résident.
- Certains CUs ne sont pas pertinents ou répétitifs, comme "Consulter les travaux" qui est répété dans vos deux diagrammes, "Suggérer des améliorations dans la ville" ou "consulter les délais estimés".
- Pourquoi est-ce que la ville proposerait un plan de projet? Elle ne devrait pas intervenir sur ça dans l'application, c'est uniquement à l'intervenant de soumettre son projet dans l'application. Le plan serait fait en externe donc ne concerne pas MaVille.
- Pourquoi est-ce qu'un intervenant pourrait modifier une requête de travaux soumise par un résident? Il peut modifier 
- Concrètement, seul le résident devrait pouvoir annuler la requête de travail car c'est lui qui l'a créé. Il peut l'annuler tant qu'un intervenant ne l'a pas déjà commencé. Pour qu'un intervenant puisse "annuler" une requête de travail, ce ne serait que si l'intervenant rencontre des problèmes dans le projet qu'il a prévu pour satisfaire la requête, alors il annulerait le projet tout court et le résident recevra une notification de changement sur l'état de sa requête.
- Un acteur secondaire est censé uniquement participer à un cas d'utilisation initié par un des acteurs principaux, il ne doit pas pouvoir en gérer un par lui-même.

## Scénarios

- Modifier une requête de travail n'est pas un CU valide, sinon elle aurait été correcte.
- Il n'y a pas de section "Réclamations" dans l'application. Si le résident a une plainte, il le fera en signalant un problème.
- Il n'y a pas de système de "vote" pour prioriser des travaux, cela n'a pas été mentionné dans les exigences. L'approche la plus similaire serait la planification participative proposée.
- "Le résident a accès à l’historique des travaux terminés" n'est pas une postcondition lorsqu'on consulte l'historique des travaux car c'est justement ce qu'il fait au sein du scénario.
- Le système ne devrait pas avoir de CU en tant qu'acteur principal. L'envoi de notification aux résidents concernés devrait être une postcondition dans le CU où un intervenant crée un nouveau projet. De plus, le CU "Notifier les résidents d'un nouveau projet" n'a pas été mentionné dans le diagramme de CUs. Pareil pour "Recevoir des notifications sur les travaux.
- "Le résident a accès aux informations des travaux" n'est pas une postcondition.

## Diagramme d'activités

- Le diagramme "principal" d'ouverture de l'application devrait avoir un noeud de fusion et un noeud de fin d'activité après les 6 sous-activités.
- Le flot pour personnaliser ses notifications est mal compris : Le résident devrait commencer par chercher une rue ou un quartier, puis voir les projets sur la rue ou le quartier donné, puis sélectionner les projets sur lesquels il veut recevoir des notifications, ou directement être notifié pour tous les projets de la rue ou le quartier choisi. 
- Le diagramme d'activité pour signaler un problème est trop simple. Vous dites vous-mêmes dans le scénario de ce CU qu'il y a un scénario alternatif où le résident ne complète pas les champs obligatoires, il faut aussi le montrer dans le flot du diagramme.

## Analyse

### Risques

- "Problèmes de sécurité" n'est pas un titre suffisamment représentatif du risque dont vous parlez dans la justification.

### Besoins non-fonctionnels

- La personnalisation n'est pas un besoin non fonctionnel suffisamment pertinent. L'accessibilité par exemple aurait été un meilleur choix.

### Besoins matériels

- Il faudrait mentionner ce dont l'utilisateur a besoin pour lancer l'application. En l'occurence, un ordinateur avec Java.

### Solution de stockage

- Quid de la sécurité de la base de données et du stockage des fichiers?

### Solution d'intégration

Bien!

## Prototype

- Il manque le fichier .jar
- Il n'y a pas de menu distinct pour l'intervenant
- Pas de gestion robuste d'erreur quand l'utilisateur ne met pas un chiffre pour le choix du menu

## Git 

Bien!

## Rapport

Bien!
