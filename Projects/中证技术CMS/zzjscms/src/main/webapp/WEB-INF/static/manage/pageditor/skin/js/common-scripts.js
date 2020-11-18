/*---LEFT BAR ACCORDION----*/
var Script = function () {

//    sidebar dropdown menu auto scrolling

    jQuery('#sidebar .sub-menu > a').click(function () {
        var o = ($(this).offset());
        diff = 250 - o.top;
        if(diff>0)
            $("#sidebar").scrollTo("-="+Math.abs(diff),500);
        else
            $("#sidebar").scrollTo("+="+Math.abs(diff),500);
    });

//    sidebar toggle

    $(function() {
        function responsiveView() {
            var wSize = $(window).width();
            if (wSize <= 768) {
                $('#container').addClass('sidebar-close');
                $('#sidebar > ul').hide();
            }

            if (wSize > 768) {
                $('#container').removeClass('sidebar-close');
                $('#sidebar > ul').show();
            }
        }
        $(window).on('load', responsiveView);
        $(window).on('resize', responsiveView);
    });

    $('.icon-reorder').click(function () {
        if ($('#sidebar > ul').is(":visible") === true) {
            $('#main-content').css({
                'margin-left': '0px'
            });
            $('#sidebar').css({
                'margin-left': '-210px'
            });
            $('#sidebar > ul').hide();
            $("#container").addClass("sidebar-closed");
        } else {
            $('#main-content').css({
                'margin-left': '210px'
            });
            $('#sidebar > ul').show();
            $('#sidebar').css({
                'margin-left': '0'
            });
            $("#container").removeClass("sidebar-closed");
        }
    });

// widget tools

    jQuery('.panel .tools .icon-chevron-down').click(function () {
        var el = jQuery(this).parents(".panel").children(".panel-body");
        if (jQuery(this).hasClass("icon-chevron-down")) {
            jQuery(this).removeClass("icon-chevron-down").addClass("icon-chevron-up");
            el.slideUp(200);
        } else {
            jQuery(this).removeClass("icon-chevron-up").addClass("icon-chevron-down");
            el.slideDown(200);
        }
    });

    jQuery('.panel .tools .icon-remove').click(function () {
        jQuery(this).parents(".panel").parent().remove();
    });


//    tool tips

    $('.tooltips').tooltip();

//    popovers

    $('.popovers').popover();



// custom bar chart

    if ($(".custom-bar-chart")) {
        $(".bar").each(function () {
            var i = $(this).find(".value").html();
            $(this).find(".value").html("");
            $(this).find(".value").animate({
                height: i
            }, 2000);
        });
    }


}();


/**
 * 显示表单的错误提示
 * @param id 表单ID
 * @param errors 错误列表
 */
function showErrors(id,errors){
	id.find('p[class=help-block]').hide();
	id.find('input,select').parent().parent().removeClass("has-error");
	for(var name in errors){
		var e = id.find('p[for='+name+']');
		id.find('input[name='+name+'],select[name='+name+']').parent().parent().addClass("has-error");
		if(e.length==0){
			id.find('input[name='+name+'],select[name='+name+']').after('<p for="'+name+'" class="help-block"></p>');
			e = id.find('p[for='+name+']');
		}
		if(errors[name]!=""){
			e.html(errors[name]);
			e.show();
		}
	}
}

//编码
function html_encode(str)
{
  var s = "";
  if (str.length == 0) return "";
  s = str.replace(/&gt;/g, ">");
  s = s.replace(/&lt;/g, "<");
  s = s.replace(/&gt;/g, ">");
  s = s.replace(/ /g, " ");
  s = s.replace(/\'/g, "'");
  s = s.replace(/\"/g, "\"");
  s = s.replace(/\n/g, "<br>");
  return s;
}

//解码
function html_decode(str)
{
  var s = "";
  if (str.length == 0) return "";
  s = str.replace(/>/g, "&gt;");
  s = s.replace(/</g, "&lt;");
  s = s.replace(/>/g, "&gt;");
  s = s.replace(/ /g, " ");
  s = s.replace(/'/g, "\'");
  s = s.replace(/"/g, "\"");
  s = s.replace(/<br>/g, "\n");
  return s;
}

function html_decode_iframe(str)
{
  var s = "";
  if (str.length == 0) return "";
  s = str.replace(/&gt;/g, ">");
  s = s.replace(/&lt;/g, "<");
  s = s.replace(/&gt;/g, ">");
  s = s.replace(/ /g, " ");
  s = s.replace(/&#39;/g, "'");
  s = s.replace(/&quot;/g, "\"");
  return s;
}

//Html编码获取Html转义实体
function htmlEncode(value){
  return $('<div/>').text(value).html();
}
//Html解码获取Html实体
function htmlDecode(value){
  return $('<div/>').html(value).text();
}
