<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#article").datagrid({
            url:"${pageContext.request.contextPath}/article/showAll",
            fit:true,
            height:400,
            fitColumns:true,
            pagination:true,
            pageList:[2,4,6,8,10],
            pageSize:2,
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:openSaveArt,
            }],
            columns:[[
                {title:"id",field:"id",width:100},
                {title:"文章名",field:'title',width:100},
                {title:"封面",field:"imgPath",width:100,height:10},
                {title:"内容",field:"content",width:100},
                {title:"发布时间",field:"publishTime",width:100},
                {title:"操作",field:"options",width:100,
                    formatter:function(value,row,index){
                        return  "<a href='javascript:;' class='option' onclick=\"delArt('"+row.id+"')\" data-options='iconCls:\"icon-remove\"'>删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='option' onclick='openupdateArt()' data-options='iconCls:\"icon-edit\"'>修改</a>"
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
                    '<p>文章名: ' + rowData.title + '</p>' +
                    '<p>内容: ' + rowData.content + '</p>' +
                    '<p>发布时间: ' + rowData.publishTime + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })
    
    function delArt(id){
        $.post("${pageContext.request.contextPath}/article/delete",{"id":id},function(){
            $("#article").datagrid('reload');
        });
    }
    
    function openSaveArt(){
        $("#addArticle").dialog({
            width:500,
            height:360,
            iconCls:'icon-save',
            title:'添加文章',
            href:'${pageContext.request.contextPath}/back/guru/addArt.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $("#saveArtForm").form('submit',{
                        url:'${pageContext.request.contextPath}/article/save',
                        success:function(result){
                            $.messager.show({
                                title:'提示',
                                msg:'添加成功',
                            });
                            $("#addArticle").dialog('close');
                            $("#article").datagrid('reload');
                        }
                    })
                }
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    $("#addArticle").dialog('close');
                }
            }],
            
        });
    }
    
    function openupdateArt(){
        alert('文章乃上师所著，不可随意修改！！！');
    }
</script>
<table id="article"></table>
<div id="addArticle"></div>
<div id="updateArticle"></div>
