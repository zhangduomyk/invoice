<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>评论列表</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="static/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="static/assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="static/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户体验 <span class="c-gray en">&gt;</span> 评论列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container indexPosotion">
    <div class="cl pd-5 bg-1 bk-gray mt-20" style="height: 42px;">
        <div class="text-c">
            <span class="l">
                <a href="javascript:;" onclick="dataDdd('发表评论','jsps/criticism/add-cri.jsp','800','400')" class="btn btn-primary radius">
                    <i class="Hui-iconfont">&#xe600;</i> 发表评论</a></span>
            <span class="r">第<strong><span id="spanId-1"></span></strong>页/共<strong id="spanId-2"><span></span></strong>页</span> </div>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="100">用户</th>
                <th>评论</th>
                <th width="200">日期</th>
            </tr>
            </thead>
            <tbody id="tbodyId">
            <c:forEach var="list" items="${pageBean.list}">
                <tr class="text-c">
                    <td>${list.uid}</td>
                    <td>${list.comment}</td>
                    <td>${list.date.toLocaleString()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="pageDiv" id="ulId">
        </div>

    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value="/static/My97DatePicker/4.8/WdatePicker.js"/>"></script>
<script type="text/javascript" src="static/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="static/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="static/myscript/data_js.js"></script>
<script type="text/javascript">
    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    var pageCode = ${pageBean.pageCode};
    var totalPage = ${pageBean.totalPage};
    var ulValue = '';
    var begin = null;
    var end = null;
    function pageFoot() {
        ulValue += '<ul data-am-widget="pagination" class="am-pagination am-pagination-default">';
        ulValue += '<li class="am-pagination-first">';
        ulValue += '<a class="am-btn-xs" id="firstPage">首页</a>';
        ulValue += '</li>';

        if(pageCode > 1) {
            ulValue += '<li class="am-pagination-prev">';
            ulValue += '<a class="am-btn-xs" id="upPage">上一页</a>';
            ulValue += '</li>';
        }


        if(totalPage <= 10) {
            begin = 1;
            end = totalPage;
        } else {
            begin = pageCode - 5;
            end = pageCode + 4;
        }

        if(begin < 1) {
            begin = 1;
            end = 10;
        }

        if(end > totalPage) {
            begin = totalPage - 9;
            end = totalPage;
        }

        for(var i = begin; i <= end; i++) {
            ulValue += '<li>';
            var st = "<c:url value="/criticism/pageRecord"/>?pageCode="+ i;
            ulValue += '<a class="am-btn-xs" id="newPage_' + i + '" href="<c:url value="/criticism/pageRecord"/>?pageCode='+i+'">'+i+'</a>';
            ulValue += '</li>';
        }

        if(pageCode < totalPage) {
            ulValue += '<li class="am-pagination-next">';
            ulValue += '<a class="am-btn-xs" id="downPage">下一页</a>';
            ulValue += '</li>';
        }

        ulValue += '<li class="am-pagination-last am-btn-xs">';
        ulValue += '<a class="am-btn-xs" id="endPage">尾页</a>';
        ulValue += '</li>';
        ulValue += '</ul>';

        document.getElementById("ulId").innerHTML = ulValue;

        bindAtion();

        ulValue = '';

        document.getElementById("spanId-1").innerHTML = pageCode;
        document.getElementById("spanId-2").innerHTML = totalPage;
    }
    pageFoot();
    function bindAtion() {
        //'首页'事件
        $("#firstPage").bind("click", function() {
            window.location.href = '<c:url value="/criticism/pageRecord"/>?pageCode=1'
        });

        //'上一页'事件
        $("#upPage").bind("click", function() {
            var st = "<c:url value="/criticism/pageRecord"/>?pageCode="+ --pageCode;
            window.location.href = st
        });

        //'页码跳转'事件--->


        //'下一页'事件
        $("#downPage").bind("click", function() {
            var st = "<c:url value="/criticism/pageRecord"/>?pageCode="+ ++pageCode;
            window.location.href = st
        });

        //'尾页'事件
        $("#endPage").bind("click", function() {
            var st = "<c:url value="/criticism/pageRecord"/>?pageCode="+ totalPage;
            window.location.href = st
        });

    }
</script>
</body>
</html>