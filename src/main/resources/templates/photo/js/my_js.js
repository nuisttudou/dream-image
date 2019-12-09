function downloadImg(){
    var img = document.getElementById('pic'); // 获取要下载的图片
    var url = img.src;                            // 获取图片地址
    var a = document.createElement('a');          // 创建一个a节点插入的document
    var event = new MouseEvent('click')           // 模拟鼠标click点击事件
    a.download = '图片名字'                  // 设置a节点的download属性值
    a.href = url;                                 // 将图片的src赋值给a节点的href
    a.dispatchEvent(event)                        // 触发鼠标点击事件
}


var singleUploadForm = document.querySelector('#singleUploadForm');
// var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');
function uploadSingleFile(file) {//后
    console.log("uploadSingleFile(file)");
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" +
                response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a>"+
                "useUrl: http://localhost:8080/images/userimg/"+response.fileName+
                "</p>"
            ;
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}

singleUploadForm.addEventListener('click', function(event){//先
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

    //Usage example:
    var file = dataURLtoFile(img.src,'hello.png');
    console.log(file);
    // // const objectURL = window.URL.createObjectURL(img);
    //
    // var preview = document.querySelector('pic');
    // preview.src = reader.result;
    // var file    = document.querySelector('input[type=file]').files[0];
    // var reader  = new FileReader();
    //
    //
    // var files = img.src;//singleFileUploadInput.files;
    // console.log(files);
    //
    // // if(files.length === 0) {
    // //     singleFileUploadError.innerHTML = "Please select a file";
    // //     singleFileUploadError.style.display = "block";
    // // }
    uploadSingleFile(file);
    event.preventDefault();
}, true);

