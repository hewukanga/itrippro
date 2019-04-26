/**
 * Created by zhzbin on 2016/12/6.
 */
var showMessage= $("#showErrorMessage");
var showTips=$("#promptMessage");
$("#login").on("click",function (e) {
    var email=jbit.util.validator.email;
    var mobile=jbit.util.validator.mobile;
    var password=jbit.util.validator.account;
    var name=$("#username").val();
    var pd=$("#password").val();
    var lc = $("#verify_input").val();
    var flage=true;
    function showErrorMess(ms) {
        flage=false;
        showTips.html(ms);
        showMessage.show();
    }
    if(name==""||name==null){
        showErrorMess("用户名不能为空！");
        return;
    }if(pd==""||pd==null){
        showErrorMess("密码不能为空！");
        return;
    }

    if(!(email(name).code||mobile(name).code)){
        showErrorMess("请输入有效的手机号码或邮箱");
        return;

    }
    if(!password(pd).code){
        showErrorMess("请输入正确的密码");
        return;
    }
    var isLc=false;
    $("#selectShowType input[type=radio]").each(function (i, item) {
       if(this.checked){//当选择的是第一个的时候  islc就等于true
           if(this.value==1){
               isLc=true
           }
       }
    });
    if(isLc){
        if(lc==""||lc==null){
            showErrorMess("请输入验证码");
            return;
        }
        if(flage){//当我点击登陆的时候进行判断  当判断条件全部不成立的时候flag才是true才可以走到这里面  当我输入的东西全部是正确的时候 才可以进行登录
            showMessage.hide();
            if(verify) {//判断  当我验证码输入正确的时候才可以走这里  在那边会显示验证码错误  只要那边显示验证码错误 那边给verify的值就是false 只要是false就走不进这个里面  所以必须那边显示的是验证码正确  就会给verify一个true的值  这样 才可以走到这个if里面 进行登陆
                var name = $("#username").val();
                var pwd = $("#password").val();
                window.location.href="/itrip/loginUser?name="+name+"&pwd="+pwd;
            }
        }
    }
})
$("#selectShowType input[type=radio]").on("change",function (e) {
    if(this.value==1){
        $("#actionPass").hide();
        $("#staticPass").show();
    }else{
        $("#actionPass").show();
        $("#staticPass").hide();
    }
});
$(".right-erweima").on("click",function (e) {
    var sef=$(this);
    if(sef.hasClass("dian-nao")){
        clearTimeout(window.phone);
        clearTimeout(window.richScan);
        $("#staticOption").show();
        $("#actionOption").hide();
        sef.removeClass("dian-nao");
        $(".phone-richScan").hide();

    }else{
        sef.addClass("dian-nao");
        $("#staticOption").hide();
        $("#actionOption").show();
        movePhone(0);
    }
});
function movePhone(ml) {
    if(!(ml==200)){
        window.phone=setTimeout(function (e) {
            movePhone(ml+1)
        },0.1)
    }else{
        $(".phone-richScan").show();
        moveRichScan(0)
    }
    $(".phone-erweima").css("left",-ml)
}function moveRichScan(ml) {
    if(!(ml==131)){
        window.richScan=setTimeout(function (e) {
            moveRichScan(ml+1)
        },1)
    }
    $(".phone-richScan").css("left",-ml)
}