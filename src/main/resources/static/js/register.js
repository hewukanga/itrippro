/*
* @Author: xianghai.peng
* @Date:   2016-12-05 11:06:21
* @Last Modified by:   xianghai.peng
* @Last Modified time: 2016-12-06 11:54:05
*/
'use strict';
// tab切换
$( '.i-reg-top label' ).click( function(event){
		event.stopPropagation(); 
		var index = $( this ).index();
		$( '.i-reg-bottom' ).eq( index ).addClass( 'cur' ).siblings().removeClass( 'cur' );
	} );


// 表单验证
var ok1=false;
var ok2=false;
var ok3=false;
var ok4=false;

//验证手机
$('input[name="phone"]').focus(function(){
  $(this).next().text('请输入手机号').removeClass().addClass('state2 icon-exclamation-sign');
}).blur(function(){
  if($(this).val().search(/^1[34578]\d{9}$/)==-1){
    $(this).next().text('请输入正确的手机号').removeClass('state1').addClass('icon-remove-sign state3');
    ok1=false;
  }else{         
    $(this).next().text('').removeClass().addClass('icon-ok-sign');
    ok1=true;
  }
    
});

//验证手机密码
$('input[name="pwd"]').focus(function(){
  $(this).next().text('以字母开头的6-18位字符、数字和下划线').removeClass().addClass('state2 icon-exclamation-sign');
}).blur(function(){
  if($(this).val().search(/^[a-zA-Z]\w{5,17}$/)==-1){
    $(this).next().text('请输入正确的密码格式').removeClass().addClass('icon-remove-sign state3');
    ok2=false;
  }else{         
    $(this).next().text('').removeClass().addClass('icon-ok-sign');
    ok2=true;
  }
    
});
//验证邮箱密码
$('input[name="password"]').focus(function(){//选中这个框的时候
    $(this).next().text('以字母开头的6-18位字符、数字和下划线').removeClass().addClass('state2 icon-exclamation-sign');
}).blur(function(){//失去焦点的时候
    if($(this).val().search(/^[a-zA-Z]\w{5,17}$/)==-1){
        $(this).next().text('请输入正确的密码格式').removeClass().addClass('icon-remove-sign state3');
        ok4=false;
    }else{
        $(this).next().text('').removeClass().addClass('icon-ok-sign');
        ok4=true;
    }

});


//验证邮箱
$('input[name="mail"]').focus(function(){
  $(this).next().text('请输入注册邮箱').removeClass().addClass('state2 icon-exclamation-sign');
}).blur(function(){
  if($(this).val().search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/)==-1){
    $(this).next().text('请输入正确的EMAIL格式').removeClass().addClass('icon-remove-sign state3');
    ok3=false;
  }else{         
    $(this).next().text('').removeClass().addClass('icon-ok-sign');
    ok3=true;
  }
    
});


var a = "";
// 验证码
function idCode(){
        var arr = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'];
        var str = '';
        for(var i = 0 ; i < 4 ; i ++ )
            str += ''+arr[Math.floor(Math.random() * arr.length)];
        a=str;
        return str;
    }
$('.i_check_in').html(idCode());
$('.idCode').click(function ( ){
	$('.i_check_in').html(idCode());
})


// 手机注册
$('.submitOne').click(function(){
    alert("aaa")
    var inputyanzm = $("#inputyanzm").val().toLowerCase();//自己输入的yanzm转换为小写
    var jihuoma = $("#jihuoma").val();//激活码 手机激活码
    var phone = $("#phone").val();
    var pwd = $("#pwd").val();
    var yanzm = a.toLowerCase();//用来判断和自己输入的验证码是不是一样
    if(ok1==true&&ok2==true) {
        if (phone == null || phone == "") {
            layer.msg("请输入手机号码")
            return;
        }else if (inputyanzm == null || inputyanzm == "") {
            layer.msg("请输入验证码");
            return;
        }else if (dxyzm == null || dxyzm == "") {//拦截 当我没有获取激活码的时候 如果我输入的激活码是空他们也相等 也可以注册 所以这里就拦截一下 当我没获取激活码  就拦截 请先获取激活码
            layer.msg("请先获取手机激活码");
            return;
        }
        if (jihuoma == dxyzm && inputyanzm == yanzm) {
            $.ajax({
                url: "addPhoneUser",
                type: "post",
                async: false,
                dataType: "json",
                data: {phone: phone, password: pwd, code: 1},
                success: function (data) {
                    if (data) {
                        layer.alert("注册成功", function () {
                            window.location.href = "index";
                        });
                    } else {
                        layer.alert("注册失败");
                    }
                }
            })
        } else if (jihuoma != dxyzm && inputyanzm == yanzm) {//这是获取的激活码和输入的激活码作比较  jihuoma和dxyzm
            layer.msg("请输入正确的短信激活码");
            return false;
        } else if (inputyanzm != yanzm && jihuoma == dxyzm) {//这是输入的图片验证码作比较 inputyanzm和yanzm
            layer.msg("验证码错误");
            return false;
        } else if (inputyanzm != yanzm && jihuoma != dxyzm) {
            layer.msg("请输入正确的短信验证码和激活码");
            return false;
        }
    }
});
//邮箱注册
$('.submitTwo').click(function(){
    alert("aaaa")
    var inputCheckCode = $("#code").val();//得到自己输入的激活码
    var mail = $("#mail").val();//得到输入的邮箱
    var password = $("#password").val();
    //得到方法产生并且显示在页面的验证码
    var yanzhengma = $("#yanzhengma").val().toLowerCase();//得到自己输入的验证码
    var yzm = a.toLowerCase();
    if(ok3==true&&ok4==true) {//第一层 判断是否输入  如果没有 就不会走到下一层
        if (mail == null || mail == "") {//只要这个ifelse里面有任何一个不满足  就不会到下面去进行添加  这里显示判断是否输入了
            layer.msg("请先输入邮箱");
            return;
        }else if (yanzhengma == null || yanzhengma == "") {
            layer.msg("请先输入验证码");
            return;
        }else if (checkCode==null||checkCode=="") {
            layer.msg("请先获取邮箱激活码")
            return;
        }

        if (inputCheckCode == checkCode && yanzhengma == yzm) {//判断邮箱激活码是否输入正确  在判断这里之前必须要判断邮箱激活码是否已经获取 如果没有获取那么就不能走这里
            $.ajax({
                url: "addUser",
                type: "post",
                async: false,
                dataType: "json",
                data: {usercode: mail, password: password, code: 1},//usercode就是邮箱 用户通过邮箱注册 所以登录账号就是邮箱
                success: function (data) {
                    if (data) {
                        layer.alert("注册成功", function () {
                            window.location.href = "index";
                        });
                    } else {
                        layer.alert("注册失败");
                    }
                }
            })
        } else if (inputCheckCode != checkCode && yanzhengma == yzm) {//这里才是判断是否输入正确  一层一层的来
            layer.msg("激活码输入错误");
            return false;
        } else if (yanzhengma != yzm && inputCheckCode == checkCode) {
            layer.msg("验证码错误");
            return false;
        } else if (inputCheckCode != checkCode && yanzhengma != yzm) {
            layer.msg("验证码和激活码都有错误");
            return false;
        }
    }
});


