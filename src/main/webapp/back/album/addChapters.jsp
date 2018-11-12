<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8" %>

<script>
    $(function(){
        $("#albumId").combobox({
            url:'${pageContext.request.contextPath}/album/showAll',
            valueField:'id',
            textField:'title',
            limitToList:true,
            panelMaxHeight:100,
            editable:false,
            width:170,
        });
    })
</script>
<div style="text-align: center">
    <form class="easyui-form" enctype="multipart/form-data" method="post" id="saveChaptForm">
        <div style="margin-top:50px;">
            <div style="margin-top: 20px;">
                文&nbsp;&nbsp;件&nbsp;&nbsp;名：<input class="easyui-filebox" name="mp3" data-options="required:true,validType:'audio',">
            </div>
            <div style="margin-top: 20px;">
                所属专辑：<select name="album_id" id="albumId" data-options="required:true"></select>
            </div>
        </div>
    </form>
</div>
