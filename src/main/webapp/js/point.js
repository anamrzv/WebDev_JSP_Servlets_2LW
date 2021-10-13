let x, yCoord;
let r = 0;
const svgSize = 300;
document.getElementById("graph_pic").addEventListener("click", checkPoint);
let graph = document.getElementById("graph_pic");

function checkPoint(event) {
    if (document.getElementById("cb1").checked) r = 1;
    else if (document.getElementById("cb2").checked) r = 2;
    else if (document.getElementById("cb3").checked) r = 3;
    else if (document.getElementById("cb4").checked) r = 4;
    else if (document.getElementById("cb5").checked) r = 5;
    if (r !== 0) {
        const domRect = graph.getBoundingClientRect();
        const rowX = event.pageX - domRect.x;
        const rowY = event.pageY - domRect.y;
        x = ((r * (svgSize / 2 - rowX) * -1) / 100).toFixed(2);
        yCoord = ((r * (svgSize / 2 - rowY)) / 100).toFixed(2);
        sendRequest(x, yCoord, r);
    } else {
        alert('Выберите радиус R');
    }
}

function sendRequest(x, y, r) {
    $.ajax({
        type: 'POST',
        url: 'main',
        data: {
            'x': x,
            'y': y,
            'r': r
        },
        success: function () {
            window.location.href = 'result_page.jsp';
        }
    });
}