# 基于Android的手机音乐播放器的设计与实现

# 摘 要

随着Android系统和移动互联网的快速崛起，手机已经成为人们生活不可缺的一部分，在现代人的生活中，人们生活节奏的加快，生活压力越来越大，碎片化的时间越来越多，那么一个可以在碎片化的时间内调节自己心情的产品，无疑将拥有一个巨大的市场，而且随着移动设备硬件越来越先进，人们对移动设备的软件要求也越要越高，而基于Android系统的手机音乐播放器就能很好地满足这个需求。

Android是一个开源的基于Linux的系统，本论文将基于Android开源系统技术，使用java语言和Android Studio开发工具实现基于Android系统的音乐播放器。相对于传统的卡带式音乐播放器，MP3播放器，MP4播放器，Android系统的手机音乐播放器有着反应速度快，在线听音乐，分享心情感受，收藏歌曲等无法比拟的优势，Android系统的手机音乐播放器逐渐成为人们生活不可或缺的一部分，所以一个基于Android的音乐播放器无疑将拥有一个巨大的市场。 

本文将会详细地从需求分析开始，认真分析用户需求，然后进行界面，数据库等的设计工作。进而使用java实现需求，开发出一个高效的贴近用户的操作简单的音乐APP。最后通过系统化的测试，检验系统的稳定性。同时也要总结整个过程并指出播放器的不足之处，并提出修改的思路。

**关键词**：Android，音乐播放器，高效

# Abstract

With the rapid rise of the Android system and mobile Internet, mobile phones have become an indispensable part of people's lives. In modern people's lives, people's life pace is accelerated, life pressure is increasing, and fragmentation takes more and more time. Then a product that can adjust its mood in a fragmented time will undoubtedly have a huge market, and as the hardware of mobile devices becomes more and more advanced, people’s software requirements for mobile devices will also be higher, based on Android. The system's mobile music player will be able to meet this demand.

Android is an open source Linux-based system. This article will be based on Android open source system technology, using java language and Android Studio development tools to achieve Android-based music player. Compared to traditional cassette music players, MP3 players, MP4 players, Android mobile music players have a fast response, listen to music online, share feelings, collect songs and other incomparable advantages, Android system Mobile music players have gradually become an integral part of people's lives, so an Android-based music player will undoubtedly have a huge market.

This article will start from the requirements analysis in detail, carefully analyze the user requirements, and then proceed with the design of the interface and database. Then use java to realize the demand and develop an efficient and simple music APP that is close to the user. Finally, through systematic testing, the stability of the system is checked. At the same time, we must also sum up the entire process and point out the inadequacies of the player and propose revised ideas.

**Key words**: Android, MusicPlayer, Efficient

# 1 前言

## 1.1 研究目的与意义

现今社会生活节奏越来越快，而听音乐是舒缓压力的有效方式之一，本文的主要目的是开发一个方便快捷地为大众提供服务的音乐播放器，它可以支持多种格式播放，比如MP3，Wav等多种格式，并且能够控制音乐的播放暂停，停止，上一首，下一首等功能，界面简洁，操作简单。

在现代生活中，能在空闲的时间里听一下音乐，无疑是一大乐趣，而随着科技的进步，人们听音乐的方式也在悄悄地改变，从传统的MP3转到了智能手机，这时候一个好的音乐APP就可以满足你要求的一切，所以本系统选择移动手机作为开发平台。

目前，移动互联网已经超越传统PC，成为最大的互联网市场，在庞大的手机市场中，主流的手机操作系统包括Android，IOS，Windows mobile,相对于Windows mobile的一蹶不振，IOS的封闭，Android系统由于它的开放性，吸引了越来越多的开发者投身于Android开发社区中，Android成为现今最受欢迎的系统，所以本文选择Android作为开发的目的系统。

综上，本文选择为基于Android系统的手机音乐播放器，传统的手机音乐播放器一味地追求功能强大而忽略了CPU和内存占用率过大，对低端智能手机用户不友好，所以该APP追求的是一个更加简洁，通用性广的音乐播发器，同时本系统也会在这基础上追求为用户提供更多音乐资源，致力于打造一个最适合大部分用户的APP，同时本人也可以借助这个机会学习Android移动平台的开发技能。

## 1.2 研究概况

首先简单介绍一下Android系统，Android开始的时候是Rubin Andy团队开发的一个独立的手机系统，他是基于Linux内核，后来(2005年)该系统被Google公司收购，2007年11月Google宣布退出基于Linux的Android开源系统，而这时正值Apple发布革命性产品iPhone。发展到现在，Android已经更新的8.0，Android也经历了11个年头，也成为了市场占有率最高的系统。根据最新市场调查，在中国市场，Android市场份额上升7.2%，达到79.9%，iOS用户则下滑5.4%，Windows几乎面临“绝迹”，而且还具有上升的趋势。

在Android系统中主流的音乐播放器有百度音乐，酷狗音乐、QQ音乐、天天动听、网易云音乐。

**百度音乐**的前身为“千千静听”，二者进行整合之后更是发挥了自身优势，为用户带来了更加完美的视听享受。且百度音乐重视原创和正版，在应用中还专门设立了原创歌曲榜单。百度音乐独有场景电台功能，可根据当前的时间为您推荐不同种类的歌曲，相当的智能化，比如午后会为您推荐一些慵懒又温暖的音乐，而在下班的路上则会推荐一些较为轻快的乐曲。除此之外，百度音乐还有K歌台服务，这里有大量歌曲供您选择，且提供伴奏曲，您尽可以举着手机高歌一曲，保存后还可分享给好友们收听，或请他们也来PK一下，不只是听歌，百度音乐还能满足您唱歌的需求。

**酷狗**算是老牌的音乐播放器了，出色的交互设计和良好的使用体验让它积累了不少忠实用户，酷狗音乐拥有海量乐曲库，并且都是正版，这是因为酷狗与多家媒体或唱片公司都是合作伙伴关系，不但在质量上有所保证，更新速度也能保持同步。酷狗音乐中有个功能叫做“演艺直播”，这里聚集着大量的草根明星，用自己的歌喉为用户们献上一首首精心录制的歌曲，用户可为她送礼物和她交流，也能自己点歌，和舞台上的明星不同，这里多了一丝亲切的味道。 

**QQ音乐**，但它的优势在于，结合着QQ自身的优势，让用户可以享受到更多的服务。听歌识曲应该是音乐客户端的标准配置了，可QQ音乐却将识曲与摇一摇相结合，无需任何点击，晃动一下即可启动，不仅方便还增添了不少乐趣。QQ音乐为用户们准备了明星部落，这里汇聚了明星们的一手消息，和大量的话题，保证能满足用户追星的需求。 

**天天动听**是上海水渡石旗下的一款音乐播放器，以其绚丽的可视化效果赢得了用户的喜爱，在播放时封面还会随着音乐一起变换，在视觉和听觉上都是一种享受。它功能丰富实用，支持多种格式的歌曲，操作简单流畅，听歌也能变得如此简单，它功能丰富实用，支持多种格式的歌曲，操作简单流畅，听歌也能变得如此简单，天天动听提供了摇一摇切歌功能，且摇的力度也不尽相同。用户可自己设置首页显示内容，个性化做的非常出众。 

**网易云音乐**上线仅有几年的时间，但是它却迅速成为了用户们追捧的对象，不止是因为其出众的界面设计，在操作体验上也令人印象深刻，网易云音乐在功能上也有创新，它融入了流行的社交元素，让用户在听歌之外，还能实现分享交流的目的。网易云音乐的与众不同之处，是社交，评论、分享让大家因为对音乐的共同品味而走到了一起，除此之外就是主播电台栏目，音乐故事、情感调频、娱乐八卦，还有热度极高的明星做主播，与听CD的感觉完全不同，偶像与粉丝之间消除了隔阂感，距离更近一些。当然其它的功能在网易云音乐中也能找到，比如听歌识曲、定时停止播放，还可以更换主题皮肤。

## 1.3 论文的主要工作

本文主要针对播放器的基本功能进行实现，主要研究内容分为:对播放界面的优化，美观的播放界面会给用户带来更好的体验，文中主要提到对图片毛玻璃效果的实现，基于百度音乐API的接口实现访问，跨进进程调度音乐播放器，最后还使用高德地图API实现实时的天气预报功能。

## 1.4 论文的结构

本论文各章内容安排如下:

- **第一章**：前言，介绍了国内的Android手机音乐播放器发展现状，并进一步分析了这些软件对于用户使用的一些不足

- **第二章**：开发技术及工具的介绍，这里主要阐述Android系统的发展和架构，Retrofit和Rxjava作为Android客户端访问网络的的框架，和使用MVP的设计模式，使用Android Studio 开发Android端，Idea作为后台的开发工具，JavaEE技术，MySQL数据库，Spring-Boot框架

- **第三章**：需求分析。通过对该系统实现的可行性做了分析，在了解需求的基础上，对系统的功能需求做了阐述，采用了用例图、用例简介、活动图、包图等对系统的流程进行了分析

- **第四章**：系统总体设计。概括分析说明了音乐播放器的主要功能，在了解需求的基础上，设计了系统的总体功能模块。从概念结构设计、物理结构设计及数据库设计三方面对系统的设计进行介绍

- **第五章**：系统详细设计。分别通过时序图、界面、核心代码(内附界面截图及精髓技术的代码)。阐述播放器播放音乐流程。并介绍了本文实践项目的一些亮点与独到之处

- **第六章**：系统测试。对目前常用的测试技术进行了介绍并介绍了测试该系统的方法

- **第七章**：结束语。总结整个设计，并说明不足及进一步改善的方向

# 2 开发技术及工具的介绍

在本章中，本系统主要采用Retrofit和Rxjava作为Android客户端访问网络的的框架，使用MVP的设计模式，使用Android Studio 开发Android端，Idea作为后台的开发工具，使用JavaEE技术，使用MySQL作为后台数据库，Spring-Boot框架。

## 2.1 Android系统简介

Android是一个基于Linux内核的开放源代码移动操作系统，由Google成立的Open Handset Alliance(OHA，开放手持设备联盟)持续领导与开发，主要设计用于触屏移动设备如智能手机和平板电脑与其他便携式设备。

Android系统最初并不是由Google公司研发的，Android最初由安迪•鲁宾(Andy Rubin)的团队开发制作，最初开发这个系统的目的是创建一个数码相机的先进操作系统；但是后来发现市场需求不够大，加上智能手机市场快速成长，于是Android成为一款面向智能手机的操作系统。于2005年7月11日被美国科技企业Google收购。2007年11月，Google与84家硬件制造商、软件开发商及电信营运商成立开放手持设备联盟来共同研发改良Android，随后，Google以Apache免费开放源代码许可证的授权方式，发布了Android的源代码，开放源代码加速了Android普及，让生产商推出搭载Android的智能手机，Android后来更逐渐拓展到平板电脑及其他领域上。随着时间的推移，Android系统逐渐强大起来，现在Android已经成为了全球最大的移动操作系统，Android从面世以来已经有二十多个版本了在这几年的发展过程中，谷歌为Android建立了一个完整的生态系统[5]。Android系统的主要厂商有SAMSUNG，华为，HTC，OPPO，VIVO，小米等。目前最新的额Android版本是Android 8.1(更智能、更迅捷、更强大。广受世人喜爱的不仅仅是曲奇饼干，更是为您打造的全新 Android 系统[1]) 。

Android系统由高到低分为Application层、Application Framework层、Libraries层、AndroidRuntime层，和 Linux 内核层。蓝色的代表java程序，黄色的代码为运行JAVA程序而实现的虚拟机，绿色部分为C/C和和语言编写的程序库，红色的代码内核(linux内核和driver)。在Application Framework之下，由C/C和和的程序库组成，通过JNI完成从JAVA到C的调用。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/392ddab57ecfb90e07caf7fb2cafd6e3.writebug)

### 2.1.1 Application

所有的应用程序都是使用JAVA语言编写的，每一个应用程序由一个或者多个活动组成，活动必须以Activity类为超类，活动类似于操作系统上的进程，但是活动比操作系统的进程要更为灵活，与进程类似的是，活动在多种状态之间进行切换。利用JAVA的跨平台性质，基于Android框架开发的应用程序可以不用编译运行于任何一台安装有android系统的平台，这点正是Android的精髓所在[6]。

### 2.1.2 Application Framework

应用程序的架构设计简化了组件的重用；任何一个应用程序都可以发布它的功能块并且任何其它的应用程序都可以使用其所发布的功能块(不过得遵循框架的安全性限制)。帮助程序员快速的开发程序，并且该应用程序重用机制也使用户可以方便的替换程序组件[11]。

### 2.1.3 Libraries

Android包含一个C/C和和库的集合，供Android系统的各个组件使用。这些功能通过Android的应用程序框架(application framework)暴露给开发者。下面列出一些核心库。

### 2.1.4 Android Runtime层

Android包含一个核心库的集合，提供大部分在Java编程语言核心类库中可用的功能。每一个Android应用程序是Dalvik虚拟机中的实例，运行在他们自己的进程中。Dalvik虚拟机设计成，在一个设备可以高效地运行多个虚拟机。Dalvik虚拟机可执行文件格式是.dex，dex格式是专为Dalvik设计的一种压缩格式，适合内存和处理器速度有限的系统。

### 2.1.5 Linux内核

Android 的核心系统服务依赖于 Linux 2.6 内核 ，如安全性，内存管理，进程管理， 网络协议栈和驱动模型。 Linux 内核也同时作为硬件和软件栈之间的抽象层。

## 2.2 Retrofit技术框架

A type-safe HTTP client for Android and Java[2]，这是Retrofit官网对Retrofit的定义。Retrofit 是 Square公司旗下的类型安全的 HTTP 客户端，支持 Android 和 Java 等，它能将你的 HTTP API 转换为 Java 接口。Retrofit其实就是对okhttp做了进一步一层封装优化。用户只需要通过简单的配置就能使用Retrofit来进行网络请求了。   

Retrofit能够直接返回Bean对象，例如如果用户进行一个网络接口的请求，返回来一串json字符串。那么这个时候一般用户都要拿到这个json字符串后进行解析得到对应的Bean对象，Retrofit只要依赖一下Gson的转换库然后进行简单的配置就能够直接拿到Bean对象了，不需要用户自己去解析。 

## 2.3 Rxjava技术框架

RxJava is a Java VM implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences[3]。Rxjava和Retrofit都是由Square公司开发的开源框架，Rxjava一般配合Retrofit一起使用，RxJava是JVM的响应式编程扩展是一个为Java虚拟机编写的使用可观察序列的构建异步的基于事件的程序的类库。它基于观察者模式实现对数据/事件的序列的支持，并添加了一些操作符，允许你以声明式构建序列， 使得开发者无需关心底层的线程、同步、线程安全和并发数据结构。

## 2.4 MVP框架技术简介

对于一个应用而言用户需要对它抽象出各个层面，而在MVP架构中它将UI界面和数据进行隔离，所以用户的应用也就分为三个层次。

- **View**：对于View层也是视图层，在View层中只负责对数据的展示，提供友好的界面与用户进行交互。在Android开发中通常将Activity或者Fragment作为View层

- **Model**：对于Model层也是数据层。它区别于MVC架构中的Model，在这里不仅仅只是数据模型。在MVP架构中Model它负责对数据的存取操作，例如对数据库的读写，网络的数据的请求等

- **Presenter**：对于Presenter层他是连接View层与Model层的桥梁并对业务逻辑进行处理。在MVP架构中Model与View无法直接进行交互。所以在Presenter层它会从Model层获得所需要的数据，进行一些适当的处理后交由View层进行显示。这样通过Presenter将View与Model进行隔离，使得View和Model之间不存在耦合，同时也将业务逻辑从View中抽离。更好的使得单元测试得以实现[14]

下图很好的展示了MVP各个组件间的关系：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/9bffc03dff4e4bac47039754cca2e7cd.writebug)

## 2.5 Android studio开发工具简介

Android Studio是一个为Android平台开发程序的集成开发环境。2013年5月16日在Google I/O上发布，可供开发者免费使用。2013年5月发布早期预览版本，版本号为0.1。2014年6月发布0.8版本，至此进入beta阶段。第一个稳定版本1.0于2014年12月8日发布。Android Studio基于JetBrains IntelliJ IDEA，为Android开发特殊定制，并在Windows、OS X和Linux平台上均可运行。

Android Studio 是基于 IntelliJ IDEA 的官方 Android 应用开发集成开发环境 (IDE)。 除了 IntelliJ 强大的代码编辑器和开发者工具，Android Studio 提供了更多可提高 Android 应用构建效率的功能，例如：

- 基于 Gradle 的灵活构建系统

- 快速且功能丰富的模拟器

- 可针对所有 Android 设备进行开发的统一环境

- Instant Run，可将变更推送到正在运行的应用，无需构建新的 APK

- 可帮助您构建常用应用功能和导入示例代码的代码模板和 GitHub 集成

- 丰富的测试工具和框架

- 可捕捉性能、易用性、版本兼容性以及其他问题的 Lint 工具

- C和和 和 NDK 支持

- 内置对 Google 云端平台的支持，可轻松集成 Google Cloud Messaging 和 App 引擎

- 对最新的Google主推的开发语言Kotlin进行支持

目前Android Studio的最新版本时3.1。

## 2.6 IntelliJ IDEA开发工具简介

IntelliJ IDEA是一种商业化销售的Java集成开发环境(Integrated Development Environment，IDE)工具软件，由捷克软件公司JetBrains在2001年1月时推出最初版。

IntelliJ IDEA是用于开发计算机软件的Java集成开发环境(IDE)。 它由JetBrains(以前称为IntelliJ)开发，可作为Apache 2许可社区版本和专有商业版本提供。 两者均可用于商业开发。

IntelliJ IDEA能尽可能地促进程序员的编程速度。它包括了很多辅助的功能，并且与Java结合得相当好。不同的工具窗口围绕在主编程窗口周围，当鼠标点到时即可 打开，无用时也可轻松关闭，使用户得到了最大化的有效屏幕范围。以技术为导向的IDEA集成了调试器，支持本地和远程的调试，即使用户需要修改一些设置上 的东西使用户的工作顺利进展。另外，它还提供了通常的监视，分步调试以及手动设置断点功能，在这种断点模式下，用户可以自动地在断点之外设置现场访问，甚 至可以浏览不同的变量的值。IDE支持多重的JVM设置，几个编译程序和Ant建造系统，并且，它使得设置多重的自定义的类途径变得简单。

IntelliJ IDEA是一个相对较新的Java IDE。它是Java开发环境中最为有用的一个。高度优化的IntelleJ Idea使普通任务变得相当容易，Idea支持很多整合功能，更重要的使它们设计的好容易使用。Idea支持XML中的代码实现，Idea同时还会校正 XML，Idea支持JSP的结构。作用于普通Java代码的众多功能同样适用于JSP(比如整合功能)，同时支持JSP调试；支持EJB，尽管它不包括 对个别应用服务器的特殊支持。Idea支持Ant建立工具，不仅是运行目标它还支持编译与运行程序前后运行目标，另外也支持绑定键盘快捷键。在编辑一个 Ant建立XML文件时，Idea还对组成Ant工程的XML部分提供支持。IntelliJ IDEA 被称为是最好的JAVA IDE开发平台，这套软件就是以其聪明的即时分析和方便的 refactoring 功能深获大家所喜爱。缺点是较复杂，对初学者来说，理解起来比较困难。

## 2.7 PowerDesign工具介绍

Power Designer 是Sybase公司的CASE工具集，使用它可以方便地对管理信息系统进行分析设计，他几乎包括了数据库模型设计的全过程。利用Power Designer可以制作数据流程图、概念数据模型、物理数据模型，还可以为数据仓库制作结构模型，也能对团队设计模型进行控制。他可以与许多流行的数据库设计软件，例如PowberBuilder，Delphi，VB等相配合使来缩短开发时间和使系统设计更优化。

## 2.8 Rotation Rose简介

由于本系统使用RUP设计模式，需要建立可视化建模。可视化建模(VISUAL MODELING)是利用围绕现实想法组织模型的一种思考问题的方法。模型对于了解问题、与项目相关的每个人(客户、行业专家、分析师、设计者等)沟通、模仿企业流程、准备文档、设计程序和数据库来说都是有用的。建模促进了对需求的更好的理解、更清晰的设计、更加容易维护的系统。

Rational Rose是Rational公司出品的一种面向对象的统一建模语言的可视化建模工具。用于可视化建模和公司级水平软件应用的组件构造。

Rational Rose 是一个完全的，具有能满足所有建模环境(Web开发，数据建模，Visual Studio和 C和和 )需求能力和灵活性的一套解决方案。Rose 允许开发人员，项目经理，系统工程师和分析人员在软件开发周期内在将需求和系统的体系架构转换成代码，消除浪费的消耗，对需求和系统的体系架构进行可视化，理解和精练。通过在软件开发周期内使用同一种建模工具可以确保更快更好的创建满足客户需求的可扩展的、灵活的并且可靠的应用系统。

## 2.9 Spring-boot技术简介

Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible[4]。Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。

从最根本上来讲，Spring Boot就是一些库的集合，它能够被任意项目的构建系统所使用。简便起见，该框架也提供了命令行界面，它可以用来运行和测试Boot应用。框架的发布版本，包括集成的CLI(命令行界面)，可以在Spring仓库中手动下载和安装。

要进行打包和分发的工程会依赖于像Maven或Gradle这样的构建系统。为了简化依赖图，Boot的功能是模块化的，通过导入Boot所谓的“starter”模块，可以将许多的依赖添加到工程之中。为了更容易地管理依赖版本和使用默认配置，框架提供了一个parent POM，工程可以继承它。

## 2.10 Mysql数据库简介

MySQL Enterprise Edition includes the most comprehensive set of advanced features, management tools and technical support to achieve the highest levels of MySQL scalability, security, reliability, and uptime。 MySQL是一种开放源代码的关系型数据库管理系统(RDBMS)，MySQL数据库系统使用最常用的数据库管理语言--结构化查询语言(SQL)进行数据库管理。由于MySQL是开放源代码的，因此任何人都可以在General Public License的许可下下载并根据个性化的需要对其进行修改。MySQL因为其速度、可靠性和适应性而备受关注。大多数人都认为在不需要事务化处理的情况下，MySQL是管理内容最好的选择。

MySQL的海豚标志的名字叫“sakila”，它是由MySQL AB的创始人从用户在“海豚命名”的竞赛中建议的大量的名字表中选出的。获胜的名字是由来自非洲斯威士兰的开源软件开发者Ambrose Twebaze提供。根据Ambrose所说，Sakila来自一种叫SiSwati的斯威士兰方言，也是在Ambrose的家乡乌干达附近的坦桑尼亚的Arusha的一个小镇的名字。

MySQL，虽然功能未必很强大，但因为它的开源、广泛传播，导致很多人都了解到这个数据库。它的历史也富有传奇性。

## 2.11 Glide框架

Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface。[7]在泰国举行的谷歌开发者论坛上，谷歌为开发者介绍了一个名叫 Glide 的图片加载库，作者是bumptech。这个库被广泛的运用在google的开源项目中，包括2014年google I/O大会上发布的官方app。

Glide中有一部分单词，用英文单词可能在行文中更加合适，还有一些词在Glide中有特别的含义，这里简要说明一下：

- **View**：一般情况下，指Android中的View及其子类控件(包括自定义的)，尤其指ImageView。这些控件可在上面绘制Drawable

- **Target**：Glide中重要的概念，目标。它即可以指封装了一个View的Target(ViewTarget)，也可以不包含View(SimpleTarget)

- **Drawable**：指Android中的Drawable类或者它的子类，如BitmapDrawable等。或者Glide中继承Drawable实现的自定义Drawable(如GifDrawable等)。Request - 加载请求，可以是网络请求或者其他任何下载图片的请求，也是Glide中的一个类

- **Model**：数据源的提供者，如Url，文件路径等，可以从model中获取InputStream

- **Signature**：签名，可以唯一地标识一个对象

- **recycle()**：Glide中Resource类有此方法，表示该资源不被引用，可以放入池中(此时并没有释放空间)。Android中Bitmap也有此方法，表示释放Bitmap占用的内存

## 2.12 Mybatis

MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。[9]MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。
 
# 3 需求分析

## 3.1 系统概述

本系统主要的用户为广大的Android手机用户提供音乐播放，歌曲下载，歌迷互动三大模块功能。

## 3.2 系统分析

### 3.2.1 系统需求分析

随着Android系统和移动互联网的快速崛起，手机已经成为人们生活不可缺的一部分，在现代人的生活中，人们生活节奏的加快，生活压力越来越大，碎片化的时间越来越多，那么一个可以在碎片化的时间内调节自己心情的产品，无疑将拥有一个巨大的市场，而基于Android系统的手机音乐播放器就能很好地满足这个需求。

通过调查分析，本系统的用户为广大的Android手机用户，用户可以通过本系统实现音乐播放的基本功能包括播放，暂停，上一首，下一首等。用户还可以分享歌曲，对歌曲进行评论或者点赞别人的评论，下载歌曲，具体需求如下：

- **音乐播放**，音乐播放包括了音乐播放的基本功能:开始，暂停，上一首，下一首，同时还可以滑动唱片来实现切换上下首，通过拖动进度条来切换到音乐的不同位置

- **歌曲下载**，首先用户需要搜索所需要的歌曲，然后点击下载。同时用户可以搜索不同平台的歌曲，这样就可以不会因为不同版权而听不到音乐

- **乐迷互动**，用户可以通过在播放页面的评论按钮评论歌曲，进入评论界面后还可以对自己喜欢的评论进行点赞或者评论，同时歌迷也可以通过分享到第三方平台一起享受音乐带来的乐趣

### 3.2.2 系统可行性分析

- **经济可行性**：本系统作为一个毕业设计，并不需要任何的开发经费，而且本人也可以通过这次机会提升本人的Android开发技术和后台技术。并且本系统由于其简介的界面设计和丰富的资源平台将在这个巨大的市场有很大的发展空间

- **技术可行性**： 为了保证系统开发成功，必须采用RUP的系统开发方法。并且采取主流的MVP设计框架，运用成熟的技术比如Rxjava和Retrofit，还有Glide等。后台也采用了目前主流的MySQL作为数据库，数据安全得到了很好的保障，Tomcat 8.5作为服务器，使用Spring-Boot简易开发

就本人而言，本人有系统地学习Android开发基础同时也有不错的Android开发技术，和Retrofit和Rxjava的开发经验，也有Spring-Boot的开发技术，所以技术可行性上是没有问题的。

### 3.2.3 系统用力模型分析	

#### 3.2.3.1 包图

![](http://www.writebug.com/myres/static/uploads/2021/10/19/d1a41431401c7ee7f11f0aa34eb59b20.writebug)

#### 3.2.3.2 用例图及其用例简介

用例图定义：由参与者(Actor)、用例(Use Case)以及它们之间的关系构成的用于描述系统功能的动态视图称为用例图。

音乐播放用例：本用例可以通过通过播放器进行对音乐播放的基本操作，包括上一首，下一首，播放，暂停，还有拖动到某一时间点的功能。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/11b9e9f432d94fbd28601f14e8d8375c.writebug)

歌曲下载，首先用户需要搜索所需要的歌曲，然后点击下载。同时用户可以搜索不同平台的歌曲，这样就可以不会因为不同版权而听不到音乐。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/b4d840febaea41eaff87a5bf01ad5eeb.writebug)

乐迷互动，用户可以通过在播放页面的评论按钮评论歌曲，进入评论界面后还可以对自己喜欢的评论进行点赞或者评论，同时歌迷也可以通过分享到第三方平台一起享受音乐带来的乐趣。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/2ea702d4c9d4a85ba958f52ef865deee.writebug)

## 3.3 系统用例分析

本文将采用活动图来阐述系统的业务用例实现的工作流程，通过业务工作流程说明业务为向所服务的业务主角提供其所需的价值而必须完成的工作。业务用例由一系列活动组成，它们共同为业务主角生成某些工件。工作流程通常包括一个基本工作流程和一个或多个备选工作流程。工作流程的结构使用活动图来进行说明。

### 3.3.1 用例阐述

#### 3.3.1.1 播放音乐

- **基本流**
  - 用户启动应用并进入播放界面后播放界面有播放，上一首，下一首三个按钮，用户点击播放按钮
  - 系统监听到用户点击播放按钮的回调后，系统查找播放列表，判断播列表是否有歌曲。系统找到歌曲，系统将歌曲信息发送给MediaPalyer，MediaPlayer根据歌曲信息找到播放源进行播放

- **备选流**
  - 系统在监听到用户点击播放按钮的回调后，系统查找播放列表，判断播放列表是否有歌曲。系统没有找到歌曲，系统提示用户播放列表为空

#### 3.3.1.2 暂停播放

- **基本流**
  - 用户处于播放界面，用户点击暂停按钮
  - 系统监听到用户点击暂停按钮的回调后，系统判断现在是否处于播放状态，系统处于播放状态。系统通知MediaPlayer暂停播放音乐，MediaPalyer暂停播放音乐

- **备选流**
  - 系统监听到用户点击暂停按钮的回调后，系统判断现在是否处于播放状态，系统并没有处于播放状态。提示用户现在是暂停状态

#### 3.3.1.3 播放上一首

- **基本流**
  - 用户启动应用并进入播放界面后播放界面有播放，上一首，下一首三个按钮，用户点击上一首按钮
  - 系统监听到用户点击播放按钮的回调后，系统查找播放列表，判断播列表是否有上一首歌曲。系统找到歌曲，系统将歌曲信息发送给MediaPalyer，MediaPlayer根据歌曲信息找到播放源进行播放

- **备选流**
  - 系统在监听到用户点击播放按钮的回调后，系统查找播放列表，判断播放列表是否有上一首歌曲。系统没有找到歌曲，系统提示用户播放列表没有上一首歌曲

#### 3.3.1.4 播放下一首

- **基本流**
  - 用户启动应用并进入播放界面后播放界面有播放，上一首，下一首三个按钮，用户点击下一首按钮
  - 系统监听到用户点击播放按钮的回调后，系统查找播放列表，判断播列表是否有下一首歌曲。系统找到歌曲，系统将歌曲信息发送给MediaPalyer，MediaPlayer根据歌曲信息找到播放源进行播放

- **备选流**
  - 系统在监听到用户点击播放按钮的回调后，系统查找播放列表，判断播放列表是否有下一首歌曲。系统没有找到歌曲，系统提示用户播放列表没有下一首歌曲

#### 3.3.1.5 歌曲下载

- **基本流**
  - 用户进入在线音乐并点击下载音乐
  - 系统弹出下载页面，并且下载音乐

- **备选流**
  - 假如网络错误，系统弹出错误界面

#### 3.3.1.6 评论歌曲

- **基本流**
  - 用户点击菜单的评论歌曲
  - 系统弹出输入框用户输入评论并点击提交，系统提交数据

- **备选流**
  - 假如网络错误，系统弹出错误界面。

#### 3.3.1.7 分享歌曲

- **基本流**
  - 用户点击分享按钮
  - 系统弹出分享途径选择，用户选择途径，系统根据选择分享到所选择的平台

- **备选流**
  - 假如网络错误，系统弹出错误界面

## 3.4 领域涉及模型

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a0f37164e29a8b8f0ff8725e1e0bca05.writebug)

# 4 系统设计

## 4.1 概念模型

CDM：concept data model，即概念数据模型。简称概念模型，是面向数据库用户的实现世界的模型，主要用来描述世界的概念化结构，它使数据库的设计人员在设计的初始阶段，摆脱计算机系统及DBMS的具体技术问题，集中精力分析数据以及数据之间的联系等，与具体的数据管理系统(Database Management System，简称DBMS)无关。概念数据模型必须换成逻辑数据模型，才能在DBMS中实现。其只描述信息的特征和强调语义，而不涉及信息在计算机中的表示，是现实世界到信息世界的第一层抽象，根据需求分析及系统设计综合考虑，本系统的概念模型如下：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/ad0ac50f5d0c0bedf1d750bc1409d6fa.writebug)

## 4.2 物理模型

PDM(Physical Data Model)即物理数据模型，提供了系统初始设计所需要的基础元素，以及相关元素之间的关系；数据库的物理设计阶段必须在此基础上进行详细的后台设计，包括数据库的存储过程、操作、触发、视图和索引表等；本系统的物理如下图：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/c2a9e4e36e406306bc2e5cacfbdb949b.writebug)

## 4.3 数据库设计

根据关系化得到的各个模式，创建音乐播放器系统的各数据表如下。

### 4.3.1 歌曲表

| 字段名  | 字段码            | 数据类型         | 数据长度 | 备注   | 主键   |
| ---- | -------------- | ------------ | ---- | ---- | ---- |
| ID   | songid         | bigint       |      |      | X    |
| 唱片ID | albumid        | bigint       |      |      |      |
| 歌手ID | singer_id      | bigint       |      |      |      |
| 歌曲名  | songname       | varchar(32)  | 32   |      |      |
| 歌手名  | singername     | varchar(20)  | 20   |      |      |
| 播放链接 | m4a            | varchar(255) | 255  |      |      |
| 下载地址 | downUrl        | varchar(255) | 255  |      |      |
| 唱片小图 | albumpic_small | varchar(255) | 255  |      |      |
| 唱片大图 | albumpic_big   | varchar(255) | 255  |      |      |
| 唱片名  | albumname      | varchar(32)  | 32   |      |      |

### 4.3.2 唱片表

| 字段名  | 字段码            | 数据类型         | 数据长度 | 备注   | 主键   |
| ---- | -------------- | ------------ | ---- | ---- | ---- |
| 唱片ID | albumid        | bigint       |      |      | X    |
| 唱片名  | albumname      | varchar(20)  | 20   |      |      |
| 唱片大图 | albumpic_big   | varchar(255) | 255  |      |      |
| 唱片小图 | albumpic_small | varchar(255) | 255  |      |      |

### 4.3.3 歌手表

| 字段名  | 字段码        | 数据类型        | 数据长度 | 备注   | 主键   |
| ---- | ---------- | ----------- | ---- | ---- | ---- |
| 歌手ID | singer_id  | bigint      |      |      | X    |
| 歌手名  | singername | varchar(20) | 20   |      |      |

### 4.3.4 评论表

| 字段名      | 字段码           | 数据类型         | 数据长度 | 备注   | 主键   |
| -------- | ------------- | ------------ | ---- | ---- | ---- |
| 评论ID     | comment_id    | bigint       |      |      | X    |
| 用户ID     | user_id       | bigint       |      |      |      |
| ID       | songid        | bigint       |      |      |      |
| 评论内容     | content       | varchar(517) | 517  |      |      |
| 时间       | data          | date         |      |      |      |
| 对应的评论的id | to_comment_id | bigint       |      |      |      |

### 用户表

| 字段名  | 字段码       | 数据类型         | 数据长度 | 备注   | 主键   |
| ---- | --------- | ------------ | ---- | ---- | ---- |
| 用户ID | user_id   | bigint       |      |      | X    |
| 用户名  | user_name | varchar(255) | 255  |      |      |

## 4.4 目录结构设计

### 4.4.1 RUP面向对象设计模式的可视化建模

**用例视图**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/683bb589da88155cb465bfc56c128eb9.writebug)

### 4.4.2 客户端工程文件目录图

![](http://www.writebug.com/myres/static/uploads/2021/10/19/fbb0684d07cade18a839dbe509538936.writebug)

目录文件说明：

- Adapter：存放各种适配器

- Aidl：存放在不同进程间传递的Entity

- Application：存放Android的Application

- Contract：存放一下比如URl或者常量

- MVP
  - base：存放BaseModle，BasePresent的接口和抽象类
  - 其他基于MVP模式的模块

- Interfac：存放一下监听接口

- Service：存放Android的Service

- Tool：存放一下工具类

- Weight：存放一下自定义的控件

### 4.4.3 服务端工程文件目录图

![](http://www.writebug.com/myres/static/uploads/2021/10/19/694702fb6a1acb04043eed95c8a87fbb.writebug)

目录文件解释：

- controller：存放控制类，即各个请求相应的逻辑处理

- bean：存放数据实体类Entity

- util：存放开发的公共资源处理类和工具类

- repository：DAO层接口

- service：service层

- annotation：注解处理器

- map：Mybatis的Mapper

- Modle：Modle层

- tool：工具类

# 5 系统详细设计

## 5.1 系统时序图

### 5.1.1 播放音乐

![](http://www.writebug.com/myres/static/uploads/2021/10/19/09cc6e8ff1fa5913b3fb4683f629b287.writebug)

## 5.2 系统界面及其核心代码

### 5.2.1 播放器界面的实现

![](http://www.writebug.com/myres/static/uploads/2021/10/19/4f8b57995276c23adcbd058c12a90e85.writebug)

播放界面的xml代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e7995d06f8832987450bf8ae6dc2ae9c.writebug)

播放控制代码：(播放器和界面分开为两个进程，界面使用AIDL远程控制播放器的进程)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/b59834826a476d0ea729a699e578f270.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/551172cfc53951ec4250a51d3d17e7b9.writebug)

AIDL接口(通过在AIDL接口定义一个注册监听器的方法使得界面的进程可以接收到播放界面进程的返回参数，然后可以根据参数判断播放进程的状态)：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/13ed6320554683ee21d8126554aa2e2d.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/86e4104db64deebcdd4686eff921994f.writebug)

关键代码如下(歌词主要是通过一个Recycleview实现，通过解析lrc文件获取歌词和不同的时间段中间的歌词位置)：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e913b08951f9d8bd757e83a452859961.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/c325399119518d4976045915ad9c4994.writebug)

播放列表主要使用Popwindwos实现，弹出播放列表的时候播放背景变灰，然后监控背景的点击事件，当被点击时播放列表收回，同时还为弹出很收回设置动画，用于获得更好的用户体验。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/84ce520cdbb5b83a50b160198dc61638.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/41b490e8fb0a2ca44723795abe86b0ce.writebug)

Android使用sharePrefrence来保存本地音乐列表，要获取本地音乐只需要扫描本地的sharePrefrence获取本地的音乐，为了保证主线程不被阻塞，使用AsynTask进行扫描数据，在OnpostExcute刷新界面数据。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/790d4b2c375c4b8e28ac3f29f02694d2.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/d5e8e12b39d5dd99867a69918d23bb67.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/9582800a6311cd828b5cea39a29644bf.writebug)

分享歌曲是通过Android的系统分享途径分享音乐。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/baf24c3fa1d358a5de0403cde4d7c434.writebug)

同时还可以删除音乐，通过删除音乐文件然后重新扫描本地歌曲的方法来删除歌曲；设置为铃声，通过Android系统提供的方法进行设置，这个需要Android系统的写入权限来实现。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/5d2959ac4eb1d2044deb57f168b0563f.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/d69bdaea96e1890300613b8539774e4c.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8539d37461b468393cfa78e881012c22.writebug)

本系统是使用百度音乐API来获取音乐榜单，主要分类有:百度热歌榜，百度新歌榜，华语金曲榜，欧美金曲榜，情歌对唱榜，网络歌曲榜，经典老歌榜，摇滚榜，KTV热歌榜，Billboard，Hito中文版，叱咤歌曲榜等十二个榜单，适应更多用户的需求。列表的封面使用榜单第一名的歌曲，榜单显示全三场的歌曲的名字和歌手。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/75c0affd100b8ba76ca8815ba98400ec.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/d2a244e6d1700eae5c3dceda9d2ff7ad.writebug)

榜单详情使用Google原生的MaterialDesign风格，头部是可折叠的ToolBar，下面是一个RecycleView。

界面详情：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8b3734aca5a651f87e1bd869356998ef.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8c0878298721db3f8beddccc79d4f124.writebug)

分享的实现很本地歌曲的分享是一样的，都是通过Android系统分享的途径来进行分享歌曲，同时也可以支持很多平台的分享，包括当前最流行的QQ和微信。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/ba16237f16bc0064786df54a768d87db.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/ee1d9b12490a5eaa58c4dda3aa287fb7.writebug)

下载歌曲时会判断当前的网络状态，假如时使用移动网络那么会提醒是否要继续下载。

代码实现：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/bfdb80b51d0fcd133b666dba33b21926.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8085a6078a2da61306f075b4672ee85e.writebug)

下载歌曲时会在通知栏显示下载内容和进度，这是调用系统的DownloadManger实现。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/0af7cae5ef98f7e144ba3657b15f1c59.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/535b124ef709668013b580543f0412ba.writebug)

当DownloadManger下载完成后会有一个回调，可以通过回调来刷新本地歌曲的列表。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a17c05509ae141a3e871cd7305015adc.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/82802c269754bf949b1ded96e1d65e97.writebug)

Android端可以通过播放界面的菜单进行评论歌曲，当点击发送时会向服务器发送该歌曲的ID和评论内容还有当点的登陆的user，所以要使用该功能必须要登陆以后，代码中的Contract.TOKEN是当用户登陆之后服务器返回的一串token值。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/82ed97b103514a6e671b4f1ad44e2ed7.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/805461cb85468bcbab5a571afea3bf17.writebug)

用户可以点击评论然后输入内容对已有的评论进行评论。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/351423535beffd55ac7c9d31ce446d30.writebug)

在主菜单界面有天气的功能，这个是继承了高德地图API的定位服务和天气服务，首先先定位用户的经纬度，然后将经纬度发送给高德地图服务后台来获取当前的天气状况。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/58176fba5b94ceac49824bc952fd3f62.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/36d59bd2fd5b70242bc83bd6375ce277.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/65fffe6bfb22c8bef3b741fea3e704b3.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/fcb021caf479e16edf0dd1444b1c0f45.writebug)

这是登陆和注册页面，登陆和注册页面可以相互切换，登陆只需要用户名和密码，点击登录后，Android端会向后台发送登陆验证，假如验证成功，就会向Android端返回一串TOKEN值，当使用到必须要登陆才能使用的服务比如评论歌曲时，Android端会给服务器的请求Http的header里面添加TOKEN值，服务器通过这串TOKEN值解析出用户，然后进行其他相关操作，同时Android端有一个记住密码的功能，只要用户有登陆成功，那么Android端就会在SharePrefernce报错密码和用户名。下次再次点击登录的时候就可以直接显示用户名和密码，方便用户操作。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/db8e1b91ebdd1ac1dd83563b629eb429.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a873c17a6c758f46e20c12cb84959d17.writebug)

搜索歌曲也是使用百度音乐API接口，可以根据歌手名称，歌曲名等相关联的进行搜索。当点击搜索结果时就可以听该歌曲。

关键代码：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/583aee028011038d11410bc68f2dcf3b.writebug)

# 6 系统测试

## 6.1 软件测试常识及主要技术

软件测试是在规定的条件下对程序进行操作，以发现程序错误，衡量软件质量，并对其是否能满足设计要求进行评估的过程。 从软件开发者的角度出发，希望表明软件产品不存在错误和缺陷，验证软件能正确地实现用户需用户求，确立人们对软件质量的信心。从用户角度出发，希望通过软件测试暴露软件隐藏的错误和缺陷，从而考虑是否接受该产品。一般来说软件测试应由独立的产品评测中心负责，严格按照软件测试流程，制定测试计划、测试方案、测试规范，实施测试，对测试记录进行分析，并根据回归测试情况撰写测试报告。测试是为了证明程序有错，而不能保证程序没有错误。

测试工具介绍：

**Monkey**是Android SDK自带的测试工具，在测试过程中会向系统发送伪随机的用户事件流，手势输入，触摸屏输入，如按键输入等，它实现对正在开发的应用程序进行压力测试，也有日志输出。实际上该工具只能做程序做一些压力测试，由于测试事件和数据都是随机的，不能自定义，所以有很大的局限性。

**MonkeyRunner**类似于Monkey，它们都是Android SDK原有的。严格意义上来说MonkeyRunner其实是一个Api工具包，比Monkey强大，可以编写测试脚本来自定义数据、事件。但是MonkeyRunner的脚本是用Python来写，这样无疑会加重测试人员的负担。 

**Instrumentation**是早期Google提供的Android自动化测试工具类，相对于Junit  Instrumentation允许你对应用程序做更为复杂的测试，甚至是框架层面的。通过Instrumentation你可以模拟按键按下、抬起、屏幕点击、滚动等事件而JUint几乎都是进行简单的方法测试。Instrumentation是通过将主程序和测试程序运行在同一个进程来实现这些功能，你可以把Instrumentation看成一个类似Activity或者Service并且不带界面的组件，在程序运行期间监控你的主程序。缺点是对测试人员来说编写代码能力要求较高，需要对Android相关知识有一定了解，还需要配置AndroidManifest.xml文件，但是它存在一个缺点就是不可以同一套测试方法只能在一个APP上使用。

主要测试技术和方法介绍：

**黑盒测试**，软件测试的主要方法之一，也可以称为功能测试、数据驱动测试或基于规格说明的测试。测试者不了解程序的内部情况，不需具备应用程序的代码、内部结构和编程语言的专门知识。在黑盒测试中，被测对象的内部结构，运作情况对测试人员是不可见的，测试人员对测试产品的验证主要是根据其规格，验证其与规格一致性。就像对一台自动售货机，为了验证其能否自动售出货物，你可以指定需要购买的物品，塞入钱币，然后观测售货机能否输出正确的货物并找出正确的零钱。在这个过程中你不需要关注自动售货机是如何判定钱币数额，如何选择货物，如何找出零钱等内部操作。这是白盒测试关注的范围，黑盒测试关注的是结果。

此测试方法可适合大部分的软件测试，如集成测试(integration testing)以及系统测试(system testing)。

**白盒测试(white-box testing)**又称透明盒测试(glass box testing)、结构测试(structural testing)等，软件测试的主要方法之一，也称结构测试、逻辑驱动测试或基于程序本身的测试。白盒测试(white-box testing)分为逻辑驱动测试:(语句覆盖，判定覆盖(分支覆盖)，条件覆盖，判定/条件覆盖，条件组合覆盖)和基本路径测试。

白盒测试可以应用于单元测试(unit testing)、集成测试(integration testing)和系统的软件测试流程，可测试在集成过程中每一单元之间的路径，或者主系统跟子系统中的测试。尽管这种测试的方法可以发现许多的错误或问题，它可能无法检测未使用部分的规范。

## 6.2 测试用例及结果

### 6.2.1 播放音乐

| **Step Name** | **Description** | **Expected Result** |
| ------------- | --------------- | ------------------- |
| Step 1        | 打开APP           | 系统进入音乐播放界面          |
| Step 2        | 点击播放音乐按钮        | 系统开始播放音乐            |
| Step3         | 点击播放上一首         | 系统播放上一首音乐           |
| Step4         | 点击播放下一首         | 系统播放下一首音乐           |
| Step4         | 点击暂停            | 系统暂停播放音乐            |
| Stpe5         | 点击歌词            | 系统切换到歌词界面           |
| Step6         | 拖动进度条           | 系统播放对一个进度的音乐        |

### 6.2.2 评论歌曲

| **Step Name** | **Description** | **Expected  Result** |
| ------------- | --------------- | -------------------- |
| Step 1        | 打开APP           | 系统进入音乐播放界面           |
| Step 2        | 点击右边菜单栏         | 系统展开菜单               |
| Step 3        | 点击登录            | 系统进入登录界面             |
| Step 4        | 输入用户名和密码点击登录    | 系统显示登录成功             |
| Step 5        | 返回点击唱片图片        | 系统进入播放界面             |
| Step 6        | 点击菜单按钮选择评论      | 系统进入评论界面             |
| Step 7        | 在输入框输入评论内容发送    | 系统显示新增的评论            |

### 6.2.3 下载歌曲

| **Step Name** | **Description** | **Expected Result** |
| ------------- | --------------- | ------------------- |
| Step 1        | 打开APP           | 系统进入音乐播放界面          |
| Step 2        | 点击在线音乐          | 系统进入在线音乐节目          |
| Step 3        | 点击新歌榜           | 系统进入新歌榜单            |
| Step 4        | 点击第一首音乐点击菜单     | 系统显示菜单界面            |
| Step 5        | 点击下载音乐          | 系统添加下载任务            |

# 7 总结与展望

## 7.1 总结

本系统是基于Android的音乐播放器的设计与实现，本系统实现音乐播放器的基本功能，同时也拥有不错的界面设计。论文首先从现在Android音乐播放器的现状说起，分析音乐播放器的需求，然后对整个系统进行分析和设计，接下来就是代码实现，最后再用测试样本进行测试，以验证其可行性。

尽管本系统实现了音乐播放器的基本功能但是还是有很多不足之处，比如说本系统只集成百度音乐API而不是各个平台的音乐API，因为版权关系，各家音乐播放器拥有不同的版权，导致很多用户需要下载多个音乐播放器才能满足日常需求，加入可以加入各个平台的音乐API就可以为用户提供更好的服务。其次，本系统缺少比较新颖的功能比如说听歌识曲和歌单等，新颖的功能无疑可以更加吸引用户。后台服务只是本地服务导致评论歌曲的功能在不同局域网的手机无法连接。

## 7.2 展望
正如上面所说本系统还存在各种不足之处，对此对如何改进各种不足做出展望：

- 集成更多平台的音乐API

- 利用第三方平台开发听过识曲等新颖功能

- 买入阿里云服务器，上线服务

# 参考文献

[1]	Android 开发者官网https://developer.android.com/index.html

[2]	Retrofit官网https://square.github.io/retrofit/

[3]	RxJava官网https://github.com/ReactiveX/RxJava

[4]	SpringBoot官网https://projects.spring.io/spring-boot/

[5]	MyBatis官网 http://www.mybatis.org/mybatis-3/zh/index.html

[6]	Mysql 官网 https://www.mysql.com/

[7]	Glide 官网 https://github.com/bumptech/glide

[8]	《第一行代码Android》郭霖 人民邮电出版社2016.12

[9] 《Android开发艺术探索》任玉刚电子工业出版社 2015.9

[10] 《轻量级Java Web整合开发入门》李占波 清华大学出版社 2015.9.1

[11] 《Spring MVC实战》张龙、覃璐、李哲、丁涛译电子工业出版社 2017.5.1

[12] 《MyBatis技术内幕》徐郡明 电子工业出版社 2017.6.1

[13] 《Android源码设计模式解析与实战》何红辉、关爱民 人民邮电出版社 2017.7

[14] 《Android开发模式和最佳实战》菲尔 达特森 电子工业出版社 2017.2.1

[15] 《软件工程》萨默维尔 机械工业出版社 2011.5.1