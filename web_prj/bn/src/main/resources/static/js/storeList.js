window.onload = function () {
  // var products = [];
	
  axios
    .get("http://localhost:8888/api/storeList")
    .then(function (response) {
    	drawStoreList(response.data);
    })
    .catch(function (err) {
      console.log("실패", err);
    });
  function drawStoreList(mStores) {
    var stores = mStores;
    var productHtml = "";
    for (var i = 0; i < stores.length; i++) {
    	productHtml +=
    	"<tr>"+
    	'<td>'+
  	 	stores[i].classification+
  	 	"</td>"+
     	'<td><a href="/bn/foodList?storeId='+
     	stores[i].storeId+
    	'" >'+
     	 stores[i].storeName+
     	"</a></td>"+
     	'<td>'+
     	stores[i].storeId+
    	''+
     	 stores[i].storeNumber+
     	"</td>"+
     	'<td><a href="/bn/map'+
     	'" >'+
     	 stores[i].floor+
     	 "층"+
     	 stores[i].address+
     	 "</a></td>"+
     	 "</tr>";
    	
        
    }
    document.getElementById("store-list").innerHTML += productHtml;
  }
};
