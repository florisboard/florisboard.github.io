+++
title = "Politique de confidentialité"
[extra]
go_to_top = false
+++
_Dernière modification : 25 août 2022_

FlorisBoard (le « Projet ») est un clavier open-source et respectueux de la vie privée, développé et maintenu principalement par Patrick Goldinger ([@patrickgold](https://github.com/patrickgold)) et Lars Mühlbauer ([@lm41](https://github.com/lm41)), avec le support formidable de la communité du Projet.
Cette politique de confidentialité existe pour vous donner une meilleure compréhension des données personnelles minimum qui doivent être lues et/ou stockées localement pour vous fournir un clavier fonctionnel.

## Accès aux données et utilisation

L’engagement principal du Projet est d’accéder et de stocker le moins de données personnelles possible, tout en délivrant une bonne expérience personnalisée.
Toute donnée personnelle qui est lue ou stockée est gardée exclusivement sur votre appareil, soit en mémoire, soit dans le dossier privé des données d’application. Elle n’est **jamais** partagée avec personne.

### À quelle donnée personnelle Florisboard accède-t-il et pourquoi ?

Dès que vous sélectionnez un champ texte et que FlorisBoard est le clavier par défaut ("IME", _input method editor_), FlorisBoard a accès à tout le contenu de ce champ de texte.
Il suit et stocke en mémoire un petit ensemble autour du curseur, pour garder la trace de l’état actuel et pour améliorer les performances.
De plus, en tant que clavier par défaut (_default IME_), FlorisBoard a accès au presse-papiers du système, et garde activement une trace de la dernière entrée du presse-papiers pour vous fournir les fonctionnalités de presse-papiers.
En outre, FlorisBoard a accès au dictionnaire utilisateur du système, pour lire son contenu si la vérification d’orthographe, les suggestions ou le « glisser pour taper » sont activés.

Sauf si l’inverse est précisé dans la section suivante, toute donnée personnelle accédée est seulement stockée en mémoire, et sera détruite quand vous désélectionnerez le champ texte ou quand le processus du clavier terminera.

### Quelle donnée personnelle Florisboard stocke-t-il et pourquoi ?

Certaines fonctionnalités nécessitent que des données personnelles soient stockées localement sur le disque pour être réutilisées plus tard.
Cela s’applique à :

- **Correction d’orthographe, suggestions et « glisser pour taper »**
  Pour être capable de créer automatiquement des dictionnaires personnalisés, et de proposer dynamiquement des suggestions basées sur vos saisies précédentes, FlorisBoard a besoin d’accéder à vos habitudes de saisie, afin de les apprendre et de les sauvegarder localement.
  Le suivi d’habitude de saisie est complètement désactivé si le clavier est en mode _incognito_ ou si les fonctionnalités nécessitant cette option sont désactivées.
- **Historique de presse-papiers**
  Pour être capable de stocker et d’afficher plusieurs entrées du presse-papiers, FlorisBoard stocke ces entrées dans une base de données locale.
  Cette base de données n’est maintenue et utilisée que si la fonctionnalité d’historique du presse-papiers est activée.

### Est-ce que des données personnelles quittent l’appareil ?

Non. Toutes les données personnelles stockées le sont localement, et ne quittent **jamais** votre appareil.

## Autre

Pour plus d’information à propos des permissions requises par FlorisBoard, merci de lire [ce document (en anglais)](https://github.com/florisboard/florisboard/wiki/List-of-permissions-FlorisBoard-requests).

### Mise à jour de cette politique de confidentialité

Nous nous réservons le droit de revoir et mettre à jour périodiquement cette politique.
Les changements de cette politique seront annoncés publiquement et le lien sera donné dans le journal des modifications de la version correspondante.
La poursuite de l’utilisation de FlorisBoard sera considérée comme le consentement à ces changements.

### Contact

Si vous avez des questions supplémentaires, des commentaires ou des préoccupations à propos de cette politique de confidentialité, merci de contacter [patrick@patrickgold.dev](mailto:patrick@patrickgold.dev) (en anglais) ou de remplir une _issue_ dans le [logiciel de suivi de problèmes](https://github.com/florisboard/florisboard/issues) de FlorisBoard.

