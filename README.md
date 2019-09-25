说明: 

- /static、/public、/resources、和/META-INF/resources，
默认映射路径都是/。SpringBoot 默认会按照
META/resources > resources > static > public 
的优先级寻找对应的资源文件并返回第一个找到的文件。
-  http://127.0.0.1:8089/pic.png 可以直接访问到图片
- SpringBoot 官方原话 : 如果你的应用使用 jar 打包，不要使用/src/main/webapp 目录，尽管它是一个标准目录,该目录仅仅在使用 war 打包部署的时候生效，在大部分构建工具都它都会被忽略