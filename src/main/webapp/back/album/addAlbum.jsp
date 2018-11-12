<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<div style="text-align: center">
    <form enctype="multipart/form-data" method="post" id="saveAlbumForm">
        <div style="margin-top:50px;">
            <div style="margin-top: 20px;">
                专辑名：<input class="easyui-textbox" name="title">
            </div>
            <div style="margin-top: 20px;">
                封面：<input class="easyui-filebox" name="file">
            </div>
            <div style="margin-top: 20px;">
                集数：<input class="easyui-textbox" name="count">
            </div>
            <div style="margin-top: 20px;">
                评分：<input class="easyui-textbox" name="score">
            </div>
            <div style="margin-top: 20px;">
                作者：<input class="easyui-textbox" name="author">
            </div>
            <div style="margin-top: 20px;">
                播音：<input class="easyui-textbox" name="broadCast">
            </div>
            <div style="margin-top: 20px;">
                简介：<input class="easyui-textbox" name="brief">
            </div>
        </div>
    </form>
</div>
