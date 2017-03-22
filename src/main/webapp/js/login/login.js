

$(function(){
    showCode(true);

    $('#log-cacct').focus(function(){
        checkFocus( 'log-cacct' );
    }).blur(function(){
        var acctVal = $(this).val().replace(/\s+/g, '');
        $(this).val(acctVal);
        checkFocus( 'log-cacct' );
    }).keydown(function(event){
        checkFocus( 'log-cacct' );
        if( event.keyCode == 13 ){
            var acctVal = $(this).val().replace(/\s+/g, '');
            $(this).val(acctVal);
            login();
        }
    }).keyup(function(){
        checkFocus( 'log-cacct' );
    })

    $('#log-pwd').focus(function(){
        checkFocus( 'log-pwd' );
    }).blur(function(){
        checkFocus( 'log-pwd' );
    }).keydown(function(event){
        checkFocus( 'log-pwd' );
        if( event.keyCode == 13 ){
            login();
        }
    }).keyup(function(){
        checkFocus( 'log-pwd' );
    })

    $('#log-valid').focus(function(){
        checkFocus( 'log-valid' );
    }).blur(function(){
        checkFocus( 'log-valid' );
    }).keydown(function(event){
        checkFocus( 'log-valid' );
        if( event.keyCode == 13 ){
            login();
        }
    }).keyup(function(){
        checkFocus( 'log-valid' );
    })

    $('#log-valid-img, #log-refresh-btn').click( changeValidImg )
    // $('#login-button').click(function(){
    //     login();
    // });
    $('#login-button').hover(function(){
        $(this).addClass("loginBtn-hover");
    }, function(){
        $(this).removeClass("loginBtn-hover");
    });

    $('#reg-button').hover(function(){
        $(this).addClass("regBtn-hover");
    }, function(){
        $(this).removeClass("regBtn-hover");
    });

    //IE(除了IE11)，底层的灰色提示标签会被触发focus，反而顶层输入框获取不到焦点，这里特殊处理转移焦点
    //因为IE给元素设置了绝对定位和z-index，若顶层元素是透明而底层元素非透明，还是会默认底层非透明的元素在上层（可以给底层输入框加背景颜色试试就知，加了不做以下的焦点转移也可以正常获取焦点）
    if(Fai.isIE()){
        $('.log-line .log-txt').click(function(){
            $(this).siblings('.log-input').focus();
        });
    }
    if ( Fai.isIE7() || Fai.isIE8()){	//IE7/8隐藏我们自定义的checkbox样式，会错位
        $('.goin .checkItemLabel').hide();
    }

    checkFocus( 'log-cacct' );
    checkFocus( 'log-pwd' );
    checkFocus( 'log-valid' );

    setTimeout(autoFocus, 50);
});

//自动获取输入框焦点
function autoFocus(){
    $('#log-cacct, #log-sacct, #log-pwd').filter(':visible').each(function(){
        var $this = $(this);
        if($this.val() == ''){
            $this.focus();
            checkFocus($this.attr('id'));
            return false;
        }
    });
}

function checkFocus( id ){
    var input = $('#' + id),
        val = input.val();
    if (id != "log-pwd"){
        val = $.trim(val);
    }
    $('#log-form').find('input.log-input').removeClass('input1');
    var txt = input.parent().children('.log-txt');
    $('.log-txt').removeClass("log-txt-hover");
    txt.addClass('log-txt-hover');
    $('.log-line').removeClass("log-line-hover");
    if ( id != "log-valid" ){
        input.parent().addClass("log-line-hover");
    }
    if( val == '' ){
        txt.show();
    }else{
        txt.hide();
    }
}
// $('#log-valid-img').bind('click',showCode(true));
function genTimestamp() {
    var time = new Date();
    return time.getTime();
}
function showCode( needCode ){
    var login_line = $('#log-valid-line');
    if( needCode ){
        login_line.show();
        $('#log-valid').val('').focus();
        $('#log-valid-img').attr( 'src', 'code?t=' + genTimestamp() );
    }else{
        login_line.hide();
    }
}

function changeValidImg(){
    showCode( true );
}
function login(){
    var me = $('#login-button');
    if( me.hasClass('disabled') ){
        return;
    }
    var username = $('#log-cacct').val();
    var password = $('#log-pwd').val();
    var code = $('#log-valid').val();
    if( !username ){
        showMsg( '请输入帐号' );
        $('#log-cacct').focus();
        return false;
    }
    if( !password ){
        showMsg( '请输入密码' );
        $('#log-pwd').focus();
        return false;
    }
    if( !code ){
        showMsg( '请输入验证码' )
        $('#log-valid').focus();
        return false;
    }
    me.addClass( 'disabled' ).html('正在登录...');
    showMsg('');
}

function showMsg(msg){
    $('#error').text( msg ).show();
    if($.trim(msg) == '' || msg == null){
        $('#error').hide();
    }
}

