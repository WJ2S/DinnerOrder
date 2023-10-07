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
            <h2>Find My Password</h2>
            <label>
                <span>username</span>
                <input id="username" name="username" type="text"/>
            </label>
            <label>
                <span>email</span>
                <input id="email" name="email" type="email"/>
            </label>
        </form>
        <button class="submit" id="submit" onclick="submitClick()" type="button">Submit</button>
    </div>
</div>
</body>

<script>
    function submitClick() {
        let username = $("#username").val();
        if (!username) {
            alert("Username can not be empty");
            return;
        }

        let email = $("#email").val();
        if (!email) {
            alert("Email can not be empty");
            return;
        }

        // 发送密码找回请求
        console.log(email)
        $.post({
            url: "${pageContext.request.contextPath}/find_my_password",
            data: {
                "username": username,
                "email": email,
            },
            success: function (result) {
                result = $.parseJSON(result)
                // 用户名、密码输入正确，发送密码至邮箱
                if (result.code === 1) {
                    alert("Password has been sent to your email address");
                }
                // 用户名、密码输入错误，提示错误信息
                else {
                    alert(result.msg);
                }
            }
        })
    }
</script>
</html>
