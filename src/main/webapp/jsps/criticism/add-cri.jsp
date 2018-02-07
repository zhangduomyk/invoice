<%@ page import="cn.ccut.invoice.criticism.model.CriticismCustom" %><%--
  Created by IntelliJ IDEA.
  User: 10851
  Date: 2018/2/7
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加评论</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/invoice/static/h-ui.admin/css/style.css"/>
</head>
<body>
<article class="page-container page-index">
    <form action="<c:url value="/criticism/insertOneRecord"/>" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>评论内容：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="comment" id="critied" cols="" rows="" class="textarea"  placeholder="说点什么...30个字符以内" dragonfly="true" onblur="checkcriti()"></textarea>
                <span class="c-red" style="position: absolute; bottom: -30px; right: 20px; display: none;" id="error_number"><i class="Hui-iconfont">&#xe6dd;字数长度不符合要求</i></span>
            </div>
        </div>
        <div style="height: 35px"></div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>当前时间：</label>
            <div class="formControls col-xs-8 col-sm-9" id="dateShow">
                <%
                    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    java.util.Date currentTime = new java.util.Date();//得到当前系统时间
                    String str_date1 = formatter.format(currentTime); //将日期时间格式化
                    String str_date2 = str_date1.toString();//将Date型日期时间转换成字符串形式
                %>
                <big><%=str_date2 %></big>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" id="submitid" onclick="myWaiteClose()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                <input class="btn btn-defaul radius" type="button" onclick="myClose()" value="&nbsp;&nbsp;退出&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/invoice/static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/invoice/static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/invoice/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript">

    var flagNumber = false;
    function checkcriti() {
        var value = document.getElementById("critied").value;
        var length = value.length;
        var error = document.getElementById("error_number");
        if(length > 30) {
            error.style.display = "";
        } else {
            error.style.display = 'none';
            flagNumber = true;
        }
        var sub = document.getElementById("submitid");
        if(flagNumber) {
            sub.disabled = false;
        } else {
            sub.disabled = true;
        }
    }

    /*关闭窗口*/
    function myClose() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }
    function myWaiteClose() {
        var st = document.getElementById("critied").innerText;
        setTimeout("myClose()", 2);
        alert("添加成功")
    }

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
