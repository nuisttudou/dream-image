function downloadImg(){
    var img = document.getElementById('pic'); // 获取要下载的图片
    var url = img.src;                            // 获取图片地址
    var a = document.createElement('a');          // 创建一个a节点插入的document
    var event = new MouseEvent('click')           // 模拟鼠标click点击事件
    a.download = '图片名字'                  // 设置a节点的download属性值
    a.href = url;                                 // 将图片的src赋值给a节点的href
    a.dispatchEvent(event)                        // 触发鼠标点击事件
}

// var singleUploadForm = document.querySelector('#singleUploadForm');
// var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
// // var singleFileUploadError = document.querySelector('#singleFileUploadError');
// // var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');
//
//
//
//
//
//
// function uploadSingleFile(file) {
//     var formData = new FormData();
//     formData.append("file", file);
//     var xhr = new XMLHttpRequest();
//     xhr.open("POST", "/uploadFile");
//     xhr.onload = function() {
//         console.log(xhr.responseText);
//         var response = JSON.parse(xhr.responseText);
//         if(xhr.status == 200) {
//             singleFileUploadError.style.display = "none";
//             singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
//             singleFileUploadSuccess.style.display = "block";
//         } else {
//             singleFileUploadSuccess.style.display = "none";
//             singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
//         }
//     }
//
//     xhr.send(formData);
// }
//
// singleUploadForm.addEventListener('submit', function(event){
//     console.log("thisismylisten");
//     var files = singleFileUploadInput.files;
//     if(files.length === 0) {
//         singleFileUploadError.innerHTML = "Please select a file";
//         singleFileUploadError.style.display = "block";
//     }
//     uploadSingleFile(files[0]);
//     event.preventDefault();
// }, true);
