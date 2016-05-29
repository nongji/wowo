<#import "../widgets/variable.ftl" as var />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title!'找回密码'} | ${var.siteName}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="chorcut icon" href="${var.assertBase}/favicon.ico">
    <link href="${var.assertBase}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${var.assertBase}/css/home.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="container reset-container">
        <div class="col-md-12 ">
            <h1 class="margin-bottom-15">忘记密码</h1>
            <form id="forgot-form" class="form-horizontal forgot-password-form " role="form" action="/forgotPassword"
                  method="post">
                <div class="form-group">
                    <div class="col-md-12">
                        请输入绑定邮箱
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <input type="email" class="form-control" name="email" placeholder="电子邮箱" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <input type="submit" value="重置密码" id="forgot-btn" class="btn btn-danger"
                               data-loading-text="正在发送重置邮件...">
                        <br><br>
                        <a href="/#login">登陆</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<#include "../widgets/footer.ftl" />
<script src="${var.assertBase}/js/jquery.min.js?v=1.11.2"></script>
<script src="${var.assertBase}/js/bootstrap.min.js?v=3.3.2"></script>
<script src="${var.assertBase}/js/home.js?v=0.0.1"></script>
<script>
    $(function () {
        var submitForgotForm = function (event) {
            var form = $(event.target).parents('#forgot-form');
            var email = form.find('[name="email"]').val();
            if (!isEmail(email)) {
                alert('请输入正确的邮箱地址');
                return false;
            }
            var $btn = $(this).button('loading');
            $.post('/forgotPassword',
                    form.serialize(),
                    function (res) {
                        $btn.button('reset');
                        if (res.error) {
                            alert(res.error);
                        } else if (res.success) {
                            alert(res.success);
                        }
                        if (res.action) {
                            location.href = res.action;
                        }
                    }, 'json');
            return false;
        };
        $('#forgot-btn').bind('click', submitForgotForm);
    });
</script>
<!-- Baidu Analytics -->
<#include "../widgets/analytics.ftl" />
</body>
</html>