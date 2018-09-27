// javascript 69

function ActiveKanvas() {
    var ctx;
    var canvas;

    canvas = window.document.getElementById("kanVas");
    if(canvas.getContext) {
        ctx = canvas.getContext('2d');
        ctx.beginPath();
        ctx.moveTo(66,69);
        ctx.lineTo(50,50);
        ctx.lineTo(150,270);
        ctx.fill();
    }
}

function QueryLocation () {
    var query = document.querySelector("div");
    var queryAll = document.querySelector("div h1 span");
    queryAll.innerHTML=="mini"?queryAll.innerHTML="grande":queryAll.innerHTML="mini";
}