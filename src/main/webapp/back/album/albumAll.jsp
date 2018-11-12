<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
            $("#alb").treegrid({
                url:'${pageContext.request.contextPath}/album/showPage',
                idField:'id',
                treeField:'title',
                height:400,
                fitColumns:true,
                animate:true,
                pagination:true,
                pageSize:20,
                pageList:[20,30,40,50],
                toolbar:[{
                    text:'添加专辑',
                    iconCls:'icon-add',
                    handler:openSaveAlbum,
                },{
                    text:'添加章节',
                    iconCls:'icon-add',
                    handler:openSaveChapt,
                }],
                columns:[[
                    {title:'专辑|章节',field:'title'},
                    {title:'作者',field:'author'},
                    {title:'大小',field:'size'},
                    {title:'时长',field:'duration'},
                    {title:'下载路径',field:'downUrl'},
                    {title:'简介',field:'brief',width:200},
                    {title:'操作',field:'options',width:100,
                        formatter:function(value,row,index){
                        if(row.duration in window) return "";
                           return " <a href='javascript:;' class='options' onclick=\"delChapter('"+row.id+"')\" data-options='iconCls:\"icon-remove\"'>删除</a>&nbsp;&nbsp;" +
                               "<a href='${pageContext.request.contextPath}/chpater/downLoad?fileName="+row.title+"' class='options' data-options='iconCls:\"icon-search\"'>下载</a>"
                        }
                    },
                ]],
                onLoadSuccess:function() {
                    $(".options").linkbutton({
                        plain:true,
                    });
                }
            })
        })
    
    
    /*删除*/
    function delChapter(id) {
        alert(id);
        $.post('${pageContext.request.contextPath}/chpater/delete',{"id":id},function(){
            $("#alb").treegrid('reload');
        });
    }
    
    
    //添加专辑
    function openSaveAlbum() {
        $("#addAlbum").dialog({
            width:500,
            height:450,
            title:'添加专辑',
            href:'${pageContext.request.contextPath}/back/album/addAlbum.jsp',
            iconCls:'icon-save',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $("#saveAlbumForm").form('submit',{
                        url:'${pageContext.request.contextPath}/album/addAlbum',
                        success:function(){
                            $.messager.show({
                                title:'提示',
                                msg:'添加成功',
                            });
                            $("#addAlbum").dialog('close');
                            $("#alb").treegrid('reload');
                        }
                    })
                }
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    $("#addAlbum").dialog('close');
                }
            }],
        });
    }
    //添加章节
    function openSaveChapt() {
        $("#addChapt").dialog({
            width:400,
            height:280,
            title:'添加章节',
            iconCls:'icon-save',
            href:'${pageContext.request.contextPath}/back/album/addChapters.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $("#saveChaptForm").form('submit',{
                        url:'${pageContext.request.contextPath}/chpater/saveChpater',
                        success:function() {
                            $.messager.show({
                                title: '提示',
                                msg: '上传成功',
                            });
                            $("#addChapt").dialog('close');
                            $("#alb").treegrid('reload');
                        }
                    })
                }
            },{
                text:'取消',
                iconCls:'icon-no',
                handler:function(){
                    $("#addChapt").dialog('close');
                }
            }],
        });
    }
    
</script>
<table id="alb"></table>
<div id="addAlbum"></div>
<div id="addChapt"></div>
