var isEmail = function (email) {
    if (typeof email !== 'string') {
        return false;
    }
    var emailRegExp =
        /^\w+([-.+]\w+)*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
    return emailRegExp.test(email);
};

var isIdNumber = function (idNumber) {
    if (typeof idNumber !== 'string') {
        return false;
    }
    idNumber = idNumber.toUpperCase();
    if (!(/^\d{17}(\d|X)$/).test(idNumber)) {
        return false;
    }
    var codes = idNumber.split('');
    var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
    var parity = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
    var sum = 0;
    for (var i = 0; i < 17; i++) {
        sum += codes[i] * factor[i];
    }
    return parity[sum % 11] === codes[17];
};

var isPasswdValid = function (password) {
    if (typeof password !== 'string') {
        return false;
    }
    return password.length > 5;
};

var postJsonData = function (url, params, success) {
    $.ajax(
        {
            url: url,
            type: "POST",
            data: JSON.stringify(params),
            dataType: 'json',
            async: false,
            contentType: 'application/json; charset=utf-8',
            success: success
        }
    );
};

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
        if (!isEmail(username)) {
            alert('请输入有效的电子邮件地址!');
            return false;
        }
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
                console.log(res);
                alert(res.toString());
            });
        return false;
    };
    var submitSignupForm = function (event) {
        var form = $(event.target).parents('#signup');
        var email = form.find('[name="email"]').val();
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
        var $btn = $(this).button('loading');

        postJsonData('/user/signup',
            {
                "username": username,
                "password": password,
                "email": email,
            },
            function (res) {
                $btn.button('reset');
                console.log(res);
                alert(res.toString());
            });
        return false;
    };
    $('#login-btn').bind('click', submitLoginForm);
    $('#signup-btn').bind('click', submitSignupForm);
});