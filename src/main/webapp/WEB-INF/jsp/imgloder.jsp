<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    图片上传
</head>
<body>

<form action="/upload.do" method="post" enctype="multipart/form-data">
<input type="file" name="file" multiple class="file" accept="image/*">
<img src="" alt="">
    <input type="submit" value="提交"/>
</form>
<c:if test="${code!=null}">
    <h4>图片地址:</h4>
    <textarea cols="20" rows="10" id="biao1">${code}</textarea>
    <input type="button" onClick="copyUrl2()" value="点击复制代码" />
</c:if>
<script>
    var eleFile = document.querySelector('.file');
    var image = document.querySelector("img")
    var button = document.querySelector("button")
    // 压缩图片需要的一些元素和对象
    var targetWidth, targetHeight
    var reader = new FileReader(),
        img = new Image();

    // 选择的文件对象
    var file = null;

    // base64地址图片加载完毕后
    img.onload = function () {
        // 图片原始尺寸
        var originWidth = this.width;
        var originHeight = this.height;
        // 最大尺寸限制
        var maxWidth = 600,
            maxHeight = 500;
        // 目标尺寸
        targetWidth = originWidth,
            targetHeight = originHeight;
        // 图片尺寸超过400x400的限制
        if (originWidth > maxWidth || originHeight > maxHeight) {
            if (originWidth / originHeight > maxWidth / maxHeight) {
                // 更宽，按照宽度限定尺寸
                targetWidth = maxWidth;
                targetHeight = Math.round(targetWidth* (originHeight / originWidth));
            } else {
                targetHeight = maxHeight;
                targetWidth = Math.round(targetHeight* (originWidth / originHeight));
            }
        }
        image.width = targetWidth
        image.height = targetHeight
    };

    // 文件base64化，以便获知图片原始尺寸
    reader.onload = function (e) {
        img.src = e.target.result;
        image.src = e.target.result
    };
    eleFile.addEventListener('change', function (event) {
        file = event.target.files[0];
        // 选择的文件是图片
        if (file.type.indexOf("image") == 0) {
            reader.readAsDataURL(file);
        }
    });
    button.addEventListener('click', function () {
        if (!file) {
            return
        }
        var formData = new FormData()
        formData.append(file.name, file)
        //uploadImage(formData)
    })
</script>

<script type="text/javascript">
    function copyUrl2()
    {
        var Url2=document.getElementById("biao1");
        Url2.select(); // 选择对象
        document.execCommand("Copy"); // 执行浏览器复制命令
        alert("已复制好，可贴粘。");
    }
</script>


</body>


</html>