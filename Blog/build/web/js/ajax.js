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
function removeScript(s) {  
    return s.replace(/<script.*?>.*?<\/script>/ig, '');  
}  
function postdata() {           //提交数据函数         
    $.ajax({//调用jquery的ajax方法        
        type: "POST", //设置ajax方法提交数 据的形式        
        url: "UserServlet?action=ajouterCommentaire", //把数 据提交到comments.php        
        data: "nom=" + removeScript($("#nom").val()) 
                + "&contenu=" + removeScript($("#contenu").val()) 
                + "&IdNews=" + $("#IdNews").val()+"&time=" + $("#time").val(),
        success: function(msg) {    
            var urlimg="http://www.gravatar.com/avatar/"+$.md5(removeScript($("#nom").val()))+"?s=40";
            if (msg==="ok") {
                alert("Votre commentaire est bon ！");
                $("#insert")
                        .html("<b>Pseudo:</b>"+removeScript($("#nom").val()) + "<br/>"+
                        "<b>Time:</b>"+$("#time").val().substring(4,16) + "<br/>"
                        +"<img src='"+urlimg+"'/>"
                        +removeScript($("#contenu").val()+"<hr/>"));
            } else {
                alert("Je suis plus fort que toi :P");
            }
        }
    });
}
