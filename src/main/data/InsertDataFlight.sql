SELECT * FROM API_Flight.sanbay;
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('VCS', 'VietNam', 'Côn Đảo', 'Bà rại - Vũng tàu', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('UIH', 'VietNam', 'Phù Cát', 'Bà rại - Bình Định', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('VCA', 'VietNam', 'Cần Thơ', 'Cần Thơ', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('DAD', 'VietNam', 'Đà Nẵng', 'Đà Nẵng', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('HPH', 'VietNam', 'Cát Bi', 'Hải Phòng', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('HAN', 'VietNam', 'Nội Bài', 'Hà Nội', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('SGN', 'VietNam', 'Tân Sân Nhất', 'Hồ Chí Minh', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('CXR', 'VietNam', 'Cam Ranh', 'Khánh Hoà', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('PQC', 'VietNam', 'Phú Quốc', 'Kiên Giang', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('TBB', 'VietNam', 'Tuy Hoà', 'Phú yên', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('VCL', 'VietNam', 'Chu lai', 'Quảng Nam', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('HUI', 'VietNam', 'Phú Bài', 'Thừa Thiên Huế', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('THD', 'VietNam', 'Thọ Xuân', 'Thanh Hoá', 1);
INSERT INTO `API_Flight`.`sanbay` (`code`, `quocgia`, `tensanbay`, `tenthanhpho`, `tinhtrang`) VALUES ('VDO', 'VietNam', 'Vân Đồn', 'Quảng Ninh', 1);

SELECT * FROM API_Flight.chucvu;
INSERT INTO `API_Flight`.`chucvu` (`code`, `tenchucvu`, `tinhtrang`) VALUES ('USER', 'Nhân Viên', 1);
INSERT INTO `API_Flight`.`chucvu` (`code`, `tenchucvu`, `tinhtrang`) VALUES ('ADMIN', 'Quản Lý', 1);

SELECT * FROM API_Flight.hangve;
INSERT INTO `API_Flight`.`hangve` (`code`, `tenhangve`, `tinhtrang`) VALUES ('PT', 'Phổ Thông', 1);
INSERT INTO `API_Flight`.`hangve` (`code`, `tenhangve`, `tinhtrang`) VALUES ('TG', 'Thương Gia', 1);

SELECT * FROM API_Flight.khachhang;
INSERT INTO `API_Flight`.`khachhang` (`cmnd`, `hoten`, `matkhau`, `sodienthoai`, `taikhoan`, `tinhtrang`) VALUES ('200118294', 'Nguyễn Thành Long', 'long123', '03566377543', 'longzip113', 1);
INSERT INTO `API_Flight`.`khachhang` (`cmnd`, `hoten`, `matkhau`, `sodienthoai`, `taikhoan`, `tinhtrang`) VALUES ('200165738', 'Nguyễn Văn Đạt', 'Dat123', '0356637586', 'dat113', 1);

SELECT * FROM API_Flight.nhanvien;
INSERT INTO `API_Flight`.`nhanvien` (`cmnd`, `hoten`, `matkhau`, `sodienthoai`, `taikhoan`, `tinhtrang`, `chucvu_id`) VALUES ('533474545', 'Nguyễn Văn A', 'admin', '08654735844', 'a111', 1, 1);
INSERT INTO `API_Flight`.`nhanvien` (`cmnd`, `hoten`, `matkhau`, `sodienthoai`, `taikhoan`, `tinhtrang`, `chucvu_id`) VALUES ('765987432', 'Nguyễn Văn C', 'user', '0974327865', 'b111', 1, 2);


SELECT * FROM API_Flight.maybay;
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietNamAirline', '150', '50', 'Boeing 707 - 120', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietNamAirline', '115', '50', 'Boeing 707 - 200', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietNamAirline', '100', '30', 'Boeing 707 - 100', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietNamAirline', '90', '20', 'Boeing 707 - 300', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietNamAirline', '128', '60', 'Boeing 727 - 200', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietJetAirline', '115', '50', 'Douglas DC-9-40', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietJetAirline', '120', '30', 'Douglas DC-9-50', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietJetAirline', '140', '20', 'Douglas DC-8-60', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('VietJetAirline', '128', '60', 'Douglas DC-8-70', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('BambooAirline', '115', '50', 'Bombardier CRJ-900', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('BambooAirline', '160', '50', 'Bombardier CRJ-1000', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('BambooAirline', '180', '20', 'Bombardier CRJ-700', 1);
INSERT INTO `API_Flight`.`maybay` (`hangmaybay`, `soghehang1`, `soghehang2`, `tenmaybay`, `tinhtrang`) VALUES ('BambooAirline', '178', '60', 'Bombardier CRJ-200', 1);

SELECT * FROM API_Flight.tuyenbay;
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 4);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 4, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 5);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 5, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 6);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 6, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 7);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 7, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 8);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 8, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 9);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 9, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 10);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 10, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 11);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 11, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 3, 12);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 12, 3);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 8, 9);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 9, 8);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 8, 10);
INSERT INTO `API_Flight`.`tuyenbay` (`tinhtrang`, `sanbayden_id`, `sanbaydi_id`) VALUES (b'1', 10, 8);

SELECT * FROM API_Flight.chuyenbay;
INSERT INTO `API_Flight`.`chuyenbay` (`ngaygio`, `thoigianbay`, `tinhtrang`, `maybay_id`, `tuyenbay_id`) VALUES ('2010-05-17 22:52:21', '2', 1, 1, 1);
INSERT INTO `API_Flight`.`chuyenbay` (`ngaygio`, `thoigianbay`, `tinhtrang`, `maybay_id`, `tuyenbay_id`) VALUES ('2020-06-29 23:00:00', '2', 1, 2, 3);
INSERT INTO `API_Flight`.`chuyenbay` (`ngaygio`, `thoigianbay`, `tinhtrang`, `maybay_id`, `tuyenbay_id`) VALUES ('2020-08-25 22:00:00', '2', 1, 3, 7);
INSERT INTO `API_Flight`.`chuyenbay` (`ngaygio`, `thoigianbay`, `tinhtrang`, `maybay_id`, `tuyenbay_id`) VALUES ('2020-02-14 21:00:00', '2', 1, 8, 8);
INSERT INTO `API_Flight`.`chuyenbay` (`ngaygio`, `thoigianbay`, `tinhtrang`, `maybay_id`, `tuyenbay_id`) VALUES ('2020-07-05 18:00:00', '2', 1, 4, 9);

SELECT * FROM API_Flight.vechuyenbay;
INSERT INTO `API_Flight`.`vechuyenbay` (`dongia`, `tinhtrang`, `chuyenbay_id`, `hangve_id`) VALUES ('700000', 1, 1, 1);
INSERT INTO `API_Flight`.`vechuyenbay` (`dongia`, `tinhtrang`, `chuyenbay_id`, `hangve_id`) VALUES ('1500000', 1, 1, 2);
INSERT INTO `API_Flight`.`vechuyenbay` (`dongia`, `tinhtrang`, `chuyenbay_id`, `hangve_id`) VALUES ('1000000', 1, 2, 1);
INSERT INTO `API_Flight`.`vechuyenbay` (`dongia`, `tinhtrang`, `chuyenbay_id`, `hangve_id`) VALUES ('2000000', 1, 2, 2);

SELECT * FROM API_Flight.phieudatve;
INSERT INTO `API_Flight`.`phieudatve` (`maghe`, `ngaydat`, `thanhtien`, `tinhtrang`, `khachhang_id`, `nhanvien_id`, `vechuyenbay_id`)
VALUES ('MG01', '2020-02-17', '1700000', 1, 5, 3, 3);



















