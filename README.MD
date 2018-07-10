Bienvenue dans le Projet 3 réalisé par Julien - Parcours DA JAVA

Afin de récupérer le code du projet, il vous suffit de télécharger le repository https://github.com/mercure84/MasterMindOO en cliquant sur "clone or download" depuis le profil GitHub mercure84.

Je vous conseille de télécharger l'ensemble au format ZIP (download Zip) et de décompresser ensuite le dossier sur votre machine.

Ouvrez votre IDE Java (Eclipse par exemple) et importez le projet Mastermind.
Positionnez-vous sur la class Menu qui contient la méthode main (point d'entrée du programme) : vous pouvez désormais lancer l'application et vous amuser avec 2 jeux et 3 modes !

Les jeux sont basés sur la réflexion et le but est de trouver une combinaison cachée :


- Combinaison Secrète : il s'agit d'une combinaison de chiffres entre 0 et 9 ; le nombre de chiffres est paramétré via le fichier config.properties. Les indices sont +/- sur chaque chiffre proposé.
- MasterMind : la combinaison est composée de X boules de Y couleurs. Le nombre de boules et de couleurs sont paramétrés dans le fichier config.properties.

Les modes de jeu :
- Challenger : vous jouez contre l'ordinateur et tentez de deviner le code ou la combinaison.
- Défenseur : l'ordinateur tente de deviner le code ou la combinaison que vous gardez secret
- Duel : Vous cherchez la combinaison de l'IA et l'IA cherche votre combinaison ; chacun son tour ! Le premier qui a trouvé la combinaison de l'autre a gagné.



BONUS : 

Le mode MasterMindUltra permet de tester la résolution du MasterMind par l'IA.
L'IA va deviner la combinaison secrète en exploitant l'algorithme de Knuth sur le nombre de parties demandées. Noter que pour chaque partie une combinaison aléatoire sera générée automatiquement; le but de ce mode est de demander à l'IA de réaliser un grand nombre de parties de MasterMind et d'en constater les performances (rapidité / nombres d'essais).