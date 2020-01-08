var cacheStr = window.sessionStorage.getItem("cache"),
    oneLoginStr = window.sessionStorage.getItem("oneLogin");
layui.use(['form','jquery','layer','colorpicker'],function() {
    var form = layui.form, colorpicker = layui.colorpicker,
        $ = layui.jquery,
        layer = parent.layer === undefined ? layui.layer : top.layer;

    //判断是否web端打开
    if(!/http(s*):\/\//.test(location.href)){
        layer.alert("请先将项目部署到 localhost 下再进行访问【建议通过tomcat、webstorm、hb等方式运行，不建议通过iis方式运行】，否则部分数据将无法显示");
    }else{    //判断是否处于锁屏状态【如果关闭以后则未关闭浏览器之前不再显示】
        if(window.sessionStorage.getItem("lockcms") !== "true"){
        }
    }

    //判断是否设置过头像，如果设置过则修改顶部、左侧和个人资料中的头像，否则使用默认头像
    if(window.sessionStorage.getItem('userFace') &&  $(".userAvatar").length > 0){
        $("#userFace").attr("src",window.sessionStorage.getItem('userFace'));
        $(".userAvatar").attr("src",$(".userAvatar").attr("src").split("images/")[0] + "images/" + window.sessionStorage.getItem('userFace').split("images/")[1]);
    }else{
        $("#userFace").attr("src","../../images/face.jpg");
    }

    //锁屏
    function lockPage(){
        layer.open({
            title : false,
            type : 1,
            content : '<div class="admin-header-lock" id="lock-box">'+
                            '<div class="admin-header-lock-img"><img src="images/face.jpg" class="userAvatar"/></div>'+
                            '<div class="admin-header-lock-name" id="lockUserName">管理员</div>'+
                            '<div class="input_btn">'+
                                '<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />'+
                                '<button class="layui-btn" id="unlock">解锁</button>'+
                            '</div>'+
                            '<p>页面已锁定，请输入“123456”解锁。</p>'+
                        '</div>',
            closeBtn : 0,
            shade : 0.9,
            success : function(){
                //判断是否设置过头像，如果设置过则修改顶部、左侧和个人资料中的头像，否则使用默认头像
                if(window.sessionStorage.getItem('userFace') &&  $(".userAvatar").length > 0){
                    $(".userAvatar").attr("src",$(".userAvatar").attr("src").split("images/")[0] + "images/" + window.sessionStorage.getItem('userFace').split("images/")[1]);
                }
            }
        });
        $(".admin-header-lock-input").focus();
    }
    //触发锁屏
    $(".lockcms").on("click",function(){
        // window.sessionStorage.setItem("lockcms",true);
        window.localStorage.setItem("lockcms",true);
        lockPage();
    });
    // 判断是否显示锁屏
    // if(window.sessionStorage.getItem("lockcms") === "true"){
    if(window.localStorage.getItem("lockcms") === "true"){
        lockPage();
    }
    // 解锁
    $("body").on("click","#unlock",function(){
        var thisEle = this;
        if($(thisEle).siblings(".admin-header-lock-input").val() === ''){
            layer.msg("请输入密码解锁", {anim:6});
            $(thisEle).siblings(".admin-header-lock-input").focus();
        }else{
            $(thisEle).addClass("layui-btn-disabled").prop("disabled", true).text("解锁中…");
            setTimeout(function () {
                if($(thisEle).siblings(".admin-header-lock-input").val() === "123456"){
                    // window.sessionStorage.setItem("lockcms",false);
                    window.localStorage.setItem("lockcms",false);
                    $(thisEle).siblings(".admin-header-lock-input").val('');
                    layer.closeAll("page");
                    layer.msg("解锁成功");
                }else{
                    layer.msg("密码错误，请重新输入密码。", {anim:6});
                    $(thisEle).siblings(".admin-header-lock-input").val('').focus();
                }
                $(thisEle).removeClass("layui-btn-disabled").prop("disabled", false).text("解锁");
            },500);
        }
    });

    //锁屏页面回车
    $(document).on('keydown', function(event) {
        var event = event || window.event;
        if(event.keyCode === 13) {
            $("#unlock").click();
        }
    });

    //退出登录
    $(".signOut").click(function(){
        window.sessionStorage.removeItem("menu");
        menu = [];
        window.sessionStorage.removeItem("curmenu");
    });

    //功能设定
    $(".functionSetting").click(function(){
        layer.open({
            title: "功能设定",
            area: ["380px", "280px"],
            type: "1",
            content :  '<div class="functionSrtting_box">'+
                            '<form class="layui-form">'+
                                '<div class="layui-form-item">'+
                                    '<label class="layui-form-label">开启Tab缓存</label>'+
                                    '<div class="layui-input-block">'+
                                        '<input type="checkbox" name="cache" lay-skin="switch" lay-text="开|关">'+
                                        '<div class="layui-word-aux">开启后刷新页面不关闭打开的Tab页</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="layui-form-item">'+
                                    '<label class="layui-form-label">Tab切换刷新</label>'+
                                    '<div class="layui-input-block">'+
                                        '<input type="checkbox" name="changeRefresh" lay-skin="switch" lay-text="开|关">'+
                                        '<div class="layui-word-aux">开启后切换窗口刷新当前页面</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="layui-form-item">'+
                                    '<label class="layui-form-label">单一登陆</label>'+
                                    '<div class="layui-input-block">'+
                                        '<input type="checkbox" name="oneLogin" lay-filter="multipleLogin" lay-skin="switch" lay-text="是|否">'+
                                        '<div class="layui-word-aux">开启后不可同时多个地方登录</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="layui-form-item skinBtn">'+
                                    '<a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="settingSuccess">设定完成</a>'+
                                    '<a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-primary" lay-submit="" lay-filter="noSetting">朕再想想</a>'+
                                '</div>'+
                            '</form>'+
                        '</div>',
            success : function(index, layero){
                //如果之前设置过，则设置它的值
                $(".functionSrtting_box input[name=cache]").prop("checked",cacheStr=="true" ? true : false);
                $(".functionSrtting_box input[name=changeRefresh]").prop("checked",changeRefreshStr=="true" ? true : false);
                $(".functionSrtting_box input[name=oneLogin]").prop("checked",oneLoginStr=="true" ? true : false);
                //设定
                form.on("submit(settingSuccess)",function(data){
                    window.sessionStorage.setItem("cache",data.field.cache=="on" ? "true" : "false");
                    window.sessionStorage.setItem("changeRefresh",data.field.changeRefresh=="on" ? "true" : "false");
                    window.sessionStorage.setItem("oneLogin",data.field.oneLogin=="on" ? "true" : "false");
                    window.sessionStorage.removeItem("menu");
                    window.sessionStorage.removeItem("curmenu");
                    location.reload();
                    return false;
                });
                //取消设定
                form.on("submit(noSetting)",function(){
                    layer.closeAll("page");
                });
                //单一登陆提示
                form.on('switch(multipleLogin)', function(data){
                    layer.tips('温馨提示：此功能需要开发配合，所以没有功能演示，敬请谅解', data.othis,{tips: 1})
                });
                form.render();  //表单渲染
            }
        })
    });

    //判断是否修改过系统基本设置，去显示底部版权信息
    if(window.sessionStorage.getItem("systemParameter")){
        systemParameter = JSON.parse(window.sessionStorage.getItem("systemParameter"));
        $(".footer p span").text(systemParameter.powerby);
    }

    //更换皮肤
    function skins() {
        var skin = window.localStorage.getItem("skin");
        if (skin) {  //如果更换过皮肤
            if (window.localStorage.getItem("skinValue") !== "自定义") {
                $("body").addClass(window.localStorage.getItem("skin"));
            } else {
                $(".layui-layout-admin .layui-header").css("cssText", "background-color:" + skin.split(',')[0] + " !important");
                $(".layui-bg-black").css("cssText", "background-color:" + skin.split(',')[1] + " !important");
                $(".hideMenu").css("cssText", "background-color:" + skin.split(',')[2] + " !important");
            }
        }
    }

    skins();
    //更换皮肤
    $(".changeSkin").click(function () {
        layer.open({
            title: "更换皮肤",
            area: ["375px", "250px"],
            type: "1",
            content: '<div class="skins_box">' +
                        '<form class="layui-form">' +
                            '<div class="layui-form-item">' +
                                '<input type="radio" name="skin" value="默认" title="默认" lay-filter="default" checked>' +
                                '<input type="radio" name="skin" value="橙色" title="橙色" lay-filter="orange">' +
                                '<input type="radio" name="skin" value="蓝色" title="蓝色" lay-filter="blue">' +
                                '<input type="radio" name="skin" value="自定义" title="自定义" lay-filter="custom">' +
                                '<div class="skinCustom layui-input-inline">' +
                                    '<input type="text" class="layui-input topColor" name="topSkin" placeholder="顶部颜色"/><span id="topSkin-form"></span>' +
                                '</div>' +
                                '<div class="skinCustom layui-input-inline">' +
                                    '<input type="text" class="layui-input leftColor" name="leftSkin" placeholder="左侧颜色"/><span id="leftSkin-form"></span>' +
                                '</div>' +
                            '</div>' +
                            '<div class="layui-form-item skinBtn">' +
                                '<a href="javascript:void(0)" class="layui-btn layui-btn-sm layui-btn-normal" lay-submit lay-filter="changeSkin">确定更换</a>' +
                                '<a href="javascript:void(0)" class="layui-btn layui-btn-sm layui-btn-primary" lay-submit lay-filter="noChangeSkin">我再想想</a>' +
                            '</div>' +
                        '</form>' +
                    '</div>',
            success: function (index, layero) {
                colorpicker.render({
                    elem: '#topSkin-form'
                    , color: '#000'
                    , done: function (color) {
                        $('.topColor,.menuColor').val(color);
                        $('.topColor,.menuColor').blur();
                    }
                    , alpha: true
                    , predefine: true
                });
                colorpicker.render({
                    elem: '#leftSkin-form'
                    , color: '#000'
                    , done: function (color) {
                        $('.leftColor').val(color);
                        $('.leftColor').blur();
                    }
                    , alpha: true
                    , predefine: true
                });

                var skin = window.localStorage.getItem("skin");
                if (window.localStorage.getItem("skinValue")) {
                    $(".skins_box input[value=" + window.localStorage.getItem("skinValue") + "]").attr("checked", "checked");
                }
                if ($(".skins_box input[value=自定义]").attr("checked")) {
                    $(".skinCustom").css("visibility", "inherit");
                    $(".topColor").val(skin.split(',')[0]);
                    $(".leftColor").val(skin.split(',')[1]);
                    $(".menuColor").val(skin.split(',')[2]);
                }
                form.render();
                $(".skins_box").removeClass("layui-hide");
                $(".skins_box .layui-form-radio").on("click", function () {
                    var skinColor;
                    if ($(this).find("div").text() === "橙色") {
                        skinColor = "orange";
                    } else if ($(this).find("div").text() === "蓝色") {
                        skinColor = "blue";
                    } else if ($(this).find("div").text() === "默认") {
                        skinColor = "";
                    }
                    if ($(this).find("div").text() !== "自定义") {
                        $(".topColor,.leftColor,.menuColor").val('');
                        $("body").removeAttr("class").addClass("main_body " + skinColor + "");
                        $(".skinCustom").removeAttr("style");
                        $(".layui-bg-black,.hideMenu,.layui-layout-admin .layui-header").removeAttr("style");
                    } else {
                        $(".skinCustom").css("visibility", "inherit");
                    }
                });
                var skinStr, skinColor;
                $(".topColor").focus(function () {
                    layer.open({
                        type: 4,
                        content: ['请输入[十六进制颜色码]或者颜色的[英文单词]', this]
                        , shade: 0
                        , closeBtn: 0
                        , time: 5000
                    });
                }).blur(function () {
                    layer.closeAll('tips');
                    $(".layui-layout-admin .layui-header").css("cssText", "background-color:" + $(this).val() + " !important");
                    $(".hideMenu").css("cssText", "background-color:" + $(this).val() + " !important");
                });
                $(".leftColor").focus(function () {
                    layer.open({
                        type: 4,
                        content: ['请输入[十六进制颜色码]或者颜色的[英文单词]', this]
                        , shade: 0
                        , closeBtn: 0
                        , time: 5000
                    });
                }).blur(function () {
                    layer.closeAll('tips');
                    $(".layui-bg-black").css("cssText", "background-color:" + $(this).val() + " !important");
                });
                form.on("submit(changeSkin)", function (data) {
                    if (data.field.skin !== "自定义") {
                        if (data.field.skin === "橙色") {
                            skinColor = "orange";
                        } else if (data.field.skin === "蓝色") {
                            skinColor = "blue";
                        } else if (data.field.skin === "默认") {
                            skinColor = "";
                        }
                        window.localStorage.setItem("skin", skinColor);
                    } else {
                        skinStr = $(".topColor").val() + ',' + $(".leftColor").val() + ',' + $(".menuColor").val();
                        window.localStorage.setItem("skin", skinStr);
                        $("body").removeAttr("class").addClass("main_body");
                    }
                    window.localStorage.setItem("skinValue", data.field.skin);
                    layer.closeAll("page");
                    layer.msg("换肤成功");
                });
                form.on("submit(noChangeSkin)", function () {
                    $("body").removeAttr("class").addClass("main_body " + window.localStorage.getItem("skin") + "");
                    $(".layui-bg-black,.hideMenu,.layui-layout-admin .layui-header").removeAttr("style");
                    skins();
                    layer.closeAll("page");
                    layer.msg("取消换肤");
                });
            },
            cancel: function () {
                $("body").removeAttr("class").addClass("main_body " + window.localStorage.getItem("skin") + "");
                $(".layui-bg-black,.hideMenu,.layui-layout-admin .layui-header").removeAttr("style");
                skins();
            }
        })
    });
});
