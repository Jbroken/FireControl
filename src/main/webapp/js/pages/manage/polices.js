/**
 * Created by bo.e.zhao on 5/8/2017.
 */

/**
 * 请求数据
 */
 var getPoliceList =function () {
    $.ajax({
        url:'getPoliceList',
        type:'post',
        dataType:'json',
        success:function (rdata) {
            appendTableHead();
            loadPolice(rdata);
        },
        error:function () {
            $.alert()
        }
    })
}
var appendTableHead = function () {
    var row = new Array();
    $table = $('table thead');
    row.push('<th>警号</th>');
    row.push('<th>所属派出所</th>');
    row.push('<th>电话号码</th>');
    row.push('<th>姓名</th>');

    $table.append(row.join(' '));
}
/**
 * 加载数据
 */
var loadPolice = function (police) {
    var row = new Array();
    $table = $('table tbody');
    $.each(police,function (index,item) {
        row.push('<tr>')
        row.push('<td>'+ item.userid +'</td>');
        row.push('<td>'+ item.policestation +'</td>');
        row.push('<td>'+ item.tel +'</td>');
        row.push('<td>'+ item.relname +'</td>');
        row.push('</tr>');
    })
    $table.append(row.join(' '));
}
$(document).ready(function () {
    getPoliceList();
})
