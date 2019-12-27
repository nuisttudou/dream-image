function makeMD5() {
    var ps=document.getElementById('password');
    // console.log(document.getElementById('ps').value);
    // var hash = md5("value");
    ps.value=md5(ps.value);
    // console.log(document.getElementById('ps').value);
}