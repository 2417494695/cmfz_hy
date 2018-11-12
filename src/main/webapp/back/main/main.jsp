<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/bootstrap/easyui.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">   
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>   
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.etree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.etree.lang.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/form.validator.rules.js"></script>
<script type="text/javascript">
	$(function(){
        $.post("${pageContext.request.contextPath}/menu/showAll",function(menu){
            if(menu=="error"){
                location='${pageContext.request.contextPath}/back/login.jsp';
            }
        })
	    $.post("${pageContext.request.contextPath}/menu/showAll",function(menu){
            $.each(menu,function(index,men){
                var content="<div style='text-align:center;'>";
                $.each(men.menus,function(idx,m){
                    content+="<a onclick=\"showMenu('"+m.name+"','"+m.iconCls+"','"+m.href+"')\" " +
                        "style='width:90%;margin-top:10px;border:1px solid #70B8E9;' " +
                        "class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+m.iconCls+"',\">"+m.name+"</a>";
                })
                content+="</div>";
                $("#aa").accordion('add',{
                    title:men.name,
                    iconCls:men.iconCls,
                    content:content,
                });
            })
        });
    })
    
    function showMenu(name,iconCls,href){
	    if(name=="计数器"){
	        $("#count").dialog({
                width:200,
                height:60,
                style:{top:10},
                title:'提示',
                content:'没有计数器。',
            })
        }
	    //判断name是否存在
	    if(!$("#tt").tabs('exists',name)){
	        //不存在，添加
            $("#tt").tabs('add',{
                title:name,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:'${pageContext.request.contextPath}/'+href,
            })
        }else{
            $("#tt").tabs('select',name);
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true,href:'${pageContext.request.contextPath}/back/main/head.jsp'" style="height:60px;background-color:  #5C160C"></div>   
    
    <div data-options="region:'south',split:true,href:'${pageContext.request.contextPath}/back/main/footer.jsp'" style="height: 40px;background: #5C160C"></div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true"></div>  
    </div>   
    
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-save'" 
                 style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);
                       background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
<div id="count" style="text-align: center;margin-top: 10px;"></div>
</body> 
</html>