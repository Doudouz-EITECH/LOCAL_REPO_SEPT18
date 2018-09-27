/*alert('aux gogoles !');


var int1 = 10, int2 = 2, somme;
somme = int1 + '' + int2;
alert(somme);

if(confirm('T\'es pas un babtout fragile ?') == true) {
	// nothing
} else {
	alert('GOGOL sort de ce Kaaris');
}


var numTiroir = prompt('Choix du tiroir ?  --- nb : de 1 à 4');
alert('Vous avez entré une variable de type ' + typeof(numTiroir));
numTiroir = parseInt(numTiroir);
alert('Vous avez entré une variable de type ' + typeof(numTiroir));


var age = parseInt(prompt('Quel est votre age ?'));

switch(age) {
case (0):
	alert('cas impossible');
	break;
case(18):
	alert('Vous avez la majorité');
	break;
default:
	alert('impossible n\'est pas français');
	break;
}
*/

// var message = confirm('Etes vous blèche ?')? alert('UN BLECHE'):alert('Un pas blèche ...');

// confirm('Etes vous majeur ?')?alert('vous rentrez donc dans le site'):alert('degage');

// alert("message");
/*
var adult = parseInt(prompt('quel est votre age ?'));
// alert('Vous avez rentré : ' + adult + ', ce qui est de type ' + typeof(adult));

switch (true) {
	case (adult < 10):
		alert('très petit bébé');
		break;
	case (adult === 18):
		alert('Hummmm on en mangerait : tout juste à point sur les i !');
		// no break pour avoir la derniere phrase
	case (adult > 18):
		alert('Et c\' est bon d\'être dans la fleur de l\'âge, non ? !');
		break;
	default:
		alert('Rien à dire de spécial.');
		break;
}

*/

// alert('Date : ' + Date());
/*
// 15:00 début exercice
var age = parseInt(prompt('Age du plaignant ?'));
switch (true) {
	case (age < 1):
		alert("Alerte aux mongogoles...");
		break;
	case (age <= 17):
	alert('Vous n\'êtes pas encore majeur et vaccinée !');
		break;
	case (age <= 49):
		alert('Majeur, pas encore senior ');
		break;
	case (age <= 59):
	alert('Vous = senior, pas sénil !');
		break;
	case (age <= 120):
		alert('Téma l\'yeuv !');
		break;
	default:
		alert('erratum possum ergo est : ' + age);
		break;
}

if(age == 'NaN') {
	alert('Bien mon pote ' + age);
}


age=='NaN'?alert("Pas nombre ; " + age):alert('nombre ! ' + age);



var n1 = 0, n2 = n1++;
alert('n1 : ' + n1);;
alert('n2 : ' + n2);



// EXERCICE frères et soeurs
var proceed = true, chaineNoms = '';
var nouvNom;
while(proceed) {
	nouvNom = prompt('Choix prenom ?');
	if(nouvNom) { 
		chaineNoms+= nouvNom + ' ';
	} else {
		proceed =false;
}
}

alert(chaineNoms);
*/
/*
var nom = ' ',nouvNom, i = 0
for(;;++i) {
	nouvNom = prompt("choix d'un nom ?");
	if (nouvNom) {
		nom += nouvNom;
	} else {
		break;
	}	
}
alert('VOICI : \n ' + nom + '\n' + i);
*/

/*
var input = output = 0;
alert('input (0 ?): ' + input);
input++;
alert('input (1 ?) : ' + input);
++output;
alert('output (1 ?) : ' + output);
output = input++;

alert('input : ' + input);
alert('output : ' + output);
*/

/*
function sayHello(param) {
	return alert(param + ' toi !');
}
*/

// sayHello(prompt('Que voulez-vous toier ?'));
/*
var param2 = function () {
	// code de ma fonction anonyme
	alert('Voici une fonction anonyme');
	var condition=false;
	do {
		condition = confirm('Avez-vous bien compris ?');
	} while (condition === false);
}

param2();
*/

/* function FonctionAnonyme () {
	alert('vous avez appelé la fonction anonyme !');
}

// FonctionAnonyme();

(function FonctionAnonyme2 () {
	alert('222 -> vous avez appelé la fonction anonyme !');
}) ();
*/

// on va creer une variable et lui assigner une fonction anonyme
// et retourner une valeur

// ca marche, ça !
// mais ça c'est mieux non ?
/*
var maVar = (function () {
	var valeur = 'une valeur lambda';
	return valeur;
}) ();

alert('maVar vaut : ' + maVar);
*/
var maString = 'chaine de caraCTeres ! Élise';
var monTabl = [1, 'chaine', '2', 'element 4', 'Element d\'indice 4'];
// alert(maString.toLocaleUpperCase());
// alert(parseInt(maString.length) + ' caractères');
/*
var i = 0;
do {
	var cond = confirm('Vous voyez bien l\'élément ind ' + i + '\n Il vaut ' + monTabl[i]);
	i++;
} while (cond!=false);
*/

// on va se troupler un p'tit tableau, et jouer sur push(), pop()
// shift(), unshift()

// cette fonction donne l'indice et la valeur adéquate en parcourant
// le tableau
function enumTabl(arr) {
	var size = arr.length;
	for (var count = 0; count<size; count++) {
		alert('Array[' + count + '] : ' + arr[count]);
	};
}

// declaration d'un tableau
var tableau2test = ['couleur', 'fleur', 'amour', 'SCC', 2, 4, 5, 6, 'fin'];

// fonction qui renvoie indice + val des extremites du tableau
function extremitesTabl(arr) {
	var size = arr.length;console.log('taille tabl : ' + size);
	alert('arr[0] : ' + arr[0]);
	alert('arr[' + (size-parseInt(1)) + '] : ' + arr[size-parseInt(1)]);
	// return arr[0];
}
/*
extremitesTabl(tableau2test);

// modification tableau puis test
tableau2test.shift('SHIFT');
extremitesTabl(tableau2test);

tableau2test.push('p\'tit push');
extremitesTabl(tableau2test);

tableau2test.unshift('une SHIFT');
extremitesTabl(tableau2test);

tableau2test.pop('POP');
extremitesTabl(tableau2test);
*/

var tableauDeNoms =
'Alice Léa Lou-Mahaut Camille Pauline Mathilde Maylis Lnk Jojo Laura Mélissa Lola Christie Sandra Sophie ClaireColline Marion Aida meufSpanish Samyy Heloïse Malvina Marie Julie';
tableauDeNoms = tableauDeNoms.split(' ');

// alert('Taille du tableau : ' + tableauDeNoms.length);
// enumTabl(tableauDeNoms);
/*
var cousinsString = 'Pauline Guillaume Clarisse',
    cousinsArray = cousinsString.split(' ');

alert(cousinsString);
alert(cousinsArray);
enumTabl(cousinsArray); */
/*
alert(tableauDeNoms[tableauDeNoms.length-1]); // fonctionne

var plusGrandIndice = (function(tab) {
	// IFE
	// alert('Dans la fonction anonyme'); // ok
	var lastValTabl = tab[tab.length-1];
	console.log('valeur de lastValTabl : ' + lastValTabl);
	alert('lastValTabl : ' + lastValTabl);
	return lastValTabl;
	// TI-TIMMY !!
}) (tableauDeNoms);

// tableauDeNoms[tableauDeNoms.length-1] ramène la bonne val
// mais j'arrive pas à afficher avec le alerte ci dessous
// la valeur retournée par la IFE
alert((plusGrandIndice));

*/

// une fonction qui détermine l'aire en fnction de l et L

var aire = (function(l, L) {
	if (l >=0 && L >= 0) {
		return l*L;
	} else {
		return false;
	}
}) (40, 55);

// alert(aire);

// ENUM en JS
var familyOffice = {
	Navas: 'petitCon',
	Alexis: 'grosCon',
	Aurèle: 'GaelPoto',
	Hendrick: 'capitaineAuMat'
};

var bool = true;

function Parcourir () {
	for(var variable in familyOffice) {
		// boucle sur les objets de la collection (de l\'enum)
		if (bool === true) {
			alert('familyOffice ' + variable);bool = false;
		} else {
			confirm('familyOffice ' + variable); bool = true;
		}
	}
}

//Parcourir();

function getCoords() {
	return {x : 12, y : 21};
}

var ABC = getCoords();
// alert('x : ' + ABC.x);




// __________________________________________________________________________
/*
// creation tableau vide
var tablPrenom = [];
// 
var conf = confirm('ajouter ce prenom : ');
do {
	var prenom = prompt('Choix prenom ?')
	//if (prenom!=null) {
		tablPrenom.push(prenom);
		alert(tablPrenom[length]);
	//} else {
} while (prenom!=null)

var size = tablPrenom.lenght;alert('Size : ' + size);
if(size!=0) {
	// pourcours du tableau et affichage des données
	var count = 0;
	for (var p in tablPrenom) {
		alert('Prenom : ' + p[count]);
		count++;
	}
} else {
	alert('Impossible d\'afficher le contenu du tableau');
}

*/

// __________________________________________________________________________


// PARTIE I - RECUPERATION DES DONNEES
// creation d'un tabl vide
var tabl = [];
var prenom;
/* 
do {
	prenom = prompt('Choix prenom stp');
	// alert('TYPEOFPRENOM : ' + typeof(prenom));
	
	if (typeof(prenom)!= null) {
		tabl.push(prenom);
	}

	// condition en ternaire
	(isNaN(prenom)?tabl.push(prenom):'');

} while (confirm('On continue ?'));
*/
// PARTIE II - AFFICHAGE
/*
var size = tabl.length; // alert('Size : ' + size);
if(size!=0) {
	// pourcours du tableau et affichage des données
	var count = 0;
	for (var p in tabl) {
		alert('Prenom : ' + tabl[count]);
		count++;
	}
} else {
	alert('Impossible d\'afficher le contenu du tableau');
}
*/


/*
var prenoms = [];
var nouvPrenom;

while (nouvPrenom = prompt('choix d\'un prenom ?')) {
	prenoms.push(nouvPrenom);
}

(prenoms.length != 0?alert(prenoms.join('-')):alert('aucun mot !'));

*/




// __________________TP_CHIFFRES_ET_LETTRES____________________

// PART 1 - DEMANDE D'UN NOMBRE 0 à 999
var n;
var nRandom = Math.round(Math.random()*1000);
var bo;
// choix d'un nombre entre 0 et 999
function choixNombre () {
	do {
		do {
			n = parseInt(prompt('Choix nombre entre 0 et 999 inclu', nRandom), 10);
			// isNaN pour verifier que pas string	
		} while (n < 0 || n > 999 || isNaN(n));
	// boucle si non confirmation
	} while (!confirm('Vous avez choisis : ' + n));

	return n;
}

// PART 2 - DECOUPE DU NOMBRE
function DecoupeNombre(n) {
	var reste = n % 100;
	return reste;	
}


// PROGRAMME FINAL:
var m = choixNombre();
var r = DecoupeNombre(m);
alert('reste ? : ' + r);
// alert('type m ? : ' +typeof(m));
// alert(m + ' a pour type : ' + typeof(m));