/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {        //DOM的onload事件处理函数        
    $("#submit").click(function() {  //当按钮button被点击时的处理函数        
        postdata();    //button被点击时执行postdata函数         
    });
});

function postdata() {           //提交数据函数         
    $.ajax({//调用jquery的ajax方法        
        type: "POST", //设置ajax方法提交数 据的形式        
        url: "UserServlet?action=ajouterCommentaire", //把数 据提交到comments.php        
        data: "nom=" + $("#nom").val() + "&contenu=" + $("#contenu").val() 
                + "&IdNews=" + $("#IdNews").val()+"&time=" + $("#time").val(),
        success: function(msg) {                  //提交成功后的回调   
            if (msg="ok") {
                alert("回复 成功(:))！");
                $("#insert")
                        .append("<b>用户名:</b>"+$("#nom").val() + "<br/>"+
                        "<b>时间:</b>"+$("#time").val() + "<br/>"
                        +$("#contenu").val()+"<hr/>");
            } else {
                alert("回复 失败(:)！ ");
            }
        }
    });
}

