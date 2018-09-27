'use strict';

function Message2() {
	alert('Vous avez lance le javascript !');
}

function miseEnFormeTitres(titre, bool, msg) {
	// on met en forme le titre selon bool (t/f) et le message
	// bool permet de choisir une couleur
	if (bool) {
		var elements = window.document.getElementsByTagName(titre);
		for(var i=0; i<elements.length;++i) {
			if(msg===undefined) {
				elements[i].innerHTML =  '___ La force du javascript ___';
				elements[i].style.color = "#7386E5";
				// elements[i].style.fontWeight = "bold";
				// elements[i].style.text-decoration="underline";
			} else {
				elements[i].innerHTML =  msg;
				elements[i].style.color = "#7386E5";
				// elements[i].style.fontWeight="bold";
				// elements[i].style.text-decoration="underline";
			}
		}
	} else {
		var elements = window.document.getElementsByTagName(titre);
		for(var i=0; i<elements.length;++i) {
			if(msg===undefined) {
				elements[i].innerHTML =  '___ La force du javascript ___';
				elements[i].style.color = "#4AD5D5";
				// elements[i].style.fontWeight="bold";
				// elements[i].style.text-decoration="underline";
			} else {
				elements[i].innerHTML =  msg;
				elements[i].style.color = "#4AD5D5";
				// elements[i].style.fontWeight="bold";
				// elements[i].style.text-decoration="underline";
			}
		}
	}
}

// param : id -> permet de recuperer les classes dans un teableau
function getClassById (id) {
	// recuperer la classe
	var nomClass = document.getElementById(id).className;
	console.log('nomClass -> ' + nomClass);
	var classes = nomClass.split(' ');
	var classTab = [];
	var StringResult='';

	for(var i = 0; i<classes.length; i++) {
		classTab.push(classes[i]);
		StringResult += ('|' + classes[i]); 
	}

	return classTab;
	// alert(StringResult);
}

// fonction qui marche très bien
getClassById('idH1');
getParentById('idH1');

function getParentById(id) {
	var element = document.getElementById(id);
	var tablRetour = [];

	// on ajoute le noeud parent
	tablRetour.push(element.parentNode); // [0]
	tablRetour.push(element.nodeType); // [1]
	tablRetour.push(element.nodeName.toUpperCase()); // [2]

	return tablRetour;
}

// on peut iterroger les resultats du coup avec indice
/* alert(getParentById('idH1')[0]); // nom parent
alert(getParentById('idH1')[1]); // type
alert(getParentById('idH1')[2]); // nom
*/

function ChangeTitres3(titre) {
	// recup dans titreFormation de la valeur du descriptif (présentation)
	var titreFormation = document.getElementById(titre).innerText;
	// alert('Titre 222222222 : ' + titreFormation);
	if(tireFormation.toLowerCase=="Aldous, informaticien en devenir !".toLowerCase) {
		// cas de l'amour
		alert('Titre : ' + titreFormation);
		document.getElementById(titre).innerText = "Aldous, un EXPERT de l'amour !";
	} else if (tireFormation.toLowerCase=="Aldous, un EXPERT de l'amour !") {
		alert('attention : ' + tireFormation.toLowerCase);
		document.getElementById(titre).innerText= "Aldous, informaticien en devenir !"
	}
}

function ChangeTitres2(titre) {
	// alert("MOUAI debut quoi");
	switch (titre.toUpperCase()) {
		case ("Aldous, informaticien en devenir !").toUpperCase():
			// alert("JE VUEX ETRE ICI");
			document.getElementById(titre).innerText = "Aldous, un EXPERT de l'amour !";
		case ("Aldous, un EXPERT de l'amour !").toUpperCase():
		// alert('break dance');
			document.getElementById(titre).innerText = ("Aldous, informaticien en devenir !");
	}
}
function ChangeTitres4(titre) {
	switch (titre.toUpperCase()) {
		case ("Aldous, informaticien en devenir !").toUpperCase():
			document.getElementById(titre).innerText = "Aldous, un EXPERT de l'amour !";
			alert('mES COUILLES');
			return;
		case ("Aldous, un EXPERT de l'amour !").toUpperCase():
			document.getElementById(titre).innerText = ("Aldous, informaticien en devenir !");
	}
}

function ChangeTitres(titre) {
	// textPresAldous
	// alert("MOUAI debut quoi");
	switch (document.getElementById(titre).textContent.toUpperCase()) {
		case ("Aldous, informaticien en devenir !").toUpperCase():
			document.getElementById(titre).textContent = "Aldous, une MERDE de l'amour !";
			return; // verifier si c'est utile
		case ("Aldous, une MERDE de l'amour !").toUpperCase():
			document.getElementById(titre).textContent = ("Aldous, informaticien en devenir !");
	}
}

function IEouAutreNavigateur() {
	// fonction qui permet de vérifier le navigateur de l'utilisateur
	// var div = document.getElementById('idH1');
	var div = document.getElementsByTagName('div')[0];

	if(div.textContent) {
		return "Autre que IE Explorer, Opera, Mozilla, Chrome ...";
	} else if (div.innerText) {
		return "IE Explorer";
	} else {
		return "impossible a determiner";
	}
}

// alert(IEouAutreNavigateur());






function FirstAndLastChild(element) {
	var fChild = element.firstChild;
	var lChild = element.lastChild;
	var pNode = element.parentNode;
	var nodeNameElmt = element.nodeName.toLowerCase();
	var nodeTypeElmt = element.nodeType;

	return "firstChild : " + fChild.nodeName + '\n' + 
			"lastChild : " + lChild.nodeName + '\n\n' +
			"Parent node : " + pNode + '\n' + 
			"Node NAME element : " + nodeNameElmt + '\n' +
			"Node TYPE element : " + nodeTypeElmt + '\n\n' +
			"Contenu : " + element.innerText + '\n\n' +
			"Contenu : " + element.innerHTML;
}

function testFirstAndLastChild() {
	// var elmt = document.getElementsByTagName('h1')[0]; var elmt = document.getElementById('idH1');
	var elmt  = document.getElementsByClassName('noList')[0];
	console.log('val de elmt : ' + elmt + '\n' +
		'contenu de elmt : ' + elmt.innerHTML);
	console.log(FirstAndLastChild(elmt));
}

// appel de la fonction de test
// testFirstAndLastChild();