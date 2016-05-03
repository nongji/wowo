<#import "/templates/widgets/variable.ftl" as var />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title!'fangwentong'} | ${var.siteName}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="chorcut icon" href="${var.assertBase}/favicon.ico">
    <link href="${var.assertBase}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Hello, world!</h1>
<#include "/templates/widgets/footer.ftl" />
<script src="${var.assertBase}/js/jquery.min.js?v=1.11.2"></script>
<script src="${var.assertBase}/js/bootstrap.min.js?v=3.3.2"></script>
<!-- Baidu Analytics -->
<#include "/templates/widgets/analytics.ftl" />
</body>
</html>