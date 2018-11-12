<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#chap").datagrid({
            url:"${pageContext.request.contextPath}/chpater/showAll",
            fit:true,
            height:400,
            fitColumns:true,
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:openSavechapter,
            }],
            columns:[[
                {title:"id",field:"id",width:100},
                {title:"章节名",field:"title",width:100},
                {title:"章节大小",field:"size",width:100},
                {title:"时长",field:"duration",width:100},
                {title:"下载路径",field:"downUrl",width:100},
                {title:"专辑id",field:"album_id",width:100},
                {title:"操作",field:'options',width:100,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' class='option' onclick=\"delChapt('"+row.id+"')\" data-options=\"iconCls:'icon-remove'\">删除</a>"
                    }
                }
            ]],
            onLoadSuccess:function(){
                $(".option").linkbutton({
                    plain:true,
                })
            }
        })
    })
    function openSavechapter(){
        alert('此处只做展示');
    }
    
    function delChapt(id){
        $.post('${pageContext.request.contextPath}/chpater/delete',{"id":id},function(){
            $("#chap").datagrid('reload');
        })
    }
</script>
<table id="chap"></table>
<div id="addChapter"></div>
