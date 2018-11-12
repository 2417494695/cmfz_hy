<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script>
    $(function(){
        $("#couTab").datagrid({
            url:'${pageContext.request.contextPath}/course/showAll',
            fit:true,
            width:400,
            columns:[[
                {title:'id',field:'id',width:100},
                {title:'功课名',field:'name',width:100},
                {title:'添加时间',field:'createTime',width:100},
                {title:'必|选',field:'flag',width:100},
                {title:'用户id',field:'user_id',width:100},
            ]]
        })
    })
</script>
<table id="couTab"></table>
