<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>Dinner Ordering</title>
    <link href="../css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="content">
    <div class="form sign-up">
        <form id="form" method="post">
            <h2>Register</h2>
            <label>
                <span>username</span>
                <input id="username" name="username" type="text"/>
            </label>
            <label>
                <span>email</span>
                <input id="email" name="email" type="text"/>
            </label>
            <label>
                <span>password</span>
                <input id="password" name="password" type="password"/>
            </label>
            <label>
                <span>confirm password</span>
                <input id="confirm" name="confirm" type="password"/>
            </label>
        </form>
        <button class="submit" id="signup" onclick="signupClick()" type="button">Submit</button>
    </div>
</div>
</body>

<script>
    function signupClick() {
        let username = document.getElementById("username").value;
        if (!username) {
            alert("Username can not be empty");
            return;
        }

        let email = document.getElementById("email").value;
        if (!email) {
            alert("Email can not be empty");
            return;
        }

        let password = document.getElementById("password").value;
        if (password.length < 6) {
            alert("Password must have at least 6 characters");
            return;
        }

        let confirm = document.getElementById("confirm").value;
        if (confirm !== password) {
            alert("Password unmatched");
            return;
        }

        // 提交表单
        $.post({
            url: "${pageContext.request.contextPath}/signup",
            data: {
                "username": $("#username").val(),
                "email": $("#email").val(),
                "password": $("#password").val(),
            },
            success: function (result) {
                result = $.parseJSON(result)
                // 注册成功，跳转至首页
                if (result.code === 1) {
                    window.location.href = "./home.jsp"
                }
                // 注册失败，提示错误信息
                else {
                    alert(result.msg);
                }
            }
        })

    }
</script>
</html>
