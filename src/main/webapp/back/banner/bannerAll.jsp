<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#bann").edatagrid({
            url:"${pageContext.request.contextPath}/banner/showAll",
            fit:true,
            height:400,
            singleSelect:true,
            fitColumns:true,
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:openSaveBann,
            }],
            columns:[[
                {title:"id",field:"id",width:100},
                {title:"图片",field:"imgPath",width:100,height:10},
                {title:"描述",field:"title",width:100},
                {title:"状态",field:"status",width:100,editor:'text'},
                {title:"上传时间",field:"addDate",width:100},
                {title:"操作",field:"options",width:100,
                    formatter:function(value,row,index){
                        return  "<a href='javascript:;' class='option' onclick=\"delBann('"+row.id+"')\" data-options='iconCls:\"icon-remove\"'>删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='option' onclick=\"openupLoadBann('"+row.id+"')\" data-options='iconCls:\"icon-edit\"'>更新</a>"
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
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgPath + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.title + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '<p>上传时间: ' + rowData.addDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })
    
    function openSaveBann(){
        $("#addBan").dialog({
            width:500,
            height:300,
            title:'数据上传',
            href:'${pageContext.request.contextPath}/back/banner/addBann.jsp',
            buttons:[{
                text:'上传',
                iconCls:'icon-ok',
                handler:function(){
                    $("#addBannForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/file',
                        success:function(){
                            $.messager.show({
                                title:'提示',
                                msg:'上传成功',
                            });
                            $("#addBan").dialog('close');
                            $("#bann").datagrid('reload')
                        }
                    })
                },
            },{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#addBan").dialog('close');
                }
            }],
        });
    }
    
    function delBann(id){
        $.post("${pageContext.request.contextPath}/banner/delete",{"id":id},function(){
            $("#bann").datagrid('reload');
        })
    }
    
    function openupLoadBann(id){
        $("#upLoad").dialog({
            width:500,
            height:300,
            href:'${pageContext.request.contextPath}/back/banner/upLoadBann.jsp?id='+id,
            title:'更新',
            iconCls:'icon-edit',
            buttons:[{
                text:'更新',
                iconCls:'icon-edit',
                handler:function(){
                    $("#upLoadBannForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/upLoadBann',
                        success:function(){
                            $.messager.show({
                                title:'提示',
                                msg:'更新成功',
                            });
                            $("#upLoad").dialog('close');
                            $("#bann").datagrid('reload');
                        }
                    });
                }
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    //关闭对话框
                    $("#upLoad").dialog('close');
                }
            }],
        });
    }
</script>
<table id="bann"></table>
<div id="addBan"></div>
<div id="upLoad"></div>
