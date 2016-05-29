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

var isPhoneNumber = function (phoneNumber) {
    if (typeof phoneNumber != 'string') {
        return false;
    }
    var phoneRegx = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
    return phoneRegx.test(phoneNumber);
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
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: success
        }
    );
};
