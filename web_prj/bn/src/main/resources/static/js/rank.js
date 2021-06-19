window.onload = function () {
	
  axios
    .get("http://localhost:8888/api/rankList")
    .then(function (response) {
    	drawRankList(response.data);
    	console.log("성공");
    })
    .catch(function (err) {
      console.log("실패", err);
    });
  
  function drawRankList(mRank) {
	    var ranks = mRank;
	    var rankHtml = "";
	    rankHtml += '<div class="rankstyle">'+
        '<a href="/bn/foodList?storeId='+ranks[0].storeId+'" >'+ '<img src="/img/first.png" width="200" height="200">' + "</a>" +
        '<a href="/bn/foodList?storeId='+ranks[0].storeId+'" >' + ranks[0].storeName +"</a>" +
       '</div>';
	    rankHtml += '<div class="rankstyle1">'+ 
        '<a href="/bn/foodList?storeId='+ranks[1].storeId+'" >'+ '<img src="/img/22.png" width="170" height="170" >' + "</a>" +
        '<a href="/bn/foodList?storeId='+ranks[1].storeId+'" >' + ranks[1].storeName +"</a>" +
        '</div>';
	    rankHtml += '<div class="rankstyle1">'+ 
        '<a href="/bn/foodList?storeId='+ranks[3].storeId+'" >'+ '<img src="/img/33.png" width="150" height="150">' + "</a>" +
        '<a href="/bn/foodList?storeId='+ranks[3].storeId+'" >' + ranks[3].storeName +"</a>" +
        '</div>';
	    var cnt1=4;
	    
	    for (var i = 3; i < ranks.length; i++) {
	    	rankHtml += '<div class="rankstyle2">'+"<ul>"+cnt1+"등 "+ 
	        '<a href="/bn/foodList?storeId='+ranks[i].storeId+'" >' + ranks[i].storeName +"</a></div>";
	        
	       cnt1+=1;
	    }
	    document.getElementById("rankList").innerHTML += rankHtml;
	    
	  }
};
