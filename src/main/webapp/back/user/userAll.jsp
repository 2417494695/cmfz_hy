<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#userTab").edatagrid({
            url:"${pageContext.request.contextPath}/user/showAll",
            fit:true,
            height:400,
            singleSelect:true,
            fitColumns:true,
            columns:[[
                {title:'id',field:'id',width:100},
                {title:'用户名',field:'username',width:100},
                {title:'法名',field:'nickName',width:100},
                {title:'性别',field:'gender',width:100},
                {title:'生日',field:'bir',width:100},
                {title:'手机',field:'phone',width:100},
                {title:'省份',field:'province',width:100},
                {title:'城市',field:'city',width:100},
                {title:'头像',field:'headPic',width:100},
                {title:'状态',field:'status',width:100},

            ]],
            
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.headPic + '" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>用户名: ' + rowData.username + '</p>' +
                    '<p>法名: ' + rowData.nickName + '</p>' +
                    '<p>性别: ' + rowData.gender + '</p>' +
                    '<p>省份: ' + rowData.province + '</p>' +
                    '<p>城市: ' + rowData.city + '</p>' +
                    '<p>头像: ' + rowData.headPic + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })
</script>
<table id="userTab"></table>
