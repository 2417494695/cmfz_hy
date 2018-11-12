<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#guru").datagrid({
            url:"${pageContext.request.contextPath}/guru/showAll",
            fit:true,
            height:400,
            fitColumns:true,
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:openSaveGuru,
            }],
            columns:[[
                {title:"id",field:"id",width:100},
                {title:"头像",field:"headPic",width:100,height:10},
                {title:"上师名",field:"name",width:100},
                {title:"状态",field:"status",width:100},
                {title:"操作",field:"options",width:100,
                    formatter:function(value,row,index){
                        return  "<a href='javascript:;' class='option' onclick=\"delGuru('"+row.id+"')\" data-options='iconCls:\"icon-remove\"'>删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='option' onclick=\"openupdateGuru('"+row.id+"')\" data-options='iconCls:\"icon-edit\"'>修改</a>"
                    }
                },
                
            ]],
            onLoadSuccess:function(){
                $(".option").linkbutton({
                    plain:true,
                })
            },
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.headPic + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>上师名: ' + rowData.name + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })
    
    function delGuru(id){
        $.post('${pageContext.request.contextPath}/guru/delete',{"id":id},function(){
            $("#guru").datagrid('reload');
        });
    }
    
    function openSaveGuru(){
        $("#addGuru").dialog({
            width:500,
            height:300,
            title:'添加上师信息',
            iconCls:'icon-save',
            href:'${pageContext.request.contextPath}/back/guru/addGuru.jsp',
            buttons:[{
                text:'添加',
                iconCls:'icon-add',
                handler:function(){
                    $("#saveGuruForm").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/addGuru',
                        success:function(){
                            $.messager.show({
                                title:'提示',
                                msg:'添加成功',
                            });
                            $("#addGuru").dialog('close');
                            $("#guru").datagrid('reload');
                        }
                    })
                   
                }
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    $("#addGuru").dialog('close');
                }
            }],
            
        });
    }
</script>
<table id="guru"></table>
<div id="addGuru"></div>
<div id="updateGuru"></div>
