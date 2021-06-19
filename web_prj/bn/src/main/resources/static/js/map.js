var maps = "";
window.onload = function () {
  axios
    .get("http://localhost:8888/api/mapList")
    .then(function (response) {
    	maps=response.data;
    	console.log("성공");
    })
    .catch(function (err) {
      console.log("실패", err);
    });
};

function getMapImg(s) {
  var mapload = "";
  var httptext = "";
  switch (s) {
    case 1:
    	mapload = maps[0];
      break;
    case 2:
    	mapload = maps[1];
      break;
    case 3:
    	mapload = maps[2];
      break;
    default:
      break;
  }

  document.getElementById("mapimg").innerHTML = "<h2>"+ s +"층<h2>"+"<img src=" + mapload + ">";
}
