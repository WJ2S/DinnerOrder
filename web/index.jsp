<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>Dinner Ordering</title>
    <link href="./static/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="content">
    <div class="form sign-in">
        <form id="form" method="post">
            <h2>Welcome</h2>
            <label>
                <span>username</span>
                <input id="username" name="username" type="text"/>
            </label>
            <label>
                <span>password</span>
                <input id="password" name="password" type="password"/>
            </label>
        </form>
        <!-- todo 忘记密码跳转链接 -->
        <p class="forgot-pass"><a href="">forgot password?</a></p>
        <button class="submit" id="login" onclick="loginClick()" type="button">Login</button>
        <button class="sign-up" id="signup" onclick="signupClick()" type="button">Sign Up</button>
    </div>
</div>
</body>
<script>
    function loginClick() {
        const username = document.getElementById("username").value;
        if (!username) {
            alert("Username can not be empty");
            return;
        }
        const password = document.getElementById("password").value;
        if (!password) {
            alert("Password can not be empty");
            return;
        }
        // 登录校验
        $.post({
            url: "${pageContext.request.contextPath}/login",
            data: {
                "username": $("#username").val(),
                "password": $("#password").val(),
            },
            success: function (result) {
                result = $.parseJSON(result);
                // 登录成功，跳转至首页
                if (result.code === 1) {
                    window.location.href = "./static/jsp/home.jsp"
                }
                // 登录失败，显示失败提醒
                else {
                    alert(result.msg);
                }
            }
        })
    }

    function signupClick() {
        window.location.href = "./static/jsp/signup.jsp";
    }
</script>
</html>
