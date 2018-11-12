<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#upLoadBannForm").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
    })
</script>
<div>
    <form id="upLoadBannForm" enctype="multipart/form-data" method="post">
        <div style="text-align: center;margin-top: 50px;">
            <div>
                <input type="hidden" class="easyui-textbox" value="${param.id}" name="id">
            </div>
            <%--<div style="margin-top: 25px;">
                文件：<input class="easyui-filebox" name="imgPath" value=" ">
            </div>--%>
            <div style="margin-top: 25px;">
                描述：<input class="easyui-textbox" name="title">
            </div>
            <div style="margin-top:25px;">
                状态：<input class="easyui-textbox" name="status">
            </div>
        </div>
    </form>
</div>