<%--
  Created by IntelliJ IDEA.
  User: Jbroken
  Date: 2017/3/1
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>泸州消防APP后台管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <script type="text/javascript" src="js/login/jquery-core.min.js?v=201611141721"></script>
    <script type="text/javascript" src="js/login/fai.min.js?v=201612051759"></script>
    <script type="text/javascript" src="js/login/util.min.js?v=201508121741"></script>
    <style type="text/css">
        .clear {
            clear: both
        }

        image {
            border: 0
        }

        .container {
            height: auto;
            font-size: 12px;
            position: absolute;
            width: 100%;
            top: 0
        }

        .header {
            width: 960px;
            margin: auto;
            height: 92px
        }

        .header .left {
            float: left;
            width: 600px;
            height: 100%;
            padding-left: 15px;
            background: url(images/login/logo-top.jpg) 0 40% no-repeat
        }

        .header .left .logo {
            float: left;
            width: 150px;
            height: 38px;
            margin-top: 23px
        }

        .header .left .text {
            float: left;
            width: 188px;
            height: 16px;
            margin: 35px 0 0 13px
        }
        .middle {
            height: auto
        }

        .middle .content {
            width: 1058px;
            margin: auto
        }

        .middle .left {
            width: 550px;
            height: 534px;
            float: left;
            margin: 31px 100px 0 0;
            background: url(images/login/left.jpg)  no-repeat;
            position: relative;
        }

        .middle .left .regBtn-hover {
            cursor: pointer;
            background-position: -140px -599px;
            _background: 0;
        }
        .middle .right {
            font-family: "微软雅黑";
            width: 273px;
            height: auto;
            padding: 30px 32px;
            float: left;
            background: #fff;
            margin-top: 150px;
            box-shadow: 0 0 6px rgba(0, 0, 0, .08);
            -moz-box-shadow: 0 0 6px rgba(0, 0, 0, .08);
            -webkit-box-shadow: 0 0 6px rgba(0, 0, 0, .08)
        }

        .worn {
            display: none;
            font-size: 12px;
            color: #343434;
            width: 239px;
            height: 25px;
            line-height: 25px;
            text-align: left;
            padding-left: 28px;
            margin-bottom: 5px;
            border: 1px solid #ffe792;
            background: url(images/login/regVersion2016.png?v=201701061749) -670px -557px no-repeat #fffedf
        }

        .loginBtn {
            float: left;
            width: 271px;
            height: 44px;
            line-height: 44px;
            color: #fff;
            text-align: center;
            font-size: 18px;
            cursor: pointer;
            background: url(images/login/regVersion2016.png?v=201701061749) 0 -315px no-repeat
        }

        .loginBtn-hover {
            background-position: 0 -376px
        }


        .log-line {
            text-align: center;
            margin-bottom: 15px;
            position: relative;
            height: 44px;
            width: 269px;
            border: 1px solid #fff
        }

        .log-line .log-txt {
            color: #c2c2c2;
            position: absolute;
            top: 0;
            left: 50px;
            z-index: 1;
            text-align: left;
            line-height: 44px;
            font-size: 16px
        }

        .log-line .log-txt-hover {
            color: #ddd
        }

        .log-line .logIco {
            position: absolute;
            top: 10px;
            left: 10px;
            width: 24px;
            height: 24px;
            background: url(images/login/regVersion2016.png?v=201701061749) -101px 0 no-repeat;
        }

        .log-line .logIcoCacct {
            background-position: -101px 0
        }
        .log-line .logIcoPwd {
            background-position: -101px -120px
        }

        .log-line-hover .logIcoCacct {
            background-position: -162px 0
        }

        .log-line-hover .logIcoPwd {
            background-position: -162px -120px
        }

        .log-line .log-input {
            position: absolute;
            top: 0;
            left: 0;
            width: 209px;
            height: 38px;
            line-height: 38px;
            background: transparent;
            font-size: 14px;
            padding: 2px 10px 2px 50px;
            outline: 0;
            z-index: 10
        }

        .log-line .input2 {
            border: 1px solid #d7d9e1;
            color: #888
        }

        .log-line-hover .log-input {
            border: 1px solid #2f82ff;
            color: #000
        }

        #log-valid-img {
            position: absolute;
            right: 20px;
            top: 7px;
            cursor: pointer;
            height: 30px
        }

        #log-refresh-btn {
            float: right;
            margin-top: 10px;
            height: 25px;
            width: 16px;
            cursor: pointer;
            background: url(images/login/regVersion2016.png?v=201701061749) no-repeat -675px -650px
        }
        .footer{
            float:right;
            margin:30px 85px 0 0;
            line-height:23px
        }
        .graw{
            font-size:12px;
            text-decoration:none;
            text-align:right;
            padding-right:40px;
            _width:345px;
            _padding-right:20px}
    </style>
</head>

<body style="background-color:#f0f6fe; font-family:'微软雅黑';">
<div class="container">
    <div style="background-color:#fff;">
        <div class="header">
            <div class="left">
                <a hidefocus="true" class="logo" target="_blank"></a>
                <div class="text"></div>
            </div>
        </div>
    </div>
    <div class="middle">
        <div class="content">
            <div class="left">
            </div>
            <div class="right">
                <div id="log-form" class="rightmid">
                    <div class="log-input-container">
                        <div class="clear" style="font-size:0px;"></div>
                        <form action="admin" method="post" onsubmit="return login()">
                            <div class="log-line" id="rowCacct">
                                <div class="log-txt">账号</div>
                                <input id="log-cacct" type="text" name ="username" autocomplete="off" maxlength="30"
                                       class="log-input input2"/>
                                <div class="logIco logIcoCacct">&nbsp;</div>
                            </div>
                            <div class="log-line" id="rowPwd">
                                <div id="passwordLabel" class="log-txt">密码</div>
                                <input id="log-pwd" type="password" name="password" autocomplete="new-password" maxlength="20"
                                       class="log-input input2"/>
                                <div class="logIco logIcoPwd">&nbsp;</div>
                            </div>
                            <div id="log-valid-line" class="log-line">
                                <div class="log-txt" style="width:116px; left:12px;">验证码</div>
                                <input id="log-valid" type="text" class="log-input input2" name="code"
                                       style="width:116px; padding-left:12px;"/>
                                <img id="log-valid-img" title="看不清？点击换一张"/>
                                <span id="log-refresh-btn" title="看不清？点击换一张"></span>
                            </div>
                            <div id="error" class="worn"></div>
                            <button id="login-button" class="loginBtn">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                        </form>
                    </div>
                    <%--<div id="login-button" class="loginBtn">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</div>--%>
                </div>
            </div>
            <div class="footer">
                <div class="graw">Copyright <font style="font-family:'微软雅黑', '黑体', '新宋体', 'Arial Unicode MS'">&copy; </font> 2016-2017 泸州市公安消防大队<br></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/login/login.js"></script>
<script type="text/javascript">
    var errInfo = "${errInfo}";
    $(document).ready(function () {
        if(errInfo != ""){
            if (errInfo.indexOf("验证码") > -1){
                showMsg(errInfo);
                $('#log-valid').focus();
            }
            else {
                showMsg(errInfo);
                $('#log-cacct').focus();
            }
        }
    })

</script>
</body>
</html>
