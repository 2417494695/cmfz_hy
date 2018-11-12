<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 330px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="javascript:;" onclick="updatePassword('${sessionScope.admin.id}','${sessionScope.admin.password}')" class="easyui-linkbutton" 
     data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/admin/off" class="easyui-linkbutton" 
       data-options="iconCls:'icon-no'">退出系统</a></div>
<script>
    function updatePassword(id,password) {
        $("#updatePwd").dialog({
            title:'修改密码',
            iconCls:'icon-edit',
            width:400,
            height:250,
            href:'${pageContext.request.contextPath}/back/main/updatePassword.jsp',
            buttons:[{
                text:'修改',
                iconCls:'icon-edit',
                handler:function(){
                    $("#editpwd").form('submit',{
                        url:'${pageContext.request.contextPath}/admin/update',
                        success:function(result){
                            $.messager.show({
                                title:'提示',
                                msg:result,
                            })
                            $("#updatePwd").dialog('close');
                        }
                    })
                },
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    $("#updatePwd").dialog('close');
                }
            }],
        });
    }
</script>



<div id="updatePwd"></div>