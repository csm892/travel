$(function () {

    var rids=getParameter("rid");

    $.get("discuss/findByRid",{rid:rids},function (data) {
        var lis = "";
        for (var i = 0; i < data.length; i++) {


            var li = ' <li class="feed">\n' +
                '                        <div class="avatar">\n' +
                '                            <img src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3936143287,2803643994&fm=26&gp=0.jpg" alt="" />\n' +
                '                        </div><!--第一层循环start-->\n' +
                '                        <div class="box1">\n' +
                '                            <p class=\'current\'>\n' +
                '                                <a href="">'+data[i].username+'</a>\n' +
                '                            </p>\n' +
                '                            <p class="line">\n' +
                '                            </p>\n' +
                '                            '+data[i].content+'\n' +
                '                            </p>\n' +
                '                            <p class=\'info\'>\n' +
                '                                <span style="font-size: small;color: grey">'+data[i].date+'</span>\n' +
                '\n' +
                '                            <p class="line">\n' +
                '                            </p>\n' +
                '\n' +
                '                        </div>\n' +
                '\n' +
                '                        <div class="clear">\n' +
                '                        </div>\n' +
                '                    </li>\n' +
                '             ';
            lis+=li;
            $("#discuss").html(lis);

        }
    })

})