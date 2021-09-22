# Tutorial APAP
## Authors
* **Yasmin Qurrota Aini** - *1906399625* - *A*


### Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link
berikut setelah menjalankan program:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%
20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut
dapat terjadi
Jawab : Pada saat membukanya website error dan menunjukan error "whitelabel". Hal ini disebabkan belum adanya template "add-kebun-safari.html" yang berakibat hasil return controller menjadi error.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut
merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja
@Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Jawab : Menurut saya @Autowired merupakan salah satu konsep Dependency Injection. Cara kerjanya adalah isi dari Class Service menginjeksi Class Controller.

Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link
berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%
20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Jawab : Terjadi whitelabel error karena tdk ada nomor telepon sebagai parameter dari hasil required = true.

Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP,
link apa yang harus diakses?
Jawab : http://localhost:8080/kebun-safari/view/1

Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah
untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga
bukti screenshotmu.
Jawab : Tampilan keseluruhan = (https://ibb.co/NrzvtJ4)
Add = (https://yasmin22.imgbb.com/)


### Tutorial 1
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
(Tuliskan jawabanmu)
Singkatnya issue tracker merupakan alat untuk melacak bug dari produk selama proses pengembangan produk.

2. Apa perbedaan dari git merge dan git merge --squash?
Perbedaan mendasar yang saya ketahui mengenai Git merge dan Git merge --squash adalah Merge memungkinkan kita menambahkan dan menggabungkan branch sedangkan squash memungkinkan untuk mengubah isi dari pesan commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
a. Dengan adanya version contol dapat mempermudah tim untuk menganalisis, mengedit, dan membuat projek.
b. Selain itu juga berguna untuk membedakan dokumen satu sama lain. 
c. Mengurangi duplikasi dan error
d. Memberikan sudut pandang yang lebih komprehensif
e. Salah satu cara yang cukup praktis dan aman untuk pengembangan aplikasi


### Spring
4. Apa itu library & dependency?
Library adalah library merupakan tempat untuk menaro fungsionalitas umum terutama pada saat menggunakan spring boot. library tersebut kemudian dapat digunakan dalam suatu aplikasi dan spring beans.
Depedency adalah ketergantungan yang terjadi dalam sebuah project. Seperti contoh saat sebuah project kecil mungkin hanya membutuhkan external java APIs.


5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Dengan Maven projek yang kita kembangkan dapat mengeluarkan tipe output seperti JAR dan WAR. Selain itu Maven juga banyak menyediakan informasi projek dan sangat membantu untuk update pada suatu projek.  Alternatif selain Maven adalah Gradle. Dalam beberapa kasus Gradle lebih cepat dibandingkan Maven.


6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Koneksi database dan manipulasi, REST API, Catching, Entripries Application, Sistem Spring Cloud, Angular Framework.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam : digunakan untuk mengakses nilai parameter queri 
@PathVariable : digunakan untuk mengakses nilai dari template URI
Paramater Query dapat digunakan dalam pemfilteran, mengurutkan kriteria. Sedangkan path paramaters biasa digunakan dalam mengidentifikasi suatu resources.


### Daftar Pustaka
https://reqtest.com/requirements-blog/what-are-benefits-of-version-control/
https://rietta.com/blog/github-merge-types/
https://grantlittle.me/index.php/2020/08/30/create-a-spring-boot-starter-library/


