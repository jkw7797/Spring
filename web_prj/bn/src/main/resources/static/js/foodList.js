window.onload = function () {
	var sch = location.search;
	var params = new URLSearchParams(sch);
	var id = params.get('storeId');
	
  axios
    .get("http://localhost:8888/api/foodList/" + id)
    .then(function (response) {
    	drawStoreList(response.data);
    	drawMenuList(response.data);
    })
    .catch(function (err) {
      console.log("실패", err);
    });
  function drawStoreList(mStores) {
	    var stores = mStores;
	    var productHtml = "";
	    for (var i = 0; i <1; i++) {
	    	productHtml +=
	    	"<tr>"+
	    	'<td>'+
	    	stores[i].storeName+
	  	 	"</td>"+
	     	'<td>'+
	     	stores[i].storeNumber +
	     	"</td>"+
	     	'<td>'+
	     	 stores[i].classification+
	     	"</td>"+
	     	'<td>'+
	     	 stores[i].homepage+
	     	"</td>"+
	     	'<td>'+
	     	 stores[i].floor+
	     	 "층"+
	     	 stores[i].address+
	     	 "</td>"+
	     	'<td>'+
	     	 stores[i].openingHour+
	     	 "~"+
	     	 stores[i].closingHour+
	     	 "</td>"+
	     	 '<td>'+
	     	 stores[i].closedDay+
		     	"</td>"+
	     	'<td>'+
	     	 stores[i].delivery+
	     	"</td>"
	     	 "</tr>";
	    }
	    document.getElementById("store-list").innerHTML = productHtml;
	    }
  function drawMenuList(mMenu) {
	    var menu = mMenu;
	    var menuHtml = "";
	    for (var i = 0; i < menu.length; i++) {
	    	menuHtml+=
	    		"<ul>"+menu[i].foodName +" "+menu[i].foodPrice +'</ul>';
	    }
	    document.getElementById("menuList").innerHTML = menuHtml;
	  }
};
