// __________________________________________________________________________


// PARTIE I - RECUPERATION DES DONNEES
// creation d'un tabl vide
var tabl = [];
var prenom;

do {
	prenom = prompt('Choix prenom stp');
    // condition en ternaire
	(isNaN(prenom)?tabl.push(prenom):'');

} while (confirm('On continue ?'));

// PARTIE II - AFFICHAGE

var size = tabl.length; // alert('Size : ' + size);
if(size!=0) {
	// pourcours du tableau et affichage des données
	var count = 0;
	for (var p in tabl) {
		alert('Prenom n°' + parseInt(count+1) + ': ' + tabl[count]);
		count++;
	}
} else {
	alert('Impossible d\'afficher le contenu du tableau');
}