function downloadImg(){
    var img = document.getElementById('pic'); // 获取要下载的图片
    var url = img.src;                            // 获取图片地址
    var a = document.createElement('a');          // 创建一个a节点插入的document
    var event = new MouseEvent('click')           // 模拟鼠标click点击事件
    a.download = '图片名字'                  // 设置a节点的download属性值
    a.href = url;                                 // 将图片的src赋值给a节点的href
    a.dispatchEvent(event)                        // 触发鼠标点击事件
}



var singleUploadButton = document.querySelector('#singleUploadButton');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');

var singleUploadButtonSMMS=document.querySelector('#singleUploadButtonSMMS');
function uploadSingleFile(file) {//后
    var formData = new FormData();
    formData.append("file", file);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" +
                response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a>"+
                "useUrl: http://localhost:8080/images/userimg/"+response.fileName+
                "</p>"
            ;
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "error";
        }
    }
    xhr.send(formData);
}

singleUploadButton.addEventListener('click', function(event){//先
    var img = document.getElementById('pic');
    function dataURLtoFile(dataurl, filename) {
        var arr = dataurl.split(','),
            mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]),
            n = bstr.length,
            u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, {type:mime});
    }

    // @TODO 名称设置
    var file = dataURLtoFile(img.src,Math.random().toString(36).substr(2)+'.png');
    // var file = dataURLtoFile(img.src,'hello.png');
    console.log(file);
    uploadSingleFile(file);
    // uploadSingleFile_smms(file);
    event.preventDefault();
}, true);

function uploadSingleFile_smms(file) {//后
    var formData = new FormData();
    formData.append("smfile", file);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "https://sm.ms/api/upload");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            console.log(response)
            singleFileUploadSuccess.innerHTML = response.data.url+" "+"<a href=response.data.delete>"+response.data.delete+"</a>";
            singleFileUploadSuccess.style.display = "block";
            alert("useurl:\n"+response.data.url+"\ndeleteurl:\n"+response.data.delete);
        } else {
            singleFileUploadSuccess.style.display = "error";
        }
    }
    xhr.send(formData);
}
singleUploadButtonSMMS.addEventListener('click', function(event){//先
    var img = document.getElementById('pic');
    function dataURLtoFile(dataurl, filename) {
        var arr = dataurl.split(','),
            mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]),
            n = bstr.length,
            u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, {type:mime});
    }

    // @TODO 名称设置
    var file = dataURLtoFile(img.src,Math.random().toString(36).substr(2)+'.png');
    // var file = dataURLtoFile(img.src,'hello.png');
    console.log(file);
    // uploadSingleFile(file);
    uploadSingleFile_smms(file);
    event.preventDefault();
}, true);
/*
* {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":800,"height":600,
* "filename":"dhtzfyv3ob.png","storename":"P3fOKbSYVmAN9yj.png","size":358096,"path":"\/2019\/12\/09\/P3fOKbSYVmAN9yj.png"
* ,"hash":"guHqC8WTVBR6eLskwcvQpJXSzE","url":"https:\/\/i.loli.net\/2019\/12\/09\/P3fOKbSYVmAN9yj.png"
* ,"delete":"https:\/\/sm.ms\/delete\/guHqC8WTVBR6eLskwcvQpJXSzE",
* "page":"https:\/\/sm.ms\/image\/P3fOKbSYVmAN9yj"},"RequestId":"7D8E121B-752E-46FE-B3DB-32FB6AC58D29"}
* */

/*
* {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":800,"height":500,"filename":"c8qf4tjtbu.png","storename":"A2kOLZTocuRjBmF.png","size":698713,"path":"\/2019\/12\/09\/A2kOLZTocuRjBmF.png","hash":"ygMDoOJAark2RcWxF864uEY7nf","url":"https:\/\/i.loli.net\/2019\/12\/09\/A2kOLZTocuRjBmF.png","delete":"https:\/\/sm.ms\/delete\/ygMDoOJAark2RcWxF864uEY7nf","page":"https:\/\/sm.ms\/image\/A2kOLZTocuRjBmF"},"RequestId":"6F1ABCEE-63F5-4811-8DB3-95F6260065C1"}
* */