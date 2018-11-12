<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>

<script>
    $(function(){
        $("#guruId").combobox({
            width:170,
            url:'${pageContext.request.contextPath}/guru/findAll',
            valueField:'id',
            textField:'name',
            limitToList:true,
            panelMaxHeight:100,
            editable:false,
        })
    })
</script>
<div style="text-align: center">
    <form enctype="multipart/form-data" method="post" class="easyui-form" id="saveArtForm">
        <div style="margin-top: 50px;">
            <div style="margin-top: 25px;">
                文&nbsp;章&nbsp;名：<input type="text" class="easyui-textbox" name="title">
            </div>
            <div style="margin-top: 25px;">
                封&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面：<input type="text" class="easyui-filebox" name="file">
            </div>
            <div style="margin-top: 25px;">
                内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：<input type="text" class="easyui-textbox" name="content">
            </div>
            <div style="margin-top: 25px;">
                所属上师：
                <select id="guruId" name="guru_id" data-options="required:true"></select>
            </div>
        </div>
    </form>
</div>
