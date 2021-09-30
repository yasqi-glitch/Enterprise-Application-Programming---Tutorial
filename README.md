# Tutorial APAP
## Authors
* **Yasmin Qurrota Aini** - *1906399625* - *A*

### Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
Jawaban : Jika `th:include` digunakan maka elemen frgament akan didalam tag pemanggil `th:include`. Sedangkan  `th:replace`, fragment yang dipanggil tidak berada di dalam tag yang memanggil tetapi akan digantikan dengan fragmentnya.

2. Jelaskan apa fungsi dari th:object!
 `th:object` dapat digunakan untuk menentukan objek yang akan diambil dari form untuk digunakan oleh atribut dari objek tsb didalam penggunaan form html.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
 `$` untuk mendapatkan sebuah objek model yang dipassing dari controller yg dihubungkan ke form.
  `*` untuk menunjuk atribut object yang digunakan di dalam form.
  Di dalam soal, sebuah form html akan dihubungkan dengan model menggunakan $. seperti `${lcabang}` dan * dipakai saat mau mengambil attribut dari objek seprti `*{waktuTutup}`.


### Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
Jawab =
@AllArgsConstructor untuk mengenerates setiap constructor di Class dengan satu parameter
@NoArgsConstructor untuk mengenerates constructor tanpa parameter
@Setter bawaan dari lombok untuk mengenerates Setter dari Class secara otomatis
@Getter bawaan dari lombok untuk mengenerates Getter dari Class secara otomatis
@Entity mendefinisikan kelas agar dapat dipetakan ke tabel
@Table mendefinisikan nama Tabelnya

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method
tersebut?
Jawab = Untuk mencari data dari data berdasarkan nomor cabangnya.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
Jawab = @JoinTable menyimpan id kedua entitas ke tabel yang terpisah sedangkan @JoinColumn menyimpan id entitas lain di kolom baru di tabel yang sama.
@JoinColumn dapat digunakan ketika suatu entitas memiliki hubungan langsung.
@JoinTable dapat digunakan untuk mengelola hubungan antar entitas pada tabel lain.

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull
Jawab = name merupakan nama kolom, sedangkan refferencedColumnName merupakan nama kolom yang ingin di-reference, sedangkan nullable menentukan nilai null dapat dimasukkan ke dalam column atau tidak

nullable dapat mendetksi method yang hasil returnnya null
@NotNull mendeklarasikan suatu method tidak boleh mereturn null

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
Jawab = 
FetchType.LAZY memberi informasi Hibernate untuk hanya mengambil entitas terkait dari database saat menggunakan relasi.
CascadeType.ALL dapat digunakan untuk menyebarkan semua operasi termasuk kasus Hibernate
FetchType.EAGER memberi tahu Hibernate untuk mendapatkan semua elemen dari relationship saat memilih root entity.


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


