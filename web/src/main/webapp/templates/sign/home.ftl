<#import "../widgets/variable.ftl" as var />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title!'主页'} | ${var.siteName}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="chorcut icon" href="${var.assertBase}/favicon.ico">
    <link href="${var.assertBase}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${var.assertBase}/css/home.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal login-form" id="login" role="form" action="/user/login" method="post">
            <div class="row">
                <div class="col-md-12">
                    <h1>登陆</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 form-field">
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="username" class="control-label">用户名/手机号/邮箱</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-user"></i>
                                <input type="text" class="form-control" name="username" placeholder="电子邮箱" required
                                       autofocus>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="password" class="control-label">密码</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-lock"></i>
                                <input type="password" class="form-control" name="password" placeholder="密码" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" checked> 记住登陆
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="登陆" id="login-btn" class="btn btn-warning"
                                   data-loading-text="正在登陆...">
                        </div>
                    </div>
                </div> <!-- col-md-6 -->

                <div class="col-md-6">
                    <div class="col-sm-12">
                        <h4>请使用邮箱和密码登陆</h4>
                    </div>
                    <div class="col-sm-12">
                        <div class="col-sm-6">
                            <a class="btn btn-success" href="#signup">
                                我要注册
                                <i class="glyphicon glyphicon-cloud-upload"></i>
                            </a>
                        </div>
                        <div class="col-sm-6">
                            <a class="btn btn-primary" href="/forgotPassword">
                                忘记密码?
                            </a>
                        </div>
                    </div>
                </div> <!-- col-md-6 -->
            </div>
        </form>

        <form class="form-horizontal login-form" role="form" action="/user/signup" method="post" id="signup"
              style="display: none;">
            <div class="row">
                <div class="col-md-12">
                    <h1>注册</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 form-field">
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="username" class="control-label">姓名</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-user"></i>
                                <input type="text" class="form-control" name="username" placeholder="姓名" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">Email</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-send"></i>
                                <input type="email" class="form-control" name="email" placeholder="电子邮箱" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="mobile" class="control-label">手机号码</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-phone"></i>
                                <input type="text" class="form-control" name="mobile" placeholder="手机号码" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="password" class="control-label">密码 (至少6位)</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-lock"></i>
                                <input type="password" class="form-control" name="password" placeholder="密码 (至少6位)"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="repassword" class="control-label">确认密码</label>
                            <div class="input-icon-container">
                                <i class="glyphicon glyphicon-lock"></i>
                                <input type="password" class="form-control" name="repassword" placeholder="确认密码"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="注册" id="signup-btn" class="btn btn-warning"
                                   data-loading-text="正在注册...">
                        </div>
                    </div>
                </div> <!-- col-md-6 -->

                <div class="col-md-6">
                    <div class="col-sm-12">
                        <h4>注册新用户, 需要填写邮箱、姓名及密码信息.</h4>
                    </div>
                    <div class="col-sm-12">
                        <a class="btn btn-primary" href="#login">
                            立即登陆
                            <i class="glyphicon glyphicon-log-in"></i>
                        </a>
                    </div>
                </div> <!-- col-md-6 -->
            </div>
        </form>

    </div>
</div>
<#include "../widgets/footer.ftl" />
<script src="${var.assertBase}/js/jquery.min.js?v=1.11.2"></script>
<script src="${var.assertBase}/js/bootstrap.min.js?v=3.3.2"></script>
<script src="${var.assertBase}/js/home.js?v=0.0.1"></script>
<script>

    $(function () {
        var list = ['#login', '#signup'];
        var trans = function () {
            var hash = location.hash ? location.hash : '#login';
            var index = list.indexOf(hash);
            $(hash).show();
            $(list[1 - index]).hide();
        };
        trans();
        window.onhashchange = function () {
            trans();
        };
        var submitLoginForm = function (event) {
            var form = $(event.target).parents('#login');
            var username = form.find('[name="username"]').val();
            var password = form.find('[name="password"]').val();
            // validator
            if (!password) {
                alert('请输入密码');
                return false;
            }
            var $btn = $(this).button('loading');
            postJsonData('/user/login',
                    {
                        "username": username,
                        "password": password
                    },
                    function (res) {
                        $btn.button('reset');
                        alert(res.msg);
                        if (res.status == 0) {
                            location.href = "/infocenter";
                        }

                    });
            return false;
        };
        var submitSignupForm = function (event) {
            var form = $(event.target).parents('#signup');
            var email = form.find('[name="email"]').val();
            var phone = form.find('[name="mobile"]').val();
            var username = form.find('[name="username"]').val();
            var password = form.find('[name="password"]').val();
            var repassword = form.find('[name="repassword"]').val();
            // validator
            if (!isEmail(email)) {
                alert('请输入有效的电子邮件地址!');
                return false;
            }
            if (!username) {
                alert('请输入姓名');
                return false;
            }
            if (!isPasswdValid(password)) {
                alert('密码至少6位!');
                return false;
            }
            if (password !== repassword) {
                alert('密码不匹配');
                return false;
            }
            if (!isEmail(email)) {
                alert('请输入正确的邮箱地址');
                return false;
            }
            if (!isPhoneNumber(phone)) {
                alert('手机号码不合法, 请检查后重试.');
                return false;
            }
            var $btn = $(this).button('loading');

            postJsonData('/user/signup',
                    {
                        "username": username,
                        "password": password,
                        "mobile": phone,
                        "email": email,
                    },
                    function (res) {
                        $btn.button('reset');
                        alert(res.msg);
                        if (res.status == 0) {
                            location.href = "#signin";
                        }
                    });
            return false;
        };
        $('#login-btn').bind('click', submitLoginForm);
        $('#signup-btn').bind('click', submitSignupForm);
    });
</script>
<!-- Baidu Analytics -->
<#include "../widgets/analytics.ftl" />
</body>
</html>