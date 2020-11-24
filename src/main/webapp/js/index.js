$(function () {

 $.get("route/pageQuery",{cid:5},function (routes) {

     var lis = "";
     for (var i = 0; i < routes.list.length; i++) {
         var route=routes.list[i];

         var li = ' <div class="col-md-4">\n' +
             '                            <a href="route_detail.html?rid=' + route.rid + '">\n' +
             '\t\t\t\t\t\t\t\t<img src="' + route.rimage + '" style="width: 268px;height: 150px">\n' +
             '\t\t\t\t\t\t\t\t<div class="has_border">\n' +
             '\t\t\t\t\t\t\t\t\t<h3>' + route.routeIntroduce + '</h3>\n' +
             '\t\t\t\t\t\t\t\t\t<div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\t\t\t\t\t\t\t\t\t\n' +
             '\t\t\t\t\t\t\t\t</div>\n' +
             '\t\t\t\t\t\t\t</a>\n' +
             '                        </div>\n' +
             '                       ';
         lis +=li;
         $("#tupian").html(lis);
     }

 })
    $.get("route/pageQuery",{cid:4},function (routes) {

        var lis = "";
        for (var i = 0; i < routes.list.length; i++) {
            var route=routes.list[i];

            var li = ' <div class="col-md-4">\n' +
                '                            <a href="route_detail.html?rid=' + route.rid + '">\n' +
                '\t\t\t\t\t\t\t\t<img src="' + route.rimage + '" style="width: 268px;height: 150px">\n' +
                '\t\t\t\t\t\t\t\t<div class="has_border">\n' +
                '\t\t\t\t\t\t\t\t\t<h3>' + route.routeIntroduce + '</h3>\n' +
                '\t\t\t\t\t\t\t\t\t<div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\t\t\t\t\t\t\t\t\t\n' +
                '\t\t\t\t\t\t\t\t</div>\n' +
                '\t\t\t\t\t\t\t</a>\n' +
                '                        </div>\n' +
                '                       ';
            lis +=li;
            $("#tupian2").html(lis);
        }

    })

    $.get("route/pageQuery",{cid:3,pageSize:4},function (routes) {

        var lis = "";
        for (var i = 0; i < routes.list.length; i++) {
            var route=routes.list[i];

            var li = ' <div class="col-md-3">\n' +
                '                            <a href="route_detail.html?rid=' + route.rid + '">\n' +
                '\t\t\t\t\t\t\t\t<img src="' + route.rimage + '" style="width: 268px;height: 150px">\n' +
                '\t\t\t\t\t\t\t\t<div class="has_border">\n' +
                '\t\t\t\t\t\t\t\t\t<h3>' + route.routeIntroduce + '</h3>\n' +
                '\t\t\t\t\t\t\t\t\t<div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\t\t\t\t\t\t\t\t\t\n' +
                '\t\t\t\t\t\t\t\t</div>\n' +
                '\t\t\t\t\t\t\t</a>\n' +
                '                        </div>\n' +
                '                       ';
            lis +=li;
            $("#popularity2").html(lis);
        }

    })
    $.get("route/pageQuery",{cid:2,pageSize:4},function (routes) {

        var lis = "";
        for (var i = 0; i < routes.list.length; i++) {
            var route=routes.list[i];

            var li = ' <div class="col-md-3">\n' +
                '                            <a href="route_detail.html?rid=' + route.rid + '">\n' +
                '\t\t\t\t\t\t\t\t<img src="' + route.rimage + '" style="width: 268px;height: 150px">\n' +
                '\t\t\t\t\t\t\t\t<div class="has_border">\n' +
                '\t\t\t\t\t\t\t\t\t<h3>' + route.routeIntroduce + '</h3>\n' +
                '\t\t\t\t\t\t\t\t\t<div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\t\t\t\t\t\t\t\t\t\n' +
                '\t\t\t\t\t\t\t\t</div>\n' +
                '\t\t\t\t\t\t\t</a>\n' +
                '                        </div>\n' +
                '                       ';
            lis +=li;
            $("#theme2").html(lis);
        }

    })

    $.get("route/pageQuery",{cid:7,pageSize:4},function (routes) {

        var lis = "";
        for (var i = 0; i < routes.list.length; i++) {
            var route=routes.list[i];

            var li = ' <div class="col-md-3">\n' +
                '                            <a href="route_detail.html?rid=' + route.rid + '">\n' +
                '\t\t\t\t\t\t\t\t<img src="' + route.rimage + '" style="width: 268px;height: 150px">\n' +
                '\t\t\t\t\t\t\t\t<div class="has_border">\n' +
                '\t\t\t\t\t\t\t\t\t<h3>' + route.routeIntroduce + '</h3>\n' +
                '\t\t\t\t\t\t\t\t\t<div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\t\t\t\t\t\t\t\t\t\n' +
                '\t\t\t\t\t\t\t\t</div>\n' +
                '\t\t\t\t\t\t\t</a>\n' +
                '                        </div>\n' +
                '                       ';
            lis +=li;
            $("#newest2").html(lis);
        }

    })

})