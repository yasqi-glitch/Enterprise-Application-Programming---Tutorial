# Tutorial APAP
## Authors
* **Yasmin Qurrota Aini** - *1906399625* - *A*

### Tutorial 8
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
answer : Langkah yang saya lakukan adalah saya menambahkan kode pada function handleSubmitItem yaitu ->
this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
dengan menggunakan kode tersebut maka form yang akan di add akan menjadi kosong kembali setelah di-submit.

2. Jelaskan fungsi dari async dan await!
answer : 
-Async : Async sendiri merupakan fungsi dari javascript untuk kegiatan asyncronus. Fungsi async mengembalikan objek dengan tipe Promise.
-Await : Await berfungsi untuk memberitahu kepada aplikasi utk keluar sementara dari fungsi async dan akan kembali lagi ke fungsi async ketika tugas yang dijalankan selesai.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.
answer : Jawabannya disini ya kak
https://docs.google.com/document/d/1Iot_qKM-2AAd8JBzakxkcRcuPIkFHd4tTlb7uQipWPE/edit?usp=sharing

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
answer : 
componentDidMount : Biasanya digunakan untuk mengambil data. Setelah HTML yang dirender selesai loading, fungsi ini dipanggil.  componentDidMount digunakan saat React mengambil data eksternal dari website lain. Use case : Mangambil data dari website lain untuk dirender.

shouldComponentUpdate : shouldComponenUpdate() digunakan untuk memberi tahu React jika output komponen tidak terpengaruh oleh perubahan status atau props saat ini. Fungsi ini dipanggil setelah props atau state mengalami perubahan dan sebelum proses rendering dijalankan. Use case : Pengubahan komponen dan dilakukannya rendering setiap state berubah.

componentDidUpdate : Fungsi ini digunakak saat terjadi interaksi pada environment non-React speerti browser. Fungsi ini dipanggil saat terjadi update pada instance di dalam komponen dan HTML yang dirender selesai melakukan loading. Use case : mengupdate komponen.

componentWillReceiveProps : Dengan fungsi ini dapat diketahui apakah terjadi perubahan props tanpa render kembali. Fungsi ini dipanggil ketika terjadi perubahan pada props dan saat komponen akan menerima props. Use case : dilakukannya reset state.

componentWillUnmount : Biasanya fungsi ini diapakai saat dilakukan pembersihan timer yang tidak valid, membatalkan request jaringan. Fungsi ini dipanggil ketika terdapat komponen yang terhapus dari DOM. Use case : Penghapusan interval waktu.

### Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
sebagai ilustrasi dari apa yang Anda jelaskan.
Jawab : 
gambar : https://docs.google.com/document/d/1NT2yNYGYKj_hiwEKJPrMVvxbSzjNTbSCVYsT4OzQeLs/edit?usp=sharing
Pada latihan pertama saya membuat fungsi handleDeleteItemToCart. Di fungsi itu mirip dengan yang addtocart namun perbedaanya akan dicek targentInd >= 0 dan newItem.inCart = false. kemudian diremove menggunakan newItems.splice(newItem);
pada latihan nomor dua saya membuat fungsi updateBalance yang mereturn angka, jika fungsi tersebut mereturn angka 1 maka bbrti balance masih cukup dan fungsi tsb dipanggil didalam method addtoCart. jika balance masih lebih besar dari price maka fungsi akan mengurangi balance dengan price dan setBalance. kemudian saya mensetbalance kembali pada fungsi delete agar nilai balance menjadi sperti semula.
Pada latihan nomor 3 menurut saya yang paling mudah karna saya hanya perlu menambahkan Alert("") pada index.js di homefunc dan home dan tidak perlu penyeseuain lagi seperti fungsi-fungsi yang sebelumnya.

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
Jawab : Props merupakan singkatan dari property yang setara dengan argumen pada sebuah function dan state adalah data private yang dimiliki component yang terus berubah sesuai dengan perilaku program.
Props digunakan untuk komunikasi data antar komponen dari parent ke child. Sedangkan, state dapat digunakan untuk untuk kelas komponen yang memiliki state saja.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
Jawab : react bersifat reusable. Penggunaan komponen dapat membuat aplikasi menjadi lebih konsisten karna komponen dapat digunakan dimana saja.

4. Apa perbedaan class component dan functional component?
Jawab : Komponen Fungsional: Komponen fungsional adalah beberapa komponen umum yang akan ditemukan saat bekerja di React. Ini hanyalah fungsi JavaScript. Sedangkan, class component adalah adalah kelas sederhana (terdiri dari beberapa fungsi yang menambahkan fungsionalitas ke aplikasi).

5. Dalam react, apakah perbedaan component dan element?
Jawab : komponen mengacu pada bagian kecil dari entitas yang lebih besar yang sebagian besar adalah objek yang diproduksi. Sebaliknya, elemen adalah salah satu bagian paling sederhana yang terdiri dari apa pun.


### Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
Jawab: Perbedaan Otentikasi dan Otorisasi adalah otentikasi merupakan proses identifikasi pengguna sedangkan, otorisasi menentukan apakah pengguna tersebut boleh melakukan task tertentu.
Contoh otentikasi terdapat pada UserDetailsServiceImpl.java dan PageController.java
Contoh otorisasi terdapat pada class WebSecurityConfig.java dan beberapa tampilan di dalam html yang harus memenuhi syarat suatu role agar dapat melihatnya.


2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
Jawab : BCryptPasswordEncoder merupakan class bawaan springboot untuk meng-encode password menjadi kode unik agar keamanan password tersebut meningkat. Cara kerja nya adalah kode abstrak disimpan
dalam database saat user melakukan login. Kemudian akan dipanggil suatu fungsi yang dapat membalikkan kode abstrak menjadi password asli ketika sign up dan dibandingkan apakah sama atau tidak dengan input saat user login .

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
demikian?
Jawab : Untuk tingkat keamanan yang lebih tinggi, sebaiknya digunakan hashing dalam menyimpan password. Hal ini disebabkan Hashing adalah fungsi satu arah, artinya setelah Anda meng-hash kata sandi, sangat sulit untuk mendapatkan kembali kata sandi asli dari hash. Enkripsi adalah fungsi dua arah, di mana jauh lebih mudah untuk mendapatkan kembali teks asli dari teks terenkripsi.

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
Jawab :UUID kepanjangannya adalah immutable universally unique identifier. 
UUID berguna untuk mencetak karakter abstrak dari 32 karakter String yang diacak secara random. Dalam UUID tidak terdapat pola khusus.

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
Jawab :  UserDetailsServiceImpl.java berguna untuk mencocokan password dan username dengan yang ada di database. UserRoleServiceImpl.java berguna sebagai hal apa saja yang dapat dilakukan oleh role tersebut.


### Tutorial 5
1. Apa itu Postman? Apa kegunaannya?

Postman merupakan aplikasi yang berguna untuk berinteraksi dengan API melalui HTTP request.
kegunaan : memastikan fungsionalitas suatu API dengan mudah. Selain itu, dapat juga digunakan untuk automated testing, memonitor pekerjaan, serta simulasi endpoint API

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties : mengabaikan atribut dalam serialisasi dan deserialisasi JSON

@JsonProperty :  memetakan nama properti yang diberikan pada JSON terhadap properti di class Java terkait. sebagai contoh, suatu atribut age memiliki @JsonProperty berupa `classAge`, maka saat pengriman JSON dengan parameter `classAge`, parameternya akan menjadi atribut age pada class yang terkait.

3. Apa kegunaan atribut WebClient?

dapat berguna untuk membuat API consumer -> API lain dapat berkomunikasi dengan API yang ada pada project kita.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity : Sebagai representasi HTTP response dengan isi status,code, header, body. Kegunaannya, kita dapat mengatur response yang kita inginkan
BindingResult : Merupakan objek dr spring yang menyimpan hasil dan error saat melakukan suatu validasi. Dapat digunakan untuk memastikan kesesuaian isi form yang telah disubmit

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


