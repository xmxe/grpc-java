### grpc-java
- [protoc.exe下载地址](https://github.com/protocolbuffers/protobuf/releases)   
- [protoc-gen-grpc-java插件下载地址](https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/)   
- [官方github](https://github.com/grpc/grpc-java)   
- [protobuf语法知识](https://blog.csdn.net/shensky711/article/details/69696392)   
- [demo](https://www.jianshu.com/p/69e3ed94f630)   
- 生成java代码   
protoc -I=F:\zz\grpc\src\resources\proto(.proto文件所在目录) --java_out=F:\zz\grpc\src\java(java文件生成目录) F:\zz\grpc\src\resources\proto\helloworld.proto(.proto文件)  
protoc -I=F:\zz\grpc\src\resources\proto --plugin=protoc-gen-grpc-java=F:\protoc\bin\protoc-gen-grpc-java-1.10.0-windows-x86_64.exe --grpc-java_out=F:\zz\grpc\src\java F:\zz\grpc\src\resources\proto\helloworld.proto
  
### 注意
- 版本不一致 神坑~ protoc.exe要与protobuf-java.jar版本一致


### 相关文章

- [一个简单的案例入门gRPC](https://mp.weixin.qq.com/s/OyfU0tLm4f9t3nZxce-Ksw)
- [聊一聊gRPC的四种通信模式](https://mp.weixin.qq.com/s/c-_D2RpLksIlYJDfaWOSkA)
- [聊一聊gRPC中的拦截器](https://mp.weixin.qq.com/s/cxaa8uHQ1Qvjy9aDyV87GQ)
- [手把手教大家在gRPC中使用JWT完成身份校验](https://mp.weixin.qq.com/s/jIZrP-H3DmS9pvRD5QaTfA)
- [Spring Boot+Nacos+gRPC，一个区别于OpenFeign的微服务通信方案！](https://mp.weixin.qq.com/s/03aDYQ7_GV_O6scKYuIw1w)
- [Protobuf:高效数据传输的秘密武器](https://mp.weixin.qq.com/s/iX3gnB1TaKg_M2LEhabtOA)
