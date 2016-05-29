<#import "../widgets/variable.ftl" as var />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title!'重设密码'} | ${var.siteName}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="chorcut icon" href="${var.assertBase}/favicon.ico">
    <link href="${var.assertBase}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${var.assertBase}/css/home.css" rel="stylesheet">
</head>
<body>
<div class="container reset-container">
    <div class="col-md-12 ">
        <h1 class="">密码重置</h1>
        <form id="reset-form" class="form-horizontal forgot-password-form " role="form" action="/resetPassword"
              method="post">
            <div class="form-group">
                <div class="col-md-12">
                    请输入密码
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">
                    <input type="password" class="form-control" name="password" placeholder="请输入密码 (至少6位)" required
                           autofocus>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">
                    <input type="password" class="form-control" name="repassword" placeholder="重复密码" required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">
                    <input type="submit" value="重置密码" id="reset-btn" class="btn btn-danger"
                           data-loading-text="正在修改密码...">
                    <br><br>
                    <a href="/#login">登陆</a>
                </div>
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
        var submitResetForm = function (event) {
            var form = $(event.target).parents('#reset-form');
            var password = form.find('[name="password"]').val();
            var repassword = form.find('[name="repassword"]').val();
            // validator
            if (!isPasswdValid(password)) {
                alert('密码至少6位!');
                return false;
            }
            if (password !== repassword) {
                alert('密码不匹配');
                return false;
            }
            var $btn = $(this).button('loading');
            $.post('resetPassword',
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
        $('#reset-btn').bind('click', submitResetForm);
    });
</script>
<!-- Baidu Analytics -->
<#include "../widgets/analytics.ftl" />
</body>
</html>