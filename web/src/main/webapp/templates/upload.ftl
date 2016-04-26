<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Form</title>
    <link rel="stylesheet" href="/public/css/bootstrap.min.css">
    <link rel="chorcut icon" href="/public/favicon.ico">
</head>
<body>

<form class="form-horizontal" role="form" action="/upload" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="student-id" class="col-sm-2 control-label">* 学号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="student-id" name="sid" placeholder="etc. 1110100101" autofocus
                   required>
        </div>
    </div>
    <div class="form-group">
        <label for="student-name" class="col-sm-2 control-label">* 姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="student-name" name="name" placeholder="姓名" required>
        </div>
    </div>
    <div class="form-group">
        <label for="birthday" class="col-sm-2 control-label">* 生日</label>
        <div class="col-sm-10">
            <input type="text" size="10" class="form-control" id="birthday" name="birthday" value="1993-10-04"
                   data-date-format="yyyy-mm-dd" required>
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">* 手机号码</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="phone" name="phone" placeholder="etc. 18056050000" required>
        </div>
    </div>
    <div class="form-group">
        <label for="sex" class="col-sm-2 control-label">* 性别</label>
        <div class="col-sm-10">
            <select class="form-control" id="sex" name="sex">
                <option value="boy" selected>帅哥</option>
                <option value="girl">美女</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="message" class="col-sm-2 control-label">个性签名</label>
        <div class="col-sm-10">
            <textarea class="form-control" rows="5" id="message" name="message" placeholder="写出您的个性宣言"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="image" class="col-sm-2 control-label">上传头像</label>
        <div class="col-sm-10">
            <input id="image" type="file">
        </div>
    </div>
<#--<div class="form-group">-->
<#--<label for="exampleInputFile">File input</label>-->
<#--<input type="file" id="exampleInputFile">-->
<#--<p class="help-block">Example block-level help text here.</p>-->
<#--</div>-->
    <div class="form-group">
        <div class="col-sm-6 col-sm-offset-3">
            <button type="submit" id="signup-btn" class="btn btn-lg btn-primary btn-block" data-loading-text="正在提交...">
                提交信息
            </button>
        </div>
    </div>
</form>
</body>
</html>