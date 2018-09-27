/* var msg = 'Message perso';
alert(msg);
alert(typeof(b)); */

/*
recuperation nom
var userName = prompt('Quel est votre nommmm ?');
alert(userName);

*/

// alert(aleaEntreBornes(10,20));

function Message2() {
	alert('Vous avez lance le javascript !');
}

function conversion()
{
   var somme = prompt("Entrez la valeur en Euros :");
   var resultat = somme * 6.55957;
   alert(somme + " E\n" + resultat + " Frs"); // \n pour retour à la ligne
}

function somme(a, b){
	var resultat= a+b;
	return resultat;
	alert('resultat');
}

function enumNombres(n) {
	for (var i = 1; i <= n; i++) {
		alert('Voici messire : ' + i);
	}
}

function goPage(i) {
	var a = window.confirm('Sur de vouloir aller page ' + i + ' ?');
	if (a) { // === true) {
		return window.confirm("go page " + i + ' !');	
	} else {
		return window.confirm("NO GO page " + i + ' !');;
	}
}

function aleaEntreBornes(a, b) {
	var rnd = Math.random();
	rnd = Math.floor(rnd*b)+a;
	return Math.floor(rnd*b)+a;
}


// gestion du canvas de la page 42
function draw () {
	var canvas = document.getElementById("monPremierCanvas"); // id du canvas
	var ctx;
	// RECUP CONTEXTE
	if(canvas.getContext) {
		console.log('canvas supporté !');
		ctx = canvas.getContext('2d');

		// FILLSTYLE -> faire des rectangles 
		ctx.fillStyle = 'rgb(000,100,20)';
		ctx.fillRect(10,10,50,60);

		ctx.fillStyle = 'rgba(0, 0, 200, 0.5)';
		ctx.fillRect(30, 30, 50, 50);
		
		// effacement d'un rectangle :
		ctx.clearRect(30,40,20,20);

		// DEUXIEME RECTANGLE
		ctx.fillRect(80,80,60,60);
		ctx.clearRect(90,90,20,20);
		ctx.strokeRect(100,100,5,5);
	} else {
		// code non supporté -> ici
		console.log('canvas non supporté !');
	}
}

// appellee au load de la page
function drawDeuxiemeCanvas () {
	var canvas = document.getElementById("deuxiemeCanvas");
	var ctx;

	if(canvas.getContext) {
		ctx = canvas.getContext('2d');
		console.log('contexte deuxieme canvas OK');
		// dessin du canvas
		ctx.beginPath();
		ctx.moveTo(10,10);
		ctx.lineTo(24,45);
		ctx.lineTo(10,15);
		ctx.lineTo(100,45);

		ctx.moveTo(45,90);
		ctx.lineTo(100,100);
		ctx.arcTo(10,100,20,20, Math.PI);
		ctx.fill();
	} else {
		console.log('marche pas le deuxieme canvas ... ');
	}
}

function exitDeuxiemeCanvas () {
	var canvas = window.document.getElementById("deuxiemeCanvas");
	var ctx;

	if(canvas.getContext) {
		ctx = canvas.getContext('2d');
		ctx.beginPath();
		ctx.clearRect(0,0,150,150);
		ctx.fill;

	} else {
		console.log('marche pas le deuxieme canvas ... ');
	}
}

// IIFE = Immediately Invoked Function Expression
(function() {
	var text = 'un texte';
}) ();

alert(text); // marche pas car var text (sans le var, ça marche)