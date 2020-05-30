$(function () {

    $('.search').click(function () {
        var name = $("#name").val();
        $.ajax({
            type: "GET",
            url: "SearchEmployee", //Tên servlet
            data: "name=" + name,  //Gán giá trị vào name mục đich để servlet nhận được Parameter
            dataType: "json",
            async: true,
            cache: false,
            success: function (result) {
                //Lấy size của list này
                var listSize = Object.keys(result).length;
                //Nếu List lấy từ Dao là null thì thông báo Not found và return
                if (result.check == "fail") {
                    $('#message').text("List isEmpty! Name not found!");
                    $('#message').css('color', 'red');
                    return;
                }
                //Nếu list tồn tại thì reset thông điệp cảnh báo về rỗng và loop dữ liệu hiển thị ra table
                if (listSize > 0) {
                    $('#message').text("");
                    //Khai báo table kiểu global để sử dụng ngoài fuction này
                    table = document.getElementById("row");
                    for (i = 0; i < listSize; i++) {
                        var row = table.insertRow(i);

                        var cell = row.insertCell(0);
                        var cell1 = row.insertCell(1);
                        var cell2 = row.insertCell(2);
                        var cell3 = row.insertCell(3);
                        var cell4 = row.insertCell(4);
                        var cell4 = row.insertCell(5);

                        cell.innerHTML = i;
                        cell1.innerHTML = result[i].id;
                        cell2.innerHTML = result[i].name;
                        cell3.innerHTML = result[i].gioitinh;
                        cell4.innerHTML = result[i].sdt;
                        cell5.innerHTML = result[i].trangthai;

                        // Thêm class vào tr
                        row.className += 'trOnColor';// class có tên trOnColor
                        // Thêm class vào td
                        cell.className += 'text-center'; // Class có tên text-center
                        // Thêm class vào td tạo kích thước width cho từng cột
                        cell1.className += 'text-center';
                        cell2.className += 'text-center';
                        cell3.className += 'text-center';
                        cell4.className += 'text-center';
                        cell5.className += 'text-center';

                    }
                }

            }
        });
    });
    //Reset table về trạng thái không có bản ghi nào
    $('.search').click(function () {
        var trLength = table.getElementsByTagName("tr").length;
        if (trLength > 0) {
            for (i = 0; i < trLength; i++) {
                table.deleteRow(0);
            };
        }
    });
});